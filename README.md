# Hotel Management System

This is a Java-based hotel management system developed as part of a course project to explore the architecture and implementation of distributed systems using the client-server model.

The system allows multiple clients to interact with a centralized server to perform hotel-related operations such as room booking, customer management, and billing.

## Overview

The project is structured around the **Client-Server model**, where:

- The **Server** handles all business logic, data storage, and processing.
- The **Client(s)** provide a user interface to interact with the system.
- Communication is handled via **Java Sockets**.

## Key Features

- Room management (add, update, delete room info)
- Customer management (check-in, check-out)
- Booking and billing features
- Real-time communication between client and server
- Simple GUI for client-side interaction
- Console-based server with logs and processing feedback

## Technologies Used

- Java SE
- Java Networking (Sockets, ServerSocket)
- Multithreading (handle multiple clients simultaneously)
- Java Swing (for GUI)
- File I/O (for data storage)
- NetBeans IDE

## Learning Outcome

Through this project, I gained practical understanding of:

- Distributed system design (client-server communication)
- Network programming in Java
- Multithreaded server handling
- Separating concerns between UI and backend
- Developing a modular and maintainable architecture

## How to Run

1. Clone this repository:

git clone https://github.com/HungLeCanh/hotel-management.git

2. Open the project in NetBeans (or any IDE that supports Java).

3. Run the server first:
   - Navigate to the `server` package
   - Run the main server class (Server.java)

4. Run one or more clients:
   - Navigate to the `client` package
   - Launch the GUI client interface

5. Interact with the system from multiple clients to see how they connect to the same server instance.

