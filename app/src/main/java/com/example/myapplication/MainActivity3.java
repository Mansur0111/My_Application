package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity3 extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        bottomNavigationView=findViewById(R.id.bottomnavigationview1);
        getSupportFragmentManager().beginTransaction().replace(R.id.layout1,new BlankFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.item1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.layout1,new BlankFragment()).commit();
                        break;
                    case R.id.item2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.layout1,new BlankFragment2()).commit();
                        break;
                    case R.id.item3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.layout1,new BlankFragment3()).commit();
                        break;
                    case R.id.item4:
                        getSupportFragmentManager().beginTransaction().replace(R.id.layout1,new BlankFragment4()).commit();
                        break;
                }
                return true;
            }
        });
    }
}