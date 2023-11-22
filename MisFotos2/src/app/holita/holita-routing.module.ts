import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HolitaPage } from './holita.page';

const routes: Routes = [
  {
    path: '',
    component: HolitaPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class HolitaPageRoutingModule {}
