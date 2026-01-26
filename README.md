# 🏀 NBA Game Dashboard

A full-stack NBA application that aggregates **game schedules, scores, recap media, and AI-generated summaries** into a single, clean experience. This project focuses on real-world data integration, cloud infrastructure, and production-ready deployment.

---

## 📌 Overview

This application allows users to:
- View NBA **game schedules** and **final scores**
- Watch **game recap videos** with thumbnails and quarter-by-quarter scores
- (In progress) Read **AI-generated summaries** of game performance
- Access everything securely over **HTTPS**

---

## 🧩 Data Sources

- **balldontlie API**
    - Game schedules
    - Game results and scores
- **SerpAPI**
    - Game recap videos
    - Thumbnails
    - Quarterly scoring breakdowns

---

## 🏗️ Architecture

Frontend (React)
|
| HTTPS
v
AWS API Gateway (HTTPS Proxy)
|
v
Backend (Spring Boot on EC2)
|
|-- balldontlie API
|-- SerpAPI


---

## 🛠️ Tech Stack

### Frontend
- React
- TypeScript
- Vite

### Backend
- Java
- Spring Boot
- REST APIs
- Docker

### Infrastructure & Cloud
- AWS EC2 (Elastic IP)
- AWS API Gateway
- AWS ECR
- AWS Secrets Manager
- Terraform (infra as code)

---

## ☁️ Infrastructure Details

- All AWS resources are provisioned using **Terraform** in the `nba-infra` repository
- Backend runs on **EC2** with an **Elastic IP** to ensure a stable endpoint
- **API Gateway** sits in front of EC2:
    - Converts HTTP → HTTPS
    - Required due to browser and platform restrictions on HTTP
    - CORS is disabled at the gateway level
- Sensitive credentials (API keys) are stored in **AWS Secrets Manager** and fetched at runtime

---

## 🔄 CI / CD

- Source code is hosted on **GitHub**
- **GitHub Actions** workflow:
    - Builds the backend Docker image
    - Pushes the image to **AWS ECR**
    - EC2 pulls and runs the latest image

This enables consistent and repeatable deployments.

---

## 📂 Repositories

- **nba-frontend** – React frontend application
- **nba-backend** – Spring Boot backend API
- **nba-infra** – Terraform configuration for all AWS resources

---

## 🚧 Future Plans

- AI-generated **game performance summaries** using ChatGPT API
- Team standings (East / West)
- Player and team detail pages
- Filtering by date and team
- Caching for improved performance
- Mobile-friendly UI enhancements

---

## 🏁 Summary

This project demonstrates:
- Real-world API aggregation
- Secure AWS infrastructure using Terraform
- Dockerized backend with CI/CD
- Scalable architecture ready for AI integration

Built as both a learning project and a production-style NBA data platform.