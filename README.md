# Assignment 3 CSC 340 

## What is the project?

This is a **CRUD API** (Create, Read, Update, Delete) that manages student records. It demonstrates:

- How to build a REST API with Spring Boot
- How to connect to a PostgreSQL database using JPA
- How to structure a Spring Boot application with layers (Controller, Service, Repository)
- How to handle HTTP requests and responses
- How to perform database operations

**CRUD** stands for:

- **C**reate - Add new student records
- **R**ead - Retrieve student records
- **U**pdate - Modify existing student records
- **D**elete - Remove student records

---


## Installation & Setup

### Prerequisites

Before you begin, ensure you have installed:

1. **Java 25 JDK**
   - Download from [Oracle Java](https://www.oracle.com/java/technologies/downloads/) or use a package manager
   - Verify installation: `java -version`

2. **Neon.tech PostgreSQL Database** (Cloud-based, Serverless)
   - This project uses [Neon.tech](https://neon.tech), a serverless PostgreSQL database in the cloud
   - You don't need to install PostgreSQL locally
   - Sign up for a free account at [Neon.tech](https://neon.tech)
   - You only need an internet connection to connect to the database

3. **Git** (optional, for cloning the project)
   - Download from [Git Official Site](https://git-scm.com/)

### About Maven Wrapper

**Good news!** This project includes the **Maven Wrapper** (`mvnw` on Mac/Linux and `mvnw.cmd` on Windows). This means you **do not need to install Maven separately**. The wrapper automatically downloads the correct Maven version for you.

The Maven Wrapper is a handy tool that ensures everyone working on the project uses the same Maven version, reducing compatibility issues.

### Setup Instructions

1. **Clone or Download the Project**

   ```bash
   git clone <repository-url>
   cd sp26-crud-api-demo
   ```

2. **Install Dependencies**
   The Maven Wrapper will automatically download dependencies from the `pom.xml` file:

   **On Windows**:

   ```cmd
   mvnw.cmd clean install
   ```

   **On Mac/Linux**:

   ```bash
   ./mvnw clean install
   ```

   This command:
   - `clean`: Removes previous build artifacts
   - `install`: Downloads all dependencies and compiles the project
   - First run may take a few minutes as Maven is downloaded

3. **Database Configuration (Neon.tech Serverless PostgreSQL)**

   #### Step 1: Get Your Neon.tech Connection String

   1. Navigate to [Neon.tech](https://neon.tech)
   2. Sign in to your account
   3. In your project dashboard, find your connection string
   4. It will look like: `postgresql://username:password@host:5432/dbname`

   #### Step 2: Stop Tracking `application.properties` Locally

   To prevent accidentally committing your database credentials to Git, use `git skip-worktree` to exclude your local copy:

   ```bash
   git update-index --skip-worktree src/main/resources/application.properties
   ```

   This tells Git to ignore any changes you make to this file locally. You can now safely edit the file without worrying about committing sensitive data.

   #### Step 3: Update Your Connection String

   Edit `src/main/resources/application.properties` and add your Neon.tech PostgreSQL connection string:

   ```properties
   spring.application.name=crud-api
   spring.datasource.url=jdbc:postgresql://host:5432/dbname
   spring.datasource.username=your_neon_username
   spring.datasource.password=your_neon_password
   spring.jpa.hibernate.ddl-auto=update

   #Log out sql queries
   logging.level.org.hibernate.SQL=DEBUG
   logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
   logging.level.org.hibernate.orm.jdbc.bind=TRACE
   ```

   Replace with your actual Neon.tech credentials:
   - `host`: Your Neon.tech host (e.g., `some-cool-projectName-pooler.c-7.us-east-1.aws.neon.tech`)
   - `dbname`: Your database name (usually `neondb`)
   - `your_neon_username`: Your Neon.tech username
   - `your_neon_password`: Your Neon.tech password

   #### Example Connection String

   ```properties
   spring.datasource.url=jdbc:postgresql://ep-cool-cherry-ai9ih0ua-pooler.c-7.us-east-1.aws.neon.tech:5432/neondb
   spring.datasource.username=neondb_owner
   spring.datasource.password=your_password_here
   ```

   #### To Resume Tracking the File

   If you need to revert and track the file again:

   ```bash
   git update-index --no-skip-worktree src/main/resources/application.properties
   ```

   **Important Note**: This approach (using `git skip-worktree`) keeps credentials safe locally while the file can be tracked in Git. However, in production environments, database credentials should be managed using environment variables or cloud-based secret management services like AWS Secrets Manager or Azure Key Vault.

4. **Verify Setup**

   **On Windows (PowerShell)**:

   ```cmd
   mvnw.cmd compile
   ```

   **On Mac/Linux (Bash/zsh)**:

   ```bash
   ./mvnw compile
   ```

   If successful, you'll see `BUILD SUCCESS` at the end.

---

## Running the Application

### Using Maven Wrapper

**On Windows**:

```cmd
mvnw.cmd spring-boot:run
```

**On Mac/Linux**:

```bash
./mvnw spring-boot:run
```

The application will start on **http://localhost:8080**

You should see output like:

```
Started CrudApiApplication in 4.532 seconds
```

### Using VS Code GUI

1. **Open the Project**: Open the project folder in VS Code
2. **Install Extension**: Install the "Extension Pack for Java" (by Microsoft) if not already installed
3. **Run the Application**:
   - Go to the Explorer view (left sidebar)
   - Navigate to `src > main > java > com > csc340 > crud_api > CrudApiApplication.java`
   - Right-click on `CrudApiApplication.java`
   - Select **"Run Java"** or click the ▶️ **Run** button that appears above the class definition
4. **View Output**: The terminal will show the Spring Boot startup messages and confirm the application is running

### Stopping the Application

Press `Ctrl+C` in your terminal to stop the running application. If using IDE GUI, click the ⏹️ **Stop** button in the Run/Debug toolbar.

---

## API Endpoints

All endpoints use the base URL: `http://localhost:8080/api/characters`

### 1. Get All Characters

```http
GET /api/characters
```

**Description**: Retrieve a list of all characters in the database.

**Parameters**: None

**Response**:

- **Status Code**: `200 OK`
- **Body**: Array of Character objects

#### Example Request

```bash
curl http://localhost:8080/api/characters
```

#### Example Response (Status: 200 OK)

```json
[
  {
    "characterId": 1,
    "name": "Kikoru Shinomiya",
    "description": "Sidekick in 'Kaiju No. 8'",
    "role": "Sidekick",
    "universe": "Kaiju"
  },
  {
    "characterId": 2,
    "name": "Mikasa Ackerman",
    "description": "Female lead in 'Attack on Titan'",
    "role": "Lead",
    "universe": "Titan"
  }
]
```

---

### 2. Get Character by ID

```http
GET /api/characters/{id}
```

**Description**: Retrieve a single character by their ID.

**Path Parameters**:

- `id` (Long, required): The unique identifier of the character

**Response**:

- **Status Code**: `200 OK` (if found) or `404 Not Found` (if not found)
- **Body**: Charcter object

#### Example Request

```bash
curl http://localhost:8080/api/characters/1
```

#### Example Response (Status: 200 OK)

```json
{
    "characterId": 1,
    "name": "Kikoru Shinomiya",
    "description": "Sidekick in 'Kaiju No. 8'",
    "role": "Sidekick",
    "universe": "Kaiju"
  }
```

#### Example Response if not found (Status: 404 Not Found)

```
(Empty body)
```

---

### 3. Create a New Character

```http
POST /api/characters
```

**Description**: Create a new character in the database.

**Request Body**: Character object with the following fields:

- `name` (String, required): Characters first and last name
- `description` (String, required): Brief character description
- `role` (String, optional): Character's role in the show
- `universe` (String, optional): Universe character is a part of

**Response**:

- **Status Code**: `200 OK` (if created successfully)
- **Body**: Created Character object with assigned `characterId`

#### Example Request

```bash
curl -X POST http://localhost:8080/api/characters \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Orihime Inoue",
    "description": "Love interest of main character and side character in Bleach",
    "role": "Sidekick",
    "universe": "Bleach"
  }'
```

#### Example Response (Status: 200 OK)

```json
{   
    "charcterId" : 3,
    "name": "Orihime Inoue",
    "description": "Love interest of main character and side character in Bleach",
    "role": "Sidekick",
    "universe": "Bleach"
  }
```

### 4. Get Characters by Universe

```http
GET /api/students/universe/{universe}
```

**Description**: Retrieve characters by the universe they are in.

**Path Parameters**:

- `universe` (String, required)

**Response**:

- **Status Code**: `200 OK`
- **Body**: Array of characters within the universe provided.

#### Example Request

```bash
curl http://localhost:8080/api/characters/universe/Bleach
```

#### Example Response (Status: 200 OK)

```json
[
  {
    "characterId": 2,
    "name": "Rukia Kuchiki",
    "description": "Female lead in 'Bleach'",
    "role": "Main",
    "universe": "Bleach"
  },
  {   
    "charcterId" : 3,
    "name": "Orihime Inoue",
    "description": "Love interest of main character and side character in Bleach",
    "role": "Sidekick",
    "universe": "Bleach"
  }
]
```

---

### 5. Search Chracters by Name

```http
GET /api/characters/search?name=substring
```

**Description**: Search for characters by name (partial match supported) or retrieve all characters if no name is provided.

**Query Parameters**:

- `name` (String, optional): The name or part of the name to search for

**Response**:

- **Status Code**: `200 OK`
- **Body**: Array of matched Character objects

#### Example Request

```bash
curl "http://localhost:8080/api/characters/search?name=Kikoru"
```

#### Example Response (Status: 200 OK)

```json
[
  {
    "characterId": 1,
    "name": "Kikoru Shinomiya",
    "description": "Sidekick in 'Kaiju No. 8'",
    "role": "Sidekick",
    "universe": "Kaiju"
  }
]
```

---


### 6. Update a Character

```http
PUT /api/characters/{id}
```

**Description**: Update an existing character's information.

**Path Parameters**:

- `id` (Long, required): The ID of the character to update

**Request Body**: Character object with fields to update:

- `name` (String): Updated name
- `description` (String): Updated description
- `role` (String): Updated role
- `universe` (String): Updated universe

**Response**:

- **Status Code**: `200 OK` (if updated successfully) or `404 Not Found` (if character not found)
- **Body**: Updated Charcter object

#### Example Request

```bash
curl -X PUT http://localhost:8080/api/characters/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Momo Ayase",
    "description": "Main character of 'Dandadan'",
    "Role": "Main",
    "universe": "Dandadan"
  }'
```

#### Example Response (Status: 200 OK)

```json
{
    "characterId": 1,
    "name": "Momo Ayase",
    "description": "Main character of 'Dandadan'",
    "Role": "Main",
    "universe": "Dandadan"
}
```

---

### 7. Delete a Character

```http
DELETE /api/characters/{id}
```

**Description**: Delete an existing character from the database.

**Path Parameters**:

- `id` (Long, required): The ID of the character to delete

**Response**:

- **Status Code**: `204 No Content` (successful deletion)
- **Body**: Empty

#### Example Request

```bash
curl -X DELETE http://localhost:8080/api/characters/1
```

#### Example Response (Status: 204 No Content)

```
(Empty body)
```

---