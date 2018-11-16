package game_bomber;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Brick extends StaticObject {
    ImageView imageViewBrick = new ImageView(new Image(getClass().getResourceAsStream("/Image/brick.png")));
    public Brick(double LayoutX,double LayoutY) {
        super(LayoutX,LayoutY);
        imageViewBrick.setLayoutX(LayoutX);
        imageViewBrick.setLayoutY(LayoutY);
    }

}
