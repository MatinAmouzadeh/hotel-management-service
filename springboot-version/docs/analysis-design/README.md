# Hotel Management Information System (HMIS)  
# مستندات تحلیل و طراحی سیستم اطلاعات مدیریت هتل

## معرفی

این بخش شامل مستندات تحلیل و طراحی **سیستم اطلاعات مدیریت هتل** یا **HMIS** است.

هدف این مستندات، شناخت سیستم موجود، تحلیل فرایندها، شناسایی بازیگران، تعیین زیرسیستم‌ها، استخراج نیازمندی‌ها، مدل‌سازی دامنه، طراحی Use Caseها و آماده‌سازی پایه تحلیلی برای توسعه نسخه کامل‌تر پروژه است.

این مستندات به عنوان پایه‌ای برای تکمیل نسخه Spring Boot سیستم مدیریت هتل و حرکت به سمت نسخه کامل‌تر و ساختاریافته‌تر پروژه استفاده می‌شوند.

---

## ارتباط این مستندات با پروژه

این مستندات مربوط به نسخه Spring Boot و نسخه توسعه‌یافته سیستم مدیریت هتل هستند.

نسخه فایل‌محور پروژه یک نسخه اولیه و آموزشی محسوب می‌شود، اما این بخش برای تحلیل، طراحی و تکمیل نسخه پیشرفته‌تر سیستم در نظر گرفته شده است.

---

## وضعیت زبان مستندات

در حال حاضر، فایل‌های اصلی مستندات به زبان فارسی نوشته شده‌اند.

پس از نهایی‌شدن و تکمیل ویرایش نسخه فارسی، نسخه انگلیسی مستندات نیز به صورت جداگانه آماده خواهد شد.

نام فایل‌ها و پوشه‌ها مطابق راهنمای پروژه به زبان انگلیسی نوشته شده‌اند.

---

## فایل‌ها و پوشه‌های پروژه

| No. | File / Folder Name | Description |
| --: | --- | --- |
| 1 | `README.md` | توضیح کلی پروژه، فهرست فایل‌ها و وضعیت مستندات |
| 2 | `Project_Guideline.pdf` | فایل راهنمای پروژه شامل بخش‌های موردنیاز، معیارهای ارزیابی، نحوه تحویل و ساختار پیشنهادی فایل‌ها |
| 3 | `Existing_System_Introduction.pdf` | معرفی سیستم موجود هتل، ساختار سازمانی، فرایندها، فرم‌ها، سناریوها و واژه‌نامه |
| 4 | `System_Analysis.pdf` | شناخت سیستم، Domain Model، زیرسیستم‌ها، نیازمندی‌های عملکردی و غیرعملکردی، اولویت‌بندی و Prototype اولیه |
| 5 | `Use_Case_Model.pdf` | مدل Use Case شامل Actor List، Use Case Diagram نسخه اول و دوم، جدول Use Caseها، سناریوها و نگاشت Requirement به Use Case |
| 6 | `Diagrams/` | پوشه نمودارهای پروژه شامل Context Diagram، Domain Model، Package Diagram و Use Case Diagrams |
| 7 | `Prototype/` | پوشه فایل‌های Prototype یا تصاویر رابط کاربری سیستم |
| 8 | `Forms/` | لیست فرم‌های سیستم و کد فرم‌های مرتبط با فرایندها |
| 9 | `Requirement_Map.xlsx` | جدول نگاشت نیازمندی‌ها به Use Caseها، در صورت جداسازی از فایل اصلی |
| 10 | `Final_Report.pdf` | نسخه نهایی یکپارچه پروژه، در صورت نیاز برای تحویل نهایی |

---

## وضعیت مستندات اصلی

| Document | Current Status |
| --- | --- |
| Existing System Introduction | Completed / Updated |
| Process List | Completed and updated with user account processes |
| Form Codes | Completed |
| Glossary | Completed and updated |
| Domain Model Version 1 | Completed |
| Context Diagram | Completed |
| Functional Requirements | Completed and updated |
| Non-Functional Requirements | Completed and updated |
| Actor List | Completed and updated |
| Use Case Diagram Version 1 | Completed |
| Use Case Diagram Version 2 | Completed / In progress based on include relations |
| Use Case List | Completed |
| Prototype | To be completed / Final version pending |

---

## زیرسیستم‌های اصلی

| No. | Subsystem |
| --: | --- |
| 1 | Information Technology |
| 2 | Guest |
| 3 | Room |
| 4 | Reservation and Stay |
| 5 | Notification |
| 6 | Complaint and Feedback |
| 7 | Management Office |

---

## بازیگران اصلی سیستم

| Actor Type | Actors |
| --- | --- |
| Internal Human Actors | Guest, Receptionist, Hotel Management, IT/System Admin, Accountant/Cashier, Service Staff |
| External Departments | Food & Beverage Department, Housekeeping Department, Support & Maintenance Department, Finance Department, Warehouse / Inventory Department |
| External Systems | Banking System / Payment Gateway, SMS / Email Gateway, Smart Lock System, Identity Verification System |
| External Organization | Travel Agency |

---

## نکات مهم

