package com.example.hp.slideactivity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener{
    private ViewPager mPager;
    private String []arr={"Order Now","My Account","Refer& Earn","My Wallet","My Cart"};
    private DrawerLayout drawer;
    private ListView lst;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle="Home";
    private CharSequence mTitle="Hello";
    private Button btn1;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;
    Timer t;
    int position=0;
    ArrayAdapter addp;
Button []btn=new Button[6];
    Button bknow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

               Toolbar tb=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        pageSwitcher(5);
        setTitle("Tiffinshiffin");
        drawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, tb, R.string.drawer_open, R.string.drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView)findViewById(R.id.search);

        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        Dbhandl db=new Dbhandl(this);
        db.addMenu(new Schemadb(1,"Sandwich","Rice+Onion Cuury","Roti+Kheer"));
        db.addMenu(new Schemadb(2,"Chowmein","Rice+Panner Cuury","Roti+Kheer1"));
        db.addMenu(new Schemadb(3,"Pasta","Rice+Soyabean Cuury","Roti+Kheer1"));
        db.addMenu(new Schemadb(4,"Parantha","Rice+Onion Cuury","Roti+Kheer1"));
        db.addMenu(new Schemadb(5,"Paav-Bhaaji","Rice+Onion Cuury","Roti+Kheer1"));
        db.addMenu(new Schemadb(6,"Cutlet","Rice+Onion Cuury","Roti+Kheer1"));
        btn[0]=(Button) findViewById(R.id.img1);
        btn[1]=(Button) findViewById(R.id.img2);
        btn[2]=(Button) findViewById(R.id.img3);
        btn[3]=(Button) findViewById(R.id.img4);
        btn[4]=(Button) findViewById(R.id.img5);
        btn[5]=(Button) findViewById(R.id.img6);
        btn[0].setOnClickListener(this);
        btn[1].setOnClickListener(this);
        btn[2].setOnClickListener(this);
        btn[3].setOnClickListener(this);
        btn[4].setOnClickListener(this);
        btn[5].setOnClickListener(this);
        bknow=(Button)findViewById(R.id.btn1);
        bknow.setOnClickListener(this);


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
        /*getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);*/




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
if(item.getItemId()==R.id.nav_cnt){
    Intent iurt=new Intent(getApplicationContext(),Contact_menu.class);
    startActivity(iurt);


        }




        return true;
    }

    @Override
    public void onClick(View view) {
int ide=view.getId();
        if(ide==R.id.btn1)
        {
Intent knowus=new Intent(getApplicationContext(),Knowus.class);
            startActivity(knowus);
        }
        else{
        Intent menui=new Intent(getApplicationContext(),Menupull.class);
        switch (ide){
            case R.id.img1:{

                menui.putExtra("Mon",1);
                break;
            }
            case R.id.img2:{

                menui.putExtra("Mon",2);
                break;
            }
            case R.id.img3:{

                menui.putExtra("Mon",3);
                break;
            }
            case R.id.img4:{

                menui.putExtra("Mon",4);
                break;
            }
            case R.id.img5:{

                menui.putExtra("Mon",5);
                break;
            }
            case R.id.img6:{

                menui.putExtra("Mon",6);
                break;
            }
                }
        startService(menui);}



    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if(position==0)
            return new MainActivityFragment();
            else
            if(position==1)
                return new Fragment2();
            else
                if(position==2)
                    return  new Fragment3();
            else
                    return  new Fragment4();

        }

        @Override
        public int getCount() {
            return 4;
        }
    }

    public void pageSwitcher(int seconds) {
        t = new Timer(); // At this line a new Thread will be created
        t.scheduleAtFixedRate(new RemindTask(), 0, seconds * 1000); // delay
        // in
        // milliseconds
    }

    // this is an inner class...
    class RemindTask extends TimerTask {

        @Override
        public void run() {

            // As the TimerTask run on a seprate thread from UI thread we have
            // to call runOnUiThread to do work on UI thread.
            runOnUiThread(new Runnable() {
                public void run() {

                    if (position > 3) { // In my case the number of pages are 5
                        position=0;
                        // Showing a toast for just testing purpose

                    } else {
                        mPager.setCurrentItem(position++);
                    }
                }
            });

        }
    }
}
