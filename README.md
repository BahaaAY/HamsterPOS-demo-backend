# HamsterPOS Demo API

This is a simple REST API for a Point of Sale (POS) system built using Spring Boot. The API supports product management/ inventory management (low stock alert), and cart operations.

## Postman Collection

You can explore and test the API using the Postman collection available [here](https://www.postman.com/interstellar-robot-169983/workspace/hamsterpos-exam).
## Table of Contents

- [Requirements](#requirements)
- [Setup](#setup)
- [Endpoints](#endpoints)
  - [Product Endpoints](#product-endpoints)
  - [Cart Endpoints](#cart-endpoints)

## Requirements

- Java 17
- Spring Boot
- H2 Database:  H2 is used as an in-memory database to facilitate testing and development of the Spring Boot API. This means that H2 operates entirely within the application's memory, allowing for rapid setup and teardown of the database environment. Using H2 in this way ensures that testing is quick and isolated, with no permanent data storage or configuration required. 

## Setup

1. Clone the repository:

    ```bash
    git clone https://github.com/BahaaAY/HamsterPOS-demo-backend.git
    cd HamsterPOS-demo-backend
    ```

2. Build the project:

    ```bash
    ./gradlew build
    ```

3. Run the application:

    ```bash
    ./gradlew bootRun
    ```

4. The API will be available at `http://localhost:8080`.

## Endpoints

### Product Endpoints

#### Add a Product

- **URL:** `/api/products`
- **Method:** `POST`
- **Request Body:**

    ```json
    {
        "name": "Product Name",
        "price": 10.5,
        "quantity": 100,
        "reorderLevel": 10
    }
    ```

- **Response:**

    ```json
    {
        "id": 1,
        "name": "Product Name",
        "price": 10.5,
        "quantity": 100,
        "reorderLevel": 10
    }
    ```
    
#### Get All Products

- **URL:** `/api/products`
- **Method:** `GET`
- **Response:**

    ```json
    [
        {
            "id": 1,
            "name": "Product Name",
            "price": 10.5,
            "quantity": 100,
            "reorderLevel": 10
        },
    ]
    ```

#### Get Product by ID

- **URL:** `/api/products/{productId}`
- **Method:** `GET`
- **Response:**

    ```json
    {
        "id": 1,
        "name": "Product Name",
        "price": 10.5,
        "quantity": 100,
        "reorderLevel": 10
    }
    ```

#### Update Product

- **URL:** `/api/products/{productId}`
- **Method:** `PUT`
- **Request Body:**

    ```json
    {
        "name": "Updated Product Name",
        "price": 12.5,
        "quantity": 90,
        "reorderLevel": 10
    }
    ```

- **Response:**

    ```json
    {
        "id": 1,
        "name": "Updated Product Name",
        "price": 12.5,
        "quantity": 90,
        "reorderLevel": 10
    }
    ```

#### Delete Product

- **URL:** `/api/products/{productId}`
- **Method:** `DELETE`
- **Response:** `204 No Content`

### Inventory Endpoints

#### Get Low Stock Products
returns products that have product quantity less than reorderLevel
- **URL:** `/api/products/low-stock`
- **Method:** `GET`
- **Response:**

    ```json
    [
        {
            "id": 1,
            "name": "Product Name",
            "price": 10.5,
            "quantity": 10,
            "reorderLevel": 10
        },
    ]
    ```

### Cart Endpoints

#### Add Product to Cart

- **URL:** `/api/cart/add/{productId}/{quantity}`
- **Method:** `POST`
- **Response:**

    ```json
    {
        "message": "Product added to cart."
    }
    ```

    or

    ```json
    {
        "message": "Not enough stock for product: Product Name"
    }
    ```

#### Remove Product from Cart

- **URL:** `/api/cart/remove/{productId}`
- **Method:** `DELETE`
- **Response:**

    ```json
    {
        "products": {
            "1": 2,
            "2": 1
        },
        "totalPrice": 31.0,
        "discountedPrice": 31.0
    }
    ```

#### View Cart

- **URL:** `/api/cart`
- **Method:** `GET`
- **Response:**

    ```json
    {
        "products": {
            "1": 2,
            "2": 1
        },
        "totalPrice": 31.0,
        "discountedPrice": 31.0
    }
    ```

#### Checkout

- **URL:** `/api/cart/checkout`
- **Method:** `POST`
- **Response:**

    ```json
    {
        "message": "Order placed successfully. Cart is now empty."
    }
    ```

    or

    ```json
    {
        "message": "Not enough stock for product: Product Name"
    }
    ```

