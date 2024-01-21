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


