# 📦 ServiceHub Common Library

## 🚀 Overview

`servicehub-common` is a shared library used across all microservices in the **ServiceHub Platform**.

It contains common components such as:

* Event Models (Kafka Events)
* Data Transfer Objects (DTOs)
* Shared Constants
* Utility Classes
* Common Configurations

This module ensures **consistency, reusability, and loose coupling** between microservices.

---

## 🧩 Why This Module?

In a microservices architecture, different services communicate via events (Kafka).

Without a shared contract:

* Data inconsistency can occur ❌
* Serialization/Deserialization errors happen ❌
* Maintenance becomes difficult ❌

This module solves that by acting as a **single source of truth** for shared data structures.

---

## 🏗️ Project Structure

```
servicehub-common
│
├── src/main/java/com/servicehub/common/
│   ├── event/        # Kafka Event Classes
│   ├── dto/          # Shared DTOs
│   ├── constants/    # Common constants
│   ├── util/         # Utility classes
│
└── pom.xml
```

---

## 📡 Example: Event Model

```java
package com.servicehub.common.event;

public class UserRegisteredEvent {

    private Long userId;
    private String email;

    public UserRegisteredEvent() {}

    public UserRegisteredEvent(Long userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    public Long getUserId() { return userId; }
    public String getEmail() { return email; }
}
```

---

## 🔗 How to Use

### 1. Add Dependency

#### Maven

```xml
<dependency>
    <groupId>com.servicehub</groupId>
    <artifactId>servicehub-common</artifactId>
    <version>1.0.0</version>
</dependency>
```

---

### 2. Use in Producer (User Service)

```java
UserRegisteredEvent event = new UserRegisteredEvent(1L, "test@gmail.com");
kafkaTemplate.send("user-registered-topic", event);
```

---

### 3. Use in Consumer (Booking Service)

```java
@KafkaListener(topics = "user-registered-topic")
public void consume(UserRegisteredEvent event) {
    System.out.println(event.getEmail());
}
```

---

## ⚙️ Compatibility Rules

To maintain stability across services:

* Do NOT break existing fields ❗
* Always use backward-compatible changes
* Use versioning if required (v1, v2 events)

---

## 🧠 Best Practices

✔ Keep this module lightweight
✔ Avoid business logic here
✔ Only shared contracts & utilities
✔ Maintain strict versioning
✔ Ensure backward compatibility

---

## 🔄 Versioning Strategy

| Version | Description                      |
| ------- | -------------------------------- |
| 1.0.0   | Initial release with core events |
| 1.x.x   | Backward compatible changes      |
| 2.0.0   | Breaking changes (if needed)     |

---

## 🛠️ Tech Stack

* Java 17+
* Maven
* Spring Boot Compatible
* Kafka Event-Driven Architecture

---

## 📌 Future Enhancements

* Schema validation (Avro/JSON Schema)
* Event versioning strategy
* Shared error handling models

---

## 🤝 Contribution

This is a core shared module. Changes should be:

* Reviewed carefully
* Backward compatible
* Tested across services

---

## 📄 License

This project is part of the ServiceHub Platform ecosystem.
