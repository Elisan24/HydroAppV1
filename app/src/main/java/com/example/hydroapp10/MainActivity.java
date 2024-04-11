package com.example.hydroapp10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.hydroapp10.R;


public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bnvMenu;
    private Fragment fragment;
    private FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initValues();
        initListener();

        openFragment(Principal.newInstance("param1_value", "param2_value"));
    }

    private void initView(){
        bnvMenu = findViewById(R.id.bnvMenu);
    }
    private void initValues(){
        manager = getSupportFragmentManager();
    }
    private void initListener() {
        bnvMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.house) {
                    fragment = Principal.newInstance("param1_value", "param2_value");
                    openFragment(fragment);
                    return true;
                } else if (item.getItemId() == R.id.graf) {
                    fragment = Grafica.newInstance("param1_value", "param2_value");
                    openFragment(fragment);
                    return true;
                } else if (item.getItemId() == R.id.perf) {
                    fragment = Perfil.newInstance("param1_value", "param2_value");
                    openFragment(fragment);
                    return true;
                }
                return false;
            }
        });
    }


    private void openFragment (Fragment fragment){
        manager.beginTransaction()
                .replace(R.id.frameContainer, fragment)
                .commit();
    }
}