# TP5 - 

## Auteurs

- Noé Le Van Canh dit Ban
- Wassim Cherabi

## Objectifs

Determiner et créer plusieurs class et method afin de reproduire le jeu d'othello

### Objectits atteints

Nous sommes arriver au à l'objectif final de refaire un jeu d'othello à l'aide de 8 fichiers classes et des méthodes

### Difficultés rencontrée

Nous avons encore eu du mal à compiler les classes test du a des erreurs avec les asserts malgré les imports 

```import static org.junit.jupiter.api.Assertions.*;```

Cependant les test ont été validé sur VsCode

## Comment générer la documentation ?

Afin de générer la documentation il faut executer la commande suivante en se situant dans le dossier tp5:

```
javadoc -sourcepath src src/othello/*.java -d docs 
```

## Comment compiler les classes de test du projet ?

Afin de compiler les classes test du projet il faut utiliser la commande suivante en se situant dans le dossier tp5 :

```
javac -sourcepath src test/othello/*.java -d classes/test
```

## Comment exécuter les tests ?

On utilise les commandes suivantes en se situant dans le dossier tp4 après compilation des classes:

```
java -classpath classes BoardTest
```

```
java -classpath classes GameTest
```


## Comment compiler les classes du projet ?

Il faut utiliser la commande suivante en se situant dans le dossier tp5 :

```
javac -sourcepath src src/othello/*.java -d classes/src
```

## Comment créer le jar exécutable ? (une fois qu’on l’aura vu)

On utilise la commande suivante en se situant dans le dossier tp5 :

```
java -classpath classes OthelloMain 
```

## Comment tester l'exécution du programme ?

Il faut utiliser la commande suivante , on peut remplacer tim et leo par les noms souhaité :

```
java -classpath classes othello.OthelloMain tim leo
```

## Comment exécuter le jar exécutable ?

On utilise la commande suivante en se situant dans le dossier tp5 :

```
java -jar junit-console.jar -classpath test:classes -scan-classpath
```



