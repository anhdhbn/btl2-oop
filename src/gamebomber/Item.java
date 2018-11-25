package gamebomber;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Item extends StaticObject {
    ImageView imageViewItemrun = new ImageView(new Image(getClass().getResourceAsStream("/Image/itemrun.png")));
    ImageView imageViewdoor = new ImageView(new Image(getClass().getResourceAsStream("/Image/door.png")));
    ImageView imageViewX2bom=new ImageView(new Image(getClass().getResourceAsStream("/Image/itembomx2.png")));
    public void ItemRun(double LayoutX,double LayoutY) {
        this.layoutX=LayoutX;
        this.layoutY=LayoutY;
        imageViewItemrun.setLayoutX(LayoutX);
        imageViewItemrun.setLayoutY(LayoutY);
    }
    public void ItemX2bomb(double LayoutX,double LayoutY) {
        this.layoutX=LayoutX;
        this.layoutY=LayoutY;
        imageViewX2bom.setLayoutX(LayoutX);
        imageViewX2bom.setLayoutY(LayoutY);
    }
    public void ImageViewdoor(double LayoutX,double LayoutY) {
        this.layoutX=LayoutX;
        this.layoutY=LayoutY;
        imageViewdoor.setLayoutX(LayoutX);
        imageViewdoor.setLayoutY(LayoutY);
    }
}
