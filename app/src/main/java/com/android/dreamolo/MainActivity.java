package com.android.dreamolo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.all_dreams_holder)
    RelativeLayout allDreamsHolder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        allDreamsHolder.setOnClickListener((v) -> gotoDesignedDreamsOrMakeWishActivity());
    }

    public void gotoDesignedDreamsOrMakeWishActivity() {
        Intent intent = new Intent(this, DesignedDeramsOrMakeYourWishActivity.class);
        startActivity(intent);
    }
}