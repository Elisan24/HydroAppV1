package com.example.hydroapp10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivityUser extends AppCompatActivity {

    private BottomNavigationView bnvMenu2;
    private Fragment fragment;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user);
        initView();
        initValues();
        initListener();

        openFragment(PrincipalUser.newInstance("param1_value", "param2_value"));
    }

    private void initView(){
        bnvMenu2 = findViewById(R.id.bnvMenu2);
    }
    private void initValues(){
        manager = getSupportFragmentManager();
    }
    private void initListener() {
        bnvMenu2.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.house1) {
                    fragment = PrincipalUser.newInstance("param1_value", "param2_value");
                    openFragment(fragment);
                    return true;
                } else if (item.getItemId() == R.id.reporte) {
                    fragment = ReporteUser.newInstance("param1_value", "param2_value");
                    openFragment(fragment);
                    return true;
                } else if (item.getItemId() == R.id.perfil) {
                    fragment = PerfilUser.newInstance("param1_value", "param2_value");
                    openFragment(fragment);
                    return true;
                }
                return false;
            }

        });
    }


    private void openFragment (Fragment fragment){
        manager.beginTransaction()
                .replace(R.id.frameContainer2, fragment)
                .commit();
    }
}