# REST API for Car Database

Java Spring Boot back-end web application that exposes REST API for CRUD operations of car database application.

For project front-end repository go to [https://github.com/Raphaelhhc/CarDataBase-FrontEnd-TypeScript](https://github.com/Raphaelhhc/CarDataBase-FrontEnd-TypeScript)


## Technology Stack

- Java: Programming Language
- Spring Boot: Java-based framework for building REST API
- MySQL on AWS RDS: Relational database built on AWS
- Okta: Secure identity management platform for user authentication and authorization

## API Endpoints and their functions

| Endpoint                                                               | Function                                                                          | Secure | Roles                |
|------------------------------------------------------------------------|-----------------------------------------------------------------------------------|--------|----------------------|
| `GET /api/cars`                                                        | get car's specification                                                           | No     | Visitor, User, Admin |
| `GET /api/cars/<carId>`                                                | get car's specification of the car                                                | No     | Visitor, User, Admin |
| `GET /api/cars/search/findByModelnameContaining?modelname=<modelname>` | search car by model name containing inputted text and get the car's specification | No     | Visitor, User, Admin |
| `GET /api/cars/search/findByBodystyle?bodystyle=<bodystyle>`           | search car by attribute of body style and get the car's specification             | No     | Visitor, User, Admin |
| `GET /api/reviews/search/findByCarId?carId=<carId>`                    | get reviews of the car                                                            | No     | Visitor, User, Admin |
| `GET /api/secure/reviews/user/car?carId=<carId>`                       | get user's review of the car                                                      | Yes    | User, Admin          |
| `GET /api/secure/cars/currentfavorite `                                | get user's list of favorite cars                                                  | Yes    | User, Admin          |
| `GET /api/secure/cars/isfavorite/byuser?carId=<carId>`                 | get boolean of the car is in user's favorite list or not                          | Yes    | User, Admin          |
| `PUT /api/secure/cars/favorite?carId=<carId>`                          | Add the car to user's favorite list                                               | Yes    | User, Admin          |
| `PUT /api/secure/cars/removefavorite?carId=<carId>`                    | Remove the car from user's favorite list                                          | Yes    | User, Admin          |
| `POST /api/secure/reviews`                                             | Post review of the car                                                            | Yes    | User, Admin          |
| `POST /api/secure/admin/add/car`                                       | Post new car                                                                      | Yes    | Admin                |
| `PUT /api/secure/admin/update/car?carId=<carId>`                       | Update car's specification info                                                   | Yes    | Admin                |
| `DELETE /api/secure/admin/delete/car?carId=<carId>`                    | Delete the car from database                                                      | Yes    | Admin                |


## Start the Application

### 1. Prerequisites

Make sure you have the following prerequisites installed on your machine:

- Java Development Kit (JDK) 17 or higher

- Apache Maven

### 2. Clone the repository
```
git clone https://github.com/Raphaelhhc/CarDataBase-Backend-SpringBoot
```

### 3. Navigate to the project directory and build the project using Maven
```
cd CarDataBase-Backend-SpringBoot
mvn clean install
```

### 4. Modify the application.properties to provide the environment variables
```
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

okta.oauth2.clientId=${OKTA_ID}
okta.oauth2.issuer=${OKTA_ISSUER}
```
* If no OKTA account: refer to [https://developer.okta.com/](https://developer.okta.com/) to create and build application to manage user/admin account.

### 5. Run the application
```
mvn spring-boot:run
```

### 6. Access the application http://localhost:8080/ + API Endpoints
