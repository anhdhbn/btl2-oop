package game_bomber;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Enemy extends AnimatedObject {
    char STEP_SIZE ='D';
    ImageView imageViewEnemy = new ImageView(new Image(getClass().getResourceAsStream("/Image/enemy.png")));
    public Enemy(double LayoutX,double LayoutY) {
        super(LayoutX,LayoutY);
        imageViewEnemy.setLayoutX(LayoutX);
        imageViewEnemy.setLayoutY(LayoutY);
    }
    public void movingBomber (double LayoutX, double LayoutY){
        this.LayoutX=LayoutX;
        this.LayoutY=LayoutY;
        imageViewEnemy.setLayoutX(LayoutX);
        imageViewEnemy.setLayoutY(LayoutY);

    }
    public void check(Bomber bomber){
        switch (STEP_SIZE){
            case 'D':
                if(check_Right((int)LayoutX,(int)LayoutY,1)){
                    movingBomber(LayoutX+1,LayoutY);
                    STEP_SIZE='D';
                }
                else
                if(check_Down((int)LayoutX,(int)LayoutY,1)){
                    movingBomber(LayoutX,LayoutY+1);
                    STEP_SIZE='S';
                }
                else
                    if(check_Up((int)LayoutX,(int)LayoutY,1)) {
                        movingBomber(LayoutX, LayoutY - 1);
                        STEP_SIZE = 'W';
                             }
                    else
                            if(check_Left((int)LayoutX,(int)LayoutY,1)){
                                movingBomber(LayoutX-1,LayoutY);
                                STEP_SIZE='A';}
                break;
            case 'A':
                if(check_Left((int)LayoutX,(int)LayoutY,1)){
                    movingBomber(LayoutX-1,LayoutY);
                    STEP_SIZE='A';}
                else
                if(check_Down((int)LayoutX,(int)LayoutY,1)){
                    movingBomber(LayoutX,LayoutY+1);
                    STEP_SIZE='S';
                }
                else
                    if(check_Up((int)LayoutX,(int)LayoutY,1)) {
                        movingBomber(LayoutX, LayoutY - 1);
                        STEP_SIZE = 'W';
                }
                    else
                            if(check_Right((int)LayoutX,(int)LayoutY,1)){
                                movingBomber(LayoutX+1,LayoutY);
                                STEP_SIZE='D';}
                break;
            case 'S':
                if(check_Down((int)LayoutX,(int)LayoutY,1)){
                    movingBomber(LayoutX,LayoutY+1);
                    STEP_SIZE='S';
                }
                else
                if(check_Right((int)LayoutX,(int)LayoutY,1)){
                    movingBomber(LayoutX+1,LayoutY);
                    STEP_SIZE='D';}
                    else
                if(check_Left((int)LayoutX,(int)LayoutY,1)){
                    movingBomber(LayoutX-1,LayoutY);
                    STEP_SIZE='A';}
                else
                        if(check_Up((int)LayoutX,(int)LayoutY,1)) {
                                movingBomber(LayoutX, LayoutY - 1);
                                STEP_SIZE = 'W';
                }
                break;
            case 'W':
                if(check_Up((int)LayoutX,(int)LayoutY,1)) {
                    movingBomber(LayoutX, LayoutY - 1);
                    STEP_SIZE = 'W';
                }
                else
                if(check_Right((int)LayoutX,(int)LayoutY,1)){
                    movingBomber(LayoutX+1,LayoutY);
                    STEP_SIZE='D';}
                else
                if(check_Left((int)LayoutX,(int)LayoutY,1)){
                    movingBomber(LayoutX-1,LayoutY);
                    STEP_SIZE='A';}
                else
                if(check_Down((int)LayoutX,(int)LayoutY,1)){
                    movingBomber(LayoutX,LayoutY+1);
                    STEP_SIZE='S';
                }
                break;
        }
        if (Math.abs(bomber.LayoutX -this.LayoutX) < picture_width && Math.abs(this.LayoutY - bomber.LayoutY) < picture_height) {
            for(int i=0;i<GameBomber.arrbomb.size();i++){
                Bomb bomb=(Bomb)GameBomber.arrbomb.get(i);
                bomb.stoptime();
            }
            GameBomber.player=false;
            GameBomber.primaryStage.close();
            GameBomber.LOSS.show();
        }

            }

    }

