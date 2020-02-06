import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PedidoComponent } from './pedido/pedido.component';
import { AdminComponent } from './admin/admin.component';

const routes: Routes = [
  { path: 'pedido', component: PedidoComponent },
  { path: 'aprovacao', component: PedidoComponent },
  { path: 'admin', component: AdminComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
