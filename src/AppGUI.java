import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


/**
 * Created by Hubaishi on 26/12/15.
 */
public class AppGUI extends BorderPane {

    private final WahlPM model;

    HBox btnBox;
    VBox tableBox;


    Canton canton = new Canton();


    Top top;
    LeftTable table;

    public AppGUI(WahlPM model) {
        this.model = model;

        initializeControls();
        layoutControls();

    }

    private void initializeControls() {

       ///// TOP
        btnBox = new HBox(30);

        top = new Top();
        top.initializeControls();
        top.layoutControls();
        top.addBtn.setOnAction(event -> model.addNewMountain());
        top.deleteBtn.setOnAction(event -> model.deleteMountain(LeftTable.selectedMountainID));
        top.saveBtn.setOnAction(event -> model.save());

        ///// Left
        table = new LeftTable(model);
        tableBox = new VBox(10);
        tableBox.setStyle("-fx-border-color: lightgray;");
        tableBox.getChildren().addAll(table.initializeTable(table.model.getResulate()),LeftTable.countLbl);

        //////CENTER
        table.centerData.fillData();
    }

    private void layoutControls() {

        ///// TOP
        btnBox.setMaxWidth(Double.MAX_VALUE);
        btnBox.setMaxHeight(Double.MAX_VALUE);

        BorderPane.setMargin(btnBox, new Insets(0,0,15,0));
        btnBox.setPadding(new Insets(10, 20, 10, 20));
        btnBox.setPadding(new Insets(20));

        btnBox.setStyle("-fx-background-color: red;");

        btnBox.getChildren().addAll(top.saveBtn,top.addBtn,top.deleteBtn,top.undoBtn,top.redoBtn,top.searchField);

        setTop(btnBox);

        /////////// Left
        tableBox.setPadding(new Insets(0, 20, 10, 20));
        BorderPane.setMargin(tableBox,new Insets(10,10,15,10));
        tableBox.setMaxHeight(Double.MAX_VALUE);
        tableBox.setMaxWidth(Double.MAX_VALUE);
        tableBox.setPrefWidth(315);
        tableBox.getStyleClass().add("border");

        setLeft(tableBox);

        ////////// CENTER
        BorderPane.setMargin(table.centerData.grid,new Insets(10,10,15,10));

        setCenter(table.centerData.grid);

    }



}
