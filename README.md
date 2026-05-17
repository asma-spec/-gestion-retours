# Système de Gestion des Retours

## Description
Application web complète pour gérer les retours de produits dans une entreprise.

## Technologies
### Backend
- Java 17
- Spring Boot 4.0.6
- Spring Data JPA + Hibernate
- MySQL
- ModelMapper
- Spring Validation
- Swagger/OpenAPI

### Frontend
- Angular 21
- Bootstrap 5
- TypeScript

## Fonctionnalités
- CRUD complet pour toutes les entités
- Enregistrement et suivi des retours produits
- Gestion des non-conformités
- Validation et traitement par le service qualité
- Mise à jour automatique du stock
- Historique des actions
- Dashboard avec statistiques
- Documentation API avec Swagger

## Installation et Exécution

### Prérequis
- Java 17
- Node.js
- MySQL (XAMPP)
- Angular CLI

### Backend
```bash
cd backend
mvnw spring-boot:run
```

### Frontend
```bash
cd frontend
npm install
ng serve --port 4201
```

### Accès
- Frontend : http://localhost:4201
- Backend API : http://localhost:8080
- Swagger UI : http://localhost:8080/swagger-ui/index.html

## Structure du projet