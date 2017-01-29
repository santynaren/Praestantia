package com.nagajothy.smazee.praestantia;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash_screen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread welcome = new Thread() {
            public void run() {
                try {
                    sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent nexto = new Intent(Splash_screen.this, Home_page.class);
                    startActivity(nexto);
                }
            }
        };
        welcome.start();

    }
}
