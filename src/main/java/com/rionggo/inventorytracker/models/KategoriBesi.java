package com.rionggo.inventorytracker.models;

public class KategoriBesi {

    final int idKategori;
    final String merek;
    final String jenis;
    final String deskripsi;

    public KategoriBesi(int idKategori, String merek, String jenis, String deskripsi) {
        super();
        this.idKategori = idKategori;
        this.merek = merek;
        this.jenis = jenis;
        this.deskripsi = deskripsi;
    }

    public int getIdKategori() {
        return idKategori;
    }

    public String getMerek() {
        return merek;
    }

    public String getJenis() {
        return jenis;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

}
