package com.detrening.detrening;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class EditProfile extends AppCompatActivity {
    String Storage_Path = "fotoprofile/";
    public static final String Database_Path = "DeTrening";
    EditText namaEdit;
    ImageView fotoView;
    Uri FilePathUri;
    int Image_Request_Code = 7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
    }

    public void pilihFoto(View view) {
    }

    public void fungsiEdit(View view) {
    }
}
