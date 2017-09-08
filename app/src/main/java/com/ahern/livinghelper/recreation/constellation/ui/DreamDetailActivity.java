package com.ahern.livinghelper.recreation.constellation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ahern.livinghelper.R;
import com.ahern.livinghelper.common.utils.JsonUtil;
import com.ahern.livinghelper.recreation.constellation.model.DreamDetailEntity;
import com.ahern.livinghelper.recreation.constellation.model.DreamDetailRequestEntity;
import com.jaeger.library.StatusBarUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;

public class DreamDetailActivity extends AppCompatActivity {
    Unbinder unbinder;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_dream_detail_title)
    TextView mTitleTv;
    @BindView(R.id.tv_dream_detail_content)
    TextView mContentTv;

    private final static String DREAM_API_KEY = "468ea20f74584b11140e7dfea9cfc952";
    @BindView(R.id.pb_dream_detail)
    ProgressBar mProgressBar;
    @BindView(R.id.sv_dream_detail)
    ScrollView mContentSv;
    private String mAntistop = "";
    private String mPosition = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dream_detail);
        unbinder = ButterKnife.bind(this);
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.color_tabbar_default), 0);
        initView();
        request(mAntistop);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


    public void initView() {

        Intent intent = getIntent();
        mAntistop = intent.getStringExtra("dreamAntistop");
        mPosition = intent.getStringExtra("dreamPosition");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(mClickListener);
//                去掉默认title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


    }


    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DreamDetailActivity.this.finish();
        }
    };

    public void request(String antistop) {
        String url = "http://v.juhe.cn/dream/query";
        OkHttpUtils
                .get()
                .url(url)
                .addParams("key", DREAM_API_KEY)
                .addParams("q", antistop)
                .addParams("cid", "")
                .addParams("full", "1")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        DreamDetailRequestEntity entity = (DreamDetailRequestEntity) JsonUtil.stringToObject(response, DreamDetailRequestEntity.class);
                        List<DreamDetailEntity> list = entity.getResult();

                        if (list != null) {
                            DreamDetailEntity dreamDetailEntity = list.get(Integer.parseInt(mPosition));

                            mTitleTv.setText(dreamDetailEntity.getTitle());
                            StringBuilder sb = new StringBuilder();
                            for (int i = 0; i < dreamDetailEntity.getList().size(); i++) {
                                sb.append(i + 1 + "." + dreamDetailEntity.getList().get(i) + "\n\n");
                            }

                            mContentTv.setText(sb);
                        } else {

                        }
                        mProgressBar.setVisibility(View.GONE);
                        mContentSv.setVisibility(View.VISIBLE);

                    }
                });
    }
}
