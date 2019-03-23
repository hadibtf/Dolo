package com.android.dreamolo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DesignedDeramsOrMakeYourWishActivity extends AppCompatActivity {
    @BindView(R.id.designed_dreams_btn)
    LinearLayout designedDreamsBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designed_derams_or_make_your_wish);
        ButterKnife.bind(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    @OnClick(R.id.designed_dreams_btn)
    public void gotoChooseDreamActivity() {
        Intent intent = new Intent(this, ChooseDreamActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.make_wish_btn)
    public void gotoMakeWishActivity() {
        Intent intent = new Intent(this, DescribeWishActivity.class);
        startActivity(intent);
    }
}