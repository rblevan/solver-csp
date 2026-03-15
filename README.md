# Satisfy - Solveur CSP (Constraint Satisfaction Problem)

![Status](https://img.shields.io/badge/Statut-En_cours_de_développement-blueviolet?style=for-the-badge)
![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.8.5-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-4.13.1-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![GitLab CI](https://img.shields.io/badge/GitLab_CI-Configuré-FC6D26?style=for-the-badge&logo=gitlab&logoColor=white)

> ⚠️ **Note :** Ce projet est actuellement **en cours de développement**. Certaines fonctionnalités peuvent être incomplètes, et l'API interne est susceptible d'évoluer.

**Satisfy** est un solveur léger de problèmes de satisfaction de contraintes (CSP) développé en Java. Il permet de modéliser des problèmes combinatoires via des variables, des domaines et des contraintes, puis de les résoudre à l'aide d'un algorithme de backtracking intégrant du Forward Checking.

## 🚀 Fonctionnalités actuelles

* **Variables et Domaines :** Définition de variables avec des domaines d'entiers discrets.
* **Contraintes :** Prise en charge de plusieurs types de contraintes :
  * *Unaires* : Égalité (`equal`), Différence (`different`).
  * *Binaires* : Égalité (`equal`), Différence (`different`), Infériorité (`under`).
  * *Globales* : Différence totale (`allDifferent`).
* **Heuristiques (Labelling) :** Stratégies configurables pour optimiser la recherche :
  * *Sélection des variables* : Première non assignée (`VAR_FIRST_UNASSIGNED`), Domaine minimal (`VAR_MIN`), Aléatoire (`VAR_RANDOM`).
  * *Sélection des valeurs* : Dans l'ordre croissant (`VAL_IN_ORDER`), Aléatoire (`VAL_RANDOM`).

## 🛠️ Stack Technique & Prérequis

* **Langage** : Java 17
* **Build Tool** : Maven
* **Tests** : JUnit 4
* **CI/CD** : GitLab CI

## 📦 Installation et Compilation

Le projet utilise Maven pour la gestion des dépendances et du cycle de vie du build.

```bash
# Cloner le dépôt
git clone <votre-lien-de-depot>
cd satisfy

# Compiler le projet
mvn compile

# Lancer la suite de tests unitaires
mvn test
