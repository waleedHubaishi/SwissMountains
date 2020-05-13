import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Hubaishi on 28/12/15.
 */
public class Mountains {


    private final IntegerProperty selectedMountainId = new SimpleIntegerProperty(-1);

    Canton canton = new Canton();

    private final IntegerProperty mountainID      = new SimpleIntegerProperty();
    private final StringProperty  mountainName   = new SimpleStringProperty();
    private final StringProperty  height          = new SimpleStringProperty();
    private final StringProperty  gipfel             = new SimpleStringProperty();
    private final StringProperty  ort             = new SimpleStringProperty();
    private final StringProperty  kanton             = new SimpleStringProperty();
    private final StringProperty  bergkette             = new SimpleStringProperty();
    private final StringProperty  num1             = new SimpleStringProperty();
    private final StringProperty  mountain1             = new SimpleStringProperty();
    private final StringProperty  num2             = new SimpleStringProperty();
    private final StringProperty  besch1             = new SimpleStringProperty();
    private final StringProperty  besch2             = new SimpleStringProperty();




    public Mountains(String[] line) {
        setID(line[0]);
        setMountainName(line[1]);
        setHeight(line[2]);
        setGipfel(line[3]);
        setOrt(line[4]);
        if(line[5].isEmpty() == false) {
            setKanton(line[5]);
        }

        setBergkette(line[6]);
        setNum1(line[7]);
        setMountain1(line[8]);
        setNum2(line[9]);
        setBesch1(line[10]);
        setBesch2(line[11]);

    }

    public Mountains()
    {

    }




    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Mountains mountain = (Mountains) o;

        return getID() == (mountain.getID());
    }

    @Override
    public int hashCode() {
        return mountainID.hashCode();
    }

    public String infoAsLine() {
        return String.join(";",
                String.valueOf(getID()),
                getMountainName(),
                getHeight(),
                getGipfel(),
                getOrt(),
                getKanton() ,
                getBergkette(),
                getNum1(),
                getMountain1(),
                getNum2(),
                getBesch1(),
                getBesch2())
                ;
    }

    @Override
    public String toString() {
        return infoAsLine();
    }


    public int getID() {
        return mountainID.get();
    }

    public IntegerProperty IDProperty() {
        return mountainID;
    }

    public void setID(String mountainID) {
        this.mountainID.set(Integer.parseInt(mountainID));
    }



    public String getMountainName() {
        return mountainName.get();
    }

    public StringProperty mountainNameProperty() {
        return mountainName;
    }

    public void setMountainName(String mountainName) {
        this.mountainName.set(mountainName);
    }



    public String getHeight() {
        return height.get();
    }

    public StringProperty heightProperty() {
        return height;
    }

    public void setHeight(String height) {
        this.height.set(height);
    }



    public String getGipfel() {
        return gipfel.get();
    }

    public StringProperty gipfelProperty() {
        return gipfel;
    }

    public void setGipfel(String gipfel) {
        this.gipfel.set(gipfel);
    }


    public String getBergkette() {
        return bergkette.get();
    }

    public StringProperty bergketteProperty() {
        return bergkette;
    }

    public void setBergkette(String Bergkette) {
        this.bergkette.set(Bergkette);
    }



    public String getOrt() {
        return ort.get();
    }

    public StringProperty ortProperty() {
        return ort;
    }

    public void setOrt(String Ort) {
        this.ort.set(Ort);
    }




    public String getNum1() {
        return num1.get();
    }

    public StringProperty num1Property() {
        return num1;
    }

    public void setNum1(String NUM1) {
        this.num1.set(NUM1);
    }


    public String getNum2() {
        return num2.get();
    }

    public StringProperty num2Property() {
        return num2;
    }

    public void setNum2(String NUM2) {
        this.num2.set(NUM2);
    }


    public void setBesch1(String besch1) {
        this.besch1.set(besch1);
    }

    public String getBesch1() {
        return besch1.get();
    }

    public StringProperty besch1Property() {
        return besch1;
    }


    public StringProperty besch2Property() {
        return besch2;
    }

    public void setBesch2(String besch2) {
        this.besch2.set(besch2);
    }

    public String getBesch2() {
        return besch2.get();
    }


    public StringProperty mountain1Property() {
        return mountain1;
    }

    public void setMountain1(String mountain1) {
        this.mountain1.set(mountain1);
    }

    public String getMountain1() {
        return mountain1.get();
    }


    public StringProperty kantonProperty() {
        return kanton;
    }

    public void setKanton(String kanton) {
        this.kanton.set(kanton);
    }

    public String getKanton() {
        return kanton.get();
    }





    //////////


    public IntegerProperty selectedMountainIdProperty() {
        return selectedMountainId;
    }

    public void setSelectedMountainId(int selectedMountainId) {
        this.selectedMountainId.set(selectedMountainId);
    }




}
