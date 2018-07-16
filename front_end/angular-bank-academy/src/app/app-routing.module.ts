import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './sub-modules/home/home-component/home.component';
import { SearchContainerComponent } from './sub-modules/search/search-container/search-container.component';
import { ConsiglioProdottoComponent } from './sub-modules/inserimento/consiglio-prodotto/consiglio-prodotto.component';
import { ConfermaSceltaProdottoComponent } from './sub-modules/inserimento/conferma-scelta-prodotto/conferma-scelta-prodotto.component';
import { FormInserimentoComponent } from './sub-modules/inserimento/form-inserimento/form-inserimento.component';
import { RiepilogoFinaleComponent } from './sub-modules/inserimento/riepilogo-finale/riepilogo-finale.component';
import { SearchComponent } from './sub-modules/search/searchCp/search.component';
import { FormDeleteComponent } from './sub-modules/elimina-cliente/form-delete/form-delete.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'search', component: SearchContainerComponent},
  { path: 'conferma', component: ConfermaSceltaProdottoComponent },
  { path: 'consiglioProdotto', component: ConsiglioProdottoComponent },
  { path: 'compilaForm', component: FormInserimentoComponent},
  { path: 'riepilogoFinale', component: RiepilogoFinaleComponent},
  { path: 'ricerca', component: SearchComponent},
  { path: 'deleteCliente', component:FormDeleteComponent}
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  declarations: [],
  exports: [RouterModule]
})
export class AppRoutingModule { }
