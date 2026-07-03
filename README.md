# Hotel Management Service

## معرفی پروژه

پروژه **Hotel Management Service** یک سیستم مدیریت هتل است که با زبان **Java** پیاده‌سازی شده و هدف آن مدیریت بخش‌های اصلی یک هتل مانند اتاق‌ها، مهمان‌ها و رزروها است.

این پروژه در دو نسخه جداگانه توسعه داده شده است تا روند پیشرفت و تکامل سیستم از یک پیاده‌سازی ساده‌تر تا یک ساختار حرفه‌ای‌تر بک‌اند را نشان دهد.

## نسخه‌های پروژه

این ریپو شامل دو نسخه اصلی از سیستم مدیریت هتل است:

### 1. نسخه File-Based و Layered Architecture

در این نسخه، پروژه با استفاده از Java و معماری لایه‌ای پیاده‌سازی شده است. اطلاعات سیستم به جای استفاده از پایگاه داده، داخل فایل‌ها ذخیره و مدیریت می‌شوند.

هدف این نسخه، تمرکز روی مفاهیم پایه‌ای برنامه‌نویسی شیءگرا، جداسازی لایه‌ها، مدیریت داده‌ها و طراحی منطقی سیستم است.

ویژگی‌های این نسخه:

* پیاده‌سازی با Java
* استفاده از معماری لایه‌ای
* ذخیره‌سازی اطلاعات در فایل
* مدیریت اتاق‌ها
* مدیریت مهمان‌ها
* مدیریت رزروها
* مناسب برای درک ساختار اولیه سیستم‌های مدیریتی

### 2. نسخه Spring Boot و Database

در این نسخه، پروژه با استفاده از **Spring Boot** توسعه داده شده و داده‌ها در پایگاه داده ذخیره می‌شوند. این نسخه ساختار حرفه‌ای‌تری دارد و به معماری رایج در پروژه‌های بک‌اند نزدیک‌تر است.

هدف این نسخه، ارتقای پروژه از حالت فایل‌محور به یک سیستم بک‌اند واقعی‌تر با استفاده از فریم‌ورک Spring Boot و پایگاه داده است.

ویژگی‌های این نسخه:

* پیاده‌سازی با Spring Boot
* اتصال به پایگاه داده
* ساختار مناسب‌تر برای توسعه بک‌اند
* استفاده از Maven
* جداسازی بهتر لایه‌های پروژه
* مناسب برای توسعه API و منطق سمت سرور

## هدف پروژه

هدف اصلی این پروژه فقط ساخت یک سیستم مدیریت هتل نیست؛ بلکه نمایش مسیر رشد پروژه از یک نسخه ساده‌تر به یک نسخه پیشرفته‌تر است.

در نسخه اول، تمرکز روی منطق برنامه‌نویسی، فایل‌ها و معماری لایه‌ای است.
در نسخه دوم، همان ایده با استفاده از Spring Boot و پایگاه داده توسعه داده شده تا به یک ساختار واقعی‌تر و قابل گسترش‌تر نزدیک شود.

## تکنولوژی‌های استفاده‌شده

### نسخه File-Based

* Java
* Object-Oriented Programming
* Layered Architecture
* File Handling

### نسخه Spring Boot

* Java
* Spring Boot
* Maven
* Database
* Backend Development

## ساختار کلی پروژه

```text
hotel-management-service/
│
├── file-based-version/
│   └── نسخه فایل‌محور پروژه با معماری لایه‌ای
│
├── springboot-version/
│   └── نسخه Spring Boot پروژه همراه با پایگاه داده
│
└── README.md
```

## نحوه اجرای پروژه

### اجرای نسخه File-Based

برای اجرای نسخه فایل‌محور:

1. وارد پوشه `file-based-version` شوید.
2. پروژه را در IDE موردنظر خود مانند IntelliJ IDEA یا Eclipse باز کنید.
3. کلاس اصلی پروژه را اجرا کنید.
4. اطلاعات سیستم از طریق فایل‌ها مدیریت می‌شود.

### اجرای نسخه Spring Boot

برای اجرای نسخه Spring Boot:

1. وارد پوشه `springboot-version` شوید.
2. پروژه را در IDE موردنظر خود باز کنید.
3. تنظیمات پایگاه داده را در فایل مربوط به تنظیمات پروژه، مانند `application.properties` یا `application.yml`، بررسی و کامل کنید.
4. پایگاه داده موردنیاز را ایجاد کنید.
5. پروژه را با Maven یا از طریق IDE اجرا کنید.

