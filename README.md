# 🌦️ Weather Forecasting Application and Alert System

A web-based Weather Forecasting Application developed using **Spring Boot, PostgreSQL, JavaScript, and AI integration**. It provides real-time weather information for any searched city, automatically updates stored weather data, and generates AI-based weather precautions according to current weather conditions.

## 📌 Project Overview

The Weather Forecasting Application allows users to search for any city and view its current weather information. It fetches real-time weather data from the OpenWeather API and stores the information in a PostgreSQL database.

The application also uses Spring Scheduler to automatically refresh weather data for previously searched cities. AI integration provides personalized weather precautions based on temperature, humidity, wind speed, and weather conditions.

Additionally, an analytics dashboard helps track website visits, city searches, and popular cities.

## ✨ Features

- **Real-Time Weather Updates:** Fetches current weather information for any searched city using the OpenWeather API.
- **City-Based Search:** Allows users to search and view weather details for different cities.
- **Automatic Weather Updates:** Uses Spring Scheduler to periodically refresh weather information stored in PostgreSQL.
- **AI-Based Weather Precautions:** Generates useful precautions based on current weather conditions.
- **Weather Data Management:** Stores and manages weather records using PostgreSQL.
- **User Analytics Dashboard:** Tracks total page visits, city searches, and popular searched cities.
- **Responsive Interface:** Provides a user-friendly interface for accessing weather information.

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java | Backend programming |
| Spring Boot | Backend application development |
| Spring Data JPA | Database operations |
| PostgreSQL | Database management |
| JavaScript | Frontend functionality |
| HTML & CSS | User interface |
| OpenWeather API | Real-time weather data |
| OpenRouter AI | AI-generated weather precautions |
| Spring Scheduler | Automatic weather updates |
| Maven | Dependency management |

## ⚙️ Application Workflow

1. The user enters a city name in the search field.
2. Spring Boot receives the request and communicates with the OpenWeather API.
3. Real-time weather information is fetched and stored in PostgreSQL.
4. The frontend displays the weather details to the user.
5. AI integration generates weather precautions based on the current conditions.
6. Spring Scheduler automatically refreshes weather data for previously searched cities.
7. The analytics dashboard records page visits and city searches.

### 1. Prerequisites

Make sure you have installed:

- Java JDK 21 or compatible version
- Maven
- PostgreSQL
- An IDE such as IntelliJ IDEA or VS Code

### 2. Clone the Repository

```bash
git clone https://github.com/Dhirubhai-11/weatherMonitoring-and-Alert-System.git
```

### 3. Open the Project

```bash
cd weatherMonitoring-and-Alert-System
```

Open the project in your preferred IDE.

### 4. Configure PostgreSQL

Create a PostgreSQL database for the application.

Configure your database connection in `application.properties` using environment variables.

### 5. Configure API Keys

Obtain the required API credentials:

- OpenWeather API key
- OpenRouter API key

Configure the API keys through environment variables. Do not commit actual API keys or passwords to GitHub.

Example configuration:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

# Configure your API credentials
# using environment variables.
```

Make sure the environment variable names match those used in your application.

### 6. Run the Application

Using Maven:

```bash
mvn spring-boot:run
```

Alternatively, run the main Spring Boot application class from your IDE.

Open your browser and visit:

```text
http://localhost:8080
```

## 🔐 Security

- API keys are kept outside the source code.
- Database credentials are configured using environment variables.
- Never upload sensitive credentials to a public repository.

## 🎯 Future Enhancements

- Weather forecast for upcoming days.
- Weather alerts and notifications.
- Historical weather data visualization.
- Improved analytics and reporting.

## 👨‍💻 Developer

**Dhiru Bhai**

- GitHub: [Dhirubhai-11](https://github.com/Dhirubhai-11)

---

⭐ If you find this project useful, consider giving it a star!
