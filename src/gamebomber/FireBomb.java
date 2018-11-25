package gamebomber;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FireBomb extends StaticObject {
    ImageView imageViewFireBomb = new ImageView(new Image(getClass().getResourceAsStream("/Image/firebomb.png")));
    ImageView imageViewFireBombline = new ImageView(new Image(getClass().getResourceAsStream("/Image/firebombline.png")));
    ImageView imageViewcenter= new ImageView(new Image(getClass().getResourceAsStream("/Image/centerbom.png")));

    public FireBomb(double LayoutX,double LayoutY) {
        super(LayoutX,LayoutY);
        imageViewFireBomb.setLayoutX(LayoutX);
        imageViewFireBomb.setLayoutY(LayoutY);
        imageViewFireBombline.setLayoutY(LayoutY);
        imageViewFireBombline.setLayoutX(LayoutX);
        imageViewcenter.setLayoutX(layoutX);
        imageViewcenter.setLayoutY(layoutY);
    }
}
