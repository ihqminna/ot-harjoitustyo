package partypeli;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PartypeliUi extends Application {
    
    @Override
    public void start(Stage primaryStage){
        Group layout = new Group(); 
  
        Text title = new Text("PartyPeli");
        title.setFont(Font.font("norwester", 80));
        title.setFill(Color.WHITE);
        title.setX(350);
        title.setY(300);
        
        TextField nameInput = new TextField();
        nameInput.setAlignment(Pos.CENTER);
        nameInput.setTranslateX(370);
        nameInput.setTranslateY(350);
        
        Button addPlayer = new Button("Lisää pelaaja");
        addPlayer.setStyle("-fx-base: blue;");
        addPlayer.setLayoutX(570);
        addPlayer.setLayoutY(350);
        
        //pelaajien nimet näkyviin
        
        Button startGame = new Button("Aloita peli");
        startGame.setStyle("-fx-base: blue;");
        startGame.setPrefSize(200, 50);
        startGame.setLayoutX(400);
        startGame.setLayoutY(480);
        
        layout.getChildren().add(title);        
        layout.getChildren().add(addPlayer);
        layout.getChildren().add(nameInput);
        layout.getChildren().add(startGame);
        
        Scene scene = new Scene(layout, 1000, 800);
        scene.setFill(Color.RED);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