نمونه اجرای پروژه با Maven:

```bash
mvn spring-boot:run
```

## قابلیت‌های اصلی سیستم

* مدیریت اطلاعات اتاق‌ها
* مدیریت اطلاعات مهمان‌ها
* ثبت و مدیریت رزروها
* ذخیره و بازیابی اطلاعات
* جداسازی بخش‌های مختلف سیستم
* توسعه پروژه در دو نسخه متفاوت

## نکات آموزشی پروژه

این پروژه برای تمرین و یادگیری مفاهیم زیر مناسب است:

* برنامه‌نویسی شیءگرا در Java
* طراحی سیستم‌های مدیریتی
* معماری لایه‌ای
* کار با فایل‌ها در Java
* آشنایی با Spring Boot
* اتصال پروژه به پایگاه داده
* ساختاردهی بهتر پروژه‌های بک‌اند

## برنامه‌های آینده

برخی از ایده‌هایی که می‌توانند در آینده به پروژه اضافه شوند:

* اضافه کردن REST API کامل
* اضافه کردن اعتبارسنجی داده‌ها
* اضافه کردن سیستم ورود و نقش‌های کاربری
* بهبود مدیریت خطاها
* اضافه کردن تست‌های واحد
* اضافه کردن مستندات API
* طراحی رابط کاربری برای سیستم

---

# Hotel Management Service

## Project Overview

**Hotel Management Service** is a Java-based hotel management system designed to manage core hotel operations such as rooms, guests, and reservations.

This project is developed in two separate versions to demonstrate the evolution of the system from a simpler file-based implementation to a more professional backend structure using Spring Boot and a database.

## Project Versions

This repository contains two main versions of the hotel management system:

### 1. File-Based Version with Layered Architecture

In this version, the project is implemented using Java and a layered architecture. Instead of using a database, the system stores and manages data through files.

The main purpose of this version is to focus on object-oriented programming, layered design, data management, and the basic logic of a management system.

Features of this version:

* Implemented with Java
* Uses layered architecture
* Stores data in files
* Manages rooms
* Manages guests
* Manages reservations
* Suitable for understanding the basic structure of management systems

### 2. Spring Boot Version with Database

In this version, the project is developed using **Spring Boot**, and data is stored in a database. This version has a more professional structure and is closer to real-world backend applications.

The main purpose of this version is to upgrade the project from a file-based system to a more realistic backend application using Spring Boot and database integration.

Features of this version:

* Implemented with Spring Boot
* Connected to a database
* Better structure for backend development
* Uses Maven
* Improved separation of project layers
* Suitable for API and server-side logic development

## Project Goal

The main goal of this project is not only to build a hotel management system, but also to show the development path of a software project.

The first version focuses on programming logic, file handling, and layered architecture.
The second version improves the same idea using Spring Boot and a database to create a more scalable and realistic backend structure.

## Technologies Used

### File-Based Version

* Java
* Object-Oriented Programming
* Layered Architecture
* File Handling

### Spring Boot Version

* Java
* Spring Boot
* Maven
* Database
* Backend Development

## Project Structure

```text
hotel-management-service/
│
├── file-based-version/
│   └── File-based version of the project with layered architecture
│
├── springboot-version/
│   └── Spring Boot version of the project with database integration
│
└── README.md
```

## How to Run

### Running the File-Based Version

To run the file-based version:

1. Go to the `file-based-version` directory.
2. Open the project in an IDE such as IntelliJ IDEA or Eclipse.
3. Run the main class of the project.
4. The system data will be managed through files.

### Running the Spring Boot Version

To run the Spring Boot version:

1. Go to the `springboot-version` directory.
2. Open the project in your preferred IDE.
3. Check and complete the database configuration in a file such as `application.properties` or `application.yml`.
4. Create the required database.
5. Run the project using Maven or directly from your IDE.

Example command using Maven:

```bash
mvn spring-boot:run
```

## Main Features

* Room management
* Guest management
* Reservation management
* Data storage and retrieval
* Separation of system layers
* Development in two different versions

## Educational Concepts

This project is useful for practicing and learning the following concepts:

* Object-oriented programming in Java
* Designing management systems
* Layered architecture
* File handling in Java
* Introduction to Spring Boot
* Database integration
* Better structuring of backend projects

## Future Improvements

Possible future improvements for this project include:

* Adding a complete REST API
* Adding data validation
* Adding authentication and user roles
* Improving error handling
* Adding unit tests
* Adding API documentation
* Designing a user interface for the system
