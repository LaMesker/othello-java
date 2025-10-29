# Othello (Reversi) — Commandes de compilation et d'exécution (Windows / VS Code)

Ce fichier récapitule les commandes que j'ai utilisées pour compiler et exécuter le projet Java sous Windows (VS Code terminal).

Prérequis
- JDK/JRE installés (vous avez indiqué java version "1.8.0_451").
- Lancer les commandes depuis la racine du projet :
  C:\Users\baeju\Desktop\othello-java\othello

Vérifier les versions
```
java -version
javac -version
```

Option A — Utiliser l'invite de commandes (cmd.exe) — méthode simple et fiable
```
cd /d C:\Users\baeju\Desktop\othello-java\othello
rmdir /s /q out 2>nul
mkdir out
rem créer la liste des sources (tapez ceci dans cmd, utilisez %f)
(for /r %f in (*.java) do @echo %f) > sources.txt
javac -d out @sources.txt
del sources.txt
rem exécuter (2 noms de joueurs requis)
java -cp out othello.OthelloMain Alice Bob
```
Remarque : si la JVM d'exécution est Java 8 et javac est plus récent, recompilez en ciblant 1.8 :
```
javac -source 1.8 -target 1.8 -d out @sources.txt
```

Option B — Utiliser PowerShell (sans @sources.txt comme param littéral)
```
Set-Location 'C:\Users\baeju\Desktop\othello-java\othello'
Remove-Item -Recurse -Force .\out -ErrorAction SilentlyContinue
New-Item -ItemType Directory -Path out | Out-Null
$files = Get-ChildItem -Path .\src -Recurse -Filter *.java | Select-Object -ExpandProperty FullName
javac -d out $files
java -cp out othello.OthelloMain Alice Bob
```

Génération de la documentation (javadoc)
```
javadoc -sourcepath src -subpackages othello -d docs
```

Compiler les tests (remarque : pour compiler/ exécuter des tests JUnit, ajoutez le .jar JUnit au classpath)
- Commande de compilation simple (sans JUnit sur le classpath) :
```
javac -sourcepath src -d classes\src @sources.txt
javac -sourcepath src -d classes\test test\othello\*.java
```
- Pour exécuter des tests JUnit, utilisez un runner JUnit et fournissez le jar JUnit dans le classpath (ex. junit-platform-console-standalone).

Notes utiles
- PowerShell n'expande pas les globbing patterns de la même façon que cmd ; c'est la raison d'utiliser la méthode de collecte de fichiers ou d'exécuter javac depuis cmd.exe.
- Si vous rencontrez UnsupportedClassVersionError, soit installez un JRE plus récent, soit recompilez en ciblant la version de votre runtime (-source/-target 1.8).
- Si le programme lit avec System.console() et que console() renvoie null dans VS Code, exécutez-le dans un terminal externe (cmd) ou modifiez OthelloMain pour utiliser Scanner(System.in).



