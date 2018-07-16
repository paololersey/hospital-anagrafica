import { Injectable } from '@angular/core';
import { Cliente } from './model/cliente';
import { Provincia } from './model/provincia';
import { Prodotto } from './model/prodotto';

@Injectable({
  providedIn: 'root'
})

export class ModelService {

  constructor() { }
  public cliente: Cliente;
  public clientiList: Cliente[];
  public provincia: Provincia;
  public prodotto: Prodotto;
  public ricercaDone: boolean;
}
