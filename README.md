# Wordle-GUI
## JavaFX Wordle Game

## Overview
This is a JavaFX-based implementation of the popular word-guessing game Wordle. It features a graphical user interface (GUI) and utilizes the factory pattern for creating game components. The game allows players to guess a word within a limited number of attempts, with feedback provided for each guess.

## Files in the Project
- `WordleApplication.java`: Main JavaFX application class that launches the GUI.
- `WordleController.java`: Controller class for handling user interactions in the GUI.
- `GuessResult.java`: Class representing the result of a word guess.
- `IllegalWordException.java`: Custom exception class for handling illegal word entries.
- `LetterResult.java`: Class representing the result of individual letter guesses.
- `Wordle.java`: Interface for the core Wordle game logic.
- `WordleDictionary.java`: Class representing the dictionary of valid words.
- `WordleImplementation.java`: Implementation of the Wordle game logic.
- `CommandLineWordle.java`: Command-line version of the Wordle game.
- `DefaultDictionaryFactory.java`: Factory class for creating dictionary instances.

## Prerequisites
- JDK (Java Development Kit) 11 or higher
- JavaFX SDK

## Setup and Running
1. Ensure JDK 11 (or higher) and JavaFX SDK are installed on your system.
2. Clone or download the project to your local machine.
3. Set up your IDE to include JavaFX libraries and configure the VM options to include the JavaFX modules.
4. Run `WordleApplication.java` to start the game with GUI.
5. Alternatively, run `CommandLineWordle.java` to play the game in the command line.

## Gameplay
- Players have a set number of attempts to guess a hidden word.
- Each guess must be a valid word from the dictionary.
- After each guess, the game provides feedback on the correctness of each letter.

