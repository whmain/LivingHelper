package com.ahern.livinghelper.recreation.newschannel.ui;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ahern.livinghelper.R;
import com.ahern.livinghelper.common.utils.JsonUtil;
import com.ahern.livinghelper.recreation.newschannel.adapter.NewListFragmentAdapter;
import com.ahern.livinghelper.recreation.newschannel.model.ChannelRequestEntity;
import com.ahern.livinghelper.recreation.newschannel.model.NewsListFragmentEntity;
import com.astuetz.PagerSlidingTabStrip;
import com.jaeger.library.StatusBarUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;

public class NewsListActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_news_list)
    Toolbar mToolbar;
    @BindView(R.id.tabs_news_list)
    PagerSlidingTabStrip mNewsListPSTabStrip;
    @BindView(R.id.vp_news_list)
    ViewPager mNewsListVp;
//    @BindView(R.id.ll_news_list_layout)
//    LinearLayout mContentLayout;
//    @BindView(R.id.pb_news_list)
//    ProgressBar mProgressBar;
    private Unbinder unbinder;
    private NewListFragmentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        unbinder = ButterKnife.bind(this);
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.color_tabbar_default), 0);
        initTitle();
        setData();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public void initTitle() {
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(mNavigationItemClickListener);
//        去掉默认title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void setData() {
//        mProgressBar.setVisibility(View.VISIBLE);
//        mContentLayout.setVisibility(View.GONE);
        requestChannel();
    }

    /*
  * toolbar的返回按钮监听事件
  * */
    View.OnClickListener mNavigationItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            NewsListActivity.this.finish();
        }
    };


    public void requestChannel() {
//       接口说明地址 https://wx.jcloud.com/market/datas/31/11073
        String url = "https://way.jd.com/jisuapi/channel";
        OkHttpUtils
                .get()
                .url(url)
                .addParams("appkey", "8ce41956dadc4e4630d78429c222609e")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        if (isFinishing()){
                            return;
                        }

                        ChannelRequestEntity entity = (ChannelRequestEntity) JsonUtil.stringToObject(response, ChannelRequestEntity.class);
                        List<String> titles = entity.getResult().getResult();
                        List<NewsListFragmentEntity> list = new ArrayList<>();
                        for (String title : titles) {
                            list.add(new NewsListFragmentEntity(title, new NewsListFragment()));
                        }
                        mAdapter = new NewListFragmentAdapter(getSupportFragmentManager());
                        mAdapter.addData(list);
                        mNewsListVp.setAdapter(mAdapter);
                        mNewsListPSTabStrip.setViewPager(mNewsListVp);
//                        mProgressBar.setVisibility(View.GONE);
//                        mContentLayout.setVisibility(View.VISIBLE);
                    }
                });
    }


    public String getCurrentSelectedTitle(){
        return mAdapter.getData(mNewsListVp.getCurrentItem()).getTitle();
    }


}
