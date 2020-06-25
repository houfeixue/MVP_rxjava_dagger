package com.hopson.mvp;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";
    @BindView(R.id.navigationview)
    NavigationView navigationview;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
//            @Override
//            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
//                Log.e(TAG, "onDrawerSlide: ");
//            }
//
//            @Override
//            public void onDrawerOpened(@NonNull View drawerView) {
//
//            }
//
//            @Override
//            public void onDrawerClosed(@NonNull View drawerView) {
//
//            }
//
//            @Override
//            public void onDrawerStateChanged(int newState) {
//
//            }
//        });


        navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.set: {

                    }
                    break;
                    case R.id.qita: {

                    }
                    break;
                    case R.id.updete: {

                    }
                    break;
                }

                return false;
            }
        });

        toolbar.inflateMenu(R.menu.toolbar_action);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerToggle.syncState();
        
        drawerLayout.addDrawerListener(drawerToggle);




    }


    @OnClick({R.id.navigationview, R.id.drawerLayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.navigationview:
                break;
            case R.id.drawerLayout:
                break;
        }
    }
}
