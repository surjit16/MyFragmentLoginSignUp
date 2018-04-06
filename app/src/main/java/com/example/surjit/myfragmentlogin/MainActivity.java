package com.example.surjit.myfragmentlogin;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;

    public static ArrayList<String> userData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.frame);

        userData.add("Surjit");
        userData.add("1618");

        FragmentManager manager =  getSupportFragmentManager();
        FragmentTransaction transaction =  manager.beginTransaction();
        transaction.replace(R.id.frame, new Login(), "login");
        transaction.commit();
    }

    public void goToLogin(View view) {
        FragmentManager manager =  getSupportFragmentManager();
        FragmentTransaction transaction =  manager.beginTransaction();
        transaction.replace(R.id.frame, new Login(), "login");
        transaction.commit();
    }

    public void goToSignUp(View view) {
        FragmentManager manager =  getSupportFragmentManager();
        FragmentTransaction transaction =  manager.beginTransaction();
        transaction.replace(R.id.frame, new SignUp(), "signUp");
        transaction.commit();
    }
}
