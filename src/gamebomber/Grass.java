package gamebomber;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Grass extends StaticObject {
    ImageView imageViewGrass = new ImageView(new Image(getClass().getResourceAsStream("/Image/grass.png")));
    public Grass(double LayoutX,double LayoutY) {
        super(LayoutX,LayoutY);
        imageViewGrass.setLayoutX(LayoutX);
        imageViewGrass.setLayoutY(LayoutY);
    }
}
