# 🌐 Hotel API Backend -- Spring Boot

Documentación completa y estilizada de la Hotel API del backend, disponible en
**español** e **inglés**.

------------------------------------------------------------------------

# 🇪🇸 Documentación en Español

## 📑 Tabla de Contenidos

-   [Usuarios](#usuarios)
    -   [POST /register](#post-register)
-   [Hoteles](#hoteles)
    -   [POST /hotels](#post-hotels)
    -   [GET /hotels (con filtros y paginación)](#get-hotels)
    -   [PATCH /hotelsid](#patch-hotelsid)
    -   [DELETE /hotelsid](#delete-hotelsid)

------------------------------------------------------------------------

# 👤 Usuarios

## POST /register

Crea un nuevo usuario.

### URL

    POST /register

### Body (JSON)

``` json
{
  "username": "juan",
  "password": "123456"
  "role": "ADMIN"
}
```

### Respuesta esperada (201)

``` json
{
  "id": 1,
  "username": "juan"
}
```

------------------------------------------------------------------------

# 🏨 Hoteles

## POST /hotels

Crea un nuevo hotel.

### URL

    POST /hotels

### Body (JSON)

``` json
{
  "name": "Hotel Gran Canaria",
	"stars": 5,
	"address": {
    "street": "Av. de Las Canteras 123",
    "city": "Las Palmas de Gran Canaria",
    "country": "España",
    "zipCode": "35010"
  }
}
```

### Respuesta esperada (201)

``` json
{
  "id": 12,
  "name": "Hotel Gran Canaria",
}
```

------------------------------------------------------------------------

## GET /hotels

Obtiene la lista de hoteles con soporte para filtrar por ciudad, paginación
y ordenación.

### URL

    GET /hotels

### Parámetros opcionales

| Parámetro | Tipo     | Obligatorio | Descripcion                                     |
|-----------|----------|-------------|-------------------------------------------------|
| 'city'    | String   | No          | Filtra por ciudad                               |
| 'page'    | int      | No          | Número de página (0 por defecto)                |
| 'size'    | int      | No          | Cantidad de hoteles por página (10 por defecto) |
| 'sort'    | String[] | No          | Campo de ordenación                             |

### Ejemplo de Request

    GET /hotels?city=Las Palmas de Gran Canaria&page=0&size=5&sort=name,asc

### Respuesta esperada (200)

``` json
{
  "content": [
    {
      "id": 1,
      "name": "AC Hotel Gran Canaria",
			"stars": 5,
			"address": {
			   "street": "C. Eduardo Benot 3-5",
			   "city": "Las Palmas de Gran Canaria",
			   "country": "España",
			   "zipCode": "35007"
      }
    },
    {
      "id": 2,
      "name": "Hotel Cristina",
			"stars": 4,
			"address": {
			   "street": "C. Gomera 6",
			   "city": "Las Palmas de Gran Canaria",
			   "country": "España",
			   "zipCode": "35008"
      }
    },
  ],
  "number": 0,
  "size": 2,
  "totalElements": 2,
  "totalPages": 1,
  "first": true,
  "last": false,
  "numberOfElements": 2,
  "sort": {
    "empty": false,
    "sorted": true,
    "unsorted": false
  },
  "pageable": {
    "pageNumber": 0,
    "pageSize": 5,
    "offset": 0,
    "paged": true,
    "unpaged": false,
    "sort": {
      "empty": false,
      "sorted": true,
      "unsorted": false
    }
  },
  "empty": false
}
```

------------------------------------------------------------------------

## PATCH /hotels/{id}

Actualiza la dirección de un hotel.

### URL

    PATCH /hotels/{id}

### Body (JSON)

``` json
{
  "street": "Av. de Las Canteras 123",
	"city": "Las Palmas de Gran Canaria",
  "country": "España",
  "zipCode": "35010"
}
```

### Respuesta esperada (200)

``` json
{
  "id": "1",
  "new_street": "Av. de Las Canteras 123",
  "new_city": "Las Palmas de Gran Canaria",
  "new_country": "España",
  "new_zipCode": "35010"
}
```

------------------------------------------------------------------------

## DELETE /hotels/{id}

Elimina un hotel por ID.

### URL

    DELETE /hotels/{id}

### Respuesta esperada (204)

Sin contenido.

------------------------------------------------------------------------

------------------------------------------------------------------------

# 🇬🇧 Documentation in English

## 📑 Table of Contents

-   [Users](#users)
    -   [POST /register](#post-register-1)
-   [Hotels](#hotels-1)
    -   [POST /hotels](#post-hotels-1)
    -   [GET /hotels (filters & pagination)](#get-hotels-1)
    -   [PATCH /hotelsid](#patch-hotelsid-1)
    -   [DELETE /hotelsid](#delete-hotelsid-1)

------------------------------------------------------------------------

# 👤 Users

## POST /register

Creates a new user

### URL

    POST /register

### Body (JSON)

``` json
{
  "username": "juan",
  "password": "123456"
  "role": "ADMIN"
}
```

### Response (201)

``` json
{
  "id": 1,
  "username": "juan"
}
```

------------------------------------------------------------------------

# 🏨 Hotels

## POST /hotels

Creates a new hotel.

### URL

    POST /hotels

### Body (JSON)

``` json
{
  "name": "Hotel Gran Canaria",
	"stars": 5,
	"address": {
    "street": "Av. de Las Canteras 123",
    "city": "Las Palmas de Gran Canaria",
    "country": "España",
    "zipCode": "35010"
  }
}
```

### Expected response (201)

``` json
{
  "id": 12,
  "name": "Hotel Gran Canaria",
}
```

------------------------------------------------------------------------

## GET /hotels

Retrieves the list of hotels with support for filtering by city, pagination, and sorting.

### URL

    GET /hotels

### Optional parameters

| Parameter | Type     | Required | Description                               |
| --------- | -------- | -------- | ----------------------------------------- |
| `city`    | String   | No       | Filters by city                           |
| `page`    | int      | No       | Page number (0 by default)                |
| `size`    | int      | No       | Number of hotels per page (10 by default) |
| `sort`    | String[] | No       | Sorting field                             |

### Request example

    GET /hotels?city=Las Palmas de Gran Canaria&page=0&size=5&sort=name,asc

### Expected response (200)

``` json
{
  "content": [
    {
      "id": 1,
      "name": "AC Hotel Gran Canaria",
			"stars": 5,
			"address": {
			   "street": "C. Eduardo Benot 3-5",
			   "city": "Las Palmas de Gran Canaria",
			   "country": "España",
			   "zipCode": "35007"
      }
    },
    {
      "id": 2,
      "name": "Hotel Cristina",
			"stars": 4,
			"address": {
			   "street": "C. Gomera 6",
			   "city": "Las Palmas de Gran Canaria",
			   "country": "España",
			   "zipCode": "35008"
      }
    },
  ],
  "number": 0,
  "size": 2,
  "totalElements": 2,
  "totalPages": 1,
  "first": true,
  "last": false,
  "numberOfElements": 2,
  "sort": {
    "empty": false,
    "sorted": true,
    "unsorted": false
  },
  "pageable": {
    "pageNumber": 0,
    "pageSize": 5,
    "offset": 0,
    "paged": true,
    "unpaged": false,
    "sort": {
      "empty": false,
      "sorted": true,
      "unsorted": false
    }
  },
  "empty": false
}
```

------------------------------------------------------------------------

## PATCH /hotels/{id}

Updates a hotel's address.

### URL

    PATCH /hotels/{id}

### Body (JSON)

``` json
{
  "street": "Av. de Las Canteras 123",
	"city": "Las Palmas de Gran Canaria",
  "country": "España",
  "zipCode": "35010"
}
```

### Expected response (200)

``` json
{
  "id": "1",
  "new_street": "Av. de Las Canteras 123",
  "new_city": "Las Palmas de Gran Canaria",
  "new_country": "España",
  "new_zipCode": "35010"
}
```

------------------------------------------------------------------------

## DELETE /hotels/{id}

Deletes a hotel by ID.

### URL

    DELETE /hotels/{id}

### Expected response (204)

Sin contenido.
