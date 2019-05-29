package com.skkuseteam2.eatit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // frame layout에 각 메뉴의 fragment 표시
    private FragmentManager fragmentManager = getSupportFragmentManager();
    // 각 fragment들
    private HomeFragment homeFragment = new HomeFragment();
    private SearchFragment searchFragment = new SearchFragment();
    private MyPageFragment myPageFragment = new MyPageFragment();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    transaction.replace(R.id.contents, homeFragment).commitAllowingStateLoss();
                    return true;
                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                    transaction.replace(R.id.contents, searchFragment).commitAllowingStateLoss();
                    return true;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                    transaction.replace(R.id.contents, myPageFragment).commitAllowingStateLoss();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Register Activity
        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivityForResult(intent, 0);
        //startActivity(intent);

        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        // LinearLayout contents = findViewById(R.id.contents);

        // set initial page
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.contents, homeFragment).commitAllowingStateLoss();

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {

            Toast.makeText(getApplicationContext(), "로그인 완료", Toast.LENGTH_SHORT).show();
            /*
            // 로그인후 실행할 액티비티
            // First Evaluation Activity
            Intent intent = new Intent(getApplicationContext(), initialEvaluation.class);
            startActivity(intent);
            */
        }
    }
}