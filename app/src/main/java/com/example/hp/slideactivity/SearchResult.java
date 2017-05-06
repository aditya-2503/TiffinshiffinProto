package com.example.hp.slideactivity;

import android.app.SearchManager;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by HP on 11/24/2016.
 */

public class SearchResult extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{private DrawerLayout drawer;
    public void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.search);
        Intent inti=getIntent();
            handleIntent(inti);
        Toolbar tb=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        setTitle("Tiffinshiffin");
        drawer=(DrawerLayout)findViewById(R.id.drawer_layout1);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, tb, R.string.drawer_open, R.string.drawer_close);
        drawer.setDrawerListener(toggle);
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

        @Override
        protected void onNewIntent(Intent intent) {
            handleIntent(intent);
        }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(this, query, Toast.LENGTH_SHORT).show();
        }
    }

}
