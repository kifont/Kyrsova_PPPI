package com.example.kyrsova_pppi;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CatalogController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Item, Integer> countColum;

    @FXML
    private TextField countInput;

    @FXML
    private TableColumn<Item, String> descColum;

    @FXML
    private TextField descInput;

    @FXML
    private TableColumn<Item, Integer> idColum;

    @FXML
    private TextField idInput;

    @FXML
    private TableColumn<Item, String> locateColum;

    @FXML
    private TextField locateInput;

    @FXML
    private TableColumn<Item, String> nameColum;

    @FXML
    private TextField nameInput;

    @FXML
    private TextField priceInput;

    @FXML
    private TableColumn<Item, Integer> priceColum;

    @FXML
    private Button removeBtn;

    @FXML
    private Button submitBtn;

    @FXML
    private TableView<Item> tableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColum.setCellValueFactory(new PropertyValueFactory<Item, Integer>("id"));
        nameColum.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        descColum.setCellValueFactory(new PropertyValueFactory<Item, String>("descr"));
        countColum.setCellValueFactory(new PropertyValueFactory<Item, Integer>("count"));
        locateColum.setCellValueFactory(new PropertyValueFactory<Item, String>("locate"));
        priceColum.setCellValueFactory(new PropertyValueFactory<Item, Integer>("price"));


        submitBtn.setOnAction(event -> {
            Item item = new Item(idInput.getText(),
                    String.valueOf(nameInput.getText()),
                    String.valueOf(descInput.getText()),
                    Integer.parseInt(priceInput.getText()),
                    String.valueOf(countInput.getText()),
                    String.valueOf(locateInput.getText()));
            ObservableList<Item> items = tableView.getItems();
            items.add(item);
            tableView.setItems(items);

        });

        removeBtn.setOnAction(event -> {
            int selectedID = tableView.getSelectionModel().getSelectedIndex();
            tableView.getItems().remove(selectedID);
        });
    }

}
