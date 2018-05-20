package com.zn.android.aniwallpaperdemo.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.Window;

import com.zn.android.aniwallpaperdemo.DataGenerator;
import com.zn.android.aniwallpaperdemo.R;
import com.zn.android.aniwallpaperdemo.WallpaperApplication;
import com.zn.android.aniwallpaperdemo.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainContract.View{


    @Inject
    MainPresenter mainPresenter;

    @BindView(R.id.bottom_tab_layout)
    TabLayout mBottomTabLayout;

    private Fragment[] mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除标题栏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        DaggerMainActivityComponent.builder()
                .applicationComponent(WallpaperApplication.getInstance().getApplicationComponent())
                .mainModle(new MainModle(this))
                .build();

        ButterKnife.bind(this);
        mFragments = DataGenerator.getFragments("TabLayout Tab");

        initView();
    }



    private void initView() {

//        mBottomTabLayout = findViewById(R.id.bottom_tab_layout);


        mBottomTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                onItemSelected(tab.getPosition());

                for (int i = 0; i < mBottomTabLayout.getTabCount(); i++) {
                    if (i == tab.getPosition()) {
                        mBottomTabLayout.getTabAt(i).setIcon(getResources().getDrawable(DataGenerator.mTabResPressed[i]));
                    } else {
                        mBottomTabLayout.getTabAt(i).setIcon(getResources().getDrawable(DataGenerator.mTabRes[i]));
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mBottomTabLayout.addTab(mBottomTabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.ic_home_selector)).setText(DataGenerator.mTabTitle[0]));
        mBottomTabLayout.addTab(mBottomTabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.ic_img_selector)).setText(DataGenerator.mTabTitle[1]));
        mBottomTabLayout.addTab(mBottomTabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.ic_video_selector)).setText(DataGenerator.mTabTitle[2]));
        mBottomTabLayout.addTab(mBottomTabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.ic_person_selector)).setText(DataGenerator.mTabTitle[3]));
    }

    private void onItemSelected(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = mFragments[0];
                break;
            case 1:
                fragment = mFragments[1];
                break;
            case 2:
                fragment = mFragments[2];
                break;
            case 3:
                fragment = mFragments[3];
                break;

        }

        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container, fragment).commit();
        }
    }



    @Override
    public void setPresenter(Object presenter) {

    }

    @Override
    public Context getMyContext() {
        return this;
    }
}
