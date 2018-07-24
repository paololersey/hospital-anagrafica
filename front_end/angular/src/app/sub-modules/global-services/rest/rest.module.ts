import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProdottoService } from './prodotto/prodotto.service';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [],
  providers: [ProdottoService]
})
export class RestModule { }
