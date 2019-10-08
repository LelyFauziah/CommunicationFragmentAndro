package com.example.communicationfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mFrameLayout;
    FragmentTransaction mFragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFrameLayout = findViewById(R.id.frameLayout);
        moveFragment(new MovieFragment());
    }
    private void moveFragment(Fragment fragment) {
        getSupportFragmentManager().popBackStackImmediate();
        mFragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout,fragment);
        mFragmentTransaction.commit();
    }
}
