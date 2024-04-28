package com.rionggo.inventorytracker.Handlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DashboardHandlers {
    
    @FXML
    private Button btnKategoriBesi;

    @FXML
    private Button btnLaporan;

    @FXML
    private Button btnPelaggan;

    @FXML
    private Button btnPembelianBesi;

    @FXML
    private Button btnPenerimaanBesi;

    @FXML
    private Button btnPenjualanBesi;

    @FXML
    private Button btnStokBesi;

    @FXML
    private Button btnSupplierBesi;

    @FXML
    private Label menuTitleText;

    @FXML
    private void handleClick(ActionEvent event) {
        if (event.getSource() == btnKategoriBesi) {
            menuTitleText.setText("Kategori Besi");
        } else if (event.getSource() == btnLaporan) {
            menuTitleText.setText("Laporan");
        } else if (event.getSource() == btnPelaggan) {
            menuTitleText.setText("Pelanggan");
        } else if (event.getSource() == btnPembelianBesi) {
            menuTitleText.setText("Pembelian Besi");
        } else if (event.getSource() == btnPenerimaanBesi) {
            menuTitleText.setText("Penerimaan Besi");
        } else if (event.getSource() == btnPenjualanBesi) {
            menuTitleText.setText("Penjualan Besi");
        } else if (event.getSource() == btnStokBesi) {
            menuTitleText.setText("Stok Besi");
        } else if (event.getSource() == btnSupplierBesi) {
            menuTitleText.setText("Supplier Besi");
        }
    }
}