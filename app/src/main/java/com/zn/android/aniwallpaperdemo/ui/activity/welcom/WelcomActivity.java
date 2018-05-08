package com.zn.android.aniwallpaperdemo.ui.activity.welcom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.zn.android.aniwallpaperdemo.R;
import com.zn.android.aniwallpaperdemo.WallpaperApplication;
import com.zn.android.aniwallpaperdemo.base.BaseActivity;
import com.zn.android.aniwallpaperdemo.service.AniPaperService;
import com.zn.android.aniwallpaperdemo.ui.main.MainActivity;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class WelcomActivity extends BaseActivity implements WelcomContract.View {

    private int SECOND_DELAY = 2000;

    @Inject
    WelcomPresenter welcomPresenter;

    @BindView(R.id.imageView)
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_welcom);
        ButterKnife.bind(this);
        DaggerWelcomActivityComponent.builder()
                .applicationComponent(WallpaperApplication.getInstance().getApplicationComponent())
                .welcomModle(new WelcomModle(this))
                .build()
                .inject(this);

        initView();
        openService();

    }

    private void openService() {
        Intent intent = new Intent(this,AniPaperService.class);
        startService(intent);
    }

    private void initView() {
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.meizi2)
                .centerCrop();

        Glide.with(this).load(R.drawable.meizi2).apply(options).into(mImageView);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                LoadWebview();
            }
        });

        Observable.timer(SECOND_DELAY, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> gotoMainActivity());
    }

    private void LoadWebview() {

    }

    private void gotoMainActivity() {
        Intent intent = new Intent(WelcomActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void setPresenter(WelcomContract.Presenter presenter) {

    }
}
