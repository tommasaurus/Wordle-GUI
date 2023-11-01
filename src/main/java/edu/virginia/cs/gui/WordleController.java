package edu.virginia.cs.gui;

import edu.virginia.cs.wordle.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class WordleController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField text11;
    @FXML
    private TextField text12;
    @FXML
    private TextField text13;
    @FXML
    private TextField text14;
    @FXML
    private TextField text15;
    @FXML
    private TextField text21;
    @FXML
    private TextField text22;
    @FXML
    private TextField text23;
    @FXML
    private TextField text24;
    @FXML
    private TextField text25;
    @FXML
    private TextField text31;
    @FXML
    private TextField text32;
    @FXML
    private TextField text33;
    @FXML
    private TextField text34;
    @FXML
    private TextField text35;
    @FXML
    private TextField text41;
    @FXML
    private TextField text42;
    @FXML
    private TextField text43;
    @FXML
    private TextField text44;
    @FXML
    private TextField text45;
    @FXML
    private TextField text51;
    @FXML
    private TextField text52;
    @FXML
    private TextField text53;
    @FXML
    private TextField text54;
    @FXML
    private TextField text55;
    @FXML
    private TextField text61;
    @FXML
    private TextField text62;
    @FXML
    private TextField text63;
    @FXML
    private TextField text64;
    @FXML
    private TextField text65;
    @FXML
    private TextField output;
    @FXML
    private TextField playAgain;
    @FXML
    private Button yes;
    @FXML
    private Button no;


    private int col = 0;
    private int row = 0;
    private String guess = "";

    Wordle wordle= new WordleImplementation();

    @FXML
    protected void read(KeyEvent event, TextField text) {
        String word = event.getText();
        if (word.length() != 0) {
            char letter = word.toUpperCase().charAt(0);
            text.setText(String.valueOf(letter));
            text.setEditable(false);
            guess += String.valueOf(letter);
        }
    }

    @FXML
    protected void setColor(LetterResult[] color, int row) {
        TextField[][] arr = {{text11, text12, text13, text14, text15},
                {text21, text22, text23, text24, text25},
                {text31, text32, text33, text34, text35},
                {text41, text42, text43, text44, text45},
                {text51, text52, text53, text54, text55},
                {text61, text62, text63, text64, text65}};
        for(int i=0;i<color.length;i++)
        {
            if(color[i] == LetterResult.GREEN){
                arr[row][i].setStyle("-fx-font-size: 28; -fx-text-fill: WHITE; -fx-alignment: center; -fx-background-color: GREEN;");
            }
            if(color[i] == LetterResult.GRAY){
                arr[row][i].setStyle("-fx-font-size: 28;  -fx-text-fill: WHITE;-fx-alignment: center; -fx-background-color: GRAY;");
            }
            if(color[i] == LetterResult.YELLOW){
                arr[row][i].setStyle("-fx-font-size: 28;  -fx-text-fill: WHITE;-fx-alignment: center; -fx-background-color: YELLOW;");
            }
        }
        if (wordle.isGameOver()) {
            output.setVisible(true);
            output.setEditable(false);
            playAgain.setVisible(true);
            yes.setVisible(true);
            yes.setDisable(false);
            no.setVisible(true);
            no.setDisable(false);
            String out ="";
            if(wordle.isWin()){
                out = "YOU WIN! Guesses Remaining: " + (6 - wordle.getGuessCount())  + " The Correct Answer: " + wordle.getAnswer();

            }
            else{
                out = "YOU LOSE Guesses Remaining: " + (6 - wordle.getGuessCount())  + " The Correct Answer: " + wordle.getAnswer();
            }
            output.setText(out);
            playAgain.setText("Do You Want To Play Again?");
        }

    }

    @FXML
    protected void backSpace(KeyCode input)
    {
        TextField[][] arr = {{text11, text12, text13, text14, text15},
                {text21, text22, text23, text24, text25},
                {text31, text32, text33, text34, text35},
                {text41, text42, text43, text44, text45},
                {text51, text52, text53, text54, text55},
                {text61, text62, text63, text64, text65}};
        if (input == KeyCode.BACK_SPACE && col >= 1)
        {
            arr[row][col-1].setText("");
            if (col == 0)
            {
                TextField prev = arr[row][col];
                prev.requestFocus();
                guess = "";
            }
            else
            {
                col--;
                TextField prev = arr[row][col];
                prev.requestFocus();
                guess = guess.substring(0, guess.length() - 1);
            }
        }
    }

    @FXML
    protected void onType(KeyEvent event) {
        KeyCode key = event.getCode();

        TextField[][] arr = {{text11, text12, text13, text14, text15},
                {text21, text22, text23, text24, text25},
                {text31, text32, text33, text34, text35},
                {text41, text42, text43, text44, text45},
                {text51, text52, text53, text54, text55},
                {text61, text62, text63, text64, text65}};

        for (int r = 0; r < arr.length; r++)
        {
            for (int c = 0; c < arr[0].length; c++)
            {
                arr[r][c].setEditable(false);
            }
        }

        if (!wordle.isGameOver())
        {
            output.clear();
            backSpace(key);
            if (col >= 4 && row < 6) {
                if ( key == KeyCode.ENTER) {
                    try {
                        LetterResult[] colors = wordle.submitGuess(guess);
                        setColor(colors, row);
                        row++;
                        col = 0;
                        if(row < 5) {
                            TextField next = arr[row][0];
                            next.requestFocus();
                        }
                        guess = "";
                    }
                    catch(IllegalWordException | GameAlreadyOverException e) {
                        output.setText("This is not a word: " + guess);
                    }
                }
            }
            String word = event.getText();
            if (word.length() != 0) {
                char letter = word.toUpperCase().charAt(0);
                if (key.equals(KeyCode.ENTER))
                {
                }
                else if (letter < 'A' || letter > 'Z') {
                    output.setText("The character is illegal: " + letter);
                }
                else {
                    read(event, arr[row][col]);
                    col++;
                    if(col<4) {
                        TextField next = arr[row][col];
                        next.requestFocus();
                    }
                }
            }
        }
    }

    @FXML
    protected void onClickYes()
    {
        wordle = new WordleImplementation();
        TextField[][] arr = {{text11, text12, text13, text14, text15},
                {text21, text22, text23, text24, text25},
                {text31, text32, text33, text34, text35},
                {text41, text42, text43, text44, text45},
                {text51, text52, text53, text54, text55},
                {text61, text62, text63, text64, text65}};
        for (int r = 0; r < arr.length; r++)
        {
            for (int c = 0; c < arr[0].length; c++)
            {
                arr[r][c].clear();
                arr[r][c].setStyle("-fx-font-size: 28; -fx-alignment: center; -fx-background-color: WHITE; -fx-text-fill: BLACK;");
            }
        }
        reset();
    }

    @FXML
    protected void onClickNo()
    {
        System.exit(0);
    }

    protected void reset()
    {
        TextField[][] arr = {{text11, text12, text13, text14, text15},
                {text21, text22, text23, text24, text25},
                {text31, text32, text33, text34, text35},
                {text41, text42, text43, text44, text45},
                {text51, text52, text53, text54, text55},
                {text61, text62, text63, text64, text65}};
        row = 0;
        col = 0;
        guess= "";
        arr[0][0].requestFocus();
        output.clear();
        playAgain.setVisible(false);
        yes.setVisible(false);
        yes.setDisable(true);
        no.setVisible(false);
        no.setDisable(true);
    }

}