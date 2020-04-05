package partypeli;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
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
    
    public void addTitle(int x, int y, int f, Group layout){
        Text title = new Text("PartyPeli");
        title.setFont(Font.font("norwester", f));
        title.setFill(Color.WHITE);
        title.setX(x);
        title.setY(y);
        layout.getChildren().add(title);
    }
    
    public Button addButton(String text, Background background, Color textColor, int fontSize, Border border, int x, int y){
        Button button = new Button(text);
        button.setBackground(background);
        button.setTextFill(textColor);;
        button.setFont(Font.font (fontSize));
        button.setBorder(border);
        button.setLayoutY(y);
        button.setLayoutX(x);
        return button;
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
        
        addTitle(420, 410, 150, startLayout);
        addTitle(100, 250, 70, gameLayout);
        
        Text players = new Text("Pelaajat: ");
        players.setFont(Font.font(20));
        players.setFill(Color.WHITE);
        players.setX(480);
        players.setY(550);
        
        Text max = new Text("");
        max.setFont(Font.font(20));
        max.setFill(Color.BLUE);
        max.setTranslateY(450);
        max.setTranslateX(580);
        
        Button empty = addButton("Tyhjennä pelaajat", Background.EMPTY, Color.WHITE, 13, new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(2), BorderWidths.DEFAULT)), 660, 580);
        empty.setOnAction((event) ->{
            game.deletePlayers();
            players.setText("Pelaajat:");
            max.setText("");
        });
        
        TextField nameInput = new TextField();
        nameInput.setTranslateX(620);
        nameInput.setTranslateY(470);
        
        Button addPlayer = addButton("Lisää pelaaja", new Background(new BackgroundFill(Color.BLUE, new CornerRadii(2), Insets.EMPTY)), Color.WHITE, 13, new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(2), BorderWidths.DEFAULT)), 800, 470);
        addPlayer.setOnAction((event) -> {
            int amount = game.numberOfPlayers();
            if (amount < 10){
                Player toAdd = new Player(nameInput.getText());
                game.addPlayer(toAdd);
                players.setText("Pelaajat: " + game.getNames());
                nameInput.setText("");
            }else{
                nameInput.setText("RIITTÄÄ JO");
                return;
            }
            if (amount == 9){
                max.setText("PELAAJAMÄÄRÄ TÄYNNÄ");
            }
        });
        
        Button startGame = addButton("Aloita peli", new Background(new BackgroundFill(Color.BLUE, new CornerRadii(2), Insets.EMPTY)), Color.WHITE, 32, new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(2), BorderWidths.DEFAULT)), 630, 650);
        startGame.setOnAction((event) -> {
            primaryStage.setScene(gameMode);
        });
               
        startLayout.getChildren().add(addPlayer);
        startLayout.getChildren().add(nameInput);
        startLayout.getChildren().add(startGame);
        startLayout.getChildren().add(players);
        startLayout.getChildren().add(empty);
        startLayout.getChildren().add(max);
        
        primaryStage.setScene(startPage);
        primaryStage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
