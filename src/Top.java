import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Button;


import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

/**
 * Created by Hubaishi on 28/12/15.
 */
public class Top extends HBox {

    public Button saveBtn,addBtn, deleteBtn, undoBtn, redoBtn;

    TextField searchField;

    WahlPM wahlPM = new WahlPM();

    public void initializeControls() {

        Image saveImg = new Image(getClass().getResourceAsStream("Photos/save.png"));
        ImageView saveImgView = new ImageView(saveImg);
        saveImgView.setFitWidth(20.0);
        saveImgView.setFitHeight(20.0);
        saveBtn = new Button("",saveImgView);
        saveBtn.setMinSize(5,5);
        saveBtn.setMaxSize(50, 50);
        saveBtn.setPrefSize(20.0,20.0);
        saveBtn.setStyle("-fx-background-color: red;");



        Image addImg = new Image(getClass().getResourceAsStream("Photos/plus.png"));
        ImageView addimgView = new ImageView(addImg);
        addimgView.setFitWidth(20.0);
        addimgView.setFitHeight(20.0);
        addBtn = new Button("",addimgView);
        addBtn.setMinSize(5,5);
        addBtn.setMaxSize(50, 50);
        addBtn.setPrefSize(20.0,20.0);
        addBtn.setStyle("-fx-background-color: red;");



        Image deleteImg = new Image(getClass().getResourceAsStream("Photos/x.png"));
        ImageView deleteImgView = new ImageView(deleteImg);
        deleteImgView.setFitWidth(20.0);
        deleteImgView.setFitHeight(20.0);
        deleteBtn = new Button("",deleteImgView);
        deleteBtn.setMinSize(5,5);
        deleteBtn.setMaxSize(50, 50);
        deleteBtn.setPrefSize(20.0,20.0);
        deleteBtn.setStyle("-fx-background-color: red;");


        Image undoImg = new Image(getClass().getResourceAsStream("Photos/undo.png"));
        ImageView undoImageView = new ImageView(undoImg);
        undoImageView.setFitWidth(20.0);
        undoImageView.setFitHeight(20.0);
        undoBtn = new Button("",undoImageView);
        undoBtn.setMinSize(5,5);
        undoBtn.setMaxSize(50, 50);
        undoBtn.setPrefSize(20.0,20.0);
        undoBtn.setStyle("-fx-background-color: red;");


        Image redoImg = new Image(getClass().getResourceAsStream("Photos/redo.png"));
        ImageView redoImageView = new ImageView(redoImg);
        redoImageView.setFitWidth(20.0);
        redoImageView.setFitHeight(20.0);
        redoBtn = new Button("",redoImageView);
        redoBtn.setMinSize(5,5);
        redoBtn.setMaxSize(50, 50);
        redoBtn.setPrefSize(20.0,20.0);
        redoBtn.setStyle("-fx-background-color: red;");


        searchField = new TextField();
        searchField.setPrefSize(500,10);
        searchField.setStyle("-fx-background-color: white;");
        ObservableList<Mountains> masterData = FXCollections.observableArrayList();
        masterData = wahlPM.getResulate();

        FilteredList<Mountains> filteredData = new FilteredList<>(masterData, p -> true);
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {

            String lowerCaseFilter;
            if(newValue.isEmpty() != true) {
                lowerCaseFilter = newValue.toLowerCase();
                System.out.println("Lower case " + lowerCaseFilter);

                for(int i = 0;i<wahlPM.getResulate().size();i++)
                {
                    if(wahlPM.resulate.get(i).getMountainName().toLowerCase().contains(lowerCaseFilter))
                    {
                        System.out.print("the search mountain is "+wahlPM.resulate.get(i).getMountainName());
                    }
                }
            }

            else
            {
                System.out.println("newValue is empty");
            }

            });



        saveBtn.setMaxWidth(Double.MAX_VALUE);
        saveBtn.setMaxHeight(Double.MAX_VALUE);

        addBtn.setMaxWidth(Double.MAX_VALUE);
        addBtn.setMaxHeight(Double.MAX_VALUE);

        deleteBtn.setMaxWidth(Double.MAX_VALUE);
        deleteBtn.setMaxHeight(Double.MAX_VALUE);

        undoBtn.setMaxWidth(Double.MAX_VALUE);
        undoBtn.setMaxHeight(Double.MAX_VALUE);

        redoBtn.setMaxWidth(Double.MAX_VALUE);
        redoBtn.setMaxHeight(Double.MAX_VALUE);
    }


    public void layoutControls() {

        getChildren().addAll(saveBtn, addBtn, deleteBtn,undoBtn,redoBtn,searchField);

    }


}
