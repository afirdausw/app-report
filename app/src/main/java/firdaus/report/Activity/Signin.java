package firdaus.report.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import firdaus.report.R;

public class Signin extends AppCompatActivity {

    Context context;

    Boolean backDouble = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.signin);

        ButterKnife.bind(this);
        context = this;

        getWindow().setStatusBarColor(getResources().getColor(R.color.backgroundDark));
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
    }

    public void onGoogle(View view) {
        startActivity(new Intent(context, Home.class));
    }

    public void onFacebook(View view) {
        startActivity(new Intent(context, Home.class));
    }

    @Override
    public void onBackPressed() {
        if (backDouble) {
            Intent home = new Intent(Intent.ACTION_MAIN);
            home.addCategory(Intent.CATEGORY_HOME);
            home.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(home);
            return;
        }
        this.backDouble = true;
        Toast.makeText(getApplicationContext(), "Tekan kembali untuk keluar dari aplikasi!", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(() -> backDouble = false, 2000);
    }
}
