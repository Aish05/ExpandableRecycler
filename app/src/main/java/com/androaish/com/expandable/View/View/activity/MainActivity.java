package com.androaish.com.expandable.View.View.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androaish.com.expandable.R;
import com.androaish.com.expandable.View.View.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    private Fragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frag = new MainFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.main,frag)
                .commit();
    }
}
