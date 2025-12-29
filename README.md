# ✈️ CRUD de Vuelos con Spring Boot

## 📌 ¿Qué es este proyecto?

Este proyecto es una aplicación backend hecha con **Spring Boot** para gestionar una lista de vuelos mediante una **API REST**.  
La aplicación no usa base de datos, los datos se guardan en memoria, ya que el objetivo principal es practicar el CRUD, la organización del proyecto y el manejo de fechas con `LocalDate`.

La idea ha sido centrarme en que el código sea claro, fácil de entender y bien estructurado.

---

## 🧱 Organización del proyecto

El proyecto está dividido en varios paquetes para separar bien las responsabilidades:

- **controllers**  
  Se encargan de recibir las peticiones HTTP y devolver las respuestas.

- **services**  
  Aquí está la lógica principal del programa: filtros, validaciones, ordenación y reglas de negocio.

- **repositories**  
  Simula una base de datos en memoria usando un `Map` para guardar los vuelos.

- **models**  
  Contiene la clase `Vuelo`, que representa el objeto principal.

- **utils**  
  Clases de ayuda para trabajar con fechas y validaciones.

- **exceptions**  
  Manejo de errores personalizados (por ejemplo, cuando un vuelo no existe).

---

## ✈️ Objeto Vuelo

Un vuelo tiene los siguientes campos:

- id  
- nombreVuelo  
- empresa  
- lugarSalida  
- lugarLlegada  
- fechaSalida  
- fechaLlegada  

Las fechas se manejan con `LocalDate`.

Además, cuando se devuelve un vuelo, se calcula automáticamente la **duración en días** a partir de las fechas, sin guardarla como atributo fijo.

---

## 🔁 Funcionalidades CRUD

La API permite realizar todas las operaciones básicas:

- **GET /vuelos**  
  Devuelve la lista completa de vuelos ordenados por fecha de salida.

- **GET /vuelos/{id}**  
  Devuelve un vuelo concreto según su ID.

- **POST /vuelos**  
  Crea un nuevo vuelo.

- **PUT /vuelos/{id}**  
  Actualiza un vuelo existente.

- **DELETE /vuelos/{id}**  
  Elimina un vuelo por su ID.

---

## 🔍 Filtros y ordenación

Se pueden aplicar filtros opcionales usando parámetros en la URL:

- Filtrar por empresa
- Filtrar por lugar de llegada
- Filtrar por fecha de salida

Los filtros se pueden combinar entre sí.

También se puede ordenar el resultado indicando:
- El campo por el que se quiere ordenar
- El sentido (ASC o DESC)

---
## 🧠 Decisiones importantes

- La **duración del vuelo no se guarda en el repositorio** ni se calcula en el controller.  
  Este dato se obtiene a partir de las fechas de salida y llegada, por lo que **no tiene sentido almacenarlo** como un campo fijo.

- El cálculo de la duración se hace en el **service**, ya que forma parte de la lógica del negocio.  
  El controller solo se encarga de recibir peticiones y devolver respuestas, sin incluir lógica.

- De esta forma se evita duplicar código y se asegura que la duración siempre sea correcta aunque se modifiquen las fechas del vuelo.

- El **controller nunca accede directamente al repositorio**.  
  Todas las operaciones pasan primero por el service para mantener una buena separación de responsabilidades.

- El repositorio usa un `Map` en memoria para simplificar el proyecto y centrarse en la lógica del CRUD, sin depender de una base de datos.


## ✅ Validaciones

La aplicación no permite:

- Crear vuelos sin nombre.
- Fechas incorrectas (fecha de salida posterior a la de llegada).
- Modificar o eliminar vuelos que no existen.

---

## 🧪 Postman

El proyecto incluye una **colección de Postman** con todas las peticiones necesarias para probar la API:

- Listar vuelos
- Buscar por ID
- Crear vuelos
- Actualizar vuelos
- Eliminar vuelos

La aplicación arranca con **10 vuelos de prueba**, por lo que no es necesario crear datos manualmente.

La colección está incluida en la carpeta:


