# ProcessMoniteur 📊🖥️

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java)
![Maven](https://img.shields.io/badge/Maven-3.8.9-blue?style=for-the-badge&logo=apache-maven)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

## Description du Projet
**ProcessMoniteur** est un programme Java qui surveille les processus système et envoie une alerte par email lorsqu'un processus dépasse un seuil de mémoire spécifié. Le projet utilise la bibliothèque **OSHI** pour obtenir des informations système, et **JavaMail** pour envoyer les alertes par email en cas de dépassement. Il permet également une automatisation via le Planificateur de Tâches Windows.

## Fonctionnalités 🚀
- Surveillance des processus système et de l'utilisation de la mémoire.
- Envoi d'une alerte par email lorsqu'un processus dépasse un seuil de mémoire.
- Automatisation via le **Planificateur de Tâches Windows**.
- Code modulaire et propre, avec une séparation claire entre la logique de surveillance et d'alerte.

## Prérequis 🛠️
- **Java 17** ou plus récent.
- **Maven** pour la gestion et la compilation du projet.
- Bibliothèque **OSHI** (utilisée pour la surveillance des processus).
- **JavaMail** (utilisée pour l'envoi des alertes par email).

## Installation et Configuration ⚙️

### 1. Cloner le dépôt
Pour commencer avec le projet, clonez le dépôt depuis GitHub :
```bash
git clone https://github.com/akamidev/ProcessMoniteur.git
cd ProcessMoniteur
```
### Auteur 👨‍💻

- Mehdi Akami - [Mon profil GitHub](https://github.com/akamidev)
  
### Licence 📜

Ce projet est sous licence MIT. Consulte le fichier [LICENSE](https://github.com/akamidev/surveillance_disque/blob/main/LICENSE) pour plus d'informations.
