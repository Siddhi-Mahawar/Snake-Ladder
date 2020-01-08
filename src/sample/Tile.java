package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {

    public Tile(int x,int y)
    {
        setWidth(DiceRole.Title_size);
        setHeight(DiceRole.Title_size);

        setFill(Color.PINK);
        setStroke(Color.BLACK);

    }

}
