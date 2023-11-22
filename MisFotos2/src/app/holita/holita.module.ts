import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { HolitaPageRoutingModule } from './holita-routing.module';

import { HolitaPage } from './holita.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    HolitaPageRoutingModule
  ],
  declarations: [HolitaPage]
})
export class HolitaPageModule {}
