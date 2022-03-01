Client Manager - My first Spring Boot API
=
This project is not made to solve any specific need, but to show how to apply different technologies.

## These are the technologies I have used in the project:

- Maven (To manage dependencies)
- Lombok (For Getters and Setters)
- Hibernate (Java ORM for the Database)
- Argon2 (Cryptographic algorithm to hash the passwords)
- Data-tables (Javascript library to list the clients)
- JWT (Standardized JSON based token)

## Available features

- Register
- Login
- List registered users

## Images

> Password is encripted with Argon2 and saved in the DB to avoid anyone can see it, not even the system administrador. 

![mysql](https://i.imgur.com/WQdnn0U.png "Screenshoot of the Database")


---

> You only can see the information if you are registered and your token is valid.

![data](https://i.imgur.com/ofI2tMe.png)
![data](https://i.imgur.com/N5un5Nk.png)
