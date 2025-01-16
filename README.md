Documentación del Proyecto: API RESTful para Gestión de una Biblioteca
Descripción del Proyecto
Este proyecto consiste en el desarrollo de una API RESTful para gestionar un sistema básico de biblioteca.
La API permite realizar operaciones CRUD sobre los libros, como agregar, obtener, actualizar y eliminar libros. Además, 
se implementa un mecanismo de seguridad mediante autenticación básica.

Características Principales
Gestión de Libros: Operaciones para crear, leer, actualizar y eliminar libros.
Seguridad: Autenticación básica para proteger los endpoints relacionados con libros.
Validación: Validaciones básicas para garantizar la integridad de los datos.
Persistencia: Uso de una base de datos relacional como PostgreSQL para almacenar los datos.
Tecnologías: Spring Boot, Spring Security, JPA/Hibernate.
Endpoints de la API

Funcionalidades
Crear un libro
Endpoint: POST /api/books
Descripción: Permite registrar un nuevo libro en el sistema.
Ejemplo de cuerpo JSON:

json
Copiar
Editar
{
  "title": "El Principito",
  "author": "Antoine de Saint-Exupéry",
  "isbn": "9783150198668",
  "publishedDate": "1943-04-06"
}
Obtener un libro por ID
Endpoint: GET /api/books/{id}
Descripción: Recupera la información de un libro específico mediante su ID.

Actualizar un libro
Endpoint: PUT /api/books/{id}
Descripción: Actualiza los detalles de un libro existente.
Ejemplo de cuerpo JSON:

json
Copiar
Editar
{
  "title": "1984",
  "author": "George Orwell",
  "isbn": "9780451524935",
  "publishedDate": "1949-06-08"
}
Eliminar un libro
Endpoint: DELETE /api/books/{id}
Descripción: Elimina un libro del sistema mediante su ID.

Listar todos los libros
Endpoint: GET /api/books
Descripción: Devuelve una lista de todos los libros registrados en el sistema.

Requisitos del Proyecto
Java: Versión 17 o superior.
Maven: Gestión de dependencias.
Base de datos:  PostgreSQL.
Herramientas de desarrollo: IntelliJ IDEA, Eclipse o cualquier IDE compatible.
Configuración de Seguridad
La API está protegida con autenticación básica mediante las siguientes credenciales por defecto:

Usuario: TM_solution
Contraseña: TM_solution
Cómo Usar la Autenticación
En Postman:

En la pestaña Authorization, selecciona el tipo Basic Auth.
Ingresa las credenciales indicadas.
