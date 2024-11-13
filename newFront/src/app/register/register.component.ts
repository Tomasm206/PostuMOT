// formulario.component.ts
import { Component } from '@angular/core';
import { PostulanteService } from '../services/postulante.service';

@Component({
  selector: 'app-formulario',
  templateUrl: '../register/register.component.html',
  styleUrls: ['./register.component.css']
})
export class FormularioComponent {
  postulante = {
    documento: 1401,
    firstName: 'rtyuygu',
    secondName: 'ngysg',
    lastName: 'gigsiu',
    lastSecondName: 'gyug',
    phone: 30577,
    email: 'kdjkss@email.com',
    sex: 'Femenino',
    // Valores constantes
    tipodocumento_id: '00000000-0000-0000-0000-000000000000',
    city_id: '00000000-0000-0000-0000-000000000000'
  };

  constructor(private postulanteService: PostulanteService) { }

  // Método para enviar el formulario
  onSubmit(): void {
    this.postulanteService.savePostulante(this.postulante).subscribe(
      response => {
        console.log('Postulante guardado con éxito:', response);
      },
      error => {
        console.error('Error al guardar postulante:', error);
      }
    );
  }
}
