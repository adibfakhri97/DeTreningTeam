package com.detrening.detrening;

/**
 * Created by adibf on 4/6/2018.
 */

public class AdapterProfile {
    private static final AdapterProfile ourInstance = new AdapterProfile();

    public String nama;
    public String tinggi;
    public String berat;

    public String imageURL;
    public String userImage;

    public AdapterProfile() {

    }

    public AdapterProfile(String name, String tinggi, String berat, String url, String user) {

        this.nama = name;
        this.tinggi = tinggi;
        this.berat = berat;
        this.imageURL= url;
        this.userImage = user;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTinggi() {
        return tinggi;
    }

    public void setTinggi(String tinggi) {
        this.tinggi = tinggi;
    }

    public String getBerat() {
        return berat;
    }

    public void setBerat(String berat) {
        this.berat = berat;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

}
