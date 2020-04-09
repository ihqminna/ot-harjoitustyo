package partypeli.ui;

// import java.awt.event.KeyAdapter;
// import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
// import javafx.event.ActionEvent;
// import javafx.event.EventType;
import javafx.geometry.Insets;
// import javafx.geometry.Pos;
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
import partypeli.domain.Game;
import partypeli.domain.Player;

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
    
    public Button addButton(String text, int fontSize, int x, int y, Group layout){
        Button button = new Button(text);
        button.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(2), Insets.EMPTY)));
        button.setTextFill(Color.WHITE);;
        button.setFont(Font.font (fontSize));
        button.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(2), BorderWidths.DEFAULT)));
        button.setLayoutY(y);
        button.setLayoutX(x);
        layout.getChildren().add(button);
        return button;
    }
    
    public Text addText(String string, int fontSize, Color color, int x, int y, Group layout){
        Text text = new Text(string);
        text.setFont(Font.font(fontSize));
        text.setFill(color);
        text.setX(x);
        text.setY(y);
        layout.getChildren().add(text);
        return text;
    }
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException{  
        Game game = new Game();
        
        Group startLayout = new Group(); 
        Scene startPage = new Scene(startLayout, 1500, 1000);
        startPage.setFill(Color.DARKRED);
        addImageView(-400, startLayout);
        addImageView(750, startLayout);
        addTitle(420, 410, 150, startLayout);  
        Text players = addText("Pelaajat: ", 20, Color.WHITE, 480, 550, startLayout);
        Text max = addText("", 20, Color.BLUE, 580, 450, startLayout);
        TextField nameInput = new TextField();
        nameInput.setTranslateX(600);
        nameInput.setTranslateY(470);
        startLayout.getChildren().add(nameInput);
        
        Group difLayout = new Group();
        Scene setDifficulty = new Scene(difLayout, 1500, 1000);
        setDifficulty.setFill(Color.DARKRED);
        addImageView(-400, difLayout);
        addImageView(750, difLayout);
        addTitle(560, 360, 80, difLayout);
        addText("Valitse vaikeustaso:", 25, Color.WHITE, 600, 500, difLayout);
        
        Group drinkingLayout = new Group();
        Scene setDrinking = new Scene(drinkingLayout, 1500, 1000);
        setDrinking.setFill(Color.DARKRED);
        addImageView(-400, drinkingLayout);
        addImageView(750, drinkingLayout);
        addTitle(560, 360, 80, drinkingLayout);
        addText("Valitse juomatehtävien määrä:", 25, Color.WHITE, 540, 500, drinkingLayout);
        
        Group gameLayout = new Group();
        Scene gameMode = new Scene(gameLayout, 1500, 1000);
        gameMode.setFill(Color.DARKRED);
        addImageView(-500, gameLayout);
        addImageView(850, gameLayout);
        addTitle(100, 250, 70, gameLayout);
        Text player = addText("", 40, Color.WHITE, 680, 400, gameLayout);
        Text task = addText("", 30, Color.WHITE, 680, 500, gameLayout);
        
        Button empty = addButton("Tyhjennä pelaajat", 13, 660, 580, startLayout);
        empty.setOnAction((event) ->{
            game.deletePlayers();
            players.setText("Pelaajat:");
            max.setText("");
        });
        
        Button addPlayer = addButton("Lisää pelaaja", 13, 800, 470, startLayout);
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
        
        Button startGame = addButton("Aloita peli", 32, 630, 650, startLayout);
        startGame.setOnAction((event) -> {
            if (game.numberOfPlayers() >= 2) {
                primaryStage.setScene(setDifficulty);
                player.setText(game.getNextPlayerName());
                try {
                    game.makeTaskList();
                } catch (SQLException ex) {
                    Logger.getLogger(PartypeliUi.class.getName()).log(Level.SEVERE, null, ex);
                }
                //task.setText(game.getNextTask());
                task.setText("tehtäviä: " + game.numberOfTasks());
            } else {
                max.setText("Pelissä tulee olla vähintään 2 pelaajaa");
            }
        });
        
        Button easy = addButton("Helppo",20, 450, 580, difLayout);
        Button mid = addButton("Keskitaso", 20, 650, 580, difLayout);
        Button difficult = addButton("Vaikea", 20, 880, 580, difLayout);
        
        easy.setOnAction((event) -> {
            game.setDifficulty(1);
            primaryStage.setScene(setDrinking);
        });
        
        mid.setOnAction((event) -> {
            game.setDifficulty(2);
            primaryStage.setScene(setDrinking);
        });
                
        difficult.setOnAction((event) -> {
            game.setDifficulty(3);
            primaryStage.setScene(setDrinking);
        });
        
        Button none = addButton("Ei yhtään", 20, 480, 580, drinkingLayout);
        Button little = addButton("Vähän", 20, 678, 580, drinkingLayout);
        Button lot = addButton("Paljon", 20, 850, 580, drinkingLayout);
                
        none.setOnAction((event) -> {
            game.setDrinkingAmount(0);
            primaryStage.setScene(gameMode);
        });
        
        little.setOnAction((event) -> {
            game.setDrinkingAmount(1);
            primaryStage.setScene(gameMode);
        });
        
        lot.setOnAction((event) -> {
            game.setDrinkingAmount(2);
            primaryStage.setScene(gameMode);
        });
        
        Button next = addButton("Seuraava", 30, 670, 630, gameLayout);
        next.setOnAction((event) ->{
            player.setText(game.getNextPlayerName());
            task.setText(game.getNextTask());
        });
        
        Button exit = addButton("Lopeta peli", 14, 710, 760, gameLayout);
        exit.setOnAction((event) ->{
            game.deletePlayers();
            players.setText("Pelaajat:");
            primaryStage.setScene(startPage);
        });
        
        primaryStage.setScene(startPage);
        primaryStage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
