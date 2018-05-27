package com.raka.rplinformatika.datanproject;

/**
 * Created by rakaiqbalsy on 5/28/18.
 */

public class Data {
    private String keterangan;
    private String nama;
    private String pemasukan;

    public Data() {
        this.keterangan = keterangan;
    }

    public Data(String keterangan, String nama, String pemasukan) {
        this.keterangan = keterangan;
        this.nama = nama;
        this.pemasukan = pemasukan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPemasukan() {
        return pemasukan;
    }

    public void setPemasukan(String pemasukan) {
        this.pemasukan = pemasukan;
    }
}
