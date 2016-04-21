package com.social.shop.socialshop.Fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.social.shop.socialshop.R;
import com.social.shop.socialshop.views.DetailRegister;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Creado por Deimer, fecha: 11/04/2016.
 */
public class TabRegister extends Fragment{

    public static TabRegister newInstance(){
        return new TabRegister();
    }

    public TabRegister(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        ButterKnife.bind(this, view);
        //setupContext();
        return view;
    }

    @OnClick(R.id.but_sign_in)
    public void onClickRegister(){
        Intent detail = new Intent(getActivity(), DetailRegister.class);
        startActivity(detail);
    }

}
