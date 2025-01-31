# Student Management API

## Overview
This is a simple Spring Boot REST API for managing student records. It allows adding, retrieving, updating, and deleting student data.

## Features
- Add a single student or multiple students
- Retrieve all students or search by roll number, name, section, standard, or age
- Update student details based on filters
- Delete a student by roll number

## Endpoints
### Student Retrieval
- `GET /students` - Get all students
- `GET /student/roll/{rollNo}` - Get student by roll number
- `GET /student` - Find students by optional filters (`name`, `section`, `standard`, `age`)

### Student Management
- `POST /newstudent` - Add a new student
- `POST /newstudents` - Add multiple students
- `PUT /updatestudent` - Update student details using filters
- `DELETE /deletestudent/{rollNo}` - Delete a student by roll number

## Example JSON Student Object
```json
{
  "name": "Aravind",
  "rollNo": 101,
  "standard": 10,
  "section": "A",
  "age": 15
}
```

## How to Run
1. Clone the repository
2. Build and run the Spring Boot application
3. Use Postman or any REST client to test the endpoints

## Technologies Used
- Java
- Spring Boot
- REST API
