
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { RegisterComponent } from './register/register.component';
import { VacantesComponent } from './vacantes/vacantes.component';

export const routes: Routes = [ // Exporta la constante 'routes'
  { path: '', component: MenuComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'vacantes', component: VacantesComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


