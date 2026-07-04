# Hotel Management Spring Boot Version

## معرفی پروژه

این پروژه نسخه **Spring Boot** سیستم مدیریت هتل است که با زبان **Java** و فریم‌ورک **Spring Boot** پیاده‌سازی شده است.

در این نسخه، پروژه از حالت فایل‌محور خارج شده و داده‌های سیستم به جای ذخیره شدن در فایل‌های متنی، در پایگاه داده ذخیره و مدیریت می‌شوند.

این پروژه با هدف تمرین مفاهیم بک‌اند، معماری لایه‌ای، کار با دیتابیس، طراحی API و استفاده از Spring Boot نوشته شده است.

این نسخه نسبت به نسخه File-Based ساختار کامل‌تر و نزدیک‌تری به پروژه‌های بک‌اند دارد و بیشتر روی جداسازی لایه‌ها، مدیریت داده‌ها، اعتبارسنجی و ارتباط با پایگاه داده تمرکز می‌کند.

---

## هدف پروژه

هدف این پروژه، پیاده‌سازی یک سیستم مدیریت هتل در قالب یک پروژه تمرینی Spring Boot است.

این پروژه برای یادگیری و تمرین مفاهیم زیر توسعه داده شده است:

- توسعه بک‌اند با Spring Boot
- طراحی REST API
- اتصال پروژه Java به پایگاه داده MySQL
- استفاده از Spring Data JPA
- پیاده‌سازی معماری لایه‌ای
- جداسازی Controller, Service, Repository و Entity
- استفاده از DTO برای انتقال داده‌ها
- اعتبارسنجی داده‌ها
- مدیریت خطاها در پروژه بک‌اند
- آماده‌سازی پروژه برای نسخه‌های کامل‌تر و مستندتر

---

## قابلیت‌های اصلی

- مدیریت اطلاعات اتاق‌ها
- مدیریت اطلاعات مهمان‌ها
- مدیریت رزروها
- مدیریت پرداخت‌ها
- مدیریت کارمندان
- مدیریت همراهان مهمان
- ثبت و مدیریت تاریخچه فعالیت‌ها
- ذخیره و بازیابی اطلاعات از پایگاه داده
- ارائه API برای عملیات اصلی سیستم

---

## تکنولوژی‌های استفاده‌شده

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Validation
- MySQL
- Maven
- Lombok

---

## معماری پروژه

این پروژه با معماری لایه‌ای طراحی شده است تا مسئولیت بخش‌های مختلف سیستم از هم جدا باشد.

در این نسخه، پروژه شامل بخش‌های اصلی زیر است:

- **controller**  
  مسئول دریافت درخواست‌ها و ارسال پاسخ‌های API است. کنترلرها درخواست‌ها را دریافت کرده و عملیات لازم را به لایه Service منتقل می‌کنند.

- **service**  
  شامل منطق اصلی برنامه است. قوانین و عملیات مدیریتی سیستم در این بخش پیاده‌سازی می‌شوند.

- **service.impl**  
  شامل پیاده‌سازی سرویس‌ها است و منطق عملیاتی مربوط به سرویس‌ها را اجرا می‌کند.

- **repository**  
  مسئول ارتباط با پایگاه داده است و عملیات ذخیره‌سازی، جستجو و بازیابی داده‌ها را با استفاده از Spring Data JPA انجام می‌دهد.

- **entity**  
  شامل موجودیت‌های اصلی سیستم مانند Room, Guest, Reservation, Payment و Employee است.

- **dto**  
  شامل کلاس‌هایی برای انتقال داده بین لایه‌ها و دریافت یا ارسال اطلاعات از طریق API است.

- **exception**  
  شامل کلاس‌های مربوط به مدیریت خطاها و Exceptionهای پروژه است.

- **util**  
  شامل کلاس‌ها و ابزارهای کمکی مورد استفاده در پروژه است.

- **bootstrap**  
  برای مقداردهی اولیه یا آماده‌سازی داده‌های اولیه پروژه استفاده می‌شود.

---

## ساختار کلی پروژه

```text
springboot-version/
│
└── src/
    ├── README.md
    ├── pom.xml
    ├── mvnw
    ├── mvnw.cmd
    ├── .mvn/
    │
    └── src/
        └── main/
            ├── java/
            │   └── com/
            │       └── matinsoft/
            │           └── hotel/
            │               ├── bootstrap/
            │               ├── controller/
            │               ├── dto/
            │               ├── entity/
            │               ├── exception/
            │               ├── repository/
            │               ├── service/
            │               ├── util/
            │               └── HotelManagementServiceApplication.java
            │
            └── resources/
                ├── static/
                └── application.properties
```

