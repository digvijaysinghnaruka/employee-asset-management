# Employee Asset Management System

A Spring Boot REST API project for managing employees and company assets.

This system allows organizations to manage employees, track company assets, assign assets to employees, return assets, and manage asset status.

## Features

- Create and manage employees
- Create and manage company assets
- Assign assets to employees
- Return assigned assets
- Track asset status
- Asset repair management
- Employee and asset validation
- Exception handling
- DTO-based API responses

## Tech Stack

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Maven
- REST API
- Git & GitHub

## Project Structure

```text
src/main/java/employee_asset_management
├── controller
├── dto
├── entity
├── exception
├── repository
├── service
└── EmployeeAssetManagementApplication.java

## API Endpoints

### Employee APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/employees` | Create employee |
| GET | `/api/employees` | Get all employees |
| GET | `/api/employees/{id}` | Get employee by ID |
| PUT | `/api/employees/{id}` | Update employee |
| DELETE | `/api/employees/{id}` | Delete employee |

### Asset APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/assets` | Create asset |
| GET | `/api/assets` | Get all assets |
| GET | `/api/assets/{id}` | Get asset by ID |
| PUT | `/api/assets/{id}` | Update asset |
| DELETE | `/api/assets/{id}` | Delete asset |
| POST | `/api/assets/{assetId}/assign/{employeeId}` | Assign asset |
| POST | `/api/assets/{assetId}/return` | Return asset |
| POST | `/api/assets/{assetId}/repair` | Send asset for repair |

## How to Run

### Prerequisites

- Java 17 or later
- Maven
- MySQL
- IntelliJ IDEA (recommended)

### Steps

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Create a MySQL database named `employee_asset_management`.
4. Update MySQL username and password in `application.properties`.
5. Run `EmployeeAssetManagementApplication`.
6. The application will start on port `8080`.

### Base URL

`http://localhost:8080`

## Example Request

### Create Employee

**POST** `/api/employees`

```json
{
  "name": "Amit",
  "email": "amit@gmail.com",
  "department": "IT"
}
```

### Assign Asset

**POST** `/api/assets/1/assign/2`

This assigns asset `1` to employee `2`.

## Project Status

🚧 This project is currently under development.

The core employee and asset management features are implemented, with additional improvements planned for future development.