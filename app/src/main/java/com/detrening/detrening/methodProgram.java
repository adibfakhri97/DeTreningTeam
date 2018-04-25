package com.detrening.detrening;

import java.util.List;

/**
 * Created by adibf on 25/04/2018.
 */

public class methodProgram {
    private int mGif;
    private String namaGerakan;
    private String deskripsiGerakan;

    public methodProgram(int mGif,String namaGerakan,  String deskripsiGerakan){
        this.namaGerakan = namaGerakan;
        this.mGif = mGif;
        this.deskripsiGerakan = deskripsiGerakan;
    }


    public int getmGif() {
        return mGif;
    }

    public String getNamaGerakan() {
        return namaGerakan;
    }

    public String getDeskripsiGerakan() {
        return deskripsiGerakan;
    }
}
