# microblogging_ECD

# 🌐 Connecting Every Dot

**Connecting Every Dot** est une application web de microblogging réalisée avec :
- **Front-end** : Angular
- **Back-end** : Spring Boot

L'objectif est de connecter les utilisateurs via des posts courts, avec une interface rapide, intuitive et responsive.

---

## 📸 Aperçu de l'application

![Connecting Every Dot - Home Page](./bf04a9c9-440a-4734-95ad-01cff7092af4.png)

---

## 🚀 Fonctionnalités principales (MVP)

- 📝 **Page d'inscription et de connexion** : création de compte et authentification - non fonctionnelle
- 🧑‍💼 **Page de profil utilisateur** : biographie et posts de l'utilisateur - non fonctionnelle
- ✏️ **Page d'édition du profil** : modifier la biographie et photo - non fonctionnelle
- 🆕 **Formulaire de création de nouveau post**
- 🏡 **Page d'accueil (feed)** : visualisation de tous les posts de la plateforme
- 🔎 **Barre de recherche** : rechercher un utilisateur ou un post - non fonctionnelle
- 📜 **Who to follow** : suggestions d’utilisateurs
- 🆕 **Blogs récents** : dernières publications
- 📈 **Hashtags les plus recherchés** - non fonctionnelle

---

## 🗃️ Base de données du MVP

Voici la structure simplifiée de la base de données :

### Tables principales :

#### `Users`
| Colonne | Type | Description |
|:--------|:-----|:------------|
| id | INT | Identifiant unique |
| pseudonyme | VARCHAR | Nom d'utilisateur |
| profile_picture_id | INT | Image de profil |
| email | VARCHAR | Email utilisateur |
| password | VARCHAR | Mot de passe hashé |
| biography | TEXT | Biographie |

#### `Profile_Pictures`
| Colonne | Type | Description |
|:--------|:-----|:------------|
| id | INT | Identifiant unique |
| imageUrl | VARCHAR | Lien vers l'image |

#### `Posts`
| Colonne | Type | Description |
|:--------|:-----|:------------|
| id | INT | Identifiant unique |
| user_id | INT | Auteur du post |
| description | TEXT | Contenu du post |
| created_at | TIMESTAMP | Date de création |

#### `Post_Pictures`
| Colonne | Type | Description |
|:--------|:-----|:------------|
| id | INT | Identifiant unique |
| post_id | INT | Post associé |

#### `Post_Videos`
| Colonne | Type | Description |
|:--------|:-----|:------------|
| id | INT | Identifiant unique |
| post_id | INT | Post associé |
| videoUrl | VARCHAR | Lien de la vidéo |

---

## 🖥️ Pages principales

### 1. Page d'accueil
- **Feed** de tous les posts
- **Searchbar** (recherche utilisateur/post)
- **Who to follow** (suggestions)
- **Blogs récents**
- **Hashtags populaires**

### 2. Page profil personnel - NICE TO DO
- **Photo + biographie**
- **What’s happening** : créer un nouveau blog
- **Modifier** profil
- **Voir ses posts personnels**
- **Déconnexion**

## ⚙️ Stack technique

### Front-end

- Angular 17
- HTML5 / CSS3 (Flexbox, Responsive Design)
- TypeScript
- Routing Angular
- Services Angular (HTTP Client)

### Back-end

- Spring Boot 
- Spring Security (authentification sécurisée)
- JPA / Hibernate
- Base de données relationnelle : MySQL ou H2
- API REST JSON

---

## 📦 Installation et lancement

### Prérequis

- Node.js ≥ 18
- Angular CLI
- Java 21
- Maven
- MySQL (ou H2 pour dev)

---

### Démarrage rapide

#### Back-end (Spring Boot)

```bash
cd backend
mvn clean install
mvn spring-boot:run
Fichier application.properties type :

properties
Copier
Modifier
spring.datasource.url=jdbc:mysql://localhost:3306/connectingdb
spring.datasource.username=root
spring.datasource.password=motdepasse
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8080
Front-end (Angular)
bash
Copier
Modifier
cd frontend
npm install
ng serve
Fichier src/environments/environment.ts :

typescript
Copier
Modifier
export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080/api'
};


🎯 Fonctionnalités futures
👍 Système de likes

💬 Commentaires sur les posts

🏷️ Gestion avancée des hashtags
