Hotel Management File-Based Version

معرفی پروژه:

این پروژه نسخه فایل ‌محور سیستم مدیریت هتل است که با زبان  Java پیاده‌سازی شده است.

در این نسخه، اطلاعات سیستم مانند اتاق‌ها، مهمان‌ها و رزروها به جای ذخیره شدن در پایگاه داده، داخل فایل‌ها ذخیره و مدیریت می‌شوند. هدف اصلی این پروژه تمرین مفاهیم برنامه‌نویسی شیءگرا، معماری لایه‌ای و مدیریت داده‌ها با فایل در Java است.

این نسخه پایه‌ای‌تر از نسخه Spring Boot پروژه است و بیشتر روی منطق سیستم، ساختار کلاس‌ها و جداسازی مسئولیت‌ها تمرکز دارد.

________________________________________

هدف پروژه:

هدف این پروژه طراحی یک سیستم ساده مدیریت هتل با استفاده از Java است که بتواند عملیات اصلی یک هتل را مدیریت کند.

این پروژه برای تمرین و یادگیری مفاهیم زیر نوشته شده است:

•	برنامه‌نویسی شیءگرا در Java

•	طراحی کلاس‌ها و ارتباط بین آن‌ها

•	معماری لایه‌ای

•	ذخیره‌سازی و بازیابی اطلاعات از فایل

•	مدیریت منطق یک سیستم واقعی

•	آماده‌سازی ذهنی برای توسعه نسخه‌های پیشرفته‌تر با دیتابیس و Spring Boot

________________________________________

قابلیت‌های اصلی:

•	مدیریت اطلاعات اتاق‌ها

•	مدیریت اطلاعات مهمان‌ها

•	ثبت و مدیریت رزروها

•	ذخیره اطلاعات در فایل

•	خواندن اطلاعات از فایل

•	جداسازی بخش‌های مختلف پروژه با معماری لایه‌ای

•	پیاده‌سازی منطق پایه یک سیستم مدیریت هتل

________________________________________

تکنولوژی‌های استفاده‌شده:

•	Java

•	Object-Oriented Programming

•	File Handling

•	Layered Architecture

________________________________________

معماری پروژه:
این پروژه با ساختار لایه‌ای طراحی شده است تا بخش‌های مختلف سیستم از هم جدا باشند و هر بخش مسئولیت مشخصی داشته باشد.

توضیح لایه‌ها:

•	POJO:

شامل کلاس هایی که برای ایجاد آبجکت و فرستادن اطلاعات به منیجر ها مورد استفاده قرار میگیرند. مانند Room, Guest و Reservation

•	Manager:

شامل منطق اصلی برنامه و عملیات مدیریتی

•	FileManager:

بخشی برا کار با فایل ها از قبیل ایجاد، مشاهده، ویرایش و حذف اطلاعات روی فایل

________________________________________

نحوه اجرای پروژه:

برای اجرای پروژه:

1.	پروژه را Clone یا دانلود کنید.

2.	آن را در یک IDE مانند IntelliJ IDEA یا Eclipse باز کنید.

3.	وارد پوشه src شوید.

4.	کلاس اصلی برنامه را اجرا کنید.

5.	اطلاعات برنامه از طریق فایل‌های موجود در پوشه data ذخیره و بازیابی می‌شود.

________________________________________

ساختار داده‌ها:

در این نسخه، اطلاعات سیستم داخل فایل‌های متنی ذخیره می‌شوند.

نمونه فایل‌ها:

rooms.txt

guests.txt

reservations.txt

هر فایل مربوط به یک بخش از سیستم است و داده‌های همان بخش را نگهداری می‌کند.

________________________________________

نکات آموزشی پروژه:

این پروژه برای تمرین مفاهیم مهمی در Java مناسب است، از جمله:

•	کار با کلاس‌ها و آبجکت‌ها

•	استفاده از Encapsulation

•	طراحی ارتباط بین موجودیت‌های سیستم

•	جداسازی لایه‌های برنامه

•	خواندن و نوشتن فایل در Java

•	مدیریت خطاها در عملیات فایل

•	طراحی یک سیستم مدیریتی ساده

________________________________________

وضعیت پروژه:

این نسخه به عنوان نسخه اولیه و فایل‌محور سیستم مدیریت هتل توسعه داده شده است.

در نسخه‌های بعدی، همین ایده به شکل پیشرفته‌تر با استفاده از Spring Boot و پایگاه داده پیاده‌سازی شده است.

________________________________________

برنامه‌های آینده:

برخی از مواردی که می‌توانند در آینده به این نسخه اضافه یا بهتر شوند:

•	بهبود مدیریت خطاها

•	اعتبارسنجی بهتر ورودی‌ها

•	مرتب‌سازی بهتر فایل‌های داده

•	اضافه کردن رابط کاربری بهتر

•	اضافه کردن گزارش‌گیری

•	بهبود ساختار منوها

•	نوشتن تست برای بخش‌های اصلی پروژه

________________________________________

Hotel Management File-Based Version

Project Overview

This project is the file-based version of a Hotel Management System implemented in Java.

In this version, system data such as rooms, guests, and reservations are stored and managed using files instead of a database. The main purpose of this project is to practice object-oriented programming, layered architecture, and file handling in Java.

This version is a more basic implementation compared to the Spring Boot version of the project. It focuses on system logic, class structure, and separation of responsibilities.

________________________________________

Project Goal

The goal of this project is to design a simple hotel management system using Java that can handle the basic operations of a hotel.

This project was developed to practice and learn the following concepts:

•	Object-oriented programming in Java

•	Class design and object relationships

•	Layered architecture

•	Storing and retrieving data from files

•	Managing the logic of a real-world system

•	Preparing for more advanced versions using databases and Spring Boot

________________________________________

Main Features

•	Room management

•	Guest management

•	Reservation management

•	Storing data in files

•	Reading data from files

•	Separating project sections using layered architecture

•	Implementing the basic logic of a hotel management system

________________________________________

Technologies Used

•	Java

•	Object-Oriented Programming

•	File Handling

•	Layered Architecture

________________________________________

Project Architecture

This project is designed using layered architecture so that different parts of the system are separated and each part has a clear responsibility.

Layer explanation:

•	POJO: Contains the classes used for creating objects and passing data to the managers, such as `Room`, `Guest`, and `Reservation`.

•	Manager: Contains the main logic of the program and handles the management operations of the system.

•	FileManager: Handles file operations, including creating, viewing, editing, and deleting data in files.

________________________________________

How to Run:

To run the project:

1.	Clone or download the project.

2.	Open it in an IDE such as IntelliJ IDEA or Eclipse.

3.	Go to the src directory.

4.	Run the main class of the program.

5.	The application data will be stored and retrieved using the files inside the data directory.

________________________________________

Data Structure:

In this version, system data is stored in text files.

Example files:

rooms.txt

guests.txt

reservations.txt

Each file is related to a specific part of the system and stores the data for that section.

________________________________________

Educational Concepts:

This project is useful for practicing important Java concepts, including:

•	Working with classes and objects

•	Using encapsulation

•	Designing relationships between system entities

•	Separating application layers

•	Reading and writing files in Java

•	Handling errors in file operations

•	Designing a simple management system

________________________________________

Project Status:

This version was developed as the initial file-based version of the hotel management system.

In later versions, the same idea was improved and implemented using Spring Boot and a database.

________________________________________

Future Improvements:

Possible improvements for this version include:

•	Improving error handling

•	Adding better input validation

•	Organizing data files more clearly

•	Adding a better user interface

•	Adding reporting features

•	Improving menu structure

•	Writing tests for the main parts of the project
