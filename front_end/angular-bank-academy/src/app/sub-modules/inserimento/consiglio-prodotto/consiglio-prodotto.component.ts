import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { ModelService } from '../../global-services/model.service';
import { Cliente } from '../../global-services/model/Cliente';
import { Prodotto } from '../../global-services/model/prodotto';

@Component({
  selector: 'app-consiglio-prodotto',
  templateUrl: './consiglio-prodotto.component.html',
  styleUrls: ['./consiglio-prodotto.component.css']
})
export class ConsiglioProdottoComponent implements OnInit {

  public cliente: Cliente;
  public prodotto: Prodotto;

  constructor(private router:Router, private modelService : ModelService) { }

  ngOnInit() {
    this.cliente = this.modelService.cliente;
    this.prodotto= this.modelService.prodotto;
    this.cliente.nomeProdotto=this.prodotto.nomeProdotto;
  } 

  conferma(){ 
    this.modelService.cliente=this.cliente;
    this.modelService.prodotto=this.prodotto;
    this.router.navigate(['/conferma']);
  }

}