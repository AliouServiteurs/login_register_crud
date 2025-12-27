# 📚 Mini projet Spring Boot – CRUD Personne avec Authentification

## 📝 Description
Ce mini projet a pour objectif de **se familiariser avec Spring Boot et Spring Security** à travers la réalisation d’une API REST simple.

Le projet permet :
- la **gestion CRUD** (Create, Read, Update, Delete) des entités *Personne*
- la **gestion des utilisateurs** avec **register** et **login**
- la **sécurisation des endpoints** à l’aide de **Spring Security**

Ce projet sert principalement de **projet pédagogique** pour comprendre :
- l’architecture Controller / Service / Repository
- l’encodage des mots de passe
- l’authentification avec Spring Security
- les bonnes pratiques REST

---

## 🛠️ Technologies utilisées

- Java 17
- Spring Boot
- Spring Web (REST API)
- Spring Data JPA
- Spring Security
- Hibernate
- MariaDB
- Maven
- Postman (tests)

---

## 🗂️ Architecture du projet

```
com.leserviteurs.bliothequeGestion
│
├── configuration     # Configuration Spring Security
├── controller        # Controllers REST
├── model            # Entités JPA
├── repository        # Interfaces JPA Repository
├── service           # Logique métier
└── BliothequeGestionApplication.java
```

---

## 🔐 Sécurité & Authentification

La sécurité est gérée par **Spring Security**.

### Endpoints autorisés sans authentification
```text
/api/auth/**        → register & login
/api/personnes/**   → endpoints CRUD Personne (projet pédagogique)
```

Tous les autres endpoints nécessitent une authentification.

### Configuration principale
- CSRF désactivé (API REST)
- Encodage des mots de passe avec **BCrypt**
- Utilisation d’un `UserDetailsService` personnalisé

---

## 👤 Gestion des utilisateurs

### ➕ Register
Permet de créer un nouvel utilisateur avec mot de passe encodé.

**POST** `/api/auth/register`

```json
{
  "username": "aliou",
  "password": "1234"
}
```

---

### 🔑 Login
Permet à un utilisateur existant de s’authentifier.

**POST** `/api/auth/login`

```json
{
  "username": "aliou",
  "password": "1234"
}
```

---

## 👥 Gestion des Personnes (CRUD)

### 📄 Lister toutes les personnes
**GET** `/api/personnes/tous`

---

### 🔍 Obtenir une personne par ID
**GET** `/api/personnes/trouver/{id}`

---

### ➕ Ajouter une personne
**POST** `/api/personnes/ajouter`

```json
{
  "nom": "Diop",
  "prenom": "Aliou"
}
```

---

### ✏️ Modifier une personne
**PUT** `/api/personnes/mettreAJour/{id}`

---

### ❌ Supprimer une personne
**DELETE** `/api/personnes/supprimer/{id}`

---

## ⚠️ Gestion des erreurs

- Les erreurs métiers (ex : ID inexistant) sont gérées dans la **couche Service**
- Les Controllers se concentrent uniquement sur la gestion HTTP
- Exceptions possibles :
  - Ressource introuvable
  - Requêtes invalides

---

## 🧪 Tests avec Postman

1. Tester d’abord **register**
2. Tester **login**
3. Tester les endpoints `/api/personnes`

⚠️ Dans ce mini projet, les endpoints Personne sont volontairement accessibles sans authentification pour simplifier l’apprentissage.

---

## 🎯 Objectifs pédagogiques

- Comprendre Spring Boot
- Comprendre Spring Security
- Séparer les responsabilités (Controller / Service)
- Manipuler JPA et Hibernate
- Tester une API REST

---

## 🚀 Améliorations possibles

- Ajout de JWT (Bearer Token)
- Gestion des rôles (USER / ADMIN)
- Protection complète des endpoints CRUD
- Ajout de Swagger (OpenAPI)
- Validation des données (Bean Validation)

---

## 👨‍💻 Auteur

**Aliou Diop**  
Projet d’apprentissage Spring Boot & Spring Security

