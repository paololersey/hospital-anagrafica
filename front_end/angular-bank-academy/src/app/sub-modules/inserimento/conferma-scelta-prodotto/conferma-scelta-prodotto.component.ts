import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Prodotto } from './../../global-services/model/Prodotto';
import { Cliente } from './../../global-services/model/cliente';
import { ModelService } from '../../global-services/model.service';
import { ProdottoService } from '../../global-services/rest/prodotto/prodotto.service';
/*import { SelectControlValueAccessor } from '@angular/forms';*/

@Component({
  selector: 'app-conferma-scelta-prodotto',
  templateUrl: './conferma-scelta-prodotto.component.html',
  styleUrls: ['./conferma-scelta-prodotto.component.css']
})
export class ConfermaSceltaProdottoComponent implements OnInit {

  private prodotto: Prodotto;
  public cliente: Cliente;

  @Output()
  public change: EventEmitter<Cliente> = new EventEmitter<Cliente>();

  private error: any;
  private prodottiList: Prodotto[];

  @Output()
  public ricercaDone: boolean;

  constructor(private router: Router, private modelService: ModelService, private prodottoService: ProdottoService) { }

  ngOnInit() {
    this.cliente = this.modelService.cliente;
    this.prodotto = this.modelService.prodotto;
    this.modelService.ricercaDone = false;
    this.prodottoService.getProdotti().subscribe(
      result => { this.prodottiList = result; },
      error => this.error = error);
    this.cliente.nomeProdotto = this.prodotto.nomeProdotto;
  }

  conferma() {
    this.router.navigate(['/riepilogoFinale']);
  }

  /*compareFn ( p1: Prodotto, p2: Prodotto): Boolean {
    return p1 && p2 ? p1.nomeProdotto === p2.nomeProdotto : p1 === p2;
  }*/

}
