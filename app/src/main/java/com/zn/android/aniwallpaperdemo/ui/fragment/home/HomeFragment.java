package com.zn.android.aniwallpaperdemo.ui.fragment.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.zn.android.aniwallpaperdemo.R;
import com.zn.android.aniwallpaperdemo.base.BaseFragment;
import com.zn.android.aniwallpaperdemo.entity.ImageEntity;



import org.reactivestreams.Subscription;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends BaseFragment implements HomeFragmentContract.View{

    private static final String ARG_PARAM1 = "param1";

    private static String TAG="HomeFragment";
    @BindView(R.id.image_recycler)
    RecyclerView mRecycleView;
    Unbinder unbinder;
    @BindView(R.id.staggered_swipe_refresh)
    SwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.image_layout)
    LinearLayout imageLayout;

    @Inject
    HomeFragmentPresenter presenter;
    private HomeAdapter adapter;

    private WpImageLoader wpImageLoader;

    private int page =1;

    private StaggeredGridLayoutManager mLayoutManager;
    private String mParam1;


    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(String param1) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
        getImgeList();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        setListener();
        return view;
    }

    private void initView() {
        mRecycleView.setAdapter(new HomeAdapter());
        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecycleView.setLayoutManager(mLayoutManager);

        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent);
        mRefreshLayout.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));

    }


    private void setListener() {
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page=1;

            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void getImgeList() {
//        Observable observable =  wpImageLoader.getGankList().subscribe();

/*        Flowable subscription = wpImageLoader.getGankList().subscribe(
                new Action1<List<ImageEntity.ResultsBean>>() {
            @Override
            public void call(List<ImageEntity> gankEntries) {
                Log.i("FK","gank size:"+gankEntries.size());
                mAdapter.setData(gankEntries);
                mAdapter.notifyDataSetChanged();
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                throwable.printStackTrace();
            }
        });

        addSubscription(subscription;*/
    }

    @Override
    public void setPresenter(Object presenter) {

    }
}
