# Java Network Scanner 

## Introduction
The **Java Network Scanner** is a **lightweight, fast, and GUI-based network scanning tool** that functions similarly to **Nmap**. It allows users to **discover active hosts on a subnet**, for device identification. Built using **JavaFX**, this tool provides an easy-to-use interface for network scanning and security auditing.

## Features 
- **Network Scanning** – Discovers active devices within a given subnet.
- **ARP Table Extraction** – Lists devices found using **ARP table** for improved detection.
- **Fast & Multi-threaded** – Utilizes **ExecutorService** for concurrent scanning.
- **Simple GUI** – Built with JavaFX for an intuitive user experience.

## How It Works
This network scanner performs two main functions:
1. **Ping Sweep Scan**:
   - Iterates over a given subnet (e.g., `192.168.1.x`).
   - Sends ICMP (ping) requests to detect **active hosts**.
2. **ARP Table Query**:
   - Extracts the **ARP table** using the system’s `arp -a` command.
   - Displays **discovered devices** and their IP addresses.

When a scan is initiated:
- **Active hosts** are displayed in real-time.
- **ARP-detected devices** are extracted and listed.

### Prerequisites:
- **Windows/Linux** system with **Admin privileges** (for ARP scanning).
- **JavaFX dependencies** included.

