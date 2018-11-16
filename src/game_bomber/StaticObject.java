package game_bomber;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StaticObject {
    public static ArrayList enemymap= new ArrayList<Enemy>();
    final double picture_width = 45;
    final double picture_height = 45;
    protected double layoutX;
    protected double layoutY;
    public StaticObject() {
    }

    public StaticObject(double layoutX, double layoutY) {
        this.layoutX = layoutX;
        this.layoutY = layoutY;
    }

    public double getLayoutX() {
        return layoutX;
    }

    public void setLayoutX(double layoutX) {
        this.layoutX = layoutX;
    }

    public double getLayoutY() {
        return layoutY;
    }

    public void setLayoutY(double layoutY) {
        this.layoutY = layoutY;
    }
    public void loadMap (String path, Pane group){
        int column,row=-1;
        InputStream inpputStream = this.getClass().getResourceAsStream(path);
        InputStreamReader inputStreamReader = new InputStreamReader(inpputStream);
        try(BufferedReader br = new BufferedReader(inputStreamReader)){
            String lineData;
            while ((lineData=br.readLine())!=null){
                row++;
                for (int i=0;i<lineData.length();i++){
                    column=i;
                     Mapdata.Map[row][column] = lineData.charAt(i);
                    switch (lineData.charAt(i)) {
                        case '#':
                            Wall wall = new Wall((double) column * picture_width, (double) row * picture_height);
                            group.getChildren().add(wall.imageViewWall);
                            break;
                        case '*':
                            Brick brick = new Brick((double) column * picture_width, (double) row * picture_height);
                            group.getChildren().add(brick.imageViewBrick);
                            break;
                        case 'x':
                            Enemy enemy = new Enemy((double) column * picture_width, (double) row * picture_height);
                            enemymap.add(enemy);
                            Grass grassx = new Grass((double) column * picture_width, (double) row * picture_height);
                            group.getChildren().add(grassx.imageViewGrass);
                            break;
                        case ' ':
                            Grass grass = new Grass((double) column * picture_width, (double) row * picture_height);
                            group.getChildren().add(grass.imageViewGrass);
                            break;
                        case 'M':
                            Mapdata.Map[row][column]='*';
                            Brick brickM = new Brick((double) column * picture_width, (double) row * picture_height);
                            group.getChildren().add(brickM.imageViewBrick);
                            GameBomber.door.ImageViewdoor((double) column * picture_width, (double) row * picture_height);
                            break;
                        case 'R':
                            Mapdata.Map[row][column]='*';
                            Brick brickR = new Brick((double) column * picture_width, (double) row * picture_height);
                            group.getChildren().add(brickR.imageViewBrick);
                            GameBomber.itemrun.ItemRun((double) column * picture_width, (double) row * picture_height);
                            break;
                        case 'B':
                            Mapdata.Map[row][column]='*';
                            Brick brickB = new Brick((double) column * picture_width, (double) row * picture_height);
                            group.getChildren().add(brickB.imageViewBrick);
                            GameBomber.itembomx2.ItemX2bomb((double) column * picture_width, (double) row * picture_height);
                            break;
                            default: break;
                    }
                }
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

}
