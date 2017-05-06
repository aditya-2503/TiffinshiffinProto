package com.example.hp.slideactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by HP on 11/26/2016.
 */

public class Knowus extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    public void onCreate(Bundle onsty){
        super.onCreate(onsty);
        setContentView(R.layout.knowus);

        Toolbar tb2=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(tb2);
        DrawerLayout draw=(DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, draw, tb2, R.string.drawer_open, R.string.drawer_close);
        draw.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.nav_cnt){
            Intent iurt=new Intent(getApplicationContext(),Contact_menu.class);
            startActivity(iurt);


        }




        return true;
    }
}
