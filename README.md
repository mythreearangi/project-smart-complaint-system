# 🚀 Smart Complaint Management System

An AI-powered web application that automates the process of complaint registration, categorization, prioritization, and resolution tracking for institutions and organizations.

---

## 📌 Problem Statement

In many institutions and public organizations, complaint handling is manual, unorganized, and time-consuming. Complaints are often not categorized or prioritized properly, leading to delayed resolutions, lack of transparency, and user dissatisfaction. There is a need for an intelligent and automated system that can efficiently manage complaints and ensure timely resolution.

---

## 💡 Solution Overview

The Smart Complaint Management System provides an end-to-end digital platform where users can submit complaints and track their status, while administrators can monitor, prioritize, and resolve complaints efficiently. The system uses AI-based logic to automatically categorize complaints, assign priorities, and escalate unresolved complaints over time.

---

## ✨ Key Features

### 👤 User Features
- User registration and secure login
- Submit complaints with description (and optional image)
- AI-based automatic complaint categorization
- AI-based priority assignment
- View previously submitted complaints
- Track complaint status (Submitted / In Progress / Resolved)
- Secure logout

### 🛠️ Admin Features
- Admin registration and secure login
- Centralized dashboard to view all complaints
- Filter complaints by category and status
- Update complaint status in real time
- View complaint submission date and last updated time
- Monitor pending, in-progress, and resolved complaints
- Secure logout

### 🤖 AI Features
- Automatic complaint categorization using text analysis
- Smart priority assignment based on complaint severity
- Time-based priority escalation for unresolved complaints
- Ensures fairness and faster resolution of critical issues

---

## 🧱 System Architecture

The project follows a **layered architecture**:

- **Controller Layer** – Handles HTTP requests and responses
- **Service Layer** – Contains business logic and AI processing
- **Repository Layer** – Manages database operations using JPA
- **Entity Layer** – Maps Java objects to database tables

Frontend and backend communicate through RESTful APIs.

---

## 🛠️ Tech Stack

### Frontend
- HTML
- CSS
- JavaScript

### Backend
- Java
- Spring Boot
- Spring Data JPA

### Database
- H2 Database (Development)
- MySQL (Production-ready)

### Tools & Platforms
- Postman – API testing
- GitHub – Version control and source code hosting
- IntelliJ IDEA – Backend development
- VS Code – Frontend development


---

## ▶️ How to Run the Project

### 🔹 Backend Setup
1. Open the `backend` folder in IntelliJ IDEA
2. Ensure Java 17 is installed
3. Run `SmartComplaintSystemApplication.java`
4. Backend starts at:
http://localhost:8080

### 🔹 Frontend Setup
1. Open the `frontend` folder
2. Open `index.html` in a web browser
3. Select User or Admin and proceed with login/register

---

## 🧪 API Testing

All backend APIs were tested using **Postman** before frontend integration.

### Sample APIs:
- `POST /complaints/submit`
- `GET /complaints/all`
- `PUT /complaints/update/{id}`
- Authentication APIs for User/Admin

---

## 🚀 Future Scope

- Integration with advanced AI models (OpenAI / Gemini)
- Mobile application (Android / iOS)
- Real-time notifications (Email / SMS / Push)
- Cloud deployment for scalability
- Advanced analytics and reporting dashboard
- Enhanced security using JWT authentication

---

## 🏁 Conclusion

The Smart Complaint Management System provides a scalable, intelligent, and transparent solution for managing complaints efficiently. By combining AI-based automation with a clean layered architecture, the system ensures faster resolution and improved user satisfaction.

---

## 👨‍💻 Developed For

Vibe Coding Hackathon / Academic Mini Project


