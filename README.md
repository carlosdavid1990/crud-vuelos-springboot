# ✈️ CRUD de Vuelos – Spring Boot

## 📖 Descripción del proyecto

Este proyecto es una aplicación backend desarrollada con **Spring Boot** que permite gestionar una lista de vuelos mediante una **API REST**.  
No utiliza base de datos, ya que los datos se almacenan en memoria para centrarse en la lógica del CRUD, la organización del proyecto y el uso correcto de fechas con `LocalDate`.

El objetivo principal es practicar una estructura clara de proyecto, separación de responsabilidades y buenas prácticas en el desarrollo backend.

---

## 🧱 Estructura del proyecto

El proyecto está organizado en los siguientes paquetes:

- **controllers**  
  Gestiona las peticiones HTTP y expone los endpoints de la API.

- **services**  
  Contiene la lógica de negocio, validaciones, filtros y ordenación de los vuelos.

- **repositories**  
  Simula una base de datos en memoria usando un `Map` para almacenar los vuelos.

- **models**  
  Contiene la clase `Vuelo`, que representa el objeto principal del proyecto.

- **utils**  
  Incluye utilidades para trabajar con fechas y validaciones relacionadas.

- **exceptions**  
  Maneja errores personalizados como vuelos no encontrados o peticiones inválidas.

---

## ✈️ Modelo Vuelo

Cada vuelo contiene los siguientes campos:

- `id`
- `nombreVuelo`
- `empresa`
- `lugarSalida`
- `lugarLlegada`
- `fechaSalida`
- `fechaLlegada`

Las fechas se gestionan con `LocalDate`.

Además, cuando se devuelve un vuelo en la respuesta, se calcula automáticamente la **duración en días**, sin almacenarla como atributo fijo.

---

## 🔁 Funcionalidades CRUD

La API permite realizar las siguientes operaciones:

- **GET /vuelos**  
  Lista todos los vuelos ordenados por fecha de salida.

- **GET /vuelos/{id}**  
  Obtiene un vuelo concreto por su ID.

- **POST /vuelos**  
  Crea un nuevo vuelo.

- **PUT /vuelos/{id}**  
  Actualiza un vuelo existente.

- **DELETE /vuelos/{id}**  
  Elimina un vuelo por su ID.

---

## 🔍 Filtros y ordenación

La API permite aplicar filtros opcionales mediante parámetros:

- Filtrar por **empresa**
- Filtrar por **lugar de llegada**
- Filtrar por **fecha de salida**

Los filtros se pueden combinar entre sí.

También se puede ordenar el resultado usando parámetros como:

- `ordenarPor=empresa`
- `ordenarPor=lugarLlegada`
- `ordenar=ASC | DESC`

---

## 🧠 Decisiones de diseño

- La **duración del vuelo no se guarda en el repositorio** porque es un dato que se puede calcular a partir de las fechas.  
  De esta forma se evita que quede desactualizado si se modifican las fechas.

- El **controller no accede directamente al repositorio**, sino que delega toda la lógica en el service, manteniendo una buena separación de responsabilidades.

- El repositorio usa un `Map` en memoria para simplificar el proyecto y centrarse en la lógica del CRUD.

---

## ✅ Validaciones

El sistema no permite:

- Crear vuelos sin nombre.
- Fechas incoherentes (fecha de salida posterior a la de llegada).
- Modificar o eliminar vuelos que no existen.

---

## 🧪 Postman

El proyecto incluye una **colección de Postman** con todas las peticiones necesarias para probar la API:

- Listar vuelos
- Buscar por ID
- Crear vuelos
- Actualizar vuelos
- Eliminar vuelos

No es necesario crear vuelos manualmente, ya que el proyecto inicia con **10 vuelos de prueba**.

La colección se encuentra en la carpeta:

