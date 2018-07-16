import {
  ModuleWithProviders, NgModule,
  Optional, SkipSelf
} from '@angular/core';

import { CommonModule } from '@angular/common';

import { ModelService } from './model.service';
import { ProdottoService } from './rest/prodotto/prodotto.service';
import { ClienteService } from './rest/cliente/cliente.service';
 /*import { RestModule } from './rest/rest.module';*/

/* This module define all the providers for common services */
@NgModule({
  imports: [CommonModule],
  //  declarations: [RestModule],
  providers: [ModelService, ProdottoService, ClienteService],
  // exports: [RestModule]
})
export class ContainerServiceModule { }
