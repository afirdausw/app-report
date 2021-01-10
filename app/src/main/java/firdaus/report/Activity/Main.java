package firdaus.report.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();


        //startActivity(new Intent(getApplicationContext(), Home.class));
        startActivity(new Intent(getApplicationContext(), Signin.class));
    }
}
