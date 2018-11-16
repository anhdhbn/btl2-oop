package game_bomber;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Wall extends StaticObject {
    ImageView imageViewWall = new ImageView(new Image(getClass().getResourceAsStream("/Image/wall.png")));
    public Wall(double layoutX,double layoutY) {
        super(layoutX,layoutY);
        imageViewWall.setLayoutX(layoutX);
        imageViewWall.setLayoutY(layoutY);
    }
}