---

## نحوه اجرای پروژه

برای اجرای پروژه:

1. پروژه را Clone یا دانلود کنید.

2. وارد مسیر نسخه Spring Boot شوید:

```bash
cd hotel-management-service/springboot-version/src
```

3. پروژه را در یک IDE مانند IntelliJ IDEA یا Eclipse باز کنید.

4. پایگاه داده MySQL موردنیاز را ایجاد کنید.

5. تنظیمات اتصال به دیتابیس را در فایل `application.properties` بررسی و کامل کنید.

6. پروژه را اجرا کنید.

اجرای پروژه با Maven Wrapper:

```bash
./mvnw spring-boot:run
```

در ویندوز:

```bash
mvnw.cmd spring-boot:run
```

یا در صورت نصب بودن Maven روی سیستم:

```bash
mvn spring-boot:run
```

---

## تنظیمات پایگاه داده

این پروژه برای ذخیره اطلاعات از MySQL استفاده می‌کند.

نمونه تنظیمات پیشنهادی در فایل `application.properties`:

```properties
spring.application.name=HotelManagementService

spring.datasource.url=${DB_URL:jdbc:mysql://127.0.0.1:3306/hoteldb}
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD:}

spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
spring.jpa.hibernate.naming.implicit-strategy=org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl
```

برای اجرای پروژه، می‌توانید اطلاعات دیتابیس را مستقیم برای محیط local خود تنظیم کنید یا از Environment Variables استفاده کنید.

---

## موجودیت‌های اصلی سیستم

در این نسخه، موجودیت‌های اصلی سیستم شامل موارد زیر هستند:

- Room
- Guest
- Reservation
- Payment
- Employee
- Companion
- ActivityHistory

این موجودیت‌ها بخش‌های اصلی سیستم مدیریت هتل را تشکیل می‌دهند و از طریق Repositoryها و Serviceها مدیریت می‌شوند.

---

## تفاوت با نسخه File-Based

در نسخه File-Based، اطلاعات سیستم داخل فایل‌های متنی ذخیره و مدیریت می‌شدند.

اما در این نسخه، همان ایده با استفاده از Spring Boot و پایگاه داده بازطراحی شده است. این نسخه ساختار لایه‌ای کامل‌تری دارد و به معماری رایج پروژه‌های بک‌اند نزدیک‌تر است.

---

## نکات آموزشی پروژه

این پروژه برای تمرین مفاهیم زیر مناسب است:

- توسعه REST API با Spring Boot
- کار با MySQL در پروژه Java
- استفاده از Spring Data JPA
- طراحی Entity و Repository
- استفاده از DTO برای مدیریت ورودی و خروجی داده‌ها
- پیاده‌سازی معماری لایه‌ای
- مدیریت خطاها در پروژه بک‌اند
- استفاده از Maven برای مدیریت وابستگی‌ها
- آماده‌سازی پروژه برای توسعه نسخه‌های کامل‌تر

---

## وضعیت پروژه

این نسخه به عنوان نسخه Spring Boot و دیتابیس‌محور سیستم مدیریت هتل توسعه داده شده است.

پروژه حالت تمرینی و آموزشی دارد و در حال بهبود و تکمیل است.

---

## برنامه‌های آینده

برخی از مواردی که می‌توانند در آینده به این نسخه اضافه یا بهتر شوند:

- اضافه کردن مستندات API با Swagger
- اضافه کردن تست‌های واحد و Integration Test
- بهبود مدیریت خطاها
- اضافه کردن Authentication و Authorization
- اضافه کردن نقش‌های کاربری
- بهبود ساختار پاسخ‌های API
- اتصال پروژه به رابط کاربری Frontend
- تکمیل مستندات تحلیل و طراحی سیستم

---

# Hotel Management Spring Boot Version

## Project Overview

This project is the Spring Boot version of a **Hotel Management System** implemented with **Java** and **Spring Boot**.

In this version, the project has been upgraded from a file-based system to a database-driven backend application. System data is stored and managed in a database instead of text files.

This project was developed as a practice project to learn backend development concepts, layered architecture, database integration, API design, and Spring Boot.

Compared to the File-Based version, this version has a more complete backend structure and focuses on layer separation, data management, validation, and database communication.

