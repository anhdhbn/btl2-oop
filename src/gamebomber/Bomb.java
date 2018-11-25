package gamebomber;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;

public class Bomb extends StaticObject {
    public static int check = 1;
    public boolean Right = false;
    public boolean Left = false;
    public boolean Up = false;
    public boolean Down = false;
    static Media mediabom = new Media(new File("C:\\Users\\Admin\\IdeaProjects\\Game_Bomber\\sound\\tiengbomsapno.mp3").toURI().toString());
    public MediaPlayer mediaPlayer1 = new MediaPlayer(mediabom);

    public void starttime() {
        mediaPlayer1.setStartTime(Duration.millis(500));
        mediaPlayer1.setStopTime(Duration.millis(5000));
        mediaPlayer1.play();
    }

    public void stoptime() {
        mediaPlayer1.stop();
    }

    ImageView imageViewBomb = new ImageView(new Image(getClass().getResourceAsStream("/Image/bomb.png")));

    //if(GameBomber.Item) check=2;
    public Bomb(double LayoutX, double LayoutY) {
        super(LayoutX, LayoutY);
        imageViewBomb.setLayoutX(LayoutX);
        imageViewBomb.setLayoutY(LayoutY);
    }

    public FireBom show() {
        //Group group=new Group();
        FireBomb fireBomb;
        double layoutX = this.imageViewBomb.getLayoutX();
        double layoutY = this.imageViewBomb.getLayoutY();
        int x = (int) (layoutX / picture_width);
        int y = (int) ((layoutY - picture_height) / picture_height);
        FireBom fireBom = new FireBom();
        if ((Mapdata.getMapAtPos(y, x) != '#')) {
            if (GameBomber.Item) {
                if (Mapdata.getMapAtPos(y - 1, x) != '#')
                    fireBomb = new FireBomb(layoutX, layoutY - picture_height * 2);
                else
                    fireBomb = new FireBomb(layoutX, layoutY - picture_height);
            } else
                fireBomb = new FireBomb(layoutX, layoutY - picture_height);
            this.Up = true;
            fireBom.arrNode.add(fireBomb.imageViewFireBomb);
            //group.getChildren().add(fireBomb.imageViewFireBomb);
        }
        x = (int) (layoutX / picture_width);
        y = (int) ((layoutY + picture_height) / picture_height);
        if (Mapdata.getMapAtPos(y, x) != '#') {
            if (GameBomber.Item) {
                if (Mapdata.getMapAtPos(y + 1, x) != '#')
                    fireBomb = new FireBomb(layoutX, layoutY + picture_height);
                else
                    fireBomb = new FireBomb(layoutX, layoutY);
            } else
                fireBomb = new FireBomb(layoutX, layoutY);
            this.Down = true;
            fireBom.arrNode.add(fireBomb.imageViewFireBomb);
            //group.getChildren().add(fireBomb.imageViewFireBomb);
        }
        x = (int) ((layoutX - picture_width) / picture_width);
        y = (int) (layoutY / picture_height);
        if (Mapdata.getMapAtPos(y, x) != '#') {
            if (GameBomber.Item) {
                if (Mapdata.getMapAtPos(y, x - 1) != '#')
                    fireBomb = new FireBomb(layoutX - picture_width * 2, layoutY);
                else
                    fireBomb = new FireBomb(layoutX - picture_width, layoutY);

            } else
                fireBomb = new FireBomb(layoutX - picture_width, layoutY);
            this.Left = true;
            fireBom.arrNode.add(fireBomb.imageViewFireBombline);
            //group.getChildren().add(fireBomb.imageViewFireBombline);
        }
        x = (int) ((layoutX + picture_width) / picture_width);
        y = (int) (layoutY / picture_height);
        if (Mapdata.getMapAtPos(y, x) != '#') {
            if (GameBomber.Item) {
                if (Mapdata.getMapAtPos(y, x + 1) != '#')
                    fireBomb = new FireBomb(layoutX + picture_width, layoutY);
                else
                    fireBomb = new FireBomb(layoutX, layoutY);
            } else
                fireBomb = new FireBomb(layoutX, layoutY);
            this.Right = true;
            //fireBomb=new FireBomb(layoutX,layoutY);
            fireBom.arrNode.add(fireBomb.imageViewFireBombline);
            //group.getChildren().add(fireBomb.imageViewFireBombline);
        }
        fireBomb = new FireBomb(layoutX, layoutY);
        fireBom.arrNode.add(fireBomb.imageViewcenter);
        return fireBom;
    }

