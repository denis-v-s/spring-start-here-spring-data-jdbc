# Spring Data JDBC Example
This is a Spring Boot application that demonstrates a simple banking system with support for account management and money transfers. It uses Spring Data JDBC for database interactions and H2 as the in-memory database. The main focus is transactional operations, specifically when transferring money.

## Features

- **Account Management**: View all accounts and their balances.
- **Money Transfer**: Transfer money between accounts with transactional support to ensure data consistency.

## Project Structure

### Key Components

#### 1. **Controller**
- [`AccountController`](src/main/java/com/example/spring_data_jdbc/controller/AccountController.java): Handles HTTP requests for account operations and money transfers.

#### 2. **Model**
- [`Account`](src/main/java/com/example/spring_data_jdbc/model/Account.java): Represents an account with fields for `id`, `name`, and `amount`.
- [`TransferRequest`](src/main/java/com/example/spring_data_jdbc/model/TransferRequest.java): Represents a request to transfer money between accounts.

#### 3. **Repository**
- [`AccountRepository`](src/main/java/com/example/spring_data_jdbc/repository/AccountRepository.java): Provides methods to interact with the database, such as finding accounts and updating balances.

#### 4. **Service**
- [`TransferService`](src/main/java/com/example/spring_data_jdbc/service/TransferService.java): Contains the business logic for transferring money between accounts. It ensures transactional consistency.

#### 5. **Exception**
- [`AccountNotFoundException`](src/main/java/com/example/spring_data_jdbc/exception/AccountNotFoundException.java): A custom exception thrown when an account is not found in the database.

#### 6. **Database**
- `schema.sql`: Defines the `account` table structure.
- `data.sql`: Populates the database with initial data.

#### 7. **Application**
- [`SpringDataJdbcApplication`](src/main/java/com/example/spring_data_jdbc/SpringDataJdbcApplication.java): The main entry point of the Spring Boot application.

## How to Run

1. **Prerequisites**:
   - Java 17 or higher.
   - Maven.

2. **Build and Run**:
   ```bash
   ./mvnw spring-boot:run
   ```

## API Endpoints

- **Get All Accounts**
  - `GET /accounts`
  - Response: A list of all accounts with their details.

- ** Get Account By Name**
  - `GET /accounts?name=Jane+Down`
  - Response: Jane Down's account

- **Transfer Money**
  - `POST /transfer`
  - Request Body:
    ```json
    {
      "idSender": 1,
      "idReceiver": 2,
      "amount": 100.00
    }
    ```
  - Response: Confirmation of the transfer.