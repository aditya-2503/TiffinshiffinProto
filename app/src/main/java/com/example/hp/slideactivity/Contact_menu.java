package com.example.hp.slideactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by HP on 11/26/2016.
 */

public class Contact_menu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cntact_menu);

        Toolbar tb=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        DrawerLayout drw=(DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drw, tb, R.string.drawer_open, R.string.drawer_close);
        drw.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView nvg=(NavigationView)findViewById(R.id.nav_view);
        nvg.setNavigationItemSelectedListener(this);
    }
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.nav_cnt){
            Intent iurt=new Intent(getApplicationContext(),Contact_menu.class);
            startActivity(iurt);


        }




        return true;
    }
}
