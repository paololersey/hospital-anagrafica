import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LibsModule } from '../libs/libs.module';
import { SearchComponent } from './searchCp/search.component';
import { TableComponent } from './table/table.component';
import { SearchContainerComponent } from './search-container/search-container.component';
import { ContainerDirectiveModule } from './../container-directive/container-directive.module';

@NgModule({
  imports: [
    CommonModule,
    LibsModule,
    ContainerDirectiveModule
  ],
  declarations: [ SearchComponent, TableComponent, SearchContainerComponent],
  exports: [ SearchComponent, TableComponent, SearchContainerComponent]
})
export class SearchModule { }
