# Janus Platform
## A Microservices-Based Foundation for Inventory Truth & AI-Driven Optimization


## Overview

**Janus Platform** is a modular, microservices-based system designed to model **real-world inventory systems correctly** and serve as a **reliable foundation for AI-driven forecasting, optimization, and decision-making**.

At its core, the platform treats inventory not as a mutable number, but as a **ledger of events** from which the current state is derived. This mirrors how enterprise-grade accounting systems and supply chains operate in reality.

The platform is intentionally designed to be:

- Correct before intelligent  
- Auditable before optimized  
- Simple before abstract  
- AI-ready by design  

---

## Why This Project Exists

Most inventory systems fail because they treat inventory as **state**, not **truth**.

This leads to:

- Silent data corruption  
- Negative or impossible stock states  
- Unexplainable analytics and AI decisions  
- Loss of business trust  

**Janus Platform fixes this by enforcing a ledger-first architecture**, where:

- Every stock change is recorded
- History is immutable
- Current balance is derived
- AI consumes clean, explainable data

---

## Core Design Principles

1. **Inventory is a Ledger**
   - Transactions are immutable
   - Balance is derived
   - History is the source of truth

2. **Single Source of Truth**
   - Only one service owns inventory
   - No other service may mutate stock directly

3. **Correctness Over Convenience**
   - Impossible states are prevented
   - Validation is mandatory

4. **Microservices by Responsibility**
   - Each service owns exactly one domain
   - No shared databases

5. **AI-Ready Architecture**
   - Clean historical data
   - Explainable state transitions
   - Suitable for forecasting and optimization

---

## Repository Structure
janus-platform/
│
├── inventory-service/
│   ├── Inventory Ledger Microservice
│   └── (owns inventory, products, warehouses, transactions)
│
|
├── forecasting-service/        (planned)
│   └── Demand forecasting & seasonality models
│
|
├── replenishment-service/      (planned)
│   └── Reorder point & EOQ optimization
│
|
├── notification-service/       (planned)
│   └── Alerts via Email / Slack / SMS
│
|
├── shared-docs/
│   ├── architecture.md
│   ├── api-contracts.md
│   └── README.md


Each microservice is:

- Independently buildable
- Independently deployable
- Owns its own database
- Responsible for a single domain

---

## Inventory Service (Foundation Microservice)

### What It Represents (Real Life)

The **Inventory Service** represents the **ground truth of physical stock**.

It answers fundamental questions:

- How many items do I have right now?
- Where are those items located?
- What exactly happened in the past?

If this service is wrong, **everything else collapses**.

---

## Responsibilities of Inventory Service

### What This Service Does

- Records every inventory event
- Maintains current stock per product per warehouse
- Prevents impossible states (e.g., negative stock)
- Preserves a complete historical audit trail

### What This Service Does NOT Do

- Forecast demand
- Decide reorder quantities
- Perform optimization
- Trigger business workflows

Those responsibilities belong to other services.

---

## Data Owned by Inventory Service

This service exclusively owns the following data models.

### Product

Represents **what exists** in the business.

Examples:
- Chicken Biryani
- Veg Biryani

Products can exist even if stock is zero.

---

### Warehouse

Represents **where inventory exists physically**.

Examples:
- Kitchen A
- Central Store

Inventory is always tied to a warehouse.

---

### Inventory Transaction

Represents **what happened**.

Examples:
- “3 biryanis sold at Kitchen A”
- “10 biryanis cooked at Kitchen A”
- “2 biryanis discarded due to spoilage”

Properties:
- Append-only
- Immutable
- Source of truth

---

### Inventory Balance

Represents **current derived state**.

Example:
- “Kitchen A currently has 17 biryanis”

Notes:
- Exists for performance
- Can be recomputed from transactions
- Not the source of truth

---

## Inventory Service APIs

The Inventory Service exposes a minimal and intentional API surface.

POST /inventory/transactions
GET /inventory/balance
GET /inventory/transactions


### API Philosophy

- Writes are event-based
- Reads are state or history
- No direct balance mutation
- No hidden shortcuts

⚠️ **No other service is allowed to modify inventory directly**

---

## Example Flow

**Scenario:**  
“3 biryanis sold at Kitchen A”

1. Client sends `POST /inventory/transactions`
2. Service validates:
   - Product exists
   - Warehouse exists
   - Available stock ≥ 3
3. Transaction is recorded
4. Balance is updated atomically
5. Request completes successfully

If validation fails, **nothing is written**.

---

## Internal Architecture (Inventory Service)

Controller
↓
Service
↓
Repository (interfaces)
↓
Database


### Layer Responsibilities

- **Controller**
  - Handles HTTP requests
  - Delegates to service
  - No business logic

- **Service**
  - Core business rules
  - Validation
  - Ledger enforcement

- **Repository**
  - Data access only
  - No validation
  - No calculations

- **Database**
  - MySQL
  - Transactional and auditable

---

## Why Inventory Service Is Built First

This service is the **foundation of the entire platform**.

It enforces:

- Spring Boot fundamentals
- JPA & relational modeling
- Transaction management
- Validation discipline
- Real-world correctness

Every future service depends on this one.

---

## Planned Services (Roadmap)

- **Forecasting Service**
  - Demand prediction using historical transactions

- **Replenishment Service**
  - EOQ and reorder logic

- **Optimization Service**
  - AI-driven inventory optimization

- **Notification Service**
  - Alerts for low stock and anomalies

All future services **consume inventory data**, never modify it.

---

## Technology Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- REST APIs

(Event-driven messaging and cloud integrations will be added later.)

---

## Final Note

Inventory is not a number.  
Inventory is **history + discipline**.

If the ledger is correct,  
everything else can be optimized.

If the ledger is wrong,  
nothing else matters.

This repository is a **master platform repository** containing multiple microservices.

