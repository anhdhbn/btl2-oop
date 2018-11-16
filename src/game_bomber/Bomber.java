package game_bomber;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Bomber extends AnimatedObject {
    ImageView imageViewBomber = new ImageView(new Image(getClass().getResourceAsStream("/Image/bomberDown.png")));
    public Bomber(double LayoutX,double LayoutY) {
        super(LayoutX,LayoutY);
        imageViewBomber.setLayoutX(LayoutX);
        imageViewBomber.setLayoutY(LayoutY);
    }
    public void movingBomber (double LayoutX, double LayoutY){
        this.LayoutX=LayoutX;
        this.LayoutY=LayoutY;
        imageViewBomber.setLayoutX(LayoutX);
        imageViewBomber.setLayoutY(LayoutY);

    }
    public void updateimage(String Layout,Pane root){
        switch (Layout){
            case "RIGHT":
                root.getChildren().remove(imageViewBomber);
                imageViewBomber = new ImageView(new Image(getClass().getResourceAsStream("/Image/bomberRight.png")));
                imageViewBomber.setLayoutX(LayoutX);
                imageViewBomber.setLayoutY(LayoutY);
                root.getChildren().add(imageViewBomber);
                break;
            case "LEFT":
                root.getChildren().remove(imageViewBomber);
                imageViewBomber = new ImageView(new Image(getClass().getResourceAsStream("/Image/bomberLeft.png")));
                imageViewBomber.setLayoutX(LayoutX);
                imageViewBomber.setLayoutY(LayoutY);
                root.getChildren().add(imageViewBomber);
                break;
            case "UP":
                root.getChildren().remove(imageViewBomber);
                imageViewBomber = new ImageView(new Image(getClass().getResourceAsStream("/Image/bomberUp.png")));
                imageViewBomber.setLayoutX(LayoutX);
                imageViewBomber.setLayoutY(LayoutY);
                root.getChildren().add(imageViewBomber);
                break;
            case "DOWN":
                root.getChildren().remove(imageViewBomber);
                imageViewBomber = new ImageView(new Image(getClass().getResourceAsStream("/Image/bomberDown.png")));
                imageViewBomber.setLayoutX(LayoutX);
                imageViewBomber.setLayoutY(LayoutY);
                root.getChildren().add(imageViewBomber);
                break;

        }

    }
    public void CheckItem(Pane root){
        if(Math.abs(LayoutX-GameBomber.itembomx2.layoutX)<picture_width&&Math.abs(LayoutY-GameBomber.itembomx2.layoutY)<picture_height){
            GameBomber.Item=true;
            root.getChildren().remove(GameBomber.itembomx2.imageViewX2bom);
            GameBomber.itembomx2.ItemX2bomb(0,0);
        }
        else
            if(Math.abs(LayoutX-GameBomber.itemrun.layoutX)<picture_width&&Math.abs(LayoutY-GameBomber.itemrun.layoutY)<picture_height){
                GameBomber.SPEED=5;
                root.getChildren().remove(GameBomber.itemrun.imageViewItemrun);
                GameBomber.itemrun.ItemX2bomb(0,0);
        }
        if(Math.abs(LayoutX-GameBomber.door.layoutX)<picture_width&&Math.abs(LayoutY-GameBomber.door.layoutY)<picture_height&&StaticObject.enemymap.size()==0){
            for(int i=0;i<GameBomber.arrbomb.size();i++){
                Bomb bomb=(Bomb)GameBomber.arrbomb.get(i);
                bomb.stoptime();
            }
            boolean player= true;
             boolean NotPutBomb=false;
             GameBomber.arrbomb.clear();
             GameBomber.timebomb.clear();
             GameBomber.timefire.clear();
             GameBomber.arrNode.clear();
             GameBomber.Item =false;
             GameBomber.itembomx2=new Item();
             GameBomber.itemrun=new Item();
             GameBomber.door=new Item();
             GameBomber.SPEED=3;
             root.getChildren().clear();
             StaticObject staticObject = new StaticObject();
             staticObject.loadMap("/Map_level/Map2.txt", root);
            for(int i=0;i<StaticObject.enemymap.size();i++){
                root.getChildren().add(((Enemy)(StaticObject.enemymap.get(i))).imageViewEnemy);
            }
            this.movingBomber(picture_width,picture_height);
            root.getChildren().add(this.imageViewBomber);


    }}
}
