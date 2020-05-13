import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Hubaishi on 05/12/15.
 */


    public class WahlPM {

    private static final String FILE_NAME = "mountains.csv";
    private static final String FILE_NAME1 = "cantons.csv";



    /////////// added to original

    private final Mountains mountainsProxy = new Mountains();


    private final IntegerProperty selectedIndex     = new SimpleIntegerProperty(-1);

    private final IntegerProperty selectedMountainId = new SimpleIntegerProperty(-1);

    public int getSelectedCountryId() {
        return selectedMountainId.get();
    }

    public IntegerProperty selectedCountryIdProperty() {
        return selectedMountainId;
    }

    public void setSelectedMountainId(int selectedMountainId) {
        this.selectedMountainId.set(selectedMountainId);
    }

    public int getSelectedIndex() {
        return selectedIndex.get();
    }

    public IntegerProperty selectedIndexProperty() {
        return selectedIndex;
    }


    private void bindToProxy(Mountains country) {
        mountainsProxy.IDProperty().bindBidirectional(country.IDProperty());
        mountainsProxy.mountainNameProperty().bindBidirectional(country.mountainNameProperty());
        mountainsProxy.heightProperty().bindBidirectional(country.heightProperty());
    }

    private void unbindFromProxy(Mountains country) {
        mountainsProxy.IDProperty().unbindBidirectional(country.IDProperty());
        mountainsProxy.mountainNameProperty().unbindBidirectional(country.mountainNameProperty());
        mountainsProxy.heightProperty().unbindBidirectional(country.heightProperty());
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex.set(selectedIndex);
    }



    public WahlPM(List<Mountains> mountainsList) {
        resulate.addAll(mountainsList);

       // undoDisabled.bind(Bindings.isEmpty(undoStack));
        //redoDisabled.bind(Bindings.isEmpty(redoStack));

        selectedCountryIdProperty().addListener((observable1, oldId, newId) -> {
            try {
                setSelectedIndex(resulate.indexOf(getMountain((Integer) newId)));
            } catch (Exception e) {
                setSelectedIndex(-1);
            }
        });

        selectedIndexProperty().addListener((observable1, oldValue1, newIndex) -> {
            try {
                setSelectedMountainId(resulate.get((Integer) newIndex).getID());
            } catch (Exception e) {
                setSelectedMountainId(-1);
            }
        });

        selectedCountryIdProperty().addListener((observable, oldValue, newValue) -> {
                    Mountains oldSelection = getMountain((int) oldValue);
                    Mountains newSelection = getMountain((int) newValue);

                    if (oldSelection != null) {
                        unbindFromProxy(oldSelection);
                        //disableUndoSupport(oldSelection);
                    }

                    if (newSelection != null) {
                        bindToProxy(newSelection);
                      //  enableUndoSupport(newSelection);
                    }
                }
        );

        setSelectedMountainId(1);
    }

    public static ObservableList<Mountains> deletedItems = FXCollections.observableArrayList();
    public static ObservableList<Mountains> createdItems = FXCollections.observableArrayList();

    public int checkFree()
    {

        if(deletedItems.isEmpty())
        {
            return 0;
        }

        return deletedItems.get(0).getID();
    }

    public void deleteMountain(int id)
    {
        //get Current Collection of all mountains
        //delete record with identical id like in parameter



        Mountains toBeDeleted = getMountain(id);
        deletedItems.add(toBeDeleted);

        resulate.remove(getMountain(id));

    }




    public void addNewMountain() {

        String [] newMount = new String [12];
        newMount[0]= "0";
        newMount[1]= "Muster";
        newMount[2]= "Muster";
        newMount[3]= "Muster";
        newMount[4]= "Muster";
        newMount[5]= "Muster";
        newMount[6]= "Muster";
        newMount[7]= "Muster";
        newMount[8]= "Muster";
        newMount[9]= "Muster";
        newMount[10]= "Muster";
        newMount[11]= "Muster";

        Mountains newMountain = new Mountains(newMount);
        int newID = (resulate.get(resulate.size()-1).getID())+1;
        newMountain.setID(String.valueOf(newID));
        resulate.add(newMountain);
        createdItems.add(newMountain);

        Platform.runLater(new Runnable()
        {
            @Override
            public void run()
            {

                LeftTable.tableView.getSelectionModel().select(getMountain(newID));
                LeftTable.newSelection = LeftTable.tableView.getSelectionModel().getSelectedItem();
                LeftTable.tableView.scrollTo(LeftTable.newSelection);
            }
        });




    }

    public Mountains getMountain(int id) {
        Optional<Mountains> pmOptional = getResulate().stream()
                .filter(mountains -> mountains.getID() == id)
                .findAny();

        return pmOptional.isPresent() ? pmOptional.get() : null;
    }

    public Canton getKanton(int id) {
        Optional<Canton> pmOptionalCanton = getResulateCanton().stream()
                .filter(canton -> canton.getKantonID() == id)
                .findAny();

        return pmOptionalCanton.isPresent() ? pmOptionalCanton.get() : null;
    }





    private static final String TAB = ";";

        private final StringProperty applicationTitle = new SimpleStringProperty("Swiss Mountains");

        public ObservableList<Mountains> resulate = FXCollections.observableArrayList();
        public ObservableList<Canton> resulateCanton = FXCollections.observableArrayList();


    public WahlPM() {
        resulateCanton.addAll(readFromFile1());
        resulate.addAll(readFromFile());
        }


        public void save() {
            try (BufferedWriter writer = Files.newBufferedWriter(getPath(FILE_NAME, true))) {
                resulate.stream().forEach(resultat -> {
                    try {
                        writer.write(resultat.infoAsLine());
                        writer.newLine();
                    } catch (IOException e) {
                        throw new IllegalStateException(e);
                    }
                });
            } catch (IOException e) {
                throw new IllegalStateException("save failed");
            }
        }


    private List<Canton> readFromFile1() {
        try (Stream<String> stream = getStreamOfLines(FILE_NAME1)) {
            return stream                              // erste Zeile ist die Headerzeile; ueberspringen
                    .map(s -> new Canton(s.split(TAB))) // aus jeder Zeile ein Objekt machen
                    .collect(Collectors.toList());        // alles aufsammeln
        }
    }





    private List<Mountains> readFromFile() {
            try (Stream<String> stream = getStreamOfLines(FILE_NAME)) {
                return stream                              // erste Zeile ist die Headerzeile; ueberspringen
                        .map(s -> new Mountains(s.split(TAB))) // aus jeder Zeile ein Objekt machen
                        .collect(Collectors.toList());        // alles aufsammeln
            }
        }

        private Stream<String> getStreamOfLines(String fileName) {
            try {
                return Files.lines(getPath(fileName, true), StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        private Path getPath(String fileName, boolean locatedInSameFolder)  {
            try {
                if(!locatedInSameFolder) {
                    fileName = "/" + fileName;
                }
                System.out.println(Paths.get(getClass().getResource(fileName).toURI()).toString());
                return Paths.get(getClass().getResource(fileName).toURI());
            } catch (URISyntaxException e) {
                throw new IllegalArgumentException(e);
            }
        }



        public String getApplicationTitle() {
            return applicationTitle.get();
        }

        public StringProperty applicationTitleProperty() {
            return applicationTitle;
        }

        public ObservableList<Mountains> getResulate() {
            return resulate;
        }

    public ObservableList<Canton> getResulateCanton() {
        return resulateCanton;
    }



    }


