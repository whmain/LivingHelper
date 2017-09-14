package com.ahern.livinghelper.recreation.history.ui;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahern.livinghelper.R;
import com.ahern.livinghelper.common.utils.JsonUtil;
import com.ahern.livinghelper.recreation.history.model.HistoryDetailEntity;
import com.ahern.livinghelper.recreation.history.model.HistoryDetailRequestEntity;
import com.bumptech.glide.Glide;
import com.jaeger.library.StatusBarUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;

public class HistoryDetailActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_history_detail)
    Toolbar mToolBar;
    @BindView(R.id.iv_history_detail_pic)
    ImageView mIconIv;
    @BindView(R.id.tv_history_detail_title)
    TextView mTitleTv;
    @BindView(R.id.tv_history_detail_time)
    TextView mTimeTv;
    @BindView(R.id.tv_history_detail_content)
    TextView mContentTv;
    private String mEventId = "";
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);
        unbinder = ButterKnife.bind(this);
        StatusBarUtil.setColor(this, ContextCompat.getColor(this,R.color.color_tabbar_default), 0);
        initData();
    }

    public void initData() {
        Intent intent = getIntent();
        mEventId = intent.getStringExtra("eventId");

        setSupportActionBar(mToolBar);
        mToolBar.setNavigationOnClickListener(mClickListener);
//        去掉默认title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        request(mEventId);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            HistoryDetailActivity.this.finish();
        }
    };

    public String getApiKey() {
        ApplicationInfo appInfo = null;
        try {
            appInfo = this.getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return appInfo.metaData.getString("history_key");
    }

    public void request(String id){
        String url = "http://api.juheapi.com/japi/tohdet";
        OkHttpUtils
                .get()
                .url(url)
                .addParams("v","1")
                .addParams("id", id)
                .addParams("key",getApiKey())
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
                        HistoryDetailRequestEntity result = (HistoryDetailRequestEntity) JsonUtil.stringToObject(response,HistoryDetailRequestEntity.class);
                        List<HistoryDetailEntity> list = result.getResult();
                        Log.d("Detail",list.size()+"------------aaaaa");
                        mTitleTv.setText(list.get(0).getTitle());
                        mTimeTv.setText(String.format("时间:%d-%d-%d",list.get(0).getYear(),list.get(0).getMonth(),list.get(0).getDay()));
                        mContentTv.setText(list.get(0).getContent());
                        Glide.with(HistoryDetailActivity.this).load(list.get(0).getPicUrl()).placeholder(R.mipmap.ic_launcher).into(mIconIv);
                    }
                });
    }
}
