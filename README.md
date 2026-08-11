# 📓 Spring Boot Journal Application (Backend REST API)

A clean, production-oriented RESTful API for a personal journaling platform built with **Java 17**, **Spring Boot**, and **MongoDB**. 

This repository currently reflects **Phase 1** of development, focusing on foundational REST architecture, modular layer separation, and non-relational database persistence.

---

## 🛠️ Tech Stack (Phase 1)

* **Language:** Java 17+
* **Framework:** Spring Boot 3.x (Spring MVC)
* **Database:** MongoDB (Spring Data MongoDB)
* **Build Tool:** Maven
* **API Testing:** Postman

---

## 🏗️ Architecture & Layering Strategy

The application follows a strict separation of concerns to maintain code readability and unit testability:

* `Controller Layer`: Exposes REST endpoints, handles HTTP requests, and returns JSON responses.
* `Service Layer`: Encapsulates core business logic and transaction processing.
* `Repository Layer`: Interfaces with MongoDB via `MongoRepository` for dynamic database queries.
* `Model Layer`: Defines POJOs/Entities mapped directly to MongoDB collections.

---

## 🚀 Key Features Implemented

- [x] **Full CRUD Operations:** Create, retrieve, update, and delete journal entries and user profiles.
- [x] **MongoDB Integration:** Persistent document storage using Spring Data MongoDB.
- [x] **Clean Error Handling:** Standardized HTTP response codes (`200 OK`, `201 Created`, `404 Not Found`, etc.).

---

## 🗺️ Project Roadmap

- [x] **Phase 1:** Core REST API & Spring Data MongoDB Integration
- [ ] **Phase 2:** User Authentication & Stateless Security using **Spring Security & JWT**
- [ ] **Phase 3:** Performance optimization with **Redis Caching**
- [ ] **Phase 4:** Third-party integrations (**Weather API** auto-enrichment & **Spring Mail** notifications)

---

## ⚙️ Getting Started

### Prerequisites
* JDK 17 or higher
* Maven 3.8+
* MongoDB running locally (Port 27017) or a MongoDB Atlas Cluster connection URI

### Installation & Local Setup

1. **Clone the repository:**
   git clone https://github.com/YOUR_GITHUB_USERNAME/journal-app.git
   cd journal-app

2. **Configure Database Connection:**
   Update your `src/main/resources/application.properties` file with your local or cloud MongoDB connection details:
   spring.data.mongodb.uri=mongodb://localhost:27017/journaldb
   spring.data.mongodb.auto-index-creation=true

3. **Build and Run:**
   mvn clean package
   mvn spring-boot:run

   The application will start on http://localhost:8080.

---

## 🧪 Sample API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/journal` | Fetch all journal entries |
| `POST` | `/journal` | Create a new journal entry |
| `GET` | `/journal/id/{myId}` | Fetch a specific entry by ID |
| `DELETE` | `/journal/id/{myId}` | Delete an entry by ID |
| `PUT` | `/journal/id/{myId}` | Update an existing entry |
