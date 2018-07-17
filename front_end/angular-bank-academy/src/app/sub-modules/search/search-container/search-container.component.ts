import { Component, OnInit, OnChanges } from '@angular/core';
import { Cliente } from './../../global-services/model/cliente';
import { Provincia } from '../../global-services/model/provincia';
import { ClienteService } from '../../global-services/rest/cliente/cliente.service';
import { ModelService } from '../../global-services/model.service';

@Component({
  selector: 'app-search-container',
  templateUrl: './search-container.component.html',
  styleUrls: ['./search-container.component.css']
})

export class SearchContainerComponent implements OnInit, OnChanges {

  private risultatoTabellaDaRestService: Cliente[];
  private error: any;

  private provincia: Provincia;
  private risultatoPopolazioneTendina: Provincia[];
  private listProvince: string[];

  constructor(private clienteService: ClienteService, private modelService: ModelService) { }


  ngOnInit() {
    this.risultatoTabellaDaRestService = new Array<Cliente>();
  }


  ngOnChanges() {
    console.log('onchange');

  }
  getClientiWithProdotto(cliente: Cliente) {
    this.clienteService.getClientiWithProdotto(cliente).subscribe(
      result => { this.risultatoTabellaDaRestService = result; this.modelService.clientiList = this.risultatoTabellaDaRestService },
      error => this.error = error);
  }
}
