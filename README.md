# 🔄 Système de Gestion des Retours

## Description
Application web complète pour gérer les retours de produits dans une entreprise.
Quand un client retourne un produit défectueux, le système permet de :
- Enregistrer et suivre les retours produits
- Gérer les non-conformités détectées
- Valider et traiter les retours par le service qualité
- Mettre à jour automatiquement le stock
- Tracer toutes les actions dans un historique

## Technologies Utilisées

### Backend
- Java 17
- Spring Boot 4.0.6
- Spring Data JPA + Hibernate
- MySQL 8.0
- ModelMapper 3.1.1
- Spring Validation
- Swagger/OpenAPI (springdoc-openapi 2.8.8)
- Lombok

### Frontend
- Angular 21
- Bootstrap 5
- TypeScript
- Angular Router
- HttpClient

## Architecture
gestion-retours/
├── backend/          # Spring Boot API REST (port 8080)
│   ├── src/main/java/com/gestionretours/retours/
│   │   ├── configuration/   # Config ModelMapper + Swagger
│   │   ├── controller/      # APIs REST
│   │   ├── dto/             # Data Transfer Objects
│   │   ├── entities/        # Entités JPA
│   │   ├── mapper/          # Conversion Entity ↔ DTO
│   │   ├── repositories/    # Accès base de données
│   │   └── service/         # Logique métier
│   └── pom.xml
├── frontend/         # Angular UI (port 4201)
│   └── src/app/
│       ├── components/      # Pages de l'application
│       └── services/        # Communication avec le backend
├── docker-compose.yml
└── README.md

## Fonctionnalités
- ✅ CRUD complet pour toutes les entités
- ✅ Enregistrement et suivi des retours produits
- ✅ Gestion des non-conformités
- ✅ Validation et traitement par le service qualité
- ✅ Mise à jour automatique du stock
- ✅ Historique automatique des actions
- ✅ Dashboard avec statistiques en temps réel
- ✅ Validation des données avec Spring Validator
- ✅ Documentation API avec Swagger/OpenAPI

## Entités
- **RetourProduit** (id, produit, client, raison, état_traitement, date, quantiteStock)
- **NonConformité** (id, description, gravité, date, produit)
- **Utilisateur** (id, nom, email, rôle)
- **HistoriqueRetour** (id, retour, action, employé, date)

## URLs de Production (Google Cloud Platform)
| Service | URL |
|---------|-----|
| Frontend | https://frontend-retours-1080011468081.europe-west1.run.app |
| Backend API | https://backend-retours-1080011468081.europe-west1.run.app |
| Swagger UI | https://backend-retours-1080011468081.europe-west1.run.app/swagger-ui/index.html |

## Installation et Exécution

### Option 1 — Lancement Manuel

#### Prérequis
- Java 17
- Node.js 20+
- MySQL (XAMPP)
- Angular CLI

#### Backend
```bash
cd backend
./mvnw spring-boot:run
```

#### Frontend
```bash
cd frontend
npm install
ng serve --port 4201 --open
```

#### Accès
| Service | URL |
|---------|-----|
| Frontend | http://localhost:4201 |
| Backend API | http://localhost:8080 |
| Swagger UI | http://localhost:8080/swagger-ui/index.html |

---

### Option 2 — Lancement avec Docker

#### Prérequis
- Docker Desktop installé et démarré

#### Lancement
```bash
docker-compose up
```

#### Accès avec Docker
| Service | URL |
|---------|-----|
| Frontend | http://localhost:80 |
| Backend API | http://localhost:8080 |
| Swagger UI | http://localhost:8080/swagger-ui/index.html |

#### Arrêter Docker
```bash
docker-compose down
```
## URLs de Production (Google Cloud Platform)
| Service | URL |
|---------|-----|
| Frontend | https://frontend-retours-1080011468081.europe-west1.run.app |
| Backend API | https://backend-retours-1080011468081.europe-west1.run.app |
| Swagger UI | https://backend-retours-1080011468081.europe-west1.run.app/swagger-ui/index.html |

## Docker Hub
- Backend : `asmmaa/gestion-retours-backend:1.0`
- Frontend : `asmmaa/gestion-retours-frontend:gcp2`

## Déploiement Cloud
L'application est déployée sur Google Cloud Platform :
- **Cloud Run** — Backend Spring Boot et Frontend Angular
- **Cloud SQL** — MySQL 8.0 (europe-west1)