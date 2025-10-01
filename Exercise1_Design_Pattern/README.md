# Design Patterns Implementation

This repository contains comprehensive implementations of various design patterns through console-based Java applications. The patterns are organized into three main categories: **Behavioural**, **Creational**, and **Structural**.

---

## Project Structure

```
Exercise1_Design_Pattern/
├── Behavioural_Design_Pattern/
│   ├── youtube_subscribe_notify_system/
│   └── song_playlist_management_system/
├── Creational_Design_Pattern/
│   ├── employee_factory_system/
│   └── logger_application/
└── Structural_Design_Pattern/
    ├── pc_control_application/
    └── phone_charging_system/
```

---

## Behavioural Design Patterns

Behavioural patterns focus on communication between objects, defining how they interact and distribute responsibilities.

### 1. Observer Pattern - YouTube Subscribe & Notify System

**Location:** `Behavioural_Design_Pattern/youtube_subscribe_notify_system/`

#### Pattern Implementation
The Observer pattern establishes a one-to-many dependency between objects. When the subject (YouTube Channel) changes state, all its observers (Subscribers) are notified automatically.

**Key Components:**
- **Subject Interface:** Defines methods for subscribing, unsubscribing, and notifying observers
- **YoutubeChannel (Concrete Subject):** Maintains a list of subscribers and notifies them when new videos are uploaded
- **Observer Interface:** Defines the `notified()` method that all observers must implement
- **Subscriber (Concrete Observer):** Receives notifications when the channel uploads new content

**How It Works:**
1. Subscribers register themselves with the YouTube channel
2. When a new video is uploaded, the channel notifies all registered subscribers
3. Each subscriber receives a personalized notification message
4. Subscribers can unsubscribe at any time to stop receiving notifications

#### Features
- Subscribe new users to the channel
- Upload videos and automatically notify all subscribers
- Unsubscribe users from the channel
- View list of current subscribers

---

### 2. Iterator Pattern - Song Playlist Management System

**Location:** `Behavioural_Design_Pattern/song_playlist_management_system/`

#### Pattern Implementation
The Iterator pattern provides a way to access elements of a collection sequentially without exposing its underlying representation.

**Key Components:**
- **MyIterator Interface:** Defines `hasNext()` and `next()` methods for traversal
- **MyIteratorImpl (Concrete Iterator):** Implements iteration logic over the song collection
- **PlaylistManagement (Aggregate):** Contains the song collection and provides an iterator
- **Song:** Represents individual song objects with name, artist, and duration

**How It Works:**
1. The playlist stores songs in an ArrayList internally
2. When requested, it provides a custom iterator (MyIteratorImpl)
3. The iterator maintains the current position and allows sequential access
4. Clients can traverse the playlist without knowing the internal storage structure

#### Features
- Add songs to the playlist with name, artist, and duration
- View all songs using the custom iterator
- Remove songs by index
- Display formatted song information

---

## Creational Design Patterns

Creational patterns deal with object creation mechanisms, providing flexibility in what gets created, who creates it, and how.

### 1. Factory Pattern - Employee Factory System

**Location:** `Creational_Design_Pattern/employee_factory_system/`

#### Pattern Implementation
The Factory pattern provides an interface for creating objects but lets subclasses decide which class to instantiate. It promotes loose coupling by eliminating the need to bind application-specific classes into the code.

**Key Components:**
- **Employee Interface:** Defines contract for all employee types (salary and role methods)
- **AndroidDeveloper & WebDeveloper (Concrete Products):** Implement the Employee interface with specific behaviors
- **EmployeeFactory (Factory Class):** Contains static method `getEmployee()` that returns appropriate employee instances based on input

**How It Works:**
1. Client requests an employee type (e.g., "ANDROID DEVELOPER")
2. Factory examines the request and instantiates the appropriate concrete class
3. Factory returns the employee object through the common Employee interface
4. Client works with the employee without knowing the concrete class

#### Features
- Hire Android Developers (salary: 75,000)
- Hire Web Developers (salary: 100,000)
- View all hired employees
- Calculate total payroll for all employees
- Extensible: Easy to add new employee types

---

### 2. Singleton Pattern - Logger Application

**Location:** `Creational_Design_Pattern/logger_application/`

#### Pattern Implementation
The Singleton pattern ensures a class has only one instance and provides a global point of access to it. It uses double-checked locking for thread-safe lazy initialization.

**Key Components:**
- **Private Static Instance:** Holds the single instance of Logger
- **Private Constructor:** Prevents direct instantiation from outside
- **Public Static getLogger() Method:** Provides controlled access to the single instance
- **Synchronized Block:** Ensures thread-safety during instance creation

