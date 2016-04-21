package com.social.shop.socialshop.views;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.widget.TextView;
import com.social.shop.socialshop.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailRegister extends AppCompatActivity {

    @Bind(R.id.toolbar)Toolbar toolbar;
    @Bind(R.id.lbl_toolbar)TextView lbl_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_register);
        ButterKnife.bind(this);
        setupToolbar();
    }

    public void setupToolbar(){
        setSupportActionBar(toolbar);
        Typeface billabong = Typeface.createFromAsset(getAssets(), "fonts/billabong.ttf");
        lbl_toolbar.setTypeface(billabong);
        lbl_toolbar.setText(getString(R.string.detail_register));
        lbl_toolbar.setTextSize(TypedValue.COMPLEX_UNIT_SP, 27);
    }

}
