# CRUD de Vuelos – Spring Boot

## 📌 Descripción del proyecto

Este proyecto es una aplicación backend desarrollada con Spring Boot que permite gestionar una lista de vuelos mediante un CRUD completo (crear, leer, actualizar y eliminar).

No se utiliza base de datos. Los datos se almacenan en memoria para centrarse en la lógica del backend, la estructura del proyecto y el uso correcto de una API REST.

El objetivo principal ha sido entender cómo organizar un proyecto Spring Boot y cómo separar correctamente las responsabilidades de cada capa.

---

## 🧱 Estructura del proyecto

El proyecto está organizado en los siguientes paquetes:

- **controllers**  
  Se encarga de recibir las peticiones HTTP y devolver las respuestas.  
  No contiene lógica de negocio.

- **services**  
  Contiene la lógica principal de la aplicación: validaciones, filtros, ordenación y cálculo de datos.

- **repositories**  
  Gestiona el almacenamiento de los vuelos en memoria usando un `Map`.

- **models**  
  Contiene la clase `Vuelo`, que representa el objeto principal del proyecto.

- **utils**  
  Incluye clases auxiliares, como las relacionadas con el manejo de fechas.

- **exceptions**  
  Gestiona los errores personalizados de la aplicación.

---

## ✈️ Modelo Vuelo

Cada vuelo contiene la siguiente información:

- id  
- nombreVuelo  
- empresa  
- lugarSalida  
- lugarLlegada  
- fechaSalida  
- fechaLlegada  

Las fechas se gestionan usando `LocalDate`.

---

## 🔄 Funcionalidades del CRUD

La API permite realizar las siguientes operaciones:

- **GET /vuelos**  
  Devuelve todos los vuelos, ordenados por fecha de salida.

- **GET /vuelos/{id}**  
  Devuelve un vuelo concreto por su identificador.

- **POST /vuelos**  
  Crea un nuevo vuelo.

- **PUT /vuelos/{id}**  
  Actualiza un vuelo existente.  
  El ID siempre se toma de la URL, no del body.

- **DELETE /vuelos/{id}**  
  Elimina un vuelo por su ID.

---

## 🔍 Filtros y ordenación

La API permite filtrar los vuelos mediante parámetros opcionales:

- Por empresa  
- Por lugar de llegada  
- Por fecha de salida  

Los filtros se pueden combinar entre sí.

También es posible ordenar el resultado mediante parámetros adicionales, por ejemplo por empresa o lugar de llegada, en orden ascendente o descendente.

---

## 🧠 Decisiones importantes

- La **duración del vuelo no se guarda en el repositorio**.  
  Es un dato que se puede calcular a partir de las fechas, por lo que almacenarlo podría provocar inconsistencias si las fechas cambian.

- El cálculo de la duración se realiza en el **service**, ya que forma parte de la lógica de negocio.  
  El controller solo gestiona peticiones y respuestas.

- El **controller no accede directamente al repositorio**.  
  Todas las operaciones pasan por el service para mantener una correcta separación de responsabilidades.

- El repositorio utiliza un `Map` en memoria para simplificar el proyecto y centrarse en la lógica del CRUD sin depender de una base de datos.

---

## ✅ Validaciones

Se aplican validaciones básicas:

- No se permiten vuelos sin nombre.
- Las fechas deben ser coherentes (la fecha de salida no puede ser posterior a la de llegada).
- No se pueden modificar ni eliminar vuelos que no existen.

---

## 🧪 Postman

El proyecto incluye una colección de Postman con todas las peticiones necesarias para probar la API.

No es necesario crear vuelos manualmente, ya que el proyecto se inicia con una lista de vuelos de prueba.

---

## 🏁 Conclusión

Este proyecto implementa un CRUD completo y funcional siguiendo buenas prácticas de desarrollo backend con Spring Boot, poniendo especial atención en la organización del código y la separación de responsabilidades.


