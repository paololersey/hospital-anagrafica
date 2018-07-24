import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderModule } from './header/header.module';
import { FooterModule } from './footer/footer.module';
import { SidebarModule } from './sidebar/sidebar.module';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [],
  exports: [HeaderModule,SidebarModule,FooterModule]
})
export class PageSurroundModule { }
