
<div align="center">

# ⚖️ MetroSync: Unified Legal Metrology

**A centralized, offline-capable multi-platform system designed to digitize the entire lifecycle of weighing and measuring instruments.**

[![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack_Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)](https://developer.android.com/jetpack/compose)
[![Kotlin Multiplatform](https://img.shields.io/badge/Kotlin%20Multiplatform-7F52FF?logo=kotlin&logoColor=white)](https://kotlinlang.org/docs/multiplatform.html)
[![Node.js](https://img.shields.io/badge/Node.js-43853D?style=for-the-badge&logo=node.js&logoColor=white)](https://nodejs.org/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)](https://postgresql.org/)

*Smart India Hackathon 2026 • Problem Statement ID: SIH26036 • Team: NEXGEN*

</div>

---

## 📖 Overview

**MetroSync** is an offline-capable, multi-platform software application designed to replace manual registries with QR-enabled digital certificates. It seamlessly connects State Legal Metrology Officers (LMOs), Government Approved Test Centres (GATCs), and traders through a shared, secure infrastructure.

Built on **Clean Architecture** and **Unidirectional Data Flow**, the system completely isolates the user interface from business rules, allowing uninterrupted operation even in remote markets with zero network connectivity.

> **Note:** This project utilizes an offline-first persistence strategy, leveraging local SQLite databases and opportunistic background synchronization to ensure zero data loss during field operations.

---

## 🚀 Executive Summary: MetroSync Capabilities

* **Eliminates Network Bottlenecks:** Field operations are no longer delayed by connection timeouts. The Android client utilizes local storage as the primary source of truth, capturing calibration data, stamp photos, and GPS coordinates entirely offline.
* **Automates Expiry Monitoring:** Replaces manual tracking with automated background workers. By executing range queries against B+ Tree indexed databases, the system pulls expiring records in *O(log n + m)* time and triggers SMS and dashboard alerts.
* **Eradicates Record Tampering:** Cryptographic digital certificates linked to centralized databases ensure that consumers and regulators can instantly verify an instrument's validity via dynamic QR codes.
* **Extensible Multiplatform Architecture:** By decoupling the UI from the Domain, the exact same regulatory logic (fee calculation, expiry generation) is executed across both the Web administrative portal and the Android application, drastically reducing long-term maintenance costs.

---

## 🏗️ Architecture: Clean Architecture & UDF

MetroSync enforces a strict architectural split to ensure platform-agnostic business logic and robust offline capabilities.

* 📦 **Domain Module (Core Logic):** The isolated business logic validates inspection data, calculates required fees, and determines the next expiry date based on Legal Metrology Rules.
* 🗄️ **Data Module:** Evaluates network availability to route payloads. It safely caches inspection data in the **Local Database (SQLite)** when offline, and utilizes the **Network Module** to authenticate (JWT) and transmit data to the **Centralized Server** when online.
* 🎨 **Shared UI Module:** The user interface layer for mobile integration. When an LMO completes a verification, this module emits a structured Event and routes it upward to the Domain layer, acting purely as a reactive renderer.
* 🌐 **Composition Roots:** A single, shared domain layer powers both the administrative Web dashboard (for scheduling and pendency monitoring) and the Android application (for field officers).

---

## ✨ Key Features & Risk Mitigation

- **🛡️ Offline-First Persistence:** Writes all inspection data locally first to guarantee zero data loss regardless of network bandwidth in remote industrial warehouses.
- **🔄 Opportunistic Background Syncing:** Utilizes Kotlin Coroutines to monitor network states and silently flush the local data queue to the centralized server via atomic transactions once connectivity is restored.
- **⚖️ Deterministic Conflict Resolution:** The central server database utilizes timestamp-based Last-Write-Wins (LWW) logic to systematically reconcile discrepancies between offline field edits and central dashboard updates.
- **🔐 Cryptographic Protection:** Enforces strict JSON Web Token (JWT) authentication, while local data is secured using hardware-backed encryption (like SQLCipher).

---

## 🛠️ Tech Stack

* **Frontend & Shared Domain Logic:** Kotlin Multiplatform (KMP)
* **Mobile Interface:** Jetpack Compose
* **Offline Storage:** SQLite
* **Concurrency Engine:** Kotlin Coroutines
* **Centralized Server:** Node.js or Go
* **Primary Database:** PostgreSQL

---

## 👤 Credits & Acknowledgements

* **Team Name:** NEXGEN
* **Project Title:** MetroSync
* **Lead Architect:** Santanu Sarkar
* **Team Members:** 
* **Event:** Smart India Hackathon 2026

*Designed for the Unified Legal Metrology & Offline-First Verification platform (SIH26036).*
MetroSync_README.md
Displaying MetroSync_README.md.