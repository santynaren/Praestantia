package com.nagajothy.smazee.praestantia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.support.v7.app.ActionBar;
import android.widget.RelativeLayout;

public class Home_page extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;
    FrameLayout frameLayout;
    RelativeLayout topLevelLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        toolbar = (Toolbar)findViewById(R.id.tool);
        frameLayout =(FrameLayout)findViewById(R.id.container_view);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        topLevelLayout = (RelativeLayout)findViewById(R.id.top_layout);
        if (isFirstTime()) {
            topLevelLayout.setVisibility(View.INVISIBLE);
            frameLayout.setVisibility(View.VISIBLE);
        }
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container_view,new Home_fragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Welcome to Praestantia 2K16");
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home_view:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container_view,new Home_fragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Welcome to Praestantia 2K16");

                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.about:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container_view,new About_ece_fragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("About Our ECE Department");

                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.professors:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container_view,new Teachers_fragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Our Legendary Professors ");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.praestantia:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container_view,new About_praestantia_fragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Feel The Tech");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.events:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container_view,new Events_fragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Events");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.contact:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container_view,new BlankFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Contact Details");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();

                        break;
                    case R.id.register:
                        Uri uri = Uri.parse("http://www.praestantia.in/register"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);

                        break;
                    case R.id.bus_routes:
                        Uri uri1 = Uri.parse("http://sairam.edu.in/wp-content/uploads/2015/06/BUS-ROUTE-DETAILS_FINAL-2.pdf"); // missing 'http://' will cause crashed
                        Intent intent1 = new Intent(Intent.ACTION_VIEW, uri1);
                        startActivity(intent1);

                        break;
                    case R.id.web:
                        Uri uri2 = Uri.parse("http://www.praestantia.in"); // missing 'http://' will cause crashed
                        Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                        startActivity(intent2);

                        break;
                    case R.id.facebook:
                        Uri uri3 = Uri.parse("http://www.facebook.com/praestantia16/"); // missing 'http://' will cause crashed
                        Intent intent3 = new Intent(Intent.ACTION_VIEW, uri3);
                        startActivity(intent3);

                        break;



                }
                return false;
            }
        });
    }
    private boolean isFirstTime()
    {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        boolean ranBefore = preferences.getBoolean("RanBefore", false);
        if (!ranBefore) {

            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("RanBefore", true);
            editor.commit();
            topLevelLayout.setVisibility(View.VISIBLE);
            frameLayout.setVisibility(View.INVISIBLE);
            topLevelLayout.setOnTouchListener(new View.OnTouchListener(){

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    topLevelLayout.setVisibility(View.INVISIBLE);
                    frameLayout.setVisibility(View.VISIBLE);
                    return false;
                }

            });


        }
        return ranBefore;

    }
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
}
