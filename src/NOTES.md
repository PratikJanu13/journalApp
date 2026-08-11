# Spring Boot Notes: Videos 1–14 (Engineering Digest)

## Video 1: Introduction to Spring & Spring Boot
* Spring Framework: Provides Inversion of Control (IoC) and Dependency Injection (DI) for modular, loosely coupled code.
* Spring Boot: Sits on top of Spring. Eliminates boilerplate XML configuration via Auto-Configuration and Starter Dependencies. Comes with an embedded Tomcat server.
* Key Concept: Spring Boot is a rapid configuration/development tool for the Spring ecosystem, not a separate language or replacement.

## Video 2: Project Setup & Spring Initializr
* Core Tools: JDK (17+), IntelliJ IDEA, Postman.
* Spring Initializr (start.spring.io):
    * Project: Maven
    * Language: Java
    * Key Dependencies: Spring Web, Lombok, Spring Data JPA, H2/MySQL Driver or Spring Data MongoDB.

## Video 3: Project Structure & @SpringBootApplication
* Project Layout:
    * src/main/java: Java application code.
    * src/main/resources: application.properties / application.yml, static assets.
* @SpringBootApplication combines:
    1. @Configuration: Designates class as a source of bean definitions.
    2. @EnableAutoConfiguration: Configures beans based on classpath dependencies.
    3. @ComponentScan: Scans the root package and sub-packages for Spring components (@Component, @Service, @Repository, @RestController).

## Video 4: First REST API & @RestController
* @RestController: Combines @Controller and @ResponseBody. Converts return values directly into JSON/HTTP response bodies.
* @GetMapping: Shortcut for @RequestMapping(method = RequestMethod.GET).
* Request Cycle: Client HTTP GET -> Controller method intercepts -> Serializes response to JSON.

## Video 5: HTTP Methods & Request Mappings
* HTTP Verbs:
    * GET: Read/retrieve resource
    * POST: Create resource
    * PUT: Update existing resource
    * DELETE: Delete resource
* Class-level @RequestMapping("/journal"): Prefixes all endpoints inside that controller class.

## Video 6: URL Parameters (@PathVariable vs @RequestParam)
* @PathVariable: Reads values embedded in the URI path (/journal/id/123).
  Example: public JournalEntry getById(@PathVariable Long myId)
* @RequestParam: Reads query parameters from query string (/journal?id=123).
  Example: public String search(@RequestParam String q)

## Video 7: Request Payloads (@RequestBody)
* @RequestBody: Deserializes incoming JSON payloads into Java POJO objects using Jackson.
* Usage:
  @PostMapping
  public boolean createEntry(@RequestBody JournalEntry entry) { ... }

## Video 8: In-Memory CRUD Operations
* Concept: Storing entities in a temporary in-memory collection (Map<Long, JournalEntry>) to test CRUD lifecycle before wiring a database.
* Takeaway: Shows why persistence (DB) and structural layer separation are needed.

## Video 9: Tiered Architecture (Layering)
* Controller Layer (@RestController): Handles routing, HTTP status codes, and input/output validation.
* Service Layer (@Service): Implements business logic and transaction processing.
* Repository Layer (@Repository): Handles database interaction.
* Architectural Flow: Client -> Controller -> Service -> Repository -> Database

## Video 10: IoC, DI & Spring Beans
* Inversion of Control (IoC): Framework manages object lifecycles instead of manually invoking `new`.
* Spring Bean: An object created, configured, and managed by the Spring IoC container (ApplicationContext).
* Dependency Injection (@Autowired): Spring injects dependencies into classes automatically.
* Stereotypes: @Component, @Service, @Repository.

## Video 11: Spring Data JPA & Entities
* ORM & Hibernate: Maps Java entity classes to relational database tables.
* @Entity: Marks a class as a database table.
* @Id & @GeneratedValue: Defines the primary key and ID generation strategy.

## Video 12: JpaRepository
* Interface Setup: Extend JpaRepository<EntityClass, IDType>.
* Out-of-the-box Methods:
    * findAll()
    * findById(ID id)
    * save(S entity) (handles both insert and update)
    * deleteById(ID id)

## Video 13: Database Configuration (application.properties)
* SQL Configuration:
  spring.datasource.url=jdbc:mysql://localhost:3306/journaldb
  spring.datasource.username=root
  spring.datasource.password=password
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
* MongoDB Alternative:
  spring.data.mongodb.uri=mongodb://localhost:27017/journaldb

## Video 14: End-to-End Database Persistence
* Wire Service Layer: Inject Repository into Service class using @Autowired or constructor injection.
* Handle Missing Records: Use Java Optional (e.g., repository.findById(id).orElse(null)).
* Complete Pipeline: Route requests from Controller -> Service methods -> Repository database calls.