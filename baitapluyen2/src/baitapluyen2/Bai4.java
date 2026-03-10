package baitapluyen2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Bai4 extends Application { 
    @Override
    public void start(Stage primaryStage) {
        Label lblInstruction = new Label("Nhập độ C:");
        TextField txtCelsius = new TextField();
        Button btnConvert = new Button("Chuyển sang độ F");
        Label lblResult = new Label("Kết quả: ");
        
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(lblInstruction, txtCelsius, btnConvert, lblResult);

        btnConvert.setOnAction(e -> {
            try {
                double c = Double.parseDouble(txtCelsius.getText());
                double f = c * 1.8 + 32;
                lblResult.setText(String.format("Kết quả: %.2f °F", f));
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Vui lòng nhập số hợp lệ!");
                alert.show();
            }
        });

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.setTitle("Bài 4: Converter JavaFX");
        primaryStage.show();
    }
    public static void main(String[] args) { launch(args); }
}