package gamebomber;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GameBomber extends Application {
    static double timeShowDie = 0;
    static boolean player = true;
    static boolean NotPutBomb = false;
    static Stage primaryStage = new Stage();
    static ArrayList arrbomb = new ArrayList<Bomb>();
    static ArrayList timebomb = new ArrayList<Integer>();
    static ArrayList timefire = new ArrayList<Double>();
    static ArrayList arrNode = new ArrayList<FireBom>();
    static boolean Item = false;
    static Item itembomx2 = new Item();
    static Item itemrun = new Item();
    static Item door = new Item();
    static int SPEED = 3;
    static Stage LOSS = new Stage();
    static Media media = new Media(new File("C:\\Users\\Anh DH\\Desktop\\New folder (5)\\sound\\Tieng-Bom-V-A.mp3").toURI().toString());

    public static void main(String[] args) {
        launch(args);
    }
    private final Set<Character> pressed = new HashSet<Character>();
    @Override
    public void start(Stage primary) throws Exception {
        final int width = 675;
        final int height = 585;
        final int picture_width = 45;
        final int picture_height = 45;
        final String path = "C:\\Users\\Anh DH\\Desktop\\New folder (5)\\sound\\soundMenu.mp3";
        primaryStage.setTitle("Bomberman");
        Pane root = new Pane();
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
//        mediaPlayer.setStartTime(Duration.millis(5000));
        //mediaPlayer.play();
        mediaPlayer.setVolume(0.5);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(100);

        StaticObject staticObject = new StaticObject();
        staticObject.loadMap("/Map_level/Map1.txt", root);
        for (int i = 0; i < StaticObject.enemymap.size(); i++) {
            root.getChildren().add(((Enemy) (StaticObject.enemymap.get(i))).imageViewEnemy);
        }
        Bomber bomber = new Bomber(picture_width, picture_height);
        Scene primaryScene = new Scene(root, width, height);

        //dieu khien nhan vat
        primaryScene.setOnKeyPressed(action -> {
//            System.out.println(action.getCode().getName());
            if (player) {
                if (action.getCode() == KeyCode.UP) {
                    bomber.updateimage("UP", root);
                    if (bomber.check_Up((int) bomber.imageViewBomber.getLayoutX(), (int) bomber.imageViewBomber.getLayoutY(), SPEED + ((int) bomber.LayoutY) % SPEED)) {
                        bomber.movingBomber(bomber.imageViewBomber.getLayoutX(), bomber.imageViewBomber.getLayoutY() - (SPEED + ((int) bomber.LayoutY) % SPEED));
                        bomber.CheckItem(root);
                    } else if (((int) bomber.LayoutX) % picture_width <= 18 && ((int) bomber.LayoutX) % picture_width > 0) {
                        if (bomber.check_Left((int) bomber.imageViewBomber.getLayoutX(), (int) bomber.imageViewBomber.getLayoutY(), ((int) bomber.LayoutX) % picture_width)) {
                            if (bomber.check_Up((int) bomber.imageViewBomber.getLayoutX() - (((int) bomber.LayoutX) % picture_width), (int) bomber.imageViewBomber.getLayoutY(), SPEED + ((int) bomber.LayoutY) % SPEED)) {
                                bomber.movingBomber(bomber.imageViewBomber.getLayoutX() - (((int) bomber.LayoutX) % picture_width), bomber.imageViewBomber.getLayoutY());
                                bomber.CheckItem(root);
                            }
                        }
                    } else if (((int) bomber.LayoutX) % picture_width > 26) {
                        if (bomber.check_Right((int) bomber.imageViewBomber.getLayoutX(), (int) bomber.imageViewBomber.getLayoutY(), picture_width - ((int) bomber.LayoutX) % picture_width)) {
                            if (bomber.check_Up((int) bomber.imageViewBomber.getLayoutX() + picture_width - ((int) bomber.LayoutX) % picture_width, (int) bomber.imageViewBomber.getLayoutY(), SPEED + ((int) bomber.LayoutY) % SPEED)) {
                                bomber.movingBomber(bomber.imageViewBomber.getLayoutX() + picture_width - ((int) bomber.LayoutX) % picture_width, bomber.imageViewBomber.getLayoutY());
                                bomber.CheckItem(root);
                            }
                        }
                    }
                } else if (action.getCode() == KeyCode.LEFT) {
                    bomber.updateimage("LEFT", root);
                    if (bomber.check_Left((int) bomber.imageViewBomber.getLayoutX(), (int) bomber.imageViewBomber.getLayoutY(), SPEED + ((int) bomber.LayoutX) % SPEED)) {
                        bomber.movingBomber(bomber.imageViewBomber.getLayoutX() - (SPEED + ((int) bomber.LayoutX) % SPEED), bomber.imageViewBomber.getLayoutY());
                        bomber.CheckItem(root);
                    } else if (((int) bomber.LayoutY) % picture_height <= 18 && ((int) bomber.LayoutY) % picture_height > 0) {
                        if (bomber.check_Up((int) bomber.imageViewBomber.getLayoutX(), (int) bomber.imageViewBomber.getLayoutY(), ((int) bomber.LayoutY) % picture_height)) {
                            if (bomber.check_Left((int) bomber.imageViewBomber.getLayoutX(), (int) bomber.imageViewBomber.getLayoutY() - (((int) bomber.LayoutY) % picture_height), SPEED + ((int) bomber.LayoutX) % SPEED)) {
                                bomber.movingBomber(bomber.imageViewBomber.getLayoutX(), bomber.imageViewBomber.getLayoutY() - (((int) bomber.LayoutY) % picture_height));
                                bomber.CheckItem(root);
                            }
                        }
                    } else if (((int) bomber.LayoutY) % picture_height > 26) {
                        if (bomber.check_Down((int) bomber.imageViewBomber.getLayoutX(), (int) bomber.imageViewBomber.getLayoutY(), picture_height - ((int) bomber.LayoutY) % picture_height)) {
                            if (bomber.check_Left((int) bomber.imageViewBomber.getLayoutX(), (int) bomber.imageViewBomber.getLayoutY() + picture_height - ((int) bomber.LayoutY) % picture_height, SPEED + ((int) bomber.LayoutX) % SPEED)) {
                                bomber.movingBomber(bomber.imageViewBomber.getLayoutX(), bomber.imageViewBomber.getLayoutY() + picture_height - ((int) bomber.LayoutY) % picture_height);
                                bomber.CheckItem(root);
                            }
                        }
                    }
                } else if (action.getCode() == KeyCode.DOWN) {
                    bomber.updateimage("DOWN", root);
                    if (bomber.check_Down((int) bomber.imageViewBomber.getLayoutX(), (int) bomber.imageViewBomber.getLayoutY(), SPEED - ((int) bomber.LayoutY) % SPEED)) {
                        bomber.movingBomber(bomber.imageViewBomber.getLayoutX(), bomber.imageViewBomber.getLayoutY() + SPEED - ((int) bomber.LayoutY) % SPEED);
                        bomber.CheckItem(root);
                    } else if (((int) bomber.LayoutX) % picture_width > 26) {
                        if (bomber.check_Right((int) bomber.imageViewBomber.getLayoutX(), (int) bomber.imageViewBomber.getLayoutY(), picture_width - ((int) bomber.LayoutX) % picture_width)) {
                            if (bomber.check_Down((int) bomber.imageViewBomber.getLayoutX() + picture_width - ((int) bomber.LayoutX) % picture_width, (int) bomber.imageViewBomber.getLayoutY(), SPEED - ((int) bomber.LayoutY) % SPEED)) {
                                bomber.movingBomber(bomber.imageViewBomber.getLayoutX() + picture_width - ((int) bomber.LayoutX) % picture_width, bomber.imageViewBomber.getLayoutY());
                                bomber.CheckItem(root);
                            }
                        }
                    } else if (((int) bomber.LayoutX) % picture_width <= 18 && ((int) bomber.LayoutX) % picture_width > 0) {
                        if (bomber.check_Left((int) bomber.imageViewBomber.getLayoutX(), (int) bomber.imageViewBomber.getLayoutY(), ((int) bomber.LayoutX) % picture_width)) {
                            if (bomber.check_Down((int) bomber.imageViewBomber.getLayoutX() - (((int) bomber.LayoutX) % picture_width), (int) bomber.imageViewBomber.getLayoutY(), SPEED - ((int) bomber.LayoutY) % SPEED)) {
                                bomber.movingBomber(bomber.imageViewBomber.getLayoutX() - (((int) bomber.LayoutX) % picture_width), bomber.imageViewBomber.getLayoutY());
                                bomber.CheckItem(root);
                            }
                        }
                    }
                } else if (action.getCode() == KeyCode.RIGHT) {
                    bomber.updateimage("RIGHT", root);
                    if (bomber.check_Right((int) bomber.imageViewBomber.getLayoutX(), (int) bomber.imageViewBomber.getLayoutY(), SPEED - ((int) bomber.LayoutX) % SPEED)) {
                        bomber.movingBomber(bomber.imageViewBomber.getLayoutX() + SPEED - ((int) bomber.LayoutX) % SPEED, bomber.imageViewBomber.getLayoutY());
                        bomber.CheckItem(root);
                    } else if (((int) bomber.LayoutY) % picture_height > 26) {
                        if (bomber.check_Down((int) bomber.imageViewBomber.getLayoutX(), (int) bomber.imageViewBomber.getLayoutY(), picture_height - ((int) bomber.LayoutY) % picture_height)) {
                            if (bomber.check_Right((int) bomber.imageViewBomber.getLayoutX(), (int) bomber.imageViewBomber.getLayoutY() + picture_height - ((int) bomber.LayoutY) % picture_height, SPEED - ((int) bomber.LayoutX) % SPEED)) {
                                bomber.movingBomber(bomber.imageViewBomber.getLayoutX(), bomber.imageViewBomber.getLayoutY() + picture_height - ((int) bomber.LayoutY) % picture_height);
                                bomber.CheckItem(root);
                            }
                        }
                    } else if (((int) bomber.LayoutY) % picture_height <= 18 && ((int) bomber.LayoutY) % picture_height > 0) {
                        if (bomber.check_Up((int) bomber.imageViewBomber.getLayoutX(), (int) bomber.imageViewBomber.getLayoutY(), ((int) bomber.LayoutY) % picture_height)) {
                            if (bomber.check_Right((int) bomber.imageViewBomber.getLayoutX(), (int) bomber.imageViewBomber.getLayoutY() - (((int) bomber.LayoutY) % picture_height), SPEED - ((int) bomber.LayoutX) % SPEED)) {
                                bomber.movingBomber(bomber.imageViewBomber.getLayoutX(), bomber.imageViewBomber.getLayoutY() - (((int) bomber.LayoutY) % picture_height));
                                bomber.CheckItem(root);
                            }
                        }
                    }

                } else if (action.getCode() == KeyCode.SPACE) {
                    if (!NotPutBomb) {
                        int LayoutX = (int) bomber.LayoutX;
                        int LayoutY = (int) bomber.LayoutY;
                        LayoutX = LayoutX - LayoutX % picture_width;
                        LayoutY = LayoutY - LayoutY % picture_height;
                        Bomb bomb_ = new Bomb(LayoutX, LayoutY);
                        int j = (int) (System.nanoTime() / 1000000000);
                        if (arrbomb.isEmpty()) {
                            bomb_.starttime();
                            arrbomb.add(bomb_);
                            timebomb.add(j);
                            root.getChildren().add(bomb_.imageViewBomb);
                            Mapdata.setMapNodesAtPos(LayoutY/45,LayoutX/45,'#');
                        } else {
                            Bomb b = (Bomb) arrbomb.get(arrbomb.size() - 1);
                            if (b.layoutY != bomb_.layoutY || b.layoutX != bomb_.layoutX) {
                                bomb_.starttime();
                                arrbomb.add(bomb_);

                                timebomb.add(j);
                                root.getChildren().add(bomb_.imageViewBomb);
                                Mapdata.setMapNodesAtPos(LayoutY/45,LayoutX/45,'#');
                            }

                        }

                        root.getChildren().remove(bomber.imageViewBomber);
                        root.getChildren().add(bomber.imageViewBomber);
                    }
                }
            }
        });


        //final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                if (timeShowDie != 0) {
                    if (System.nanoTime() / 1000000000.0 - timeShowDie > 0.2) {
                        timeShowDie = 0;
                        LOSS.show();
                        primaryStage.close();
                    }
                }


                Enemy enemy;
                for (int i = 0; i < StaticObject.enemymap.size(); i++) {
                    enemy = (Enemy) StaticObject.enemymap.get(i);
                    if (enemy.getLevel() == 1)
                        enemy.check(bomber, root);
                    else if (enemy.getLevel() == 2)
                        enemy.checkRandom(bomber, root);
                    else if (enemy.getLevel() == 3) {
                        if(player)
                         enemy.checkAi(bomber, root);
                        //enemy.checkAi(bomber,root);
                        //goi cai ham check tim duoi nguoi
                        //ham đấy check xong thay toa do moi thi copy cai đoạn check bị bom nổ với va chạm người ở cuối hàm check bên trên
                        //System.out.println();
                    }
                }
                //System.out.println(Bomb.check);
                Bomb.Handling(root, bomber);
            }
        }
                .start();

//        Enemy e = (Enemy)(StaticObject.enemymap.get(0));
//        e.checkAi(bomber,root);

        root.getChildren().add(bomber.imageViewBomber);
        //root.getChildren().add(mediaView);
        primaryStage.setScene(primaryScene);
        primaryStage.setResizable(false);
        primaryStage.show();
        Pane Loss = new Pane();
        gameover gameover = new gameover(0, 0);
        Loss.getChildren().add(gameover.imageView);
        Button button = new Button();
        button.setText("Replay");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bomber.level(root, "/Map_level/Map1.txt");
                LOSS.close();
                primaryStage.show();
            }
        });
        button.setLayoutX(130);
        button.setLayoutY(170);
        button.setStyle("-fx-font-size: 2em; -fx-background-color: #0dff14 ; -fx-text-fill: #ff213f");
        Loss.getChildren().add(button);
        Loss.setStyle("-fx-background-color: #000000;");
        Loss.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene scene = new Scene(Loss, 300, 210, Color.GREEN);
        LOSS.setScene(scene);
        LOSS.setResizable(false);
        LOSS.setTitle("GAMEOVER");
        LOSS.setX(primaryStage.getX() + 200);
        LOSS.setY(primaryStage.getY() + 200);

    }
}
