# Plateforme Centralisée COUD – Projet de Mémoire

## Contexte

Au Sénégal, les services administratifs reposent encore largement sur des procédures manuelles, coûteuses pour l’État, inefficaces et contraignantes pour les citoyens. 
Conscient de ces limites, le Président de la République, Bassirou Diomaye Faye, a instruit lors du Conseil des ministres du 12 juin 2024 d’accélérer la digitalisation intégrale 
des administrations publiques et de définir une stratégie nationale de cybersécurité renforcée.

Dans cette dynamique, la modernisation du Centre des Œuvres Universitaires de Dakar (COUD), chargé des services sociaux pour les étudiants 
de l’Université Cheikh Anta Diop de Dakar (UCAD), constitue une étape clé. 
Le COUD offre des services tels que : la restauration, la santé, l’hébergement, l’entretien technique des infrastructures et bien d’autres

Cependant, leur gestion reste principalement manuelle, longue et peu transparente, nécessitant souvent la présence physique des étudiants et entraînant files d’attente et formalités lourdes.

## Organisation Technique

L’application repose sur Spring Boot avec une architecture micro-services et suit le modèle MVC (Modèle – Vue – Contrôleur). Même si la couche Vue est généralement absente côté backend, 
chaque micro-service principal comprend les couches suivantes :

- Model (Modèle) : entités Java mappées aux tables de la base via JPA.

- Controller (Contrôleur) : reçoit et traite les requêtes HTTP, puis les transmet à la couche service.

- Service : logique métier spécifique à chaque micro-service, garantissant la séparation des responsabilités.

- Repository : accès aux données persistées via Spring Data JPA (CRUD et requêtes personnalisées).

Ces couches sont organisées dans les packages standards : model, controller, service, repository.

### Micro-services Métiers

Chaque micro-service est dédié à un domaine fonctionnel pour garantir modularité et performance :

- auth-service : gestion des utilisateurs, rôles et autorisations.

- tech-service : gestion des demandes d’interventions techniques, suivi et planification pour les étudiants.

- sante-service : gestion du Dossier Médical Informatisé (DPI) pour centraliser les données médicales et optimiser le suivi sanitaire.

### Micro-services d’Infrastructure

Pour améliorer la structure, la sécurité et la performance globale, plusieurs micro-services techniques sont mis en place :

- serveur-eureka : annuaire de services pour la découverte dynamique des micro-services.

- serverconfig-service : centralise la configuration de tous les micro-services via Spring Cloud Config Server.

- api-gateway : point d’entrée unique pour toutes les requêtes externes, assurant redirection, sécurité et gestion de la montée en charge.
- disi-mock-api : composant de simulation reproduisant le comportement de l’API officielle du Département de l’Informatique et du Système d’Information (DISI) de l’UCAD.
  Cette interaction avec le service d’authentification permet de vérifier automatiquement l’inscription d’un étudiant et de récupérer ses informations personnelles et académiques,
  garantissant que seuls les étudiants autorisés peuvent accéder à la plateforme.


## Environnement de Déploiement 
L’ensemble de la solution, incluant tous les micro-services du backend ainsi que l’interface 
frontend, est entièrement conteneurisé grâce à Docker. L’utilisation d’un fichier docker
compose.yml a permis de faciliter le déploiement local en orchestrant automatiquement le 
démarrage de tous les services.  
Le schéma ci-après illustre l’architecture technique globale de l’application :
