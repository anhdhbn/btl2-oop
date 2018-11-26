package gamebomber;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Enemy extends AnimatedObject {
    private boolean walking;
    private boolean fixing;
    private int level;
    private boolean checkX;
    private boolean checkY;
    private String lastDirection = "A";

    Random random = new Random();
    List<Node> listNode = new ArrayList<>();
    char STEP_SIZE = 'D';

    public ImageView getImageViewEnemy() {
        return imageViewEnemy;
    }

    public void setImageViewEnemy(ImageView imageViewEnemy) {
        this.imageViewEnemy = imageViewEnemy;
    }

    ImageView imageViewEnemy = new ImageView(new Image(getClass().getResourceAsStream("/Image/enemy.png")));

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Enemy(double LayoutX, double LayoutY) {
        super(LayoutX, LayoutY);
        imageViewEnemy.setLayoutX(LayoutX);
        imageViewEnemy.setLayoutY(LayoutY);
        walking = false;
        fixing = false;
    }

    public void movingBomber(double LayoutX, double LayoutY) {
        this.LayoutX = LayoutX;
        this.LayoutY = LayoutY;
        imageViewEnemy.setLayoutX(LayoutX);
        imageViewEnemy.setLayoutY(LayoutY);
    }
    public void updateimage(String Layout, Pane root) {
        switch (Layout) {
            case "RIGHT":
                root.getChildren().remove(imageViewEnemy);
                imageViewEnemy = new ImageView(new Image(getClass().getResourceAsStream("/Image/rightlevel1.png")));
                imageViewEnemy.setLayoutX(LayoutX);
                imageViewEnemy.setLayoutY(LayoutY);
                root.getChildren().add(imageViewEnemy);
                break;
            case "LEFT":
                root.getChildren().remove(imageViewEnemy);
                imageViewEnemy = new ImageView(new Image(getClass().getResourceAsStream("/Image/leftlevel1.png")));
                imageViewEnemy.setLayoutX(LayoutX);
                imageViewEnemy.setLayoutY(LayoutY);
                root.getChildren().add(imageViewEnemy);
                break;
            case "UP":
                root.getChildren().remove(imageViewEnemy);
                imageViewEnemy = new ImageView(new Image(getClass().getResourceAsStream("/Image/uplevel1.png")));
                imageViewEnemy.setLayoutX(LayoutX);
                imageViewEnemy.setLayoutY(LayoutY);
                root.getChildren().add(imageViewEnemy);
                break;
            case "DOWN":
                root.getChildren().remove(imageViewEnemy);
                imageViewEnemy = new ImageView(new Image(getClass().getResourceAsStream("/Image/downlevel1.png")));
                imageViewEnemy.setLayoutX(LayoutX);
                imageViewEnemy.setLayoutY(LayoutY);
                root.getChildren().add(imageViewEnemy);
                break;
            case "right":
                root.getChildren().remove(imageViewEnemy);
                imageViewEnemy = new ImageView(new Image(getClass().getResourceAsStream("/Image/rightlevel2.png")));
                imageViewEnemy.setLayoutX(LayoutX);
                imageViewEnemy.setLayoutY(LayoutY);
                root.getChildren().add(imageViewEnemy);
                break;
            case "left":
                root.getChildren().remove(imageViewEnemy);
                imageViewEnemy = new ImageView(new Image(getClass().getResourceAsStream("/Image/leftlevel2.png")));
                imageViewEnemy.setLayoutX(LayoutX);
                imageViewEnemy.setLayoutY(LayoutY);
                root.getChildren().add(imageViewEnemy);
                break;
            case "up":
                root.getChildren().remove(imageViewEnemy);
                imageViewEnemy = new ImageView(new Image(getClass().getResourceAsStream("/Image/uplevel2.png")));
                imageViewEnemy.setLayoutX(LayoutX);
                imageViewEnemy.setLayoutY(LayoutY);
                root.getChildren().add(imageViewEnemy);
                break;
            case "down":
                root.getChildren().remove(imageViewEnemy);
                imageViewEnemy = new ImageView(new Image(getClass().getResourceAsStream("/Image/downlevel2.png")));
                imageViewEnemy.setLayoutX(LayoutX);
                imageViewEnemy.setLayoutY(LayoutY);
                root.getChildren().add(imageViewEnemy);
                break;
            case "RIGHT_":
                root.getChildren().remove(imageViewEnemy);
                imageViewEnemy = new ImageView(new Image(getClass().getResourceAsStream("/Image/rightlevel3.png")));
                imageViewEnemy.setLayoutX(LayoutX);
                imageViewEnemy.setLayoutY(LayoutY);
                root.getChildren().add(imageViewEnemy);
                break;
            case "LEFT_":
                root.getChildren().remove(imageViewEnemy);
                imageViewEnemy = new ImageView(new Image(getClass().getResourceAsStream("/Image/leftlevel3.png")));
                imageViewEnemy.setLayoutX(LayoutX);
                imageViewEnemy.setLayoutY(LayoutY);
                root.getChildren().add(imageViewEnemy);
                break;
            case "UP_":
                root.getChildren().remove(imageViewEnemy);
                imageViewEnemy = new ImageView(new Image(getClass().getResourceAsStream("/Image/uplevel3.png")));
                imageViewEnemy.setLayoutX(LayoutX);
                imageViewEnemy.setLayoutY(LayoutY);
                root.getChildren().add(imageViewEnemy);
                break;
            case "DOWN_":
                root.getChildren().remove(imageViewEnemy);
                imageViewEnemy = new ImageView(new Image(getClass().getResourceAsStream("/Image/downlevel3.png")));
                imageViewEnemy.setLayoutX(LayoutX);
                imageViewEnemy.setLayoutY(LayoutY);
                root.getChildren().add(imageViewEnemy);
                break;


        }

    }

    public void checkRandom(Bomber bomber, Pane root) {
        int temp = random.nextInt(10);
        temp = temp % 2;
        switch (STEP_SIZE) {
            case 'D':
                if (temp == 1) {
                    if (random.nextInt() % 2 == 1) {
                        if (check_Right((int) LayoutX, (int) LayoutY, 1)) {
                            this.updateimage("right",root);
                            movingBomber(LayoutX + 1, LayoutY);
                            STEP_SIZE = 'D';
                            break;
                        }
                    }
                    if (check_Down((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("down",root);
                        movingBomber(LayoutX, LayoutY + 1);
                        STEP_SIZE = 'S';
                    } else if (check_Up((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("up",root);
                        movingBomber(LayoutX, LayoutY - 1);
                        STEP_SIZE = 'W';
                    } else if (check_Right((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("right",root);
                        movingBomber(LayoutX + 1, LayoutY);
                        STEP_SIZE = 'D';
                    } else if (check_Left((int) LayoutX, (int) LayoutY, 1)) {
                        STEP_SIZE = 'A';
                        this.updateimage("left",root);
                        movingBomber(LayoutX - 1, LayoutY);

                    }

                } else {
                    if (random.nextInt() % 2 == 1) {
                        if (check_Right((int) LayoutX, (int) LayoutY, 1)) {
                            STEP_SIZE = 'D';
                            this.updateimage("right",root);
                            movingBomber(LayoutX + 1, LayoutY);
                            break;
                        }
                    }
                    if (check_Up((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("up",root);
                        movingBomber(LayoutX, LayoutY - 1);
                        STEP_SIZE = 'W';
                    } else if (check_Down((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("down",root);
                        movingBomber(LayoutX, LayoutY + 1);
                        STEP_SIZE = 'S';
                    } else if (check_Right((int) LayoutX, (int) LayoutY, 1)) {
                        STEP_SIZE = 'D';
                        this.updateimage("right",root);
                        movingBomber(LayoutX + 1, LayoutY);

                    } else if (check_Left((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("left",root);
                        movingBomber(LayoutX - 1, LayoutY);
                        STEP_SIZE = 'A';
                    }


                }
                break;
            case 'A':
                if (temp == 1) {
                    if (random.nextInt() % 2 == 1) {
                        if (check_Left((int) LayoutX, (int) LayoutY, 1)) {
                            this.updateimage("left",root);
                        movingBomber(LayoutX - 1, LayoutY);
                            STEP_SIZE = 'A';
                        }
                        break;
                    }
                    if (check_Down((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("down",root);
                        movingBomber(LayoutX, LayoutY + 1);
                        STEP_SIZE = 'S';
                    } else if (check_Up((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("up",root);
                        movingBomber(LayoutX, LayoutY - 1);
                        STEP_SIZE = 'W';
                    } else if (check_Left((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("left",root);
                        movingBomber(LayoutX - 1, LayoutY);
                        STEP_SIZE = 'A';
                    } else if (check_Right((int) LayoutX, (int) LayoutY, 1)) {
                        STEP_SIZE = 'D';
                        this.updateimage("right",root);
                            movingBomber(LayoutX + 1, LayoutY);
                    }
                } else {
                    if (random.nextInt() % 2 == 1) {
                        if (check_Left((int) LayoutX, (int) LayoutY, 1)) {
                            this.updateimage("left",root);
                        movingBomber(LayoutX - 1, LayoutY);
                            STEP_SIZE = 'A';
                        }
                        break;
                    }
                    if (check_Up((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("up",root);
                        movingBomber(LayoutX, LayoutY - 1);
                        STEP_SIZE = 'W';
                    } else if (check_Down((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("down",root);
                        movingBomber(LayoutX, LayoutY + 1);
                        STEP_SIZE = 'S';
                    } else if (check_Left((int) LayoutX, (int) LayoutY, 1)) {
                        STEP_SIZE = 'A';
                        this.updateimage("left",root);
                        movingBomber(LayoutX - 1, LayoutY);
                    } else if (check_Right((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("right",root);
                            movingBomber(LayoutX + 1, LayoutY);
                        STEP_SIZE = 'D';
                    }


                }
                break;
            case 'S':
                if (temp == 1) {
                    if (random.nextInt() % 2 == 1) {
                        if (check_Down((int) LayoutX, (int) LayoutY, 1)) {
                            this.updateimage("down",root);
                        movingBomber(LayoutX, LayoutY + 1);
                            STEP_SIZE = 'S';
                        }
                        break;
                    }
                    if (check_Left((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("left",root);
                        movingBomber(LayoutX - 1, LayoutY);
                        STEP_SIZE = 'A';
                    } else if (check_Right((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("right",root);
                            movingBomber(LayoutX + 1, LayoutY);
                        STEP_SIZE = 'D';
                    } else if (check_Down((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("down",root);
                        movingBomber(LayoutX, LayoutY + 1);
                        STEP_SIZE = 'S';
                    } else if (check_Up((int) LayoutX, (int) LayoutY, 1)) {
                        STEP_SIZE = 'W';
                        this.updateimage("up",root);
                        movingBomber(LayoutX, LayoutY - 1);
                    }
                } else {
                    if (random.nextInt() % 2 == 1) {
                        if (check_Down((int) LayoutX, (int) LayoutY, 1)) {
                            this.updateimage("down",root);
                        movingBomber(LayoutX, LayoutY + 1);
                            STEP_SIZE = 'S';
                        }
                        break;
                    }
                    if (check_Right((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("right",root);
                            movingBomber(LayoutX + 1, LayoutY);
                        STEP_SIZE = 'D';
                    } else if (check_Left((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("left",root);
                        movingBomber(LayoutX - 1, LayoutY);
                        STEP_SIZE = 'A';
                    } else if (check_Down((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("down",root);
                        movingBomber(LayoutX, LayoutY + 1);
                        STEP_SIZE = 'S';
                    } else if (check_Up((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("up",root);
                        movingBomber(LayoutX, LayoutY - 1);
                        STEP_SIZE = 'W';
                    }

                }
                break;
            case 'W':
                if (temp == 1) {
                    if (random.nextInt() % 2 == 1) {
                        if (check_Up((int) LayoutX, (int) LayoutY, 1)) {
                            this.updateimage("up",root);
                        movingBomber(LayoutX, LayoutY - 1);
                            STEP_SIZE = 'W';
                        }
                        break;
                    }
                    if (check_Left((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("left",root);
                        movingBomber(LayoutX - 1, LayoutY);
                        STEP_SIZE = 'A';
                    } else if (check_Right((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("right",root);
                            movingBomber(LayoutX + 1, LayoutY);
                        STEP_SIZE = 'D';
                    } else if (check_Up((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("up",root);
                        movingBomber(LayoutX, LayoutY - 1);
                        STEP_SIZE = 'W';
                    } else if (check_Down((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("down",root);
                        movingBomber(LayoutX, LayoutY + 1);
                        STEP_SIZE = 'S';
                    }
                } else {
                    if (random.nextInt() % 2 == 1) {
                        if (check_Up((int) LayoutX, (int) LayoutY, 1)) {
                            this.updateimage("up",root);
                        movingBomber(LayoutX, LayoutY - 1);
                            STEP_SIZE = 'W';
                        }
                        break;
                    }
                    if (check_Right((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("right",root);
                            movingBomber(LayoutX + 1, LayoutY);
                        STEP_SIZE = 'D';
                    } else if (check_Left((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("left",root);
                        movingBomber(LayoutX - 1, LayoutY);
                        STEP_SIZE = 'A';
                    } else if (check_Up((int) LayoutX, (int) LayoutY, 1)) {
                        this.updateimage("up",root);
                        movingBomber(LayoutX, LayoutY - 1);
                        STEP_SIZE = 'W';
                    } else if (check_Down((int) LayoutX, (int) LayoutY, 1)) {
                        STEP_SIZE = 'S';
                        this.updateimage("down",root);
                        movingBomber(LayoutX, LayoutY + 1);
                    }

                }
                break;
        }
        checkDie(bomber, root);
    }

    public void checkAi(Bomber bomber, Pane root) {
        //Mapdata.printMapNode();
        //System.out.printf("%d %d", (int)getLayoutX(), (int)LayoutY);
        //System.out.println();
        int startX, startY;
        if (checkX) {
            checkX = false;
            startX = ((int) getLayoutX()) / 45;
        } else {
            startX = ((int) getLayoutX() + 44) / 45;
        }
        if (checkY) {
            checkY = false;
            startY = ((int) getLayoutY()) / 45;
        } else {
            startY = ((int) getLayoutY() + 44) / 45;
        }
        int endX = (int) bomber.getLayoutX() / 45;
        int endY = (int) bomber.getLayoutY() / 45;

        //Mapdata.printMapNode(startX, startY, endX, endY);
        //System.out.printf("%d %d %d %d", startX, startY, endX, endY);
        //System.out.println();
        listNode = Mapdata.findPath(startY, startX, endY, endX);
        //movingBomber(3, 11);
        if (listNode.size() != 0) {
           /* String temp = "=================================================>" + listNode.size();
            System.out.println(temp);*/
            /*for (Node node : listNode) {
                int x = node.getX() * 45;
                int y = node.getY() * 45;
                *//*System.out.printf("%d %d", x / 45, y / 45);
                System.out.println();*//*
            }*/
            Node firstNode = listNode.get(0);

            int posY = firstNode.getX();
            int posX = firstNode.getY();
            if (posX == startX) {
                if (posY < startY) {
                    if (LayoutX % 45 == 0){
                        this.updateimage("UP_",root);
                        movingBomber(LayoutX, LayoutY - 1);
                        lastDirection = "W";
                    }else {
                        movingOldDirection(lastDirection, root);
                    }

                }
                if (posY > startY) {
                    if (LayoutX % 45 == 0){
                        this.updateimage("DOWN_",root);
                        movingBomber(LayoutX, LayoutY + 1);
                        lastDirection = "S";
                    } else {
                        movingOldDirection(lastDirection, root);
                    }
                    checkY = true;

                }
            }
            if (posY == startY) {
                if (posX < startX) {
                    if (LayoutY % 45 == 0) {
                        this.updateimage("LEFT_",root);
                        movingBomber(LayoutX - 1, LayoutY);
                        lastDirection = "A";
                    } else {
                        movingOldDirection(lastDirection, root);
                    }
                }
                if (posX > startX) {
                    if (LayoutY % 45 == 0){
                        this.updateimage("RIGHT_",root);
                            movingBomber(LayoutX + 1, LayoutY);
                        lastDirection = "D";
                    } else {
                        movingOldDirection(lastDirection, root);
                    }
                    checkX = true;

                }
            }
            listNode.remove(firstNode);
            checkDie(bomber,root);
        }
        else checkRandom(bomber,root);
    }

    public void movingOldDirection(String lastDirection, Pane root) {
        switch (lastDirection){
            case "A":{
                this.updateimage("LEFT_",root);
                        movingBomber(LayoutX - 1, LayoutY);
                break;
            }
            case "D": {
                this.updateimage("RIGHT_",root);
                            movingBomber(LayoutX + 1, LayoutY);
                break;
            }

            case "W": {
                this.updateimage("UP_",root);
                        movingBomber(LayoutX, LayoutY - 1);
                break;
            }

            case "S": {
                this.updateimage("DOWN_",root);
                        movingBomber(LayoutX, LayoutY + 1);
                break;
            }
        }
    }

    public void check(Bomber bomber, Pane root) {
        switch (STEP_SIZE) {
            case 'D':
                if (check_Right((int) LayoutX, (int) LayoutY, 1)) {
                    this.updateimage("RIGHT",root);
                            movingBomber(LayoutX + 1, LayoutY);
                    STEP_SIZE = 'D';
                } else if (check_Down((int) LayoutX, (int) LayoutY, 1)) {
                    this.updateimage("DOWN",root);
                        movingBomber(LayoutX, LayoutY + 1);
                    STEP_SIZE = 'S';
                } else if (check_Up((int) LayoutX, (int) LayoutY, 1)) {
                    this.updateimage("UP",root);
                        movingBomber(LayoutX, LayoutY - 1);
                    STEP_SIZE = 'W';
                } else if (check_Left((int) LayoutX, (int) LayoutY, 1)) {
                    this.updateimage("LEFT",root);
                        movingBomber(LayoutX - 1, LayoutY);
                    STEP_SIZE = 'A';
                }
                break;
            case 'A':
                if (check_Left((int) LayoutX, (int) LayoutY, 1)) {
                    this.updateimage("LEFT",root);
                        movingBomber(LayoutX - 1, LayoutY);
                    STEP_SIZE = 'A';
                } else if (check_Down((int) LayoutX, (int) LayoutY, 1)) {
                    this.updateimage("DOWN",root);
                        movingBomber(LayoutX, LayoutY + 1);
                    STEP_SIZE = 'S';
                } else if (check_Up((int) LayoutX, (int) LayoutY, 1)) {
                    this.updateimage("UP",root);
                        movingBomber(LayoutX, LayoutY - 1);
                    STEP_SIZE = 'W';
                } else if (check_Right((int) LayoutX, (int) LayoutY, 1)) {
                    this.updateimage("RIGHT",root);
                            movingBomber(LayoutX + 1, LayoutY);
                    STEP_SIZE = 'D';
                }
                break;
            case 'S':
                if (check_Down((int) LayoutX, (int) LayoutY, 1)) {
                    this.updateimage("DOWN",root);
                        movingBomber(LayoutX, LayoutY + 1);
                    STEP_SIZE = 'S';
                } else if (check_Right((int) LayoutX, (int) LayoutY, 1)) {
                    this.updateimage("RIGHT",root);
                            movingBomber(LayoutX + 1, LayoutY);
                    STEP_SIZE = 'D';
                } else if (check_Left((int) LayoutX, (int) LayoutY, 1)) {
                    this.updateimage("LEFT",root);
                        movingBomber(LayoutX - 1, LayoutY);
                    STEP_SIZE = 'A';
                } else if (check_Up((int) LayoutX, (int) LayoutY, 1)) {
                    this.updateimage("UP",root);
                        movingBomber(LayoutX, LayoutY - 1);
                    STEP_SIZE = 'W';
                }
                break;
            case 'W':
                if (check_Up((int) LayoutX, (int) LayoutY, 1)) {
                    this.updateimage("UP",root);
                        movingBomber(LayoutX, LayoutY - 1);
                    STEP_SIZE = 'W';
                } else if (check_Right((int) LayoutX, (int) LayoutY, 1)) {
                    this.updateimage("RIGHT",root);
                            movingBomber(LayoutX + 1, LayoutY);
                    STEP_SIZE = 'D';
                } else if (check_Left((int) LayoutX, (int) LayoutY, 1)) {
                    this.updateimage("LEFT",root);
                        movingBomber(LayoutX - 1, LayoutY);
                    STEP_SIZE = 'A';
                } else if (check_Down((int) LayoutX, (int) LayoutY, 1)) {
                    this.updateimage("DOWN",root);
                        movingBomber(LayoutX, LayoutY + 1);
                    STEP_SIZE = 'S';
                }
                break;
        }
        checkDie(bomber, root);

    }

    public void checkDie(Bomber bomber, Pane root){
        if (Math.abs(bomber.LayoutX - this.LayoutX) < picture_width && Math.abs(this.LayoutY - bomber.LayoutY) < picture_height) {
            for (int i = 0; i < GameBomber.arrbomb.size(); i++) {
                Bomb bomb = (Bomb) GameBomber.arrbomb.get(i);
                bomb.stoptime();
            }
            GameBomber.player = false;
            bomber.updateimage("DIE", root);
            GameBomber.timeShowDie = System.nanoTime() / 1000000000.0;
        }
    }

}

