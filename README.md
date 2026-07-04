# TechLab-ecommerce-Spring-Boot
Versión del proyecto TechLab- ecommerce con Java Spring Boot para curso de Talento Tech: Back End Java // !er. Cuat.2026

## Descripción del proyecto
Backend de un sistema de ecommerce desarrollado con Spring Boot.
Permite gestionar 
- productos, 
- categorías
- carritos de compra.


## Arquitectura del proyecto
El proyecto está organizado en capas:

src/main/java/com/ecommerce/
```
 ├── config/
 ├── controller/
 ├── exception/
 ├── model/
 ├── repository/
 ├── service/
 └── EcommerceApplication.java
```

## Tecnologías utilizadas
- Java 17
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Lombok
- Maven

El proyecto utiliza Maven como gestor de dependencias. Esto se identifica porque el proyecto contiene un archivo pom.xml en la raíz y sigue la estructura estándar de Maven (src/main/java y src/main/resources).

## Configuración de base de datos
El backend utiliza el motor de base de datos MySQL y una base llamada techlabdb.
La configuración se realiza en application.properties, donde se define:

- la URL de conexión a la base
- el usuario y contraseña de MySQL
- el driver JDBC
- las propiedades de JPA/Hibernate

### Requisitos previos
Tener MySQL instalado
Crear la base:
- **CREATE DATABASE techlabdb;**

## Carga inicial de datos
El proyecto incluye un CommandLineRunner que carga categorías y productos solo si la base está vacía.
Esto permite iniciar el backend con datos listos para probar.
El catálogo inicial está organizado de la siguiente manera:
* **Fruta Seca:** Nueces, Almendras, Pasas rubias/negras, Ciruelas, Castañas, Dátiles y Pistachos.
* **Varios:** Granola Premium, Aceite de Coco (Neutro/Virgen), Miel Orgánica, Crema de Maní y Hummus.

### Entidades
**Categorías**

- id: autogenerado
- nombre: obligatorio
- descripcion: opcional

**Producto**

- id: autogenerado
- nombre: obligatorio
- precio: mayor que cero
- stock: no negativo 
- imagenUrl: opcional
- categoria: relación ManyToOne con Categoria

**Carrito**

- id: autogenerado
- productos: lista de ítems del carrito
    - cascade = ALL: elimina ítems al eliminar el carrito
    - orphanRemoval = true: elimina ítems si se quitan de la lista

**CarritoProducto**

- id: autogenerado
- carrito: relación ManyToOne
- producto: relación ManyToOne
- cantidad: cantidad del producto dentro del carrito

### Endpoints disponibles
**Producto**
| Método | Endpoint | Descripción |
| --- | --- | --- |
| GET | ``/productos`` | Lista todos los productos |
| GET | ``/productos/{id}`` | Obtiene un producto |
| POST | ``/productos`` | Crea un producto |
| PUT | ``/productos/{id}`` | Actualiza un producto |
| DELETE | ``/productos/{id}`` | Elimina un producto |

**Categorías**
| Método | Endpoint | Descripción |
| --- | --- | --- |
| GET | ``/categorias`` | Lista todas las categorías |
| GET | ``/categorias/{id}`` | Obtiene una categoría |
| POST | ``/categorias`` | Crea una categoría |
| PUT | ``/categorias/{id}`` | Actualiza una categoría |
| DELETE | ``/categorias/{id}`` | Elimina una categoría |

**Carrito**
| Método | Endpoint | Descripción |
| --- | --- | --- |
| POST | ``/carritos`` | Crea un carrito |
| GET | ``/carritos/{id}`` | Obtiene un carrito |
| POST | ``/carritos/{id}/productos/{idProducto}`` | Agrega producto |
| DELETE | ``/carritos/{id}/productos/{idProducto}`` | Elimina producto |
| DELETE | ``/carritos/{id}/vaciar`` | Vacía el carrito |
| DELETE | ``/carritos/{id}`` | Elimina el carrito |

### Ejemplos de Pruebas con Thunder Client
**Crear producto**

**POST** `http://localhost:8080/productos`  
Body →
```json
{
  "nombre": "Nueces Peladas",
  "precio": 19800,
  "stock": 30,
  "imagenUrl": "https://...",
  "categoria": { "id": 1 }
}
```
**Crear categoría**
**POST** `http://localhost:8080/categorias`  
Body →
```json
{
  "nombre": "Fruta Seca",
  "descripcion": "Fruta seca y deshidratada"
}
```
**Crear carrito**
**POST** `http://localhost:8080/carritos`  
Sin body.  
```json
{
  "id": 1,
  "productos": []
}
```


## Cómo ejecutar el proyecto
El proyecto se ejecuta desde Visual Studio Code:

1. Abrir EcommerceApplication.java 
2. Presionar Run Java
3. La API queda disponible en http://localhost:8080

### Clonar el repositorio

git clone https://github.com/Adrilu-web/ecommerce-SpringBoot.git


## Mejoras futuras
- Autenticación con JWT
- Roles (admin / usuario)
