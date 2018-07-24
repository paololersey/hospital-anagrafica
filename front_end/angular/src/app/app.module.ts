import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

/* SharedModule: all external libs */
import { LibsModule } from './sub-modules/libs/libs.module';

/* SharedModule: all common services */
import { ContainerServiceModule } from './sub-modules/global-services/container-service-module.module';

import { AppComponent } from './app.component';
import { HomeModule } from './sub-modules/home/home.module';
import { PageSurroundModule } from './sub-modules/page-surround/page-surround.module';
import { SearchModule } from './sub-modules/search/search.module';
import { AppRoutingModule } from './/app-routing.module';
import { InserimentoModule } from './sub-modules/inserimento/inserimento.module';
import { EliminaClienteModule } from './sub-modules/elimina-cliente/elimina-cliente.module';
import { ContainerDirectiveModule } from './sub-modules/container-directive/container-directive.module';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    NgbModule.forRoot(),
    BrowserModule,
    LibsModule,
    ContainerServiceModule,
    ContainerDirectiveModule,

    /* features */
    PageSurroundModule,
    HomeModule,
    SearchModule,
    InserimentoModule,
    EliminaClienteModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
