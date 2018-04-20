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
import com.detrening.detrening.R;
import com.detrening.detrening.Tips.TipsTrik;
import com.detrening.detrening.WorkOut;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Beranda extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FirebaseAuth nAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    FirebaseDatabase firebaseInstance;
    DatabaseReference firebaseDatabase;

    TextView infoNama, infoEmail, infoBerat, infoTinggi, infoIdeal;
    ImageView infoFoto;

    public static String emailUser, infoUser;
    FirebaseUser firebaseUser;
    Firebase mRef;

    Button btnTips, btnChat, btnProg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nAuth = FirebaseAuth.getInstance();
        firebaseUser = nAuth.getCurrentUser();

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

        infoFoto = (ImageView) findViewById(R.id.fotoInfo);
        infoNama = (TextView) findViewById(R.id.namaInfo);
        infoEmail = (TextView) findViewById(R.id.emailInfo);
        infoBerat = (TextView) findViewById(R.id.beratInfo);
        infoTinggi = (TextView) findViewById(R.id.tinggiInfo);
        infoIdeal = (TextView) findViewById(R.id.idealInfo);

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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


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
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        switch (item.getItemId()){
            case R.id.nav_editProfile:
                Toast.makeText(Beranda.this, "Edit Profile", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Beranda.this, EditProfile.class);
                startActivity(intent);
                break;

            case  R.id.nav_logOut:
                Toast.makeText(Beranda.this, "Logout", Toast.LENGTH_SHORT).show();
                fungsiLogout();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
