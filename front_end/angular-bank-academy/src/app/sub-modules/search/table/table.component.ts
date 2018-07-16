import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { ModelService } from './../../global-services/model.service';
import { Cliente } from './../../global-services/model/cliente';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit, OnChanges {

  @Input()
  private clienti: Cliente[];
  private ricercaEnabled = false;

  constructor(private modelService: ModelService, private router: Router) { }

  ngOnInit() {
    if (this.modelService.clientiList) {
      this.clienti = this.modelService.clientiList;
    } else {
      this.clienti = new Array<Cliente>();
    }
    this.ricercaEnabled = false;
  }

  ngOnChanges() {
    this.ricercaEnabled = this.modelService.ricercaDone;
    console.log(this.ricercaEnabled);
  }

  elimina(cliente) {
    this.modelService.cliente = cliente;
    this.router.navigate(['/deleteCliente']);
  }
}
