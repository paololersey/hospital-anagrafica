import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LibsModule} from '../../sub-modules/libs/libs.module';
import { FormDeleteComponent } from './form-delete/form-delete.component';

@NgModule({
  imports: [
    CommonModule, LibsModule
  ],
  declarations: [FormDeleteComponent],
  exports:[FormDeleteComponent]
})
export class EliminaClienteModule { }