---

## Project Goal

The goal of this project is to implement a hotel management system as a Spring Boot practice project.

This project was developed to learn and practice the following concepts:

- Backend development with Spring Boot
- REST API design
- Connecting a Java project to MySQL
- Using Spring Data JPA
- Implementing layered architecture
- Separating Controller, Service, Repository, and Entity layers
- Using DTOs for data transfer
- Data validation
- Error handling in backend projects
- Preparing the project for more complete and documented versions

---

## Main Features

- Room management
- Guest management
- Reservation management
- Payment management
- Employee management
- Companion management
- Activity history management
- Storing and retrieving data from a database
- Providing APIs for the main system operations

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Validation
- MySQL
- Maven
- Lombok

---

## Project Architecture

This project is designed using layered architecture to separate the responsibilities of different parts of the system.

The main parts of the project are:

- **controller**  
  Handles incoming requests and returns API responses. Controllers receive requests and pass the required operations to the Service layer.

- **service**  
  Contains the main business logic of the application. System rules and management operations are implemented in this layer.

- **service.impl**  
  Contains the implementations of service interfaces and executes the actual service logic.

- **repository**  
  Handles communication with the database and performs storing, searching, and retrieving operations using Spring Data JPA.

- **entity**  
  Contains the main system entities such as Room, Guest, Reservation, Payment, and Employee.

- **dto**  
  Contains data transfer objects used for receiving and sending data through APIs.

- **exception**  
  Contains classes related to error handling and project exceptions.

- **util**  
  Contains utility and helper classes used in the project.

- **bootstrap**  
  Used for initial data setup or project startup preparation.

---

## Project Structure

```text
springboot-version/
│
└── src/
    ├── README.md
    ├── pom.xml
    ├── mvnw
    ├── mvnw.cmd
    ├── .mvn/
    │
    └── src/
        └── main/
            ├── java/
            │   └── com/
            │       └── matinsoft/
            │           └── hotel/
            │               ├── bootstrap/
            │               ├── controller/
            │               ├── dto/
            │               ├── entity/
            │               ├── exception/
            │               ├── repository/
            │               ├── service/
            │               ├── util/
            │               └── HotelManagementServiceApplication.java
            │
            └── resources/
                ├── static/
                └── application.properties
```

---

## How to Run

To run the project:

1. Clone or download the project.

2. Go to the Spring Boot version directory:

```bash
cd hotel-management-service/springboot-version/src
```

3. Open the project in an IDE such as IntelliJ IDEA or Eclipse.

4. Create the required MySQL database.

5. Check and complete the database configuration in `application.properties`.

6. Run the project.

Run with Maven Wrapper:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

Or run with Maven installed on your system:

```bash
mvn spring-boot:run
```

---

## Database Configuration

This project uses MySQL for storing system data.

Example configuration in `application.properties`:

```properties
spring.application.name=HotelManagementService

spring.datasource.url=${DB_URL:jdbc:mysql://127.0.0.1:3306/hoteldb}
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD:}

spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
spring.jpa.hibernate.naming.implicit-strategy=org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl
```

To run the project, you can configure your local database settings directly or use environment variables.

---

## Main Entities

The main entities in this version include:

- Room
- Guest
- Reservation
- Payment
- Employee
- Companion
- ActivityHistory

These entities represent the main parts of the hotel management system and are managed through repositories and services.

---

## Difference from the File-Based Version

In the File-Based version, system data was stored and managed using text files.

In this version, the same idea has been redesigned using Spring Boot and database integration. This version has a more complete layered structure and is closer to common backend project architecture.

---

## Educational Concepts

This project is useful for practicing the following concepts:

- Developing REST APIs with Spring Boot
- Working with MySQL in a Java project
- Using Spring Data JPA
- Designing Entities and Repositories
- Using DTOs for input and output data
- Implementing layered architecture
- Handling errors in backend projects
- Using Maven for dependency management
- Preparing the project for more complete versions

---

## Project Status

This version was developed as the Spring Boot and database-based version of the Hotel Management System.

The project is educational and practice-oriented, and it is still being improved and completed.

---

## Future Improvements

Possible future improvements include:

- Adding API documentation with Swagger
- Adding unit tests and integration tests
- Improving error handling
- Adding authentication and authorization
- Adding user roles
- Improving API response structure
- Connecting the project to a frontend application
- Completing system analysis and design documentation
