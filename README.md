# JobTrack

**JobTrack** is a Java web application for managing jobs, job applications, interviews, and user account information in one place.

The application provides workflows for user registration, login, job management, application management, interview scheduling, account updates, and password recovery. It uses Java Servlets, JSP, JDBC, and MySQL to handle web requests, display information, and persist application data.

## Features

### User Management

* User registration
* User login and account validation
* Session-based authentication
* Account information updates
* Logout
* Password recovery

### Job Management

* Add jobs
* View job information
* Delete jobs
* Manage job records

### Application Management

* Apply for jobs
* Manage job applications
* View application information
* Delete applications

### Interview Management

* Schedule interviews
* Create interview records
* Manage interview information

### Dashboard

* Access job, application, and interview workflows from a centralized page

## Technology Stack

* **Java** — application logic and domain models
* **Java Servlets** — handling HTTP requests and application workflows
* **JSP (JavaServer Pages)** — dynamic web pages
* **JDBC** — database connectivity
* **MySQL** — relational database
* **HTML/CSS** — web interface
* **Apache Tomcat** — Servlet/JSP runtime

## Application Architecture

JobTrack follows a layered architecture that separates domain data, web workflows, presentation, and database persistence.

```text
User
 │
 ▼
JSP Views
 │
 ▼
Servlets / Web Workflows
 │
 ▼
DAO Interfaces and Implementations
 │
 ▼
JDBC
 │
 ▼
MySQL Database
```

### 1. Domain Models

The application contains four main domain models:

* `User.java` — represents user information.
* `Job.java` — represents job information.
* `Application.java` — represents job application information.
* `Interview.java` — represents interview information.

### 2. Web Workflows

The web layer handles the application's primary operations, including:

* `Register.java` — user registration
* `Login.java` — user login
* `AddJobs.java` — job management
* `DeleteJobs.java` — job deletion
* `ApplyJob.java` — job applications
* `AddInterview.java` — interview creation
* `UpdateAccount.java` — account updates
* `Logout.java` — logout

Additional workflows include dashboard access, interview scheduling, application management, application deletion, and password recovery.

### 3. JSP Views

The presentation layer contains JSP pages for displaying application information and providing user interaction.

* `dashboard.jsp` — dashboard
* `jobs.jsp` — job-related pages
* `interview.jsp` — interview-related pages
* `login.jsp` — account access
* `application.jsp` — application-related pages

The diagram also identifies account pages as part of the web interface.

### 4. Data Access Layer

The persistence layer separates database operations from the web workflows.

It includes data access components for:

* Users
* Jobs
* Applications
* Interviews

The diagram identifies `UserDAOImpI.java` and `JobDAOImpI.java` as implementation classes. The application and interview persistence components handle their respective database operations.

### 5. Database

JobTrack uses MySQL for persistent storage. JDBC provides connectivity between the Java application and the database.

The persistence layer handles database access for the application's user, job, application, and interview data.

## Application Workflow

The primary application workflow connects the following operations:

1. A user registers or logs in.
2. The user accesses the dashboard.
3. The user manages job records.
4. The user submits and manages job applications.
5. The user schedules and manages interviews.
6. The user updates account information or logs out.

Password recovery is available as a separate account-related workflow.

## Getting Started

## Architecture


[![Architecture diagram of madan686/jobtrack](https://gitdiagram.com/madan686/jobtrack/diagram.png)](https://gitdiagram.com/madan686/jobtrack?utm_source=readme&utm_medium=picture)


### Prerequisites

Install the following software:

* Java Development Kit (JDK)
* Apache Tomcat
* MySQL Server
* Eclipse IDE or another Java web development IDE

### Clone the Repository

```bash
git clone https://github.com/Madan686/JobTrack.git
cd JobTrack
```

### Configure the Database

1. Start the MySQL server.
2. Create the database and tables required by the application.
3. Configure the JDBC connection details in the project.
4. Ensure the MySQL JDBC driver is available to the application.

The database name, table definitions, and connection settings should match the existing project configuration.

### Run the Application

1. Import the project into Eclipse.
2. Configure an Apache Tomcat server.
3. Configure the project's database connection.
4. Deploy the project to Tomcat.
5. Start the server and access the application through the configured local URL.

## Project Purpose

JobTrack demonstrates the development of a Java web application using Servlets, JSP, JDBC, DAO-based persistence, session management, and MySQL.

The project focuses on separating web request handling, presentation, domain data, and database operations into distinct components.

## Author

**Madan M**

GitHub: [Madan686](https://github.com/Madan686)

Repository: [JobTrack](https://github.com/Madan686/JobTrack)
