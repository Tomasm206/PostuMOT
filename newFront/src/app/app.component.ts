import { Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterOutlet } from '@angular/router';
import { MenuComponent } from "./menu/menu.component";
import { RegisterComponent } from "./register/register.component";
import { VacantesComponent } from './vacantes/vacantes.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MenuComponent, RegisterComponent, VacantesComponent, HttpClientModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'postumot';
}
