    package com.example.advancejavaassignment2;

    import javafx.beans.property.SimpleStringProperty;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Scene;
    import javafx.scene.control.*;
    import javafx.scene.control.cell.PropertyValueFactory;
    import javafx.scene.layout.AnchorPane;
    import javafx.stage.Stage;
    import org.json.JSONArray;
    import org.json.JSONObject;

    import java.io.IOException;
    import java.util.ArrayList;

    public class MainPage {
        @FXML
        private TableView<Animal> dataTable;

        @FXML
        private TextField searchTxt;
        @FXML
        private TableColumn<Animal, String> familyTableCol;

        @FXML
        private TableColumn<Animal, Button> name3;

        @FXML
        private TableColumn<Animal,String> nameTableCol;

        @FXML
        private TableColumn<Animal, String> scientificNameTableCol;
        private ArrayList<Animal> response;
        @FXML
        void searchBtn(ActionEvent event) throws IOException {
            if(this.searchTxt.getText().isEmpty()){
                return;
            }
            this.response = GetApiResponse.getResponse(this.searchTxt.getText());
            updateTable(this.response);
        }


        private void updateTable(ArrayList<Animal> animalList) {

            dataTable.getItems().clear();

            // Add animals to the TableView
            dataTable.getItems().addAll(animalList);


            nameTableCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
            scientificNameTableCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getScientificName ()));
            familyTableCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getFamily()));
        }


        @FXML
        private void initialize() {
            // Set cell factory to create buttons in the name3 column
            name3.setCellFactory(param -> new TableCell<>() {
                private final Button button = new Button("Click");

                {
                    button.setOnAction(event -> {
                        try {
                            int rowIndex = getIndex();
                            Stage s=new Stage();
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AnimalDetails.fxml"));
                            AnchorPane content = fxmlLoader.load();
                            AnimalDetailsController aDC=fxmlLoader.getController();
                            aDC.initialize(response.get(rowIndex));
                            Scene scene = new Scene(content);
                            s.setScene(scene);
                            s.showAndWait();
                            System.out.println("Clicked row number: " + rowIndex);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                }

                @Override
                protected void updateItem(Button item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || getIndex() < 0) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        setGraphic(button);
                        setText(null);
                    }
                }
            });
        }

    }