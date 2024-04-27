package com.rionggo.inventorytracker.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.rionggo.inventorytracker.models.KategoriBesi;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class Dashboard implements Initializable {

    @FXML
    ImageView exit;

    @FXML
    private TableView<KategoriBesi> tableKategori;
    @FXML
    private TableColumn<KategoriBesi, Integer> idKategori;
    @FXML
    private TableColumn<KategoriBesi, String> merek;
    @FXML
    private TableColumn<KategoriBesi, String> jenis;
    @FXML
    private TableColumn<KategoriBesi, String> deskripsi;

    public ObservableList<KategoriBesi> kategoriBesi = FXCollections.observableArrayList(
            new KategoriBesi(20134211, "Krakatau Steel", "Besi", "Besi yang dihasilkan oleh PT Krakatau Steel"),
            new KategoriBesi(20134212, "Gunung Garuda", "Besi", "Besi yang dihasilkan oleh PT Gunung Garuda"),
            new KategoriBesi(20134213, "Gunung Raja Paksi", "Besi", "Besi yang dihasilkan oleh PT Gunung Raja Paksi"));

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        idKategori.setCellValueFactory(new PropertyValueFactory<KategoriBesi, Integer>("idKategori"));
        merek.setCellValueFactory(new PropertyValueFactory<KategoriBesi, String>("merek"));
        jenis.setCellValueFactory(new PropertyValueFactory<KategoriBesi, String>("jenis"));
        deskripsi.setCellValueFactory(new PropertyValueFactory<KategoriBesi, String>("deskripsi"));

        tableKategori.setItems(kategoriBesi);
    }

    @FXML
    private void exitButton() throws IOException {
        System.exit(0);
    }
}