# 🚦 Quantum Radar System (Java)

A Java-based traffic monitoring system developed using **Object-Oriented Programming (OOP)**. The project simulates a radar system that processes vehicle observations, detects traffic violations using configurable rules, generates fines, and provides violation statistics.

## ✨ Features

* **Vehicle observations:** Processes plate number, date, vehicle type, speed, and seatbelt status.
* **Multiple vehicle types:** Supports Private, Truck, and Bus vehicles.
* **Rule-based detection:** Evaluates vehicle observations against configurable traffic rules.
* **Violation detection:** Detects traffic violations such as exceeding the speed limit and not wearing a seatbelt.
* **Fine generation:** Generates fines containing violation details and associated fees.
* **Statistics:** Calculates total fines and provides violation statistics.
* **Extensible rules:** Allows new traffic rules to be added without modifying the radar system.

## 🧱 OOP & Design Concepts

* **Abstraction:** Defines common traffic rule behavior through the `Rule` interface.
* **Encapsulation:** Separates observations, violations, fines, and radar operations into dedicated classes.
* **Polymorphism:** Allows different rule implementations to be handled through the common `Rule` interface.
* **Interfaces:** Provides a common contract for all traffic rules.
* **Strategy Design Pattern:** Treats each traffic rule as an independent strategy that can be registered and evaluated by the radar.
* **SOLID Principles:** Applies principles such as Single Responsibility and Open/Closed to improve maintainability and extensibility.

## 🛠️ Technologies

* Java
* Object-Oriented Programming (OOP)
* SOLID Principles
* Strategy Design Pattern
* Java Collections Framework
* `ArrayList`
* `HashMap`
* `List`
* `Map`
* Console-based application

## 📂 Project Structure

```text
src
├── model
│   ├── Observation.java
│   ├── Violation.java
│   └── Fine.java
├── rules
│   ├── Rule.java
│   ├── MaxSpeedRule.java
│   └── SeatbeltRule.java
├── radar
│   └── QuRadar.java
└── Main.java
```

## 🚀 Getting Started

### Requirements

JDK 11 or later.

### Run from the Command Line

```bash
git clone https://github.com/Shahdrabea2004/Quantum_Radar_System.git
cd Quantum_Radar_System
javac -d out src/*.java src/model/*.java src/rules/*.java src/radar/*.java
java -cp out Main
```

Alternatively, open the project in **IntelliJ IDEA** and run the `Main` class.

## ⚙️ How It Works

1. A vehicle `Observation` is received by the radar.
2. `QuRadar` evaluates the observation against all registered `Rule` implementations.
3. Each rule checks the observation for a specific traffic violation.
4. Detected violations are collected.
5. A `Fine` is generated if one or more violations are detected.
6. The system provides total fines and violation statistics.

```text
                Observation
                     │
                     ▼
                  QuRadar
                     │
                     ▼
            Registered Rules
               │          │
               ▼          ▼
        MaxSpeedRule   SeatbeltRule
               │          │
               ▼          ▼
        Speed Violation  Seatbelt Violation
               │          │
               └─────┬────┘
                     ▼
                Violations
                     │
                     ▼
                   Fine
                     │
                     ▼
               Statistics
```

## 📄 Sample Output

```text
=== Quantum Radar System ===

Vehicle: Private
Plate: ABC-123
Speed: 120 km/h
Seatbelt: Not Used

Violations:
- Speed Limit Exceeded
- Seatbelt Violation

Fine:
Total Fee: 750.0

=== Statistics ===
Speed Violations: 1
Seatbelt Violations: 1
Total Fines: 750.0
```

## 🎯 Learning Outcomes

Built as a Java OOP project to practice **object-oriented design, interfaces, polymorphism, SOLID principles, and the Strategy Design Pattern**.

The project demonstrates how traffic rules can be separated from the core radar logic, making the system easier to maintain and extend with new rules.

## 👩‍💻 Author

**Shahd Rabea**
