# Customer and Order Management System

This Spring Boot application allows users to manage customer and order data with basic **CRUD** operations (Create, Read, Update). It also includes a custom query for retrieving orders by customer using a database join. The application uses **JPA**, **Thymeleaf** (or **JSP** if preferred), and **MySQL**.

## Features
- **Customer Management**:
  - Create a new customer.
  - List all customers.
  - Update customer information.
  
- **Order Management**:
  - Create orders for customers.
  - View orders by a specific customer using a custom query.

## Technologies Used
- **Spring Boot** - Main framework for building the application.
- **JPA (Java Persistence API)** - For database interaction.
- **MySQL** - Database to store customer and order data.
- **Thymeleaf/JSP** - Template engines to render HTML views.
- **Maven** - Dependency management.

## Setup Instructions

### Prerequisites
- **Java 11 or higher**
- **Maven**
- **MySQL** or any other relational database (instructions are provided for MySQL setup).

### Steps to Run the Project

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/customer-order-management.git
   cd customer-order-management
2. **Setup the Database**
    Create a new database in MySQL:
    ```bash
    CREATE DATABASE customer_order_db;
  Update your database credentials in src/main/resources/application.properties:
  
    spring.datasource.url=jdbc:mysql://localhost:3306/customer_order_db
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect

3. Run the Application
    Start the Spring Boot application:
    ```bash
    mvn spring-boot:run
  The application will run on http://localhost:8080.


