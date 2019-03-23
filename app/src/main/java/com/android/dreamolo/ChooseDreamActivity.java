package com.android.dreamolo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChooseDreamActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_dream);
        ButterKnife.bind(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        allDreamsHolder.setOnClickListener((v) -> gotoDesignedDreamsOrMakeWishActivity());
    }

    @OnClick(R.id.filter_btn)
    public void gotoFilterActivity() {
        Intent intent = new Intent(this, FiltersActivity.class);
        startActivity(intent);
    }


    @OnClick(R.id.choose_btn)
    public void gotoDreamDescription() {
        Intent intent = new Intent(this, DreamDescriptionActivity.class);
        startActivity(intent);
    }
}