**How It Works:**
1. First call to `getLogger()` checks if instance is null
2. If null, enters synchronized block (thread-safe)
3. Double-checks null condition inside synchronized block
4. Creates the single instance if it doesn't exist
5. All subsequent calls return the same instance
6. All logs are stored in the single shared instance

#### Features
- Log informational messages with [INFO] prefix
- Log error messages with [ERROR] prefix
- View all logged messages in chronological order
- Thread-safe singleton implementation
- Demonstrates single instance with consistent hashCode

---

## Structural Design Patterns

Structural patterns explain how to assemble objects and classes into larger structures while keeping these structures flexible and efficient.

### 1. Facade Pattern - PC Control Application

**Location:** `Structural_Design_Pattern/pc_control_application/`

#### Pattern Implementation
The Facade pattern provides a simplified interface to a complex subsystem. It hides the complexities of the system and provides a simple interface to the client.

**Key Components:**
- **Complex Subsystem Classes:** PowerSupply, CoolingSystem, CPU, Memory, HardDrive, BIOS, OperatingSystem
- **ComputerFacade (Facade Class):** Provides simplified `startComputer()` and `shutdownComputer()` methods
- **Unified Interface:** Coordinates multiple subsystem operations in the correct sequence

**How It Works:**
1. Client calls simple facade methods (start/shutdown)
2. Facade orchestrates complex operations across multiple subsystems
3. Each subsystem performs its specific task in the proper order
4. Client doesn't need to know about individual subsystems or their interactions

**Startup Sequence:**
Power → Cooling → BIOS → CPU → Memory → Hard Drive → Operating System

**Shutdown Sequence:**
Operating System → BIOS → Hard Drive → Memory → CPU → Cooling → Power

#### Features
- Start computer with coordinated subsystem initialization
- Shutdown computer with proper cleanup sequence
- Simplified interface hiding complex operations
- Extensible: Easy to add new subsystems

---

### 2. Adapter Pattern - Phone Charging System

**Location:** `Structural_Design_Pattern/phone_charging_system/`

#### Pattern Implementation
The Adapter pattern allows objects with incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces.

**Key Components:**
- **AppleCharger Interface:** Defines `chargePhone()` method for iPhone charging
- **AndroidCharger Interface:** Defines `chargeAndroidPhone()` method for Android charging
- **AdaptorCharger (Adapter Class):** Implements AppleCharger while wrapping AndroidCharger
- **ChargerXYZ (Apple Charger):** Official iPhone charger implementation
- **ChargerABC (Android Charger):** Android charger implementation
- **Iphone Class:** Expects AppleCharger interface

**How It Works:**
1. iPhone requires AppleCharger interface for charging
2. AdaptorCharger implements AppleCharger interface
3. Internally, it holds an AndroidCharger reference
4. When `chargePhone()` is called, it delegates to `chargeAndroidPhone()`
5. This allows iPhone to charge using Android charger through the adapter

#### Features
- Charge iPhone with official Apple charger (ChargerXYZ)
- Charge iPhone with Android charger using adapter
- Charge Android phone directly with Android charger
- Demonstrates interface adaptation in real-world scenario

---

## Compilation and Execution

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line terminal or IDE (Eclipse, IntelliJ IDEA, VS Code)

### General Compilation Steps

#### Method 1: Using Command Line

1. **Navigate to the project root directory:**
   ```bash
   cd Exercise1_Design_Pattern
   ```

2. **Compile a specific application:**
   ```bash
   # For Behavioural Patterns
   javac Behavioural_Design_Pattern/youtube_subscribe_notify_system/*.java
   javac Behavioural_Design_Pattern/song_playlist_management_system/*.java

   # For Creational Patterns
   javac Creational_Design_Pattern/employee_factory_system/*.java
   javac Creational_Design_Pattern/logger_application/*.java

   # For Structural Patterns
   javac Structural_Design_Pattern/pc_control_application/*.java
   javac Structural_Design_Pattern/phone_charging_system/*.java
   ```

3. **Run the compiled application:**
   ```bash
   # For Behavioural Patterns
   java Behavioural_Design_Pattern.youtube_subscribe_notify_system.YoutubeMain
   java Behavioural_Design_Pattern.song_playlist_management_system.Main

   # For Creational Patterns
   java Creational_Design_Pattern.employee_factory_system.Main
   java Creational_Design_Pattern.logger_application.Main

   # For Structural Patterns
   java Structural_Design_Pattern.pc_control_application.Main
   java Structural_Design_Pattern.phone_charging_system.Main
   ```

### Example Execution

**Running the YouTube Subscribe System:**
```bash
cd Exercise1_Design_Pattern
javac Behavioural_Design_Pattern/youtube_subscribe_notify_system/*.java
java Behavioural_Design_Pattern.youtube_subscribe_notify_system.YoutubeMain
```
