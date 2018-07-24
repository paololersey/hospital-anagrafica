import { Component, OnInit, SecurityContext } from '@angular/core';
import { Router } from '@angular/router';
import { Cliente } from '../../global-services/model/cliente';
import { ModelService } from '../../global-services/model.service';
import { Prodotto } from './../../global-services/model/prodotto';
import { ClienteService } from '../../global-services/rest/cliente/cliente.service';
import { AlertComponent } from 'ngx-bootstrap/alert/alert.component';
import { DomSanitizer } from '@angular/platform-browser';
@Component({
  selector: 'app-riepilogo-finale',
  templateUrl: './riepilogo-finale.component.html',
  styleUrls: ['./riepilogo-finale.component.css']
})
export class RiepilogoFinaleComponent implements OnInit {
  /*alerts: any = [
    {
      type: 'success',
      msg: `<strong>Well done!</strong> You successfully read this important alert message.`
    },
    {
      type: 'info',
      msg: `<strong>Heads up!</strong> This alert needs your attention, but it's not super important.`
    },
    {
      type: 'danger',
      msg: `<strong>Warning!</strong> Better check yourself, you're not looking too good.`
    }
  ];*/

  /*alerts: any[] = [{
    type: 'success',
    msg: `Operazione Completata!\n Il cliente e' stato aggiunto correttamente. \n(alle ore: ${new Date().toLocaleTimeString()})`,
    timeout: 5000
  }];*/

  /*onClosed(dismissedAlert: AlertComponent): void {
    this.alerts = this.alerts.filter(alert => alert !== dismissedAlert);
  }*/
  public cliente: Cliente;
  public id: Number;
  public error: String;

  constructor(private router: Router, private modelService: ModelService, private clienteService: ClienteService,/* sanitizer: DomSanitizer*/) {
    /*this.alerts = this.alerts.map((alert: any) => ({
      type: alert.type,
      msg: sanitizer.sanitize(SecurityContext.HTML, alert.msg)
    }));*/
  }

  ngOnInit() {
    this.cliente = this.modelService.cliente;
  }

  conferma() {
    /*window.alert("OPERAZIONE COMPLETATA! \n"+" \nIl cliente:\n "+this.cliente.nomeCliente+" "+this.cliente.cognomeCliente+", \nè stato aggiunto con successo!");*/
    this.clienteService.insertEditCliente(this.cliente).subscribe(
      result => { this.id = result; this.router.navigate(['/search']); },
      error => this.error = error)

  }

}
