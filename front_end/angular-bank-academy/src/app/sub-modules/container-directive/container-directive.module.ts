import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UpperCaseDirective } from './directives/upper-case-directive.directive';
import { LibsModule } from '../libs/libs.module';

@NgModule({
  imports: [
    CommonModule, LibsModule
  ],
  declarations: [UpperCaseDirective],
  exports: [UpperCaseDirective]
})
export class ContainerDirectiveModule { }
