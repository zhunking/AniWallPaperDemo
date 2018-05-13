package com.zn.android.aniwallpaperdemo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zn.android.aniwallpaperdemo.ui.fragment.home.HomeFragment;
import com.zn.android.aniwallpaperdemo.ui.fragment.ImageFragment;
import com.zn.android.aniwallpaperdemo.ui.fragment.ProfileFragment;
import com.zn.android.aniwallpaperdemo.ui.fragment.VideoFragment;

public class DataGenerator {


    public static final int[] mTabRes = new int[]{R.drawable.ic_home_selector, R.drawable.ic_img_selector, R.drawable.ic_video_selector, R.drawable.ic_person_selector};
//    public static final int[] mTabResPressed = new int[]{R.drawable.ic_tab_strip_icon_feed_selected, R.drawable.ic_tab_strip_icon_category_selected, R.drawable.ic_tab_strip_icon_pgc_selected, R.drawable.ic_tab_strip_icon_profile_selected};
    public static final int[] mTabResPressed = new int[]{R.drawable.nav_home_selected, R.drawable.nav_livewp_selected, R.drawable.nav_liveshow_selected, R.drawable.nav_person_selected};
    public static final String[] mTabTitle = new String[]{"首页", "图片", "视频", "我的"};

    public static Fragment[] getFragments(String from) {
        Fragment fragments[] = new Fragment[4];
        fragments[0] = HomeFragment.newInstance(from);
        fragments[1] = ImageFragment.newInstance(from);
        fragments[2] = VideoFragment.newInstance(from);
        fragments[3] = ProfileFragment.newInstance(from);
        return fragments;
    }

    /**
     * 获取Tab 显示的内容
     *
     * @param context
     * @param position
     * @return
     */
    public static View getTabView(Context context, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_tab_content, null);
        ImageView tabIcon = (ImageView) view.findViewById(R.id.tab_content_image);
        tabIcon.setImageResource(DataGenerator.mTabRes[position]);
        TextView tabText = (TextView) view.findViewById(R.id.tab_content_text);
        tabText.setText(mTabTitle[position]);
        return view;
    }

}
