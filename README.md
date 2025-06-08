# Currency Converter Service

A simple and robust RESTful API service for currency conversion using real-time exchange rates.

---

## Table of Contents
- [About](#about)
- [Features](#features)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Configuration](#configuration)
- [Usage](#usage)
- [Error Handling](#error-handling)
- [Contributing](#contributing)
- [License](#license)

---

## About
Currency Converter Service is a Spring Boot based backend application that fetches live currency exchange rates from a third-party API and allows conversion between different currencies. It is designed for easy integration with other services or frontend applications.

---

## Features
- Real-time currency conversion.
- Supports multiple currencies.
- Fetches latest exchange rates from ExchangeRate-API.
- Simple and clean REST API.
- Exception handling for unsupported currencies.

---

## Technologies
- Java 17+
- Spring Boot 3+
- RestTemplate for HTTP calls
- Lombok
- Maven

---

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.8+
- Internet connection (to call the external currency API)

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/currency-converter-service.git
   cd currency-converter-service


| Endpoint          | Method | Description                       |
| ----------------- | ------ | --------------------------------- |
| `/api/convert`    | POST   | Convert amount between currencies |
| `/api/currencies` | GET    | Get list of supported currencies  |

Configuration
private final String API_KEY = "YOUR_API_KEY_HERE";
Replace "YOUR_API_KEY_HERE" with your actual API key.

Usage
Convert Currency Example
Request:
POST /api/convert
Content-Type: application/json

{
  "from": "USD",
  "to": "EUR",
  "amount": 100
}
Response:
{
  "from": "USD",
  "to": "EUR",
  "amount": 100,
  "convertedAmount": 93.45
}
Get Supported Currencies Example
Request:
GET /api/currencies

Error Handling
If an unsupported currency is requested, the API returns an error with HTTP status 400 (Bad Request) and a message explaining the issue.

Contributing
Contributions are welcome! Feel free to open issues or submit pull requests for improvements or bug fixes


