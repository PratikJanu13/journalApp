# 📓 Spring Boot Journal Application

A full-featured, secure backend REST API for a personal journaling platform built with **Java** and **Spring Boot**. The system enables users to create, manage, and analyze daily journal entries with robust authentication, role-based security, caching, and background services.

---

## 🛠️ Tech Stack & Concepts Covered

- **Core Framework:** Java 17+, Spring Boot, Spring MVC
- **Database & Data Access:** MongoDB, Spring Data MongoDB
- **Security & Auth:** Spring Security, JWT (JSON Web Tokens), BCrypt Password Hashing, RBAC (User / Admin roles)
- **Caching & Performance:** Redis, Spring Cache
- **Third-Party Integrations:** Weather API Integration, Java Mail Sender
- **Testing & Tools:** JUnit 5, Mockito, Postman, Logback / SLF4J Logging

---

## ✨ Key Features

- **User Authentication & Authorization:** Secure registration and stateless authentication using JWT tokens and role management.
- **Journal CRUD Operations:** Full REST API endpoints allowing users to create, read, update, and delete journal entries attached to their profiles.
- **External API Consumption:** Integration with third-party Weather APIs to auto-enrich journal entries based on local weather conditions.
- **Automated Email Notifications:** Scheduled background jobs using Spring Scheduler to dispatch email notifications and summaries.
- **Optimized Performance:** In-memory Redis caching implemented for fast session and data retrieval.

---

## ⚙️ Getting Started

### Prerequisites
- JDK 17 or higher
- MongoDB (Local instance or MongoDB Atlas)
- Redis Server
- Maven
