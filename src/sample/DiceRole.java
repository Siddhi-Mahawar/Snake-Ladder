package sample;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import static java.lang.Thread.sleep;

public class DiceRole extends Application {

    public int rand;
    public Label  randResult;

    public int circlePos[][] = new int[10][10];
    public int ladderPos[][] = new int[6][3];

    public static final int Title_size = 60;
    public static final int width = 10;
    public static final int height = 10;


    public Circle player1;
    public Circle player2;

    public int playerPos1 = 1;
    public int playerPos2 = 1;

    public boolean player1turn = true;
    public boolean player2turn = true;

    public static int player1XPos = 30;
    public static int player1YPos = 570;

    public static int player2XPos = 30;
    public static int player2YPos = 570;

    public boolean gameStart = false;

    public int posCir1 = 1;
    public  int posCir2 = 1;

    public Button gameButton;

    private Group titleGroup = new Group();

    private Parent createContent(){
        Pane root = new Pane();
        root.setPrefSize(600,660);
        root.getChildren().addAll(titleGroup);

        for(int i = 0;i<height;i++)
        {
            for(int j =0;j<width;j++)
            {
                Tile tile = new Tile(Title_size,Title_size);
                tile.setTranslateX(j*Title_size);
                tile.setTranslateY(i*Title_size);

                titleGroup.getChildren().add(tile);

                circlePos[i][j] = j*(Title_size-30);

            }
        }

        for(int i = 0;i<height;i++)
        {
            for(int j = 0;j<width;j++)
            {
                System.out.print(circlePos[i][j]+" ");

            }
            System.out.print("\n");
        }


        player1 = new Circle(30);
        player1.setId("player1");
        player1.setFill(Color.AQUA);
        player1.getStyleClass().add("style.css");
        player1.setTranslateX(player1XPos);
        player1.setTranslateY(player1YPos);

        player2 = new Circle(30);
        player2.setId("player2");
        player2.setFill(Color.BROWN);
        player2.getStyleClass().add("style.css");
        player2.setTranslateX(player2XPos);
        player2.setTranslateY(player2YPos);

        Button button = new Button("player1");
        button.setTranslateX(525);
        button.setTranslateY(615);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(gameStart)
                {
                    if(player1turn)
                    {

                        getDiceValue();
                        randResult.setText(String.valueOf(rand));
                        moveonePlayer();
                        translatePlayer(player1XPos,player1YPos,player1);
                        player2turn = true;
                        player1turn = false;

                        if(player1XPos == 210 && player1YPos == 570)
                        {
                            translatePlayer(player1XPos = 390 ,player1YPos = 510,player1);
                            posCir1 = 0;
                        }
                        if(player1XPos == 510 && player1YPos == 570)
                        {
                            translatePlayer(player1XPos = 570 ,player1YPos = 390,player1);
                            posCir1 = 0;
                        }
                        if(player1XPos == 30 && player1YPos == 510)
                        {
                            translatePlayer(player1XPos = 150 ,player1YPos = 390,player1);
                            posCir1 = 0;
                        }
                        if(player1XPos == 450 && player1YPos == 450)
                        {
                            translatePlayer(player1XPos = 210 ,player1YPos = 90,player1);
                            posCir1 = 1;
                        }
                        if(player1XPos == 30 && player1YPos == 390)
                        {
                            translatePlayer(player1XPos = 90 ,player1YPos = 270,player1);
                            posCir1 = 0;
                        }
                        if(player1XPos == 570 && player1YPos == 270)
                        {
                            translatePlayer(player1XPos = 390 ,player1YPos = 210,player1);
                            posCir1 = 1;
                        }
                        if(player1XPos == 150 && player1YPos == 210)
                        {
                            translatePlayer(player1XPos = 30 ,player1YPos = 90,player1);
                            posCir1 = 1;
                        }
                        if(player1XPos == 570 && player1YPos == 150)
                        {
                            translatePlayer(player1XPos = 570 ,player1YPos = 30,player1);
                            posCir1 = 0;
                        }


                        if(player1XPos == 210 && player1YPos == 510)
                        {
                            translatePlayer(player1XPos = 390 ,player1YPos = 570,player1);
                            posCir1= 1;
                        }
                        if(player1XPos == 390 && player1YPos == 270)
                        {
                            translatePlayer(player1XPos = 390 ,player1YPos = 390,player1);
                            posCir1 = 0;
                        }
                        if(player1XPos == 90 && player1YPos == 210)
                        {
                            translatePlayer(player1XPos = 90 ,player1YPos = 510,player1);
                            posCir1 = 0;
                        }
                        if(player1XPos == 210 && player1YPos == 210)
                        {
                            translatePlayer(player1XPos = 30 ,player1YPos = 270,player1);
                            posCir1 = 0;
                        }
                        if(player1XPos == 390 && player1YPos == 90)
                        {
                            translatePlayer(player1XPos = 210 ,player1YPos = 450,player1);
                            posCir1 = 1;
                        }
                        if(player1XPos == 90 && player1YPos == 30)
                        {
                            translatePlayer(player1XPos = 150 ,player1YPos = 150,player1);
                            posCir1 = 0;
                        }
                        if(player1XPos == 330 && player1YPos == 30)
                        {
                            translatePlayer(player1XPos = 330 ,player1YPos = 150,player1);
                            posCir1 = 0;
                        }
                        if(player1XPos == 450 && player1YPos == 30)
                        {
                            translatePlayer(player1XPos = 450 ,player1YPos = 150,player1);
                            posCir1 = 0;
                        }
                    }
                }

            }
        });

        Button button2 = new Button("Player2");
        button2.setTranslateX(30);
        button2.setTranslateY(615);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override

            public void handle(ActionEvent event) {


                if(gameStart)
                {
                    if(player2turn)
                    {

                        getDiceValue();
                        randResult.setText(String.valueOf(rand));
                        movetwoPlayer();
                        translatePlayer(player2XPos,player2YPos,player2);
                        player1turn = true;
                        player2turn = false;


                        if(player2XPos == 210 && player2YPos == 570)
                        {
                            translatePlayer(player2XPos = 390 ,player2YPos = 510,player2);
                            posCir2= 0;
                        }
                        if(player2XPos == 510 && player2YPos == 570)
                        {
                            translatePlayer(player2XPos = 570 ,player2YPos = 390,player2);
                            posCir2 = 0;
                        }
                        if(player2XPos == 30 && player2YPos == 510)
                        {
                            translatePlayer(player2XPos = 150 ,player2YPos = 390,player2);
                            posCir2 = 0;
                        }
                        if(player2XPos == 450 && player2YPos == 450)
                        {
                            translatePlayer(player2XPos = 210 ,player2YPos = 90,player2);
                            posCir2 = 1;
                        }
                        if(player2XPos == 30 && player2YPos == 390)
                        {
                            translatePlayer(player2XPos = 90 ,player2YPos = 270,player2);
                            posCir2 = 0;
                        }
                        if(player2XPos == 570 && player2YPos == 270)
                        {
                            translatePlayer(player2XPos = 390 ,player2YPos = 210,player2);
                            posCir2 = 1;
                        }
                        if(player2XPos == 150 && player2YPos == 210)
                        {
                            translatePlayer(player2XPos = 30 ,player2YPos = 90,player2);
                            posCir2 = 1;
                        }
                        if(player2XPos == 570 && player2YPos == 150)
                        {
                            translatePlayer(player2XPos = 570 ,player2YPos = 30,player2);
                            posCir2 = 0;
                        }


                        if(player2XPos == 210 && player2YPos == 510)
                        {
                            translatePlayer(player2XPos = 390 ,player2YPos = 570,player2);
                            posCir2= 1;
                        }
                        if(player2XPos == 390 && player2YPos == 270)
                        {
                            translatePlayer(player2XPos = 390 ,player2YPos = 390,player2);
                            posCir2 = 0;
                        }
                        if(player2XPos == 90 && player2YPos == 210)
                        {
                            translatePlayer(player2XPos = 90 ,player2YPos = 510,player2);
                            posCir2 = 0;
                        }
                        if(player2XPos == 210 && player2YPos == 210)
                        {
                            translatePlayer(player2XPos = 30 ,player2YPos = 270,player2);
                            posCir2 = 0;
                        }
                        if(player2XPos == 390 && player2YPos == 90)
                        {
                            translatePlayer(player2XPos = 210 ,player2YPos = 450,player2);
                            posCir2 = 1;
                        }
                        if(player2XPos == 90 && player2YPos == 30)
                        {
                            translatePlayer(player2XPos = 150 ,player2YPos = 150,player2);
                            posCir2 = 0;
                        }
                        if(player2XPos == 330 && player2YPos == 30)
                        {
                            translatePlayer(player2XPos = 330 ,player2YPos = 150,player2);
                            posCir2 = 0;
                        }
                        if(player2XPos == 450 && player2YPos == 30)
                        {
                            translatePlayer(player2XPos = 450 ,player2YPos = 150,player2);
                            posCir2 = 0;
                        }



                        System.out.println(player2XPos + " "+player2YPos);
                    }
                }

            }

        });

        gameButton = new Button("Start Game");
        gameButton.setTranslateX(270);
        gameButton.setTranslateY(630);
        gameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                gameStart = true;
                gameButton.setText("Game Started");
                player1XPos = 30;
                player1YPos = 570;

                player2XPos = 30;
                player2YPos = 570;

                player1.setTranslateX(player1XPos);
                player1.setTranslateY(player1YPos);

                player2.setTranslateX(player2XPos);
                player2.setTranslateY(player2YPos);




            }
        });

        randResult = new Label("Dice Not rolled ");
        randResult.setTranslateX(270);
        randResult.setTranslateY(610);

        Image img = new Image("download.jpg");
        ImageView bgImage = new ImageView();
        bgImage.setImage(img);
        bgImage.setFitHeight(600);
        bgImage.setFitWidth(600);

        titleGroup.getChildren().addAll(bgImage,button,button2,randResult,gameButton);
        titleGroup.getChildren().addAll(player1,player2);

        return root;

    }

    private void getDiceValue(){

        rand = (int)(Math.random()*6 + 1);
    }

    private void moveonePlayer(){

        for(int i = 0;i<rand;i++)
        {
            if(posCir1%2 == 1){
                player1XPos += 60;
            }
            if(posCir1 %2 == 0)
            {
                player1XPos-=60;
            }

            if(player1XPos > 570){
                player1YPos-=60;
                player1XPos -= 60;
                posCir1++;
            }

            if(player1XPos < 30)
            {
                player1YPos-=60;
                player1XPos += 60;
                posCir1++;
            }

            if(player1XPos<=30 && player1YPos<=30){
                player1XPos = 30;
                player1YPos = 30;
                randResult.setText("Player 1 wins");
                gameButton.setText("Start Again");
                gameStart = false;
            }


        }
    }

    private void movetwoPlayer(){

        for(int i = 0;i<rand;i++)
        {
            if(posCir2 %2 == 1){
                player2XPos += 60;
            }
            if(posCir2 %2 == 0)
            {
                player2XPos-=60;
            }

            if(player2XPos > 570){
                player2YPos-=60;
                player2XPos -= 60;
                posCir2++;
            }

            if(player2XPos < 30)
            {
                player2YPos-=60;
                player2XPos += 60;
                posCir2++;
            }

            if(player2XPos<=30 && player2YPos<=30){
                player2XPos = 30;
                player2YPos = 30;
                randResult.setText("Player 2 wins");
                gameButton.setText("Start Again");
                gameStart = false;
            }


        }
    }
    private void translatePlayer(int x,int y,Circle b)
    {
        System.out.println(x+ " " + y);
        TranslateTransition animate = new TranslateTransition(Duration.millis(1000),b);
        animate.setToX(x);
        animate.setToY(y);
        animate.setAutoReverse(false);
        animate.play();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Scene scene = new Scene(createContent());

        primaryStage.setTitle("Snake And Ladder");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