- پروژه به صورت مرحله‌ای و تکرارشونده توسعه داده شده است؛ بنابراین برخی فرایندها، نیازمندی‌ها، بازیگران و Use Caseها در مراحل بعدی تحلیل به‌روزرسانی شده‌اند.
- فرایندهای مربوط به حساب کاربری مانند ورود، خروج، تغییر رمز عبور، بازیابی رمز عبور و بازنشانی رمز عبور پس از بررسی هماهنگی بین Process List، Requirements، Actor List و Use Case Model اضافه شده‌اند.
- برخی دپارتمان‌های خارجی در Context Diagram نمایش داده شده‌اند، زیرا با HMIS تعامل دارند؛ حتی اگر در نسخه فعلی به عنوان زیرسیستم داخلی پیاده‌سازی نشده باشند.
- این مستندات در حال تکمیل هستند و ممکن است در نسخه‌های بعدی پروژه به‌روزرسانی شوند.
- این بخش به عنوان پایه تحلیلی و طراحی برای تکمیل نسخه Spring Boot و توسعه Hotel Management System V3 استفاده خواهد شد.

---

# Hotel Management Information System (HMIS)  
# Analysis and Design Documents

## Overview

This section contains the analysis and design documents for the **Hotel Management Information System (HMIS)**.

The purpose of these documents is to understand the existing hotel system, analyze business processes, identify actors, define subsystems, extract requirements, model the system domain, design use cases, and prepare an analytical foundation for developing a more complete version of the project.

These documents are used as a foundation for improving and completing the Spring Boot version of the Hotel Management System.

---

## Relationship with the Project

These documents are related to the Spring Boot version and the extended version of the Hotel Management System.

The file-based version is an earlier educational version, while this documentation section focuses on the analysis, design, and improvement of the more complete system.

---

## Documentation Language Status

Currently, the main documentation files are written in Persian.

After the Persian documents are finalized and edited, English versions of the documents will be prepared separately.

File and folder names are written in English according to the project guideline.

---

## Project Files

| No. | File / Folder Name | Description |
| --: | --- | --- |
| 1 | `README.md` | General project description, file list, and documentation status |
| 2 | `Project_Guideline.pdf` | Project guideline including required sections, evaluation criteria, delivery rules, and suggested file structure |
| 3 | `Existing_System_Introduction.pdf` | Introduction of the existing hotel system, organizational structure, processes, forms, scenarios, and glossary |
| 4 | `System_Analysis.pdf` | System understanding, Domain Model, subsystems, functional and non-functional requirements, prioritization, and initial prototype |
| 5 | `Use_Case_Model.pdf` | Use Case model including Actor List, Use Case Diagram version 1 and 2, Use Case tables, scenarios, and Requirement-to-Use Case mapping |
| 6 | `Diagrams/` | Project diagrams including Context Diagram, Domain Model, Package Diagram, and Use Case Diagrams |
| 7 | `Prototype/` | Prototype files or user interface images |
| 8 | `Forms/` | System form list and form codes related to processes |
| 9 | `Requirement_Map.xlsx` | Requirement-to-Use Case mapping table, if separated from the main document |
| 10 | `Final_Report.pdf` | Final integrated project report, if required for final delivery |

---

## Main Documents Completed

| Document | Current Status |
| --- | --- |
| Existing System Introduction | Completed / Updated |
| Process List | Completed and updated with user account processes |
| Form Codes | Completed |
| Glossary | Completed and updated |
| Domain Model Version 1 | Completed |
| Context Diagram | Completed |
| Functional Requirements | Completed and updated |
| Non-Functional Requirements | Completed and updated |
| Actor List | Completed and updated |
| Use Case Diagram Version 1 | Completed |
| Use Case Diagram Version 2 | Completed / In progress based on include relations |
| Use Case List | Completed |
| Prototype | To be completed / Final version pending |

---

## Main Subsystems

| No. | Subsystem |
| --: | --- |
| 1 | Information Technology |
| 2 | Guest |
| 3 | Room |
| 4 | Reservation and Stay |
| 5 | Notification |
| 6 | Complaint and Feedback |
| 7 | Management Office |

---

## Main Actors

| Actor Type | Actors |
| --- | --- |
| Internal Human Actors | Guest, Receptionist, Hotel Management, IT/System Admin, Accountant/Cashier, Service Staff |
| External Departments | Food & Beverage Department, Housekeeping Department, Support & Maintenance Department, Finance Department, Warehouse / Inventory Department |
| External Systems | Banking System / Payment Gateway, SMS / Email Gateway, Smart Lock System, Identity Verification System |
| External Organization | Travel Agency |

---

## Notes

- The project is developed iteratively; therefore, some processes, requirements, actors, and use cases were updated during later analysis stages.
- User account processes such as login, logout, password change, password recovery, and password reset were added after reviewing the consistency between Process List, Requirements, Actor List, and Use Case Model.
- Some external departments are shown in the Context Diagram because they interact with HMIS, even if they are not implemented as internal subsystems in the current iteration.
- These documents are still being improved and may be updated in future versions of the project.
- This documentation section will be used as the analysis and design foundation for completing the Spring Boot version and developing Hotel Management System V3.
