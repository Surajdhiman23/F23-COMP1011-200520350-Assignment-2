package com.example.advancejavaassignment2;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AnimalDetailsController {

    @FXML
    private Label animalName;

    @FXML
    private Label behaviourTxt;

    @FXML
    private Label biggestThreatTxt;

    @FXML
    private Label colorTxt;

    @FXML
    private Label familyTxt;

    @FXML
    private Label preyText;

    @FXML
    private Label speicesNameTxt;

    @FXML
    private Label topSpeed;

    @FXML
    private Label youngNameTxt;

    @FXML
    public void initialize(Animal animal) {
        this.animalName.setText(animal.getName());
        this.familyTxt.setText(animal.getFamily());
        this.preyText.setText(animal.getPrey());
        this.colorTxt.setText(animal.getColor());
        this.speicesNameTxt.setText(animal.getNoOfSpecies());
        this.youngNameTxt.setText(animal.getNameOfYoung());
        this.topSpeed.setText(animal.getTopSpeed());
    }
    @FXML
    void closeAction(ActionEvent event) {
        Stage stage=(Stage) this.topSpeed.getScene().getWindow();
        stage.close();
    }

}
