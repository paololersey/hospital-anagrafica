import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormInserimentoComponent } from './form-inserimento/form-inserimento.component';
import { ConsiglioProdottoComponent } from './consiglio-prodotto/consiglio-prodotto.component';
import { ConfermaSceltaProdottoComponent } from './conferma-scelta-prodotto/conferma-scelta-prodotto.component';
import { RiepilogoFinaleComponent } from './riepilogo-finale/riepilogo-finale.component';
import { LibsModule } from '../libs/libs.module';
import { ContainerDirectiveModule } from './../container-directive/container-directive.module';


@NgModule({
  imports: [
    CommonModule, 
    LibsModule,
    ContainerDirectiveModule
  ],
  declarations: [FormInserimentoComponent, ConsiglioProdottoComponent, ConfermaSceltaProdottoComponent, RiepilogoFinaleComponent],
  exports: [FormInserimentoComponent, ConsiglioProdottoComponent, ConfermaSceltaProdottoComponent, RiepilogoFinaleComponent]
})
export class InserimentoModule { }
