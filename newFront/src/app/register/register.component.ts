import { Component } from '@angular/core';
import { PostulanteService } from '../services/postulante/postulante.service';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { v4 as uuidv4 } from 'uuid';  // Importa uuid para generar UUID

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  standalone: true,
  imports: [FormsModule, RouterModule]
})
export class RegisterComponent {
  postulante = {
    // Asegúrate de que los nombres coincidan con los del DTO
    documento: '', // int en DTO
    firstName: '', // firstName en lugar de firstname
    secondName: '', // secondName en lugar de secondname
    lastName: '', // lastName en lugar de firstsurname
    lastSecondName: '', // lastSecondName en lugar de secondsurname
    phone: '', // phone en lugar de cell
    email: '', // email coincide
    sex: '', // sex en lugar de gender
    tipoDocumento: { tipo: '' }, // El objeto tipoDocumento debe coincidir con el DTO
    ciudad: { ciudad: '' }, // El objeto ciudad debe coincidir con el DTO
    uuid: uuidv4() // Genera el UUID
  };

  successMessage = ''; // Mensaje de éxito
  errorMessage = '';   // Mensaje de error

  constructor(
    private postulanteService: PostulanteService,
    private router: Router
  ) { }

  onSubmit() {
    this.successMessage = '';
    this.errorMessage = '';

    console.log('Formulario enviado:', this.postulante);  // Verifica los datos

    // Aquí se mapea el objeto de Angular al formato esperado por el DTO
    const postulanteDTO = {

      documento: this.postulante.documento,
      firstName: this.postulante.firstName,
      secondName: this.postulante.secondName,
      lastName: this.postulante.lastName,
      lastSecondName: this.postulante.lastSecondName,
      phone: this.postulante.phone,
      email: this.postulante.email,
      sex: this.postulante.sex,
      tipoDocumento: this.postulante.tipoDocumento,
      ciudad: this.postulante.ciudad
    };

    this.postulanteService.registrarPostulante(postulanteDTO)
      .subscribe({
        next: (response) => {
          this.successMessage = 'Registro exitoso';
          console.log('Registro exitoso:', response);
          // Redirigir a otra página o componente si es necesario
          this.router.navigate(['/']); // Cambia el path según sea necesario
        },
        error: (error) => {
          this.errorMessage = 'Error en el registro. Inténtalo nuevamente.';
          console.error('Error en el registro:', error);
        }
      });
  }
}
