// app-routing.module.ts
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { FormComponent } from './register/register.component';  // Asegúrate de que el componente esté importado

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: AppComponent },
  { path: 'form', component: FormComponent },  // Ruta para tu formulario
  { path: '**', redirectTo: '/home' }  // Redirige a home si la ruta no existe
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],  // Usa RouterModule para configurar las rutas
  exports: [RouterModule]
})
export class AppRoutingModule { }
