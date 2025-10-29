# Othello (Reversi)

Simple Java implementation of Othello (also called Reversi). This project contains the game logic, a command-line entry point, and unit tests.

## Overview
- Two-player board game on an 8x8 grid.
- Players take turns placing a disk of their color (black/white).
- Disks of the opponent that are bounded in a straight line (horizontal, vertical, diagonal) by the new disk and another disk of the current player are flipped.
- Game ends when neither player can move. Highest disk count wins.

## Rules (brief)
1. Players alternate turns; Black usually moves first.
2. A legal move must flip at least one opponent disk.
3. If a player has no legal moves, they pass.
4. Game ends when both players cannot move or board is full.
5. Winner = player with most disks.

## How to build & run (command line)
From project root:

- Compile:
  javac -d out src/othello/othello/*.java src/othello/othello/positions/*.java src/othello/othello/util/*.java

- Run:
  java -cp out othello.OthelloMain

(Or open the project in your IDE and run OthelloMain.)

## Running tests
- Tests are JUnit-based in test/othello. Run them in your IDE or configure a JUnit runner (not included here).

## Project structure
- src/othello/othello
  - Board.java — board state and move logic
  - Pawn.java — disk representation
  - Player.java — player utilities
  - Othello.java — game controller / rules application
  - OthelloMain.java — CLI entry point
- src/othello/othello/positions — position helpers (Position, Direction, exception)
- src/othello/othello/util — Color enum
- test/othello — unit tests (BoardTest, GameTest)

## Round-by-round screenshots / states
Use the placeholders below to add screenshots showing the board state after each round. Replace the sample paths with your screenshots.


Round 0
![Round 0](https://github.com/LaMesker/othello-java/blob/main/Screenshots/round0.png)



Round 1
![Round 1](https://github.com/LaMesker/othello-java/blob/main/Screenshots/round1.png)



Round 2
![Round 2](https://github.com/LaMesker/othello-java/blob/main/Screenshots/round2.png)



Round 3
![Round 3](https://github.com/LaMesker/othello-java/blob/main/Screenshots/round3.png)




