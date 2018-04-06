package com.detrening.detrening;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class Beranda extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FirebaseAuth nAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    FirebaseDatabase firebaseInstance;
    DatabaseReference firebaseDatabase;

    TextView infoNama, infoEmail, infoBerat, infoTinggi, infoIdeal;
    ImageView infoFoto;

    public static String emailUser;
    FirebaseUser firebaseUser;
    Firebase mRef;

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
                finish();
                break;
            case R.id.nav_beratBadan:
                Toast.makeText(Beranda.this, "Weight and High", Toast.LENGTH_SHORT).show();
            case  R.id.nav_logOut:
                Toast.makeText(Beranda.this, "Logout", Toast.LENGTH_SHORT).show();
                fungsiLogout();
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
