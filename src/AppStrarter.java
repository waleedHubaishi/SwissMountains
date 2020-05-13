import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

/**
 * Created by Hubaishi on 26/12/15.
 */
public class AppStrarter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        WahlPM model = new WahlPM();


        Parent rootPanel = new AppGUI(model);

        Scene scene = new Scene(rootPanel,900,540);

        String stylesheet = getClass().getResource("Style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);



        primaryStage.setTitle("Swiss Mountains");
        Image icon = new Image(getClass().getResourceAsStream("Photos/CH.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.setScene(scene);


       // primaryStage.setMaxHeight(Double.MAX_VALUE);
       // primaryStage.setMaxWidth(Double.MAX_VALUE);

        primaryStage.setMaxHeight(540);
        primaryStage.setMinHeight(540);

       primaryStage.setMaxWidth(950);
        primaryStage.setMinWidth(950);


        rootPanel.setStyle("-fx-background-color: white;");


        primaryStage.centerOnScreen();

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }




}