    public static void replaceMap(int x, int y, Pane root, Bomber bomber, ArrayList enemymap) {
        final int picture_width = 45;
        final int picture_height = 45;
        Mapdata.setMapAtPos(y, x, ' ');
        Grass grass = new Grass(x * picture_width, y * picture_height);
        root.getChildren().add(grass.imageViewGrass);
        if (x * picture_width == GameBomber.itembomx2.layoutX && y * picture_height == GameBomber.itembomx2.layoutY) {
            root.getChildren().add(GameBomber.itembomx2.imageViewX2bom);
        } else if (x * picture_width == GameBomber.itemrun.layoutX && y * picture_height == GameBomber.itemrun.layoutY) {
            root.getChildren().add(GameBomber.itemrun.imageViewItemrun);
        } else if (x * picture_width == GameBomber.door.layoutX && y * picture_height == GameBomber.door.layoutY) {
            root.getChildren().add(GameBomber.door.imageViewdoor);
        }
        for (int i = 0; i < StaticObject.enemymap.size(); i++) {
            root.getChildren().remove(((Enemy) (enemymap.get(i))).imageViewEnemy);
            root.getChildren().add(((Enemy) (enemymap.get(i))).imageViewEnemy);
        }
        root.getChildren().remove(bomber.imageViewBomber);
        root.getChildren().add(bomber.imageViewBomber);

    }

