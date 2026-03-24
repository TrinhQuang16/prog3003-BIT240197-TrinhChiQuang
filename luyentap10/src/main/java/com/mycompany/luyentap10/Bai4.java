package com.mycompany.luyentap10;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Bai4 extends Application {

    private TextField display = new TextField();
    private double fNum = 0;
    private String op = "";
    private boolean start = true;

    @Override
    public void start(Stage stage) {
       
        display.setEditable(false);
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setMinHeight(50);
        display.setFont(Font.font("Arial", 20));

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        int row = 0, col = 0;
        for (String text : buttons) {
            Button btn = new Button(text);
            btn.setPrefSize(60, 60);
            btn.setFont(Font.font(18));
            btn.setOnAction(e -> handleAction(text));
            
            grid.add(btn, col, row);
            col++;
            if (col > 3) {
                col = 0;
                row++;
            }
        }
        
        VBox root = new VBox(10, display, grid);
        root.setPadding(new Insets(15));
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 450);
        stage.setTitle("JavaFX Calculator");
        stage.setScene(scene);
        stage.show();
    }

    private void handleAction(String value) {
        if ("0123456789".contains(value)) {
            if (start) {
                display.clear();
                start = false;
            }
            display.appendText(value);
        } else if (value.equals("C")) {
            display.clear();
            fNum = 0;
            op = "";
            start = true;
        } else if (value.equals("=")) {
            calculate(Double.parseDouble(display.getText()));
            op = "";
            start = true;
        } else {
            fNum = Double.parseDouble(display.getText());
            op = value;
            start = true;
        }
    }

    private void calculate(double sNum) {
        switch (op) {
            case "+": display.setText(String.valueOf(fNum + sNum)); break;
            case "-": display.setText(String.valueOf(fNum - sNum)); break;
            case "*": display.setText(String.valueOf(fNum * sNum)); break;
            case "/": 
                if (sNum != 0) display.setText(String.valueOf(fNum / sNum));
                else display.setText("Error");
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}