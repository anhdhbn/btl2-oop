package game_bomber;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Portal extends StaticObject {
    ImageView imageViewPortal = new ImageView(new Image(getClass().getResourceAsStream("/Image/wall.png")));
    public Portal(double LayoutX,double LayoutY) {
        super(LayoutX,LayoutY);
        imageViewPortal.setLayoutX(LayoutX);
        imageViewPortal.setLayoutY(LayoutY);
    }
}
