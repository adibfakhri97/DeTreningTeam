package com.detrening.detrening.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.detrening.detrening.Authentication.Login;
import com.detrening.detrening.Profil.EditProfile;
import com.detrening.detrening.FreeChatDir.FreeChat;
import com.detrening.detrening.ProfilInfo;
import com.detrening.detrening.R;
import com.detrening.detrening.Tips.TipsTrik;
import com.detrening.detrening.WorkOut;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Beranda extends AppCompatActivity {
    private FirebaseAuth nAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    FirebaseDatabase firebaseInstance;
    DatabaseReference firebaseDatabase;

    TextView infoNama;
    ImageView infoFoto;

    public static String emailUser, infoUser;
    FirebaseUser firebaseUser;
    Firebase mRef;

    Button btnTips, btnChat, btnProg;

    DatabaseReference databaseReference;
    String uID;
    public static final String Database_Path = "DeTrening";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("DeTrening");


        nAuth = FirebaseAuth.getInstance();
        firebaseUser = nAuth.getCurrentUser();
        uID = firebaseUser.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference(Database_Path);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String nama = dataSnapshot.child(uID).child("nama").getValue(String.class);
                String tinggi = dataSnapshot.child(uID).child("tinggi").getValue(String.class);
                String berat = dataSnapshot.child(uID).child("berat").getValue(String.class);
                String email = dataSnapshot.child(uID).child("user").getValue(String.class);

//                infoNama.setText(nama);
//                infoTinggi.setText(tinggi);
//                infoBerat.setText(berat);
//                infoEmail.setText(email);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
        //        infoUser = user.getEmail().toString().trim();
      //          infoEmail.setText(infoUser);

                if (user == null){
                    startActivity(new Intent(Beranda.this, Login.class));
                    finish();
                }
            }
        };


        btnChat = (Button) findViewById(R.id.btnFreeChat);
        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Beranda.this, FreeChat.class);
                startActivity(intent);
            }
        });

        btnTips = (Button) findViewById(R.id.btnTips);
        btnTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Beranda.this, "We apologize for a while, we use the Muscle and Fitness website until our website is done", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Beranda.this, TipsTrik.class);
                startActivity(intent);
            }
        });

        btnProg = (Button) findViewById(R.id.btnProgram);
        btnProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Beranda.this, WorkOut.class);
                startActivity(intent);
            }
        });

//        firebaseInstance = FirebaseDatabase.getInstance();
//        firebaseDatabase = firebaseInstance.getReference("DeTrening");
//
//        firebaseDatabase.child(emailUser).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                AdapterSideBar adapter = dataSnapshot.getValue(AdapterSideBar.class);
//                if (adapter == null){
//                    return;
//                }
//                infoNama.setText(adapter.nama);
//                infoEmail.setText(adapter.email);
//                infoBerat.setText(adapter.berat);
//                infoTinggi.setText(adapter.tinggi);
//
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });


        emailUser = firebaseUser.getEmail().toString();

   //     loadInfo();

    }

    public void loadInfo(){
        mRef = new Firebase("https://console.firebase.google.com/u/0/project/detreningroject/database/detreningroject/data/DeTrening/-L9PjADeC-ekscjjIZsK/nama");
        mRef.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);

                infoNama.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }


    public void fungsiLogout(){
        nAuth.signOut();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.beranda, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.nav_profileInfo:
                Toast.makeText(Beranda.this, "Profile", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(Beranda.this, ProfilInfo.class);
                startActivity(intent2);
                break;
            //            case R.id.nav_reminder:
//                Toast.makeText(Beranda.this, "Set Reminder", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(Beranda.this, SetReminder.class));
//                break;
            case  R.id.nav_logOut:
                Toast.makeText(Beranda.this, "Logout", Toast.LENGTH_SHORT).show();
                fungsiLogout();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume(){
        super.onResume();

    }
    @Override
    protected void onStart(){
        super.onStart();
        nAuth.addAuthStateListener(authStateListener);

    }
    @Override
    protected void onStop(){
        super.onStop();
        if (authStateListener != null){
            nAuth.removeAuthStateListener(authStateListener);
        }

    }
}
