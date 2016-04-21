package com.social.shop.socialshop.views;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.widget.TextView;
import com.social.shop.socialshop.Adapters.TabPagerAdapter;
import com.social.shop.socialshop.Helpers.Datas;
import com.social.shop.socialshop.R;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;

public class Login extends AppCompatActivity {

    private Context context;

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.lbl_toolbar_app)TextView lbl_toolbar;
    @Bind(R.id.view_pager)ViewPager view_pager;
    @Bind(R.id.tab_layout)TabLayout tab_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setupContext();
    }

    public void setupContext(){
        context = this;
        setupToolbar();
        setupViewPager();
        setupTabView();
    }

    public void setupToolbar(){
        setSupportActionBar(toolbar);
        Typeface billabong = Typeface.createFromAsset(getAssets(), "fonts/billabong.ttf");
        lbl_toolbar.setTypeface(billabong);
        lbl_toolbar.setText(getString(R.string.login_or_register));
        lbl_toolbar.setTextSize(TypedValue.COMPLEX_UNIT_SP, 27);
    }

    public void setupViewPager(){
        Datas data = new Datas();
        List<String> tab_titles = data.tabsLogin();
        int page_count = tab_titles.size();
        view_pager.setAdapter(new TabPagerAdapter(
                getSupportFragmentManager(),
                page_count,
                tab_titles
        ));
    }

    public void setupTabView(){
        tab_layout.setTabMode(TabLayout.MODE_FIXED);
        tab_layout.setupWithViewPager(view_pager);
    }

}
