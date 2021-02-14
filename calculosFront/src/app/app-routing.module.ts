import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CalcularComponent } from './pages/negocio/calcular/calcular.component';

const routes: Routes = [
  {path: '', redirectTo: 'calcular', pathMatch: 'full' },
  {path: 'calcular', component:CalcularComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
