# PostuMOT

**PostuMOT** es una aplicación diseñada para facilitar el proceso de postulación a vacantes en diversas empresas. Los usuarios pueden crear perfiles, agregar información sobre su experiencia laboral, formación académica y aplicar a oportunidades de trabajo de manera rápida y organizada.

## Características

- **Registro de Usuario**: Los usuarios pueden crear sus cuentas con datos personales básicos y mantener un perfil actualizado.
- **Postulación a Vacantes**: Acceso a una lista de vacantes disponibles con opción de postularse de forma directa.
- **Gestión de Experiencia Laboral**: Los usuarios pueden agregar, editar y visualizar sus experiencias laborales relevantes.
- **Gestión de Formación Académica**: Permite registrar estudios académicos con información relevante para su perfil profesional.
- **Interfaz Intuitiva**: Diseñada para facilitar la navegación y mejorar la experiencia de usuario.

## Tecnologías

- **Backend**: Java con Spring Boot
- **Frontend**: Angular
- **Base de Datos**: PostgreSQL
- **Otros**: Maven para la gestión del proyecto

## Estructura del Proyecto

- `/src/main/java` - Código fuente del backend en Java.
- `/src/main/resources` - Archivos de configuración y recursos de la aplicación.
- `/src/frontend` - Código fuente del frontend en Angular.
- `/database` - Scripts y configuraciones de la base de datos.

## Instalación y Configuración

1. Clona el repositorio: `git clone https://github.com/Tomasm206/PostuMOT.git`
2. Configura la base de datos en PostgreSQL y ajusta las credenciales en `postumot.properties`.
3. Ejecuta el backend con Spring Boot desde tu entorno de desarrollo (Eclipse, IntelliJ, etc.).
4. Navega al directorio `/src/frontend` e instala las dependencias de Angular: `npm install`
5. Inicia el frontend con `ng serve` y accede a `http://localhost:4200`.
