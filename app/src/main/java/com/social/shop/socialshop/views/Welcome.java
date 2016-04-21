package com.social.shop.socialshop.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Handler;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.social.shop.socialshop.Controllers.UserController;
import com.social.shop.socialshop.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Welcome extends Activity {

    private Context context;
    private UserController userController;

    @Bind(R.id.layout_welcome)LinearLayout layout_welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        setupInstanceFacebook();
        setupContext();
    }

    public void setupContext(){
        setupThreadReveal();
        setupThreadHide();
        context = this;
        userController = new UserController(context);
    }

    public void setupThreadReveal(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                circularReveal();
            }
        }, 1000);
    }

    public void setupThreadHide(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                circularHide();
            }
        }, 5000);
    }

    public void circularReveal(){
        if(Build.VERSION.SDK_INT >= 21){
            int cx = (layout_welcome.getLeft() + layout_welcome.getRight()) / 2;
            int cy = (layout_welcome.getTop() + layout_welcome.getBottom()) / 2;
            int radio = Math.max(layout_welcome.getWidth(), layout_welcome.getHeight());
            Animator animator = ViewAnimationUtils.createCircularReveal(layout_welcome, cx, cy, 0, radio);
            layout_welcome.setVisibility(View.VISIBLE);
            animator.setDuration(1500);
            animator.start();
        } else {
            layout_welcome.setVisibility(View.VISIBLE);
        }
    }

    public void circularHide(){
        if(Build.VERSION.SDK_INT >= 21){
            int cx = (layout_welcome.getLeft() + layout_welcome.getRight()) / 2;
            int cy = (layout_welcome.getTop() + layout_welcome.getBottom()) / 2;
            int radio = layout_welcome.getWidth();
            Animator animator = ViewAnimationUtils.createCircularReveal(layout_welcome, cx, cy, radio, 0);
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    layout_welcome.setVisibility(View.INVISIBLE);
                    next();
                }
            });
            animator.setDuration(1500);
            animator.start();
        } else {
            layout_welcome.setVisibility(View.INVISIBLE);
        }
    }

    public void setupLogin(){
        Intent login = new Intent(Welcome.this, Login.class);
        startActivity(login);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

    public void setupHome(){
        Intent login = new Intent(Welcome.this, Login.class);
        startActivity(login);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

    public void next(){
        boolean sesionActiva = userController.session();
        if(sesionActiva){
            setupHome();
        }else{
            setupLogin();
        }
    }

    public void setupInstanceFacebook(){
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.social.shop.socialshop",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("Inicio(NameNotFoundException): ", e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            Log.d("Inicio(NoSuchAlgorithmException): ", e.getMessage());
        }
    }

}
