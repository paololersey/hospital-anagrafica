import { Component, OnInit, Output, Input, EventEmitter, ViewChild, ElementRef } from '@angular/core';
import { ModelService } from './../../global-services/model.service';
import { ProdottoService } from './../../global-services/rest/prodotto/prodotto.service';
import { Provincia } from './../../global-services/model/provincia';
import { Prodotto } from './../../global-services/model/Prodotto';
import { Cliente } from './../../global-services/model/cliente';
import { ProvinciaService } from '../../global-services/rest/provincia/provincia.service';
import { AlertComponent } from 'ngx-bootstrap/alert/alert.component';

@Component({
  selector: 'app-form-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  public edited = false;
  public nonedited = false;
  @ViewChild('dataContainer') dataContainer: ElementRef;

  loadData(data) {
    this.dataContainer.nativeElement.innerHTML = data;
  }

  alerts: any[] = [{
    type: 'success',
    msg: `OPERAZIONE COMPLETATA! ` + `\nIl cliente:\n \nè stato AGGIUNTO con successo!`,
    timeout: 5000
  }];

 /* add(): void {
    this.alerts.push({
      type: 'danger',
      msg: `OPERAZIONE COMPLETATA! ` + `\nIl cliente:\n \nè stato RIMOSSO con successo!`,
      timeout: 5000
    });
  }*/

  add(): void {
    this.alerts = [{
      type: 'danger',
      msg: `OPERAZIONE COMPLETATA! ` + `\nIl cliente:\n \nè stato RIMOSSO con successo!`,
      timeout: 5000
    }];
  }

  onClosed(dismissedAlert: AlertComponent): void {
    this.alerts = this.alerts.filter(alert => alert !== dismissedAlert);
  }
  private clienteInserito: Cliente;
  private prodottoInserito: Prodotto;
  private provinciaInserita: Provincia;

  private cliente: Cliente;
  private prodotto: Prodotto;
  private provincia: Provincia;
  private provinciaList: Provincia[];

  @Output()
  public cambio: EventEmitter<Cliente> = new EventEmitter<Cliente>();

  private error: any;
  private prodottiList: Prodotto[];

  constructor(private modelService: ModelService, private prodottoService: ProdottoService, private provinciaService: ProvinciaService) { }

  ngOnInit() {
    if (this.modelService.cliente) {
      console.log("cliente" + this.modelService.cliente);
      this.clienteInserito = this.modelService.cliente;
      if (!this.modelService.cliente.dataFine) {
        //this.loadData('<div *ngFor="let alert of alerts"><alert [type]="alert.type" [dismissOnTimeout]="alert.timeout" (onClosed)="onClosed(alert)">Il cliente &egrave stato  AGGIUNTO con Successo!</alert></div>');
        this.edited = true;
        //window.alert("OPERAZIONE COMPLETATA! \n" + " \nIl cliente:\n " + this.clienteInserito.nomeCliente + " " + this.clienteInserito.cognomeCliente + ", \nè stato AGGIUNTO con successo!");
      } else {
        this.nonedited = true;
        setTimeout(this.add(), 5000);
        //window.alert("OPERAZIONE COMPLETATA! \n" + this.clienteInserito.nomeCliente + " " + this.clienteInserito.cognomeCliente + ", \nè stato ELIMINATO con successo!");
      }
      this.modelService.cliente = null;
      this.clienteInserito = null;
    }

    this.cliente = new Cliente();
    this.prodotto = new Prodotto();
    this.provincia = new Provincia();
    this.modelService.ricercaDone = false;
    this.prodottoService.getProdotti().subscribe(
      result => { this.prodottiList = result; },
      error => this.error = error);

    this.provinciaService.getProvinceList().subscribe(
      result => { this.provinciaList = result; },
      error => this.error = error);
  }

  ricerca() {
    this.modelService.ricercaDone = true;
    // this.cliente.nomeCliente = this.cliente.nomeCliente.toUpperCase();
    /*this.cliente.cognomeCliente = this.cliente.cognomeCliente.toUpperCase();
    this.cliente.codiceFiscale = this.cliente.codiceFiscale.toUpperCase();*/
    if (this.modelService.cliente == null) {
      this.cliente.descProdotto = this.prodotto.nomeProdotto;
    }
    this.cambio.emit(this.cliente);
  }
}
