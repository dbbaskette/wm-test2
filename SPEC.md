# Product Requirements Document: To-Do List Application with React Frontend and Spring Boot Backend

## Overview
This project implements a simple to-do list application. The backend is built using Spring Boot, providing a REST API for managing to-do items. The frontend is built using React, providing a user interface for interacting with the API. To-do items are stored in memory (ephemeral). Each to-do item includes a description, due date, priority, and category.

## Goals
- User can add a new to-do item with a description, due date, priority, and category via the React UI.
- User can view a list of all to-do items in the React UI.
- User can mark a to-do item as complete via the React UI.
- User can delete a to-do item via the React UI.
- The Spring Boot backend provides a REST API to support the React UI functionality.

## Non-Goals
- User authentication and authorization.
- Persistent storage of to-do items (e.g., using a database).
- Advanced filtering or sorting of to-do items.
- User accounts or profiles.
- Real-time updates (e.g., using WebSockets).

## Components

### ToDoItem Model
**Responsibility:** Represents a to-do item with properties like description, due date, priority, category, and completion status.

**Affected Files:**
- `src/main/java/com/example/todolist/model/ToDoItem.java`

**Behavior Expectations:**
- The ToDoItem class should have fields for id (Long), description (String), dueDate (LocalDate), priority (String), category (String), and completed (boolean).
- The ToDoItem class should have appropriate getters and setters for all fields.
- The ToDoItem class should have a constructor that accepts description, dueDate, priority, and category as arguments.
- Priority should be an enum with values HIGH, MEDIUM, LOW.
- Category should be a String.

**Integration Points:**
- Used by the ToDoService for creating, retrieving, updating, and deleting to-do items.
- Returned by the ToDoController as part of the REST API responses.

### ToDoService
**Responsibility:** Provides the business logic for managing to-do items, including creating, retrieving, updating, and deleting them. Stores to-do items in an in-memory list.

**Affected Files:**
- `src/main/java/com/example/todolist/service/ToDoService.java`

**Behavior Expectations:**
- The ToDoService class should have methods for: - creating a new to-do item (createToDoItem) - retrieving all to-do items (getAllToDoItems) - retrieving a to-do item by ID (getToDoItemById) - updating a to-do item (updateToDoItem) - deleting a to-do item (deleteToDoItem)
- The ToDoService should use an in-memory list (ArrayList) to store the to-do items.
- The createToDoItem method should generate a unique ID for each new to-do item.
- The updateToDoItem method should update the properties of an existing to-do item.
- The deleteToDoItem method should remove a to-do item from the in-memory list.
- The getToDoItemById method should return null if no item with the given ID exists.

**Integration Points:**
- Used by the ToDoController to handle REST API requests.
- Uses the ToDoItem model to represent to-do items.

### ToDoController
**Responsibility:** Handles REST API requests for managing to-do items.

**Affected Files:**
- `src/main/java/com/example/todolist/controller/ToDoController.java`

**Behavior Expectations:**
- The ToDoController should have endpoints for: - creating a new to-do item (POST /api/todos) - retrieving all to-do items (GET /api/todos) - retrieving a to-do item by ID (GET /api/todos/{id}) - updating a to-do item (PUT /api/todos/{id}) - deleting a to-do item (DELETE /api/todos/{id})
- The ToDoController should use the ToDoService to perform the business logic.
- The ToDoController should return appropriate HTTP status codes for each request (e.g., 200 OK, 201 Created, 404 Not Found).
- The ToDoController should serialize and deserialize ToDoItem objects to/from JSON.
- The POST /api/todos endpoint should return the created ToDoItem with its generated ID.
- The PUT /api/todos/{id} endpoint should return 404 if the item does not exist.
- The DELETE /api/todos/{id} endpoint should return 404 if the item does not exist.

**Integration Points:**
- Exposes the REST API for the React frontend.
- Uses the ToDoService to manage to-do items.
- Uses the ToDoItem model to represent to-do items.

### React Frontend
**Responsibility:** Provides a user interface for interacting with the Spring Boot REST API to manage to-do items.

**Affected Files:**
- `src/main/js/App.js`
- `src/main/js/components/ToDoList.js`
- `src/main/js/components/ToDoItem.js`
- `src/main/js/components/ToDoForm.js`

**Behavior Expectations:**
- The App.js component should be the main entry point for the React application.
- The ToDoList.js component should display a list of to-do items retrieved from the API.
- The ToDoItem.js component should display a single to-do item and allow the user to mark it as complete or delete it.
- The ToDoForm.js component should allow the user to add a new to-do item.
- The React frontend should use the Fetch API or Axios to make requests to the Spring Boot REST API.
- The React frontend should handle errors gracefully (e.g., displaying an error message to the user).
- The React frontend should update the UI automatically when to-do items are added, updated, or deleted.
- The due date should be displayed in a user-friendly format.
- The priority should be displayed as High, Medium, or Low.
- The category should be displayed as a string.

**Integration Points:**
- Consumes the REST API exposed by the ToDoController.
- Displays to-do items to the user and allows them to interact with them.

### Configuration
**Responsibility:** Configures the Spring Boot application, including setting the port and enabling CORS.

**Affected Files:**
- `src/main/java/com/example/todolist/config/WebConfig.java`

**Behavior Expectations:**
- The WebConfig class should enable CORS to allow requests from the React frontend (running on a different port).
- The WebConfig class should set the port to 8080 (or another suitable port).
- The configuration should be done using annotations (e.g., @Configuration, @EnableWebMvc, @CrossOrigin).

**Integration Points:**
- Used by the Spring Boot application to configure its behavior.

## Technical Requirements
- Spring Boot for the backend.
- React for the frontend.
- Java 17 or higher.
- Maven or Gradle for dependency management.
- REST API design principles.
- CORS enabled on the backend to allow requests from the frontend.
- JSON for data serialization and deserialization.
- Use LocalDate for due dates.
- Use an enum for priority (HIGH, MEDIUM, LOW).
- Code should be well-documented and follow standard Java and JavaScript coding conventions.
- Use functional components and hooks in React.

## Edge Cases
- Empty to-do list: The React frontend should display a message indicating that there are no to-do items.
- Invalid input: The React frontend should validate user input and display appropriate error messages if the input is invalid (e.g., missing description, invalid due date).
- API errors: The React frontend should handle API errors gracefully and display an error message to the user.
- Non-existent to-do item: The ToDoController should return a 404 Not Found error if the user tries to retrieve, update, or delete a to-do item that does not exist.
- Long descriptions: The React frontend should handle long descriptions gracefully (e.g., by truncating them or wrapping them).
- Null values: The backend should handle null values for optional fields (e.g., category) gracefully.

## Acceptance Criteria
- [ ] When I add a new to-do item via the React UI, it should be displayed in the to-do list.
- [ ] When I mark a to-do item as complete via the React UI, its status should be updated in the UI.
- [ ] When I delete a to-do item via the React UI, it should be removed from the to-do list.
- [ ] When I refresh the page, the to-do list should still contain the same items (since it's in-memory).
- [ ] When the API returns an error, the React UI should display an appropriate error message.
- [ ] When I enter invalid data in the to-do form, the React UI should display validation errors.
- [ ] When I try to access a non-existent to-do item via the API, I should receive a 404 Not Found error.
- [ ] When the to-do list is empty, the React UI should display a message indicating that there are no to-do items.

