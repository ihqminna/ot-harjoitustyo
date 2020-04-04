package partypeli;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
//import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PartypeliUi extends Application {
    
    public void addImageView(int y, Group layout) throws FileNotFoundException{
        Image glitter = new Image(new FileInputStream("src/glitter_wide.jpg"));
        ImageView imageView = new ImageView(glitter);
        imageView.setY(y);
        imageView.setFitWidth(2500);
        imageView.setPreserveRatio(true);
        layout.getChildren().add(imageView);
    }
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException{  
        Game game = new Game();
        
        Group startLayout = new Group(); 
        Scene startPage = new Scene(startLayout, 1500, 1000);
        startPage.setFill(Color.DARKRED);
        
        Group gameLayout = new Group();
        Scene gameMode = new Scene(gameLayout, 1500, 1000);
        gameMode.setFill(Color.DARKRED);
        
        addImageView(-400, startLayout);
        addImageView(750, startLayout);
        
        addImageView(-500, gameLayout);
        addImageView(850, gameLayout);
        
        Text title = new Text("PartyPeli");
        title.setFont(Font.font("norwester", 150));
        title.setFill(Color.WHITE);
        title.setX(420);
        title.setY(410);
        
        Text players = new Text("Pelaajat: ");
        players.setFont(Font.font(20));
        players.setFill(Color.WHITE);
        players.setX(480);
        players.setY(550);
        
        Button empty = new Button("Tyhjennä");
        empty.setLayoutY(580);
        empty.setLayoutX(690);
        empty.setOnAction((event) ->{
            game.deletePlayers();
            players.setText("Pelaajat:");
        });
        
        TextField nameInput = new TextField();
        nameInput.setAlignment(Pos.CENTER);
        nameInput.setTranslateX(580);
        nameInput.setTranslateY(470);
        
        Button addPlayer = new Button("Lisää pelaaja");
        addPlayer.setStyle("-fx-base: blue;");
        addPlayer.setLayoutX(800);
        addPlayer.setLayoutY(470);
        addPlayer.setOnAction((event) -> {
            Player toAdd = new Player(nameInput.getText());
            game.addPlayer(toAdd);
            players.setText("Pelaajat: " + game.getNames());
            nameInput.setText("");
        });
        
        Button startGame = new Button("Aloita peli");
        startGame.setStyle("-fx-base: blue;");
        startGame.setPrefSize(200, 50);
        startGame.setLayoutX(630);
        startGame.setLayoutY(650);
        startGame.setOnAction((event) -> {
            primaryStage.setScene(gameMode);
        });
        
        startLayout.getChildren().add(title);        
        startLayout.getChildren().add(addPlayer);
        startLayout.getChildren().add(nameInput);
        startLayout.getChildren().add(startGame);
        startLayout.getChildren().add(players);
        startLayout.getChildren().add(empty);
        
        primaryStage.setScene(startPage);
        primaryStage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