    public static void ShowFirebomb(int indexbomb, Pane root, Bomber bomber) {
        if (GameBomber.Item) check = 2;
        final int picture_width = 45;
        final int picture_height = 45;
        Bomb b = (Bomb) GameBomber.arrbomb.get(indexbomb);
        Bomb tempbomb;
        FireBom fireBom = b.show();
        b.stoptime();
        root.getChildren().remove(b.imageViewBomb);
        double temptime = System.nanoTime() / 1000000000.0;
        int x = (int) (b.imageViewBomb.getLayoutX() / picture_width);
        int y = (int) ((b.imageViewBomb.getLayoutY() - picture_height) / picture_height);
        Enemy enemyTemp;
        if ((Mapdata.getMapAtPos(y, x) == '*') || Mapdata.getMapAtPos(y, x) == ' ') {
            if (GameBomber.Item) {
                if (Mapdata.getMapAtPos(y - 1, x) == '*' /*|| Mapdata.Map[y - 1][x]==' '*/) {
                    replaceMap(x, y - 1, root, bomber, StaticObject.enemymap);
                }
            }
            if (Mapdata.getMapAtPos(y, x) == '*')
                replaceMap(x, y, root, bomber, StaticObject.enemymap);
            for (int i = 0; i < StaticObject.enemymap.size(); i++) {
                enemyTemp = (Enemy) StaticObject.enemymap.get(i);
                if (Math.abs(b.layoutX - enemyTemp.LayoutX) < picture_width && Math.abs(b.layoutY - enemyTemp.LayoutY) < picture_height * (check + 1)) {
                    root.getChildren().remove(enemyTemp.imageViewEnemy);
                    StaticObject.enemymap.remove(enemyTemp);
                    i--;
                }
            }
            if (Math.abs(bomber.LayoutX - b.layoutX) < picture_width && Math.abs(b.layoutY - bomber.LayoutY) < picture_height * (check + 1)) {
                for (int i = 0; i < GameBomber.arrbomb.size(); i++) {
                    Bomb bomb = (Bomb) GameBomber.arrbomb.get(i);
                    bomb.stoptime();
                }
                GameBomber.player = false;
                bomber.updateimage("DIE", root);
                GameBomber.timeShowDie = System.nanoTime() / 1000000000.0;
            }


        }

        x = (int) (b.imageViewBomb.getLayoutX() / picture_width);
        y = (int) ((b.imageViewBomb.getLayoutY() + picture_height) / picture_height);
        if (Mapdata.getMapAtPos(y, x) == '*' || Mapdata.getMapAtPos(y, x) == ' ') {
            if (GameBomber.Item) {
                if (Mapdata.getMapAtPos(y + 1, x) == '*') {
                    replaceMap(x, y + 1, root, bomber, StaticObject.enemymap);
                }
            }
            if (Mapdata.getMapAtPos(y, x) == '*')
                replaceMap(x, y, root, bomber, StaticObject.enemymap);
            for (int i = 0; i < StaticObject.enemymap.size(); i++) {
                enemyTemp = (Enemy) StaticObject.enemymap.get(i);
                if (Math.abs(b.layoutX - enemyTemp.LayoutX) < picture_width && Math.abs(enemyTemp.LayoutY - b.layoutY) < picture_height * (check + 1)) {
                    root.getChildren().remove(enemyTemp.imageViewEnemy);
                    StaticObject.enemymap.remove(enemyTemp);
                    i--;
                }
            }
            if (Math.abs(bomber.LayoutX - b.layoutX) < picture_width && Math.abs(b.layoutY - bomber.LayoutY) < picture_height * (check + 1)) {
                for (int i = 0; i < GameBomber.arrbomb.size(); i++) {
                    Bomb bomb = (Bomb) GameBomber.arrbomb.get(i);
                    bomb.stoptime();
                }
                GameBomber.player = false;
                bomber.updateimage("DIE", root);
                GameBomber.timeShowDie = System.nanoTime() / 1000000000.0;
            }
        }

        x = (int) ((b.imageViewBomb.getLayoutX() - picture_width) / picture_width);
        y = (int) (b.imageViewBomb.getLayoutY() / picture_height);
        if (Mapdata.getMapAtPos(y, x) == '*' || Mapdata.getMapAtPos(y, x) == ' ') {
            if (GameBomber.Item) {
                if (Mapdata.getMapAtPos(y, x - 1) == '*' /*|| Mapdata.Map[y ][x-1]==' '*/) {
                    replaceMap(x - 1, y, root, bomber, StaticObject.enemymap);
                }
            }
            if (Mapdata.getMapAtPos(y, x) == '*')
                replaceMap(x, y, root, bomber, StaticObject.enemymap);

            for (int i = 0; i < StaticObject.enemymap.size(); i++) {
                enemyTemp = (Enemy) StaticObject.enemymap.get(i);
                if (Math.abs(enemyTemp.LayoutX - b.layoutX) < picture_width * (check + 1) && Math.abs(b.layoutY - enemyTemp.LayoutY) < picture_height) {
                    root.getChildren().remove(enemyTemp.imageViewEnemy);
                    StaticObject.enemymap.remove(enemyTemp);
                    i--;
                }
            }
            if (Math.abs(bomber.LayoutX - b.layoutX) < picture_width * (check + 1) && Math.abs(b.layoutY - bomber.LayoutY) < picture_height) {
                for (int i = 0; i < GameBomber.arrbomb.size(); i++) {
                    Bomb bomb = (Bomb) GameBomber.arrbomb.get(i);
                    bomb.stoptime();
                }
                GameBomber.player = false;
                bomber.updateimage("DIE", root);
                GameBomber.timeShowDie = System.nanoTime() / 1000000000.0;
            }
        }

        x = (int) ((b.imageViewBomb.getLayoutX() + picture_width) / picture_width);
        y = (int) (b.imageViewBomb.getLayoutY() / picture_height);
        if (Mapdata.getMapAtPos(y, x) == '*' || Mapdata.getMapAtPos(y, x) == ' ') {
            if (GameBomber.Item) {
                if (Mapdata.getMapAtPos(y, x + 1) == '*' /*|| Mapdata.Map[y ][x+1]==' '*/) {
                    replaceMap(x + 1, y, root, bomber, StaticObject.enemymap);
                }
            }
            if (Mapdata.getMapAtPos(y, x) == '*')
                replaceMap(x, y, root, bomber, StaticObject.enemymap);
            for (int i = 0; i < StaticObject.enemymap.size(); i++) {
                enemyTemp = (Enemy) StaticObject.enemymap.get(i);
                if (Math.abs(b.layoutX - enemyTemp.LayoutX) < picture_width * (check + 1) && Math.abs(b.layoutY - enemyTemp.LayoutY) < picture_height) {
                    root.getChildren().remove(enemyTemp.imageViewEnemy);
                    StaticObject.enemymap.remove(enemyTemp);
                    i--;
                }
            }
            if (Math.abs(bomber.LayoutX - b.layoutX) < picture_width * (check + 1) && Math.abs(b.layoutY - bomber.LayoutY) < picture_height) {
                for (int i = 0; i < GameBomber.arrbomb.size(); i++) {
                    Bomb bomb = (Bomb) GameBomber.arrbomb.get(i);
                    bomb.stoptime();
                }
                GameBomber.player = false;
                bomber.updateimage("DIE", root);
                GameBomber.timeShowDie = System.nanoTime() / 1000000000.0;
            }


        }
        if (indexbomb < GameBomber.arrbomb.size() - 1) {
            for (int i = indexbomb + 1; i < GameBomber.arrbomb.size(); i++) {
                tempbomb = (Bomb) GameBomber.arrbomb.get(i);
                if (b.imageViewBomb.getLayoutX() == tempbomb.imageViewBomb.getLayoutX() && Math.abs(b.layoutY - tempbomb.layoutY) <= picture_height * check) {
                    int temp = (int) GameBomber.timebomb.get(indexbomb);
                    GameBomber.timebomb.set(i, temp);

                }
                if (Math.abs(b.imageViewBomb.getLayoutX() - tempbomb.imageViewBomb.getLayoutX()) <= picture_width * check && b.layoutY == tempbomb.layoutY) {
                    int temp = (int) GameBomber.timebomb.get(indexbomb);
                    GameBomber.timebomb.set(i, temp);
                }
            }
        }
        GameBomber.timefire.add(temptime);
        GameBomber.arrbomb.set(indexbomb, b);
        GameBomber.arrNode.add(fireBom);
        for (int i = 0; i < fireBom.arrNode.size(); i++) {
            root.getChildren().add((Node) fireBom.arrNode.get(i));
        }
        GameBomber.NotPutBomb = true;
        Mapdata.setMapNodesAtPos((int)(b.layoutY)/45,(int)(b.layoutX)/45,' ');
        GameBomber.arrbomb.remove(indexbomb);
        GameBomber.timebomb.remove(indexbomb);
    }

    public static void Handling(Pane root, Bomber bomber) {
        for (int k = 0; k < GameBomber.timefire.size(); k++) {
            double check = System.nanoTime() / 1000000000.0;
            if (check - (double) GameBomber.timefire.get(k) > 0.2) {
                FireBom fireBom = (FireBom) GameBomber.arrNode.get(k);
                for (int i = 0; i < fireBom.arrNode.size(); i++) {
                    root.getChildren().remove((Node) fireBom.arrNode.get(i));
                }
                GameBomber.arrNode.remove(fireBom);
                GameBomber.NotPutBomb = false;
                GameBomber.timefire.remove(k);
                if (k != 0) k--;
            }
        }

        for (int i = 0; i < GameBomber.timebomb.size(); i++) {

            long j = System.nanoTime() / 1000000000;
            int temp = (int) GameBomber.timebomb.get(i);
            if (j - temp == 5) {
                MediaPlayer mediaPlayer = new MediaPlayer(GameBomber.media);
                mediaPlayer.setStartTime(Duration.millis(400));
                mediaPlayer.setStopTime(Duration.millis(1000));
                mediaPlayer.play();
                ShowFirebomb(i, root, bomber);
                i--;
            }

        }
    }

}
