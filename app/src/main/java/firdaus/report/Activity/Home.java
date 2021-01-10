package firdaus.report.Activity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import firdaus.report.Adapter.TabAdapter;
import firdaus.report.Fragment.FragmentHome;
import firdaus.report.Fragment.FragmentMessage;
import firdaus.report.Fragment.FragmentReport;
import firdaus.report.Fragment.FragmentUser;
import firdaus.report.R;

public class Home extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.top)
    RelativeLayout wrap;

    @BindView(R.id.iv_profile)
    ImageView ivProfile;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.bottomNav)
    BottomNavigationView bottomNav;

    Context context;

    TabAdapter tabAdapter;

    Boolean backDouble = false;
    int startingPosition = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.home);

        ButterKnife.bind(this);
        context = this;

        getWindow().setStatusBarColor(getResources().getColor(R.color.background));
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        loadFragment(new FragmentHome(), 0);
        bottomNav.setOnNavigationItemSelectedListener(this);

        setData();
    }

    private void setData() {
        CircularProgressDrawable circle = new CircularProgressDrawable(context);
        circle.setStrokeWidth(3f);
        circle.setCenterRadius(15f);
        circle.start();

        tvTitle.setText("Halo Nabila");

        Glide.with(context).load("https://cdn.popbela.com/content-images/post/20170826/wanita-hijab-5-64e569f4aef98abd9b2de8a22c72d04d.jpg")
                .placeholder(circle)
                .into(ivProfile);
    }

    // Bottom menu
    private boolean loadFragment(Fragment fragment, int newPosition) {
        if (fragment != null) {
            if (newPosition == 0) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            }
            if (startingPosition > newPosition) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.left_in, R.anim.right_out)
                        .replace(R.id.container, fragment).commit();
            }
            if (startingPosition < newPosition) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.right_in, R.anim.left_out)
                        .replace(R.id.container, fragment).commit();
            }
            startingPosition = newPosition;
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        int newPosition = 0;
        switch (item.getItemId()) {
            case R.id.item1:
                fragment = new FragmentHome();
                newPosition = 1;
                break;
            case R.id.item2:
                fragment = new FragmentReport();
                newPosition = 2;
                break;
            case R.id.item3:
                fragment = new FragmentMessage();
                newPosition = 3;
                break;
            case R.id.item4:
                fragment = new FragmentUser();
                newPosition = 4;
                break;
        }
        return loadFragment(fragment, newPosition);
    }
}