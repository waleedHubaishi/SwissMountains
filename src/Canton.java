import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Hubaishi on 05/01/16.
 */
public class Canton {

    private final IntegerProperty kantonID      = new SimpleIntegerProperty();
    private final StringProperty kantonName   = new SimpleStringProperty();
    private final StringProperty  kantonSmbl          = new SimpleStringProperty();
    private final StringProperty  kantonStandesstimee             = new SimpleStringProperty();
    private final StringProperty  kantonsBetritt             = new SimpleStringProperty();
    private final StringProperty  kantonsHauptort             = new SimpleStringProperty();
    private final StringProperty  kantonsEinwohner             = new SimpleStringProperty();
    private final StringProperty  kantonsAusländer             = new SimpleStringProperty();
    private final StringProperty  kantonsFläche             = new SimpleStringProperty();
    private final StringProperty  kantonsEinwohnerdichte             = new SimpleStringProperty();
    private final StringProperty  kantonsGemeinden             = new SimpleStringProperty();
    private final StringProperty  kantonsAmtssprache             = new SimpleStringProperty();

    public Canton(String[] line) {
        setKantonName(line[0]);
        setKantonSmbl(line[1]);
        setID(line[2]);
        setkantonStandesstimee(line[3]);
        setkantonsBetritt(line[4]);
        setkantonsHauptort(line[5]);
        setkantonsEinwohner(line[6]);
        setkantonsAusländer(line[7]);
        setkantonsFläche(line[8]);
        setkantonsEinwohnerdichte(line[9]);
        setkantonsGemeinden(line[10]);
        setkantonsAmtssprache(line[11]);

    }

    public Canton()
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

        Canton canton = (Canton) o;

        return getKantonID() == (canton.getKantonID());
    }

    @Override
    public int hashCode() {
        return kantonID.hashCode();
    }

    public String infoAsLine() {
        return String.join(";",
                getKantonName(),
                getKantonSmbl(),
                String.valueOf(getKantonID()),
                getkantonStandesstimee(),
                getkantonsBetritt(),
                getkantonsHauptort(),
                getkantonsEinwohner(),
                getkantonsAusländer(),
                getkantonsFläche(),
                getkantonsEinwohnerdichte(),
                getkantonsGemeinden(),
                getkantonsAmtssprache()
        )
                ;
    }

    @Override
    public String toString() {
        return infoAsLine();
    }


    public int getKantonID() {
        return kantonID.get();
    }

    public IntegerProperty IDProperty() {
        return kantonID;
    }

    public void setID(String kantonId) {
        this.kantonID.set(Integer.parseInt(kantonId));
    }



    public String getKantonName() {
        return kantonName.get();
    }

    public StringProperty kantonNameProperty() {
        return kantonName;
    }

    public void setKantonName(String kantonName) {
        this.kantonName.set(kantonName);
    }



    public String getKantonSmbl() {
        return kantonSmbl.get();
    }

    public StringProperty kantonSmblProperty() {
        return kantonSmbl;
    }

    public void setKantonSmbl(String kanton) {
        this.kantonSmbl.set(kanton);
    }



    public String getkantonStandesstimee() {
        return kantonStandesstimee.get();
    }

    public StringProperty kantonStandesstimeeProperty() {
        return kantonStandesstimee;
    }

    public void setkantonStandesstimee(String kantonStandesstimee) {
        this.kantonStandesstimee.set(kantonStandesstimee);
    }


    public String getkantonsBetritt() {
        return kantonsBetritt.get();
    }

    public StringProperty kantonsBetrittProperty() {
        return kantonsBetritt;
    }

    public void setkantonsBetritt(String kantonsBetritt) {
        this.kantonsBetritt.set(kantonsBetritt);
    }



    public String getkantonsHauptort() {
        return kantonsHauptort.get();
    }

    public StringProperty kantonsHauptortProperty() {
        return kantonsHauptort;
    }

    public void setkantonsHauptort(String kantonsHauptort) {
        this.kantonsHauptort.set(kantonsHauptort);
    }




    public String getkantonsEinwohner() {
        return kantonsEinwohner.get();
    }

    public StringProperty kantonsEinwohnerProperty() {
        return kantonsEinwohner;
    }

    public void setkantonsEinwohner(String kantonsEinwohner) {
        this.kantonsEinwohner.set(kantonsEinwohner);
    }


    public String getkantonsAusländer() {
        return kantonsAusländer.get();
    }

    public StringProperty kantonsAusländerProperty() {
        return kantonsAusländer;
    }

    public void setkantonsAusländer(String kantonsAusländer) {
        this.kantonsAusländer.set(kantonsAusländer);
    }


    public void setkantonsFläche(String kantonsFläche) {
        this.kantonsFläche.set(kantonsFläche);
    }

    public String getkantonsFläche() {
        return kantonsFläche.get();
    }

    public StringProperty kantonsFlächeProperty() {
        return kantonsFläche;
    }


    public StringProperty kantonsEinwohnerdichteProperty() {
        return kantonsEinwohnerdichte;
    }

    public void setkantonsEinwohnerdichte(String kantonsEinwohnerdichte) {
        this.kantonsEinwohnerdichte.set(kantonsEinwohnerdichte);
    }

    public String getkantonsEinwohnerdichte() {
        return kantonsEinwohnerdichte.get();
    }


    public StringProperty kantonsGemeindenProperty() {
        return kantonsGemeinden;
    }

    public void setkantonsGemeinden(String kantonsGemeinden) {
        this.kantonsGemeinden.set(kantonsGemeinden);
    }

    public String getkantonsGemeinden() {
        return kantonsGemeinden.get();
    }


    public StringProperty kantonsAmtsspracheProperty() {
        return kantonsAmtssprache;
    }

    public void setkantonsAmtssprache(String kantonsAmtssprache) {
        this.kantonsAmtssprache.set(kantonsAmtssprache);
    }

    public String getkantonsAmtssprache() {
        return kantonsAmtssprache.get();
    }





}