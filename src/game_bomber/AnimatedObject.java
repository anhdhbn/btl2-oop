package game_bomber;

import javafx.scene.image.ImageView;

import java.util.Random;

public class AnimatedObject {
    final int picture_width = 45;
    final int picture_height = 45;
    protected double LayoutX;
    protected double LayoutY;
    private Random random = new Random();

    public double getLayoutX() {
        return LayoutX;
    }

    public void setLayoutX(double layoutX) {
        LayoutX = layoutX;
    }

    public double getLayoutY() {
        return LayoutY;
    }

    public void setLayoutY(double layoutY) {
        LayoutY = layoutY;
    }

    public AnimatedObject() {
    }

    public AnimatedObject(double layoutX, double layoutY) {
        LayoutX = layoutX;
        LayoutY = layoutY;
    }

    public boolean check_Up (int layoutX, int layoutY,int SPEED){

        int locationRow1 = (layoutY-SPEED)/picture_height;
        int locationColumn1 = (layoutX)/picture_width;
        char tem1 = Mapdata.Map[locationRow1][locationColumn1];
        int locationRow2 = (layoutY-SPEED)/picture_height;
        int locationColumn2 = (layoutX+picture_width-1)/picture_width;
        char tem2 = Mapdata.Map[locationRow2][locationColumn2];
        if (((tem1=='#'||tem1=='*'||tem1=='b')||(tem2=='#'||tem2=='*'||tem2=='b')))
            return false;

        for(int i=0;i<GameBomber.arrbomb.size();i++) {
            Bomb bomb=(Bomb)GameBomber.arrbomb.get(i);
            if (Math.abs(layoutX - bomb.layoutX) <= 44 && Math.abs(layoutY - bomb.layoutY) <= 44){
                continue;
            }
            if (layoutX >= bomb.layoutX + picture_width || layoutX <= bomb.layoutX - picture_width){
                continue;
            }
            if(layoutY>bomb.layoutY){
                if(layoutY >=bomb.layoutY + picture_height+SPEED){
                    continue;
                }
            }
            else{
                continue;
            }
            return false;
        }
        return true;
    }
    public boolean check_Down (int layoutX, int layoutY,int SPEED){
        int locationRow1 = (layoutY+SPEED+picture_height-1)/picture_height;
        int locationColumn1 = (layoutX)/picture_width;
        char tem1 = Mapdata.Map[locationRow1][locationColumn1];
        int locationRow2 = (layoutY+SPEED+picture_height-1)/picture_height;
        int locationColumn2 = (layoutX+picture_width-1)/picture_width;
        char tem2 = Mapdata.Map[locationRow2][locationColumn2];
        if (((tem1=='#'||tem1=='*'||tem1=='b')||(tem2=='#'||tem2=='*'||tem2=='b')))
            return false;
        for(int i=0;i<GameBomber.arrbomb.size();i++) {
            Bomb bomb=(Bomb)GameBomber.arrbomb.get(i);
            if (Math.abs(layoutX - bomb.layoutX) <picture_width && Math.abs(layoutY - bomb.layoutY) <picture_height){
                continue;
            }
            if (layoutX >= bomb.layoutX + picture_width || layoutX <= bomb.layoutX - picture_width){
                continue;
            }
            if(layoutY<bomb.layoutY){
                if(layoutY <bomb.layoutY - picture_height-SPEED+1 ){
                    continue;
                }
            }
            else{
                continue;
            }
            return false;
        }
        return true;
    }
    public boolean check_Left (int layoutX,int layoutY,int SPEED){
        int locationRow1 = (layoutY)/picture_height;
        int locationColumn1 = (layoutX-SPEED)/picture_width;
        char tem1 = Mapdata.Map[locationRow1][locationColumn1];
        int locationRow2 = (layoutY+picture_height-1)/picture_height;
        int locationColumn2 = (layoutX-SPEED)/picture_width;
        char tem2 = Mapdata.Map[locationRow2][locationColumn2];
        if (((tem1=='#'||tem1=='*'||tem1=='b')||(tem2=='#'||tem2=='*'||tem2=='b')))
            return false;
        for(int i=0;i<GameBomber.arrbomb.size();i++) {
            Bomb bomb=(Bomb)GameBomber.arrbomb.get(i);
            if (Math.abs(layoutX- bomb.layoutX) <picture_width && Math.abs(layoutY - bomb.layoutY) <picture_height)
                continue;
            if (layoutY >= bomb.layoutY + picture_height || layoutY <= bomb.layoutY-picture_height)
               continue;
            if(layoutX>bomb.layoutX){
                if(layoutX >=bomb.layoutX+picture_width+SPEED)
                    continue;
            }
            else
                continue;
            return false;
        }
        return true;
    }
    public boolean check_Right (int layoutX,int layoutY,int SPEED){
        int locationRow1 = (layoutY)/picture_height;
        int locationColumn1 = (layoutX+SPEED+picture_width-1)/picture_width;
        char tem1 = Mapdata.Map[locationRow1][locationColumn1];
        int locationRow2 = (layoutY+picture_height-1)/picture_height;
        int locationColumn2 = (layoutX+SPEED+picture_width-1)/picture_width;
        char tem2 = Mapdata.Map[locationRow2][locationColumn2];
        if (((tem1=='#'||tem1=='*'||tem1=='b')||(tem2=='#'||tem2=='*'||tem2=='b')))
            return false;
        for(int i=0;i<GameBomber.arrbomb.size();i++) {
            Bomb bomb=(Bomb)GameBomber.arrbomb.get(i);
            if (Math.abs(layoutX - bomb.layoutX)<picture_width && Math.abs(layoutY - bomb.layoutY) <picture_height)
                continue;
            if ( layoutY >= bomb.layoutY + picture_height || layoutY <= bomb.layoutY-picture_height)
                continue;
            if(layoutX<bomb.layoutX)
            {   if(layoutX <bomb.layoutX-picture_width -SPEED+1)
                    continue;}
             else
                 continue;
             return false;
        }
        return true;
    }

}
