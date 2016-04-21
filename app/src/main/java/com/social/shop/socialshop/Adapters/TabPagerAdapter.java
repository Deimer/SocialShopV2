package com.social.shop.socialshop.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.social.shop.socialshop.Fragments.TabLogin;
import com.social.shop.socialshop.Fragments.TabRegister;
import java.util.List;

/**
 * Creado por Deimer, fecha: 11/04/2016.
 */
public class TabPagerAdapter extends FragmentPagerAdapter {

    private int page_count;
    private List<String> tab_titles;

    public TabPagerAdapter(FragmentManager fm, int pages, List<String> tabs) {
        super(fm);
        this.page_count = pages;
        this.tab_titles = tabs;
    }

    @Override
    public int getCount() {
        return page_count;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = null;
        String provider = tab_titles.get(position);
        switch (provider){
            case "Login":
                f = TabLogin.newInstance();
                break;
            case "Register":
                f = TabRegister.newInstance();
                break;
        }
        return f;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tab_titles.get(position);
    }

}
