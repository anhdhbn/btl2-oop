package gamebomber;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class gameover {
    ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("/Image/gameover.png")));
    public gameover(double LayoutX,double LayoutY) {
        imageView.setLayoutX(LayoutX);
        imageView.setLayoutY(LayoutY);
    }
}
