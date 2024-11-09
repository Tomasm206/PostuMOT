
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component'; // Cambia el path si es diferente
import { RegisterComponent } from './register/register.component'; // Cambia el path si es diferente

const routes: Routes = [
    { path: '', component: MenuComponent }, // La página principal (Home)
    { path: 'register', component: RegisterComponent } // La página de registro
  ];

//export const routes: Routes = [];
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }



// Define las rutas aquí



