import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;


public class Main extends Application {

    private Stage primaryStage;

    /* Пути к страницам */
    private static final String PLAYFIELD_PATH = "/Playfield.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            this.primaryStage = primaryStage;
            this.primaryStage.setTitle("2048");

            initPlayfield();


            this.primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Initialize field with tiles
     */
    private void initPlayfield() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(PLAYFIELD_PATH));
        GridPane gridPane = loader.load();


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Rectangle tile = new Rectangle(0, 0, 150, 100);
                tile.setArcHeight(10);

                Random random = new Random();
                double r = random.nextDouble();
                double g = random.nextDouble();
                double b = random.nextDouble();

                Color color = new Color(r, g, b, 1);
                tile.setFill(color);

                gridPane.add(tile, i, j);
            }
        }

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);

    }
}
