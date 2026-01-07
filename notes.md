## 📅 Date and Time Handling in Spring Boot (@JsonFormat)

Spring Boot uses **Jackson** internally to convert data between **JSON** and **Java objects**.
Handling date and time correctly is critical because different systems, clients, and timezones
may send data in different formats.

---

## ❓ Why JSON?

JSON (JavaScript Object Notation) is used because:
- It is **lightweight**
- Language independent
- Human-readable
- Supported by all frontend and backend technologies

Example JSON request:
```json
{
  "localDate": "2026-01-07",
  "localDateTime": "2026-01-07T14:30:00"
}
````

Spring Boot automatically converts this JSON into Java objects.

---

## 🔄 What is Deserialization?

**Deserialization** is the process of converting:

```
JSON → Java Object
```

In Spring Boot:

* Jackson library performs deserialization
* It uses **setters** or fields to populate data
* It expects a specific **date-time format**

Example:

```json
"localDate": "2026-01-07"
```

⬇️

```java
LocalDate localDate;
```

---

## ⚠️ What Happens If We Pass a Different Date Format?

If the client sends a **wrong or unexpected format**:

```json
"localDate": "07-01-2026"
```

Spring Boot will throw an error:

```
HttpMessageNotReadableException
```

Reason:

* Jackson cannot guess the date format
* Date parsing fails
* Request is rejected before reaching the service layer

This leads to:

* Unpredictable APIs
* Client-side confusion
* Production issues

---

## 🧩 Problem Without `@JsonFormat`

Without `@JsonFormat`:

* Different clients may send different formats
* Legacy `Date` may be serialized as milliseconds
* API behavior becomes inconsistent

Example without `@JsonFormat`:

```json
"date": 1704615600000
```

This is not human-readable and error-prone.

---

## ✅ What is `@JsonFormat`?

`@JsonFormat` is a Jackson annotation used to:

* Define **exact input format**
* Define **exact output format**
* Control how date and time fields are serialized and deserialized

Example:

```java
@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
private LocalDateTime localDateTime;
```

---

## 🎯 Why `@JsonFormat` is Important (KEY POINTS)

👉 **Forces a fixed input/output format**
👉 **Makes APIs predictable and stable**
👉 Prevents client-side confusion
👉 Avoids runtime parsing errors
👉 Ensures consistent API contracts

---

## 🔍 `@JsonFormat` Affects Two Things

1️⃣ **Deserialization**

```
JSON → Java Object
```

2️⃣ **Serialization**

```
Java Object → JSON Response
```

So both request and response follow the same format.

---

## 🧠 Best Practices

* Always define `@JsonFormat` for date-time fields in APIs
* Prefer `java.time` classes over `Date`
* Use ISO-8601 standard formats
* Document date formats in API contracts
