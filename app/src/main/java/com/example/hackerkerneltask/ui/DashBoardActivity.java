package com.example.hackerkerneltask.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.hackerkerneltask.R;
import com.fxn.stash.Stash;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class DashBoardActivity extends AppCompatActivity {

    FrameLayout frame;
    BottomNavigationView bottomnav;
    DrawerLayout drawer;
    NavigationView navigation;
    Toolbar toolbar;
    ImageView icom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        frame =  findViewById(R.id.frame);
        bottomnav =  findViewById(R.id.bottomnav);
        drawer=findViewById(R.id.drawer);
        navigation=findViewById(R.id.navigation);
        toolbar=findViewById(R.id.toolbar);

        icom = toolbar.findViewById(R.id.menu);
        icom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });



        replace(new FeatureArticleFragment());

        bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.home:
                        replace(new FeatureArticleFragment());
                        break;

                    case R.id.allartical:
                        replace(new AllArticalFragment());
                        break;

                    case R.id.third:
                        replace(new ThirdFragment());
                        break;



                }
                return true;
            }
        });

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.home:
                        replace(new FeatureArticleFragment());
                        break;

                    case R.id.allartical:
                        replace(new AllArticalFragment());
                        break;

                    case R.id.video:
                        replace(new VideosFragment());
                        break;

                    case R.id.categories:
                        replace(new CategoriesFragment());
                        break;

                    case R.id.search:
                        replace(new SearchFragment());
                        break;

                    case R.id.profile:
                        replace(new ProfileFragment());
                        break;

                    case R.id.membership:
                        replace(new MembershipFragment());
                        break;


                    case R.id.logout:
                        Stash.clearAll();
                        startActivity(new Intent(DashBoardActivity.this,MainActivity.class));
                        DashBoardActivity.this.onBackPressed();
                        finish();
                        break;

                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

    void replace(Fragment fragment){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame,fragment);
        ft.commit();
    }
}
