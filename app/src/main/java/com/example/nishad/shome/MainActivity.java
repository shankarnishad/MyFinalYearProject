package com.example.nishad.shome;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import android.widget.ToggleButton;
import com.firebase.client.Firebase;
import com.firebase.client.core.view.View;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

        Switch s1,s2,s3,s4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // t1=(EditText)findViewById(R.id.editText);
        //t2=(EditText)findViewById(R.id.editText2);
        s1=(Switch) findViewById(R.id.switch1);
        s2=(Switch) findViewById(R.id.switch2);
        s3=(Switch) findViewById(R.id.switch3);
        s4=(Switch) findViewById(R.id.switch4);
        Firebase.setAndroidContext(getApplicationContext());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.main, menu);
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
    //@Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void clk1(android.view.View view){
        boolean checked = ((Switch)view).isChecked();
        if(checked){
            Firebase firebase =new Firebase(Config.url);
            firebase.child("AC").setValue(0);
        }
        else {
            Firebase firebase =new Firebase(Config.url);
            firebase.child("AC").setValue(1);
        }
    }




    public void clk2(android.view.View view){
        boolean checked = ((Switch)view).isChecked();
        if(checked){
            Firebase firebase =new Firebase(Config.url);
            firebase.child("fan").setValue(0);
        }
        else {
            Firebase firebase =new Firebase(Config.url);
            firebase.child("fan").setValue(1);
        }
    }




    public void clk3(android.view.View view){
        boolean checked = ((Switch)view).isChecked();
        if(checked){
            Firebase firebase =new Firebase(Config.url);
            firebase.child("light 1").setValue(0);
        }
        else {
            Firebase firebase =new Firebase(Config.url);
            firebase.child("light 1").setValue(1);
        }
    }


    public void clk4(android.view.View view){
        boolean checked = ((Switch)view).isChecked();
        if(checked){

            Firebase firebase =new Firebase(Config.url);
            firebase.child("light 2").setValue(0);
        }
        else {
            Firebase firebase =new Firebase(Config.url);
            firebase.child("light 2").setValue(1);

        }
    }
}
