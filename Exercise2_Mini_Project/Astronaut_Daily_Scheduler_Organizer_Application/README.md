# Astronaut Daily Schedule Organizer Application

A **console-based Java application** designed to help astronauts organize their daily tasks efficiently.  
The application ensures that tasks do not overlap, while also providing clean, maintainable code using **object-oriented principles** and **design patterns**.

---

## Key Features

- **Add Task** → Create a new task with:
  - Description  
  - Start time  
  - End time  
  - Priority  

- **Remove Task** → Delete an existing task from the schedule using its description.

- **Help** → Displays the list of available commands and their usage.

- **Exit** → Safely close the application.

- **Task Conflict Management** → Prevents overlapping tasks and notifies the user in case of conflicts.

---

## Design Patterns Implemented

### 1. **Singleton Pattern**
- **Purpose:** To ensure that only one instance of the ScheduleManager exists. This creates a single, globally accessible point of control for managing all tasks, preventing inconsistencies.

### 2. **Factory Pattern**
- **Purpose:** To encapsulate the logic of creating Task objects. The TaskFactory handles the complexities of object creation, such as parsing and validating time formats, which simplifies the main application logic..

### 3. **Observer Pattern**
- **Purpose:** To create a notification system for events, such as task conflicts. The ScheduleManager (the subject) notifies all registered observers (like ConflictNotifier) when a new task overlaps with an existing one, decoupling the notification logic from the scheduling logic.

---

## Project Structure

```
Devansh_Kyada_EI_Coding_Assignment/
└── Exercise2_Mini_Project/
    └── Astronaut_Daily_Scheduler_Organizer_Application/
        ├── Main.java
        ├── ScheduleManager.java
        ├── TaskFactory.java
        ├── Task.java
        ├── ConflictNotifier.java
        └── Observer.java
```

---

## How to Compile and Run

1. **Navigate** to the project root directory:

```bash
cd Devansh_Kyada_EI_Coding_Assignment
```

2. **Compile The Code**

```bash
javac Exercise2_Mini_Project/Astronaut_Daily_Scheduler_Organizer_Application/*.java
```

3. **Run The Code**

```bash
java Exercise2_Mini_Project.Astronaut_Daily_Scheduler_Organizer_Application.Main
```