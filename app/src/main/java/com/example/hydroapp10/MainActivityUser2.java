package com.example.hydroapp10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivityUser2 extends AppCompatActivity {
    private BottomNavigationView bnvMenu3;
    private Fragment fragment;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user2);
        initView();
        initValues();
        initListener();

        openFragment(PrincipalUser2.newInstance("param1_value", "param2_value"));
    }
    private void initView(){
        bnvMenu3 = findViewById(R.id.bnvMenu3);
    }
    private void initValues(){
        manager = getSupportFragmentManager();
    }
    private void initListener() {
        bnvMenu3.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.house1) {
                    fragment = PrincipalUser2.newInstance("param1_value", "param2_value");
                    openFragment(fragment);
                    return true;
                } else if (item.getItemId() == R.id.reporte) {
                    fragment = ReporteUser2.newInstance("param1_value", "param2_value");
                    openFragment(fragment);
                    return true;
                } else if (item.getItemId() == R.id.perfil) {
                    fragment = PerfilUser2.newInstance("param1_value", "param2_value");
                    openFragment(fragment);
                    return true;
                }
                return false;
            }

        });
    }


    private void openFragment (Fragment fragment){
        manager.beginTransaction()
                .replace(R.id.frameContainer3, fragment)
                .commit();
    }
}