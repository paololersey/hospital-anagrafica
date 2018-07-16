import { Component, OnInit, OnChanges, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';
import { ModelService } from '../../global-services/model.service';
import { Cliente } from '../../global-services/model/cliente';
import { Prodotto } from '../../global-services/model/Prodotto';
import { ProvinciaService } from '../../global-services/rest/provincia/provincia.service';
import { Provincia } from '../../global-services/model/provincia';
import { ProdottoService } from '../../global-services/rest/prodotto/prodotto.service';
@Component({
  selector: 'app-form-inserimento',
  templateUrl: './form-inserimento.component.html',
  styleUrls: ['./form-inserimento.component.css']
})

export class FormInserimentoComponent implements OnInit {

  bsValue = new Date();
  bsRangeValue: Date[];
  maxDate = new Date();

  uncheckableRadioModel = 'ale';

  public cliente: Cliente;

  public prodotto: Prodotto;

  private error: any;
  private provinciaList: Provincia[];

  constructor(private router: Router, private modelService: ModelService, private provinciaService: ProvinciaService, private prodottoService: ProdottoService) {
    this.maxDate.setDate(this.maxDate.getDate() + 7);
    this.bsRangeValue = [this.bsValue, this.maxDate];
   }


  ngOnInit() {
    this.cliente = new Cliente();
    this.provinciaService.getProvincia().subscribe(
      result => { this.provinciaList = result; },
      error => this.error = error);
  }

  conferma() {
    this.cliente.nomeCliente=this.cliente.nomeCliente.toUpperCase();
    this.cliente.cognomeCliente=this.cliente.cognomeCliente.toUpperCase();
    this.cliente.codiceFiscale=this.cliente.codiceFiscale.toUpperCase();
    this.modelService.cliente = this.cliente;
    this.prodottoService.consiglioProdotto(this.cliente).subscribe(
      result => {
        this.prodotto = result;
        this.modelService.prodotto = this.prodotto;
        this.router.navigate(['/consiglioProdotto']);
      },
      error => this.error = error);
    console.log("metodo finito");


  }

}
