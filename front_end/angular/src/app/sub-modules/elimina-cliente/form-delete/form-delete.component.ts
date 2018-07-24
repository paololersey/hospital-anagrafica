import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ModelService } from '../../global-services/model.service';
import { Cliente } from '../../global-services/model/cliente';
import { ClienteService } from '../../global-services/rest/cliente/cliente.service';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-form-delete',
  templateUrl: './form-delete.component.html',
  styleUrls: ['./form-delete.component.css']
})
export class FormDeleteComponent implements OnInit {

  private cliente: Cliente;
  private id: Number;
  private error: any;
  constructor(private router: Router, private modelService: ModelService, private clienteService: ClienteService) { }

  ngOnInit() {
    this.cliente = this.modelService.cliente;

  }

  conferma() {
    this.modelService.cliente.dataFine = new Date();
    this.clienteService.deleteCliente(this.cliente.id).subscribe(
      result => { this.id = result; this.router.navigate(['/search']); },
      error => this.error = error);
  };



  annulla() {
    this.modelService.cliente = null;
    this.router.navigate(['/search']);
  }
}
