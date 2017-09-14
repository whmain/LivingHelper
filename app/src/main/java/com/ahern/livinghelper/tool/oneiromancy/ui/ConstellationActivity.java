package com.ahern.livinghelper.tool.oneiromancy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.ahern.livinghelper.R;
import com.ahern.livinghelper.common.utils.JsonUtil;
import com.ahern.livinghelper.common.utils.LogUtil;
import com.ahern.livinghelper.tool.oneiromancy.adapter.DreamListAdapter;
import com.ahern.livinghelper.tool.oneiromancy.model.DreamBriefEntity;
import com.ahern.livinghelper.tool.oneiromancy.model.DreamRequestListEntity;
import com.jaeger.library.StatusBarUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;

public class ConstellationActivity extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.sv_constellation_search)
    SearchView mSearchSv;
    @BindView(R.id.rv_constellation)
    RecyclerView mDreamListRv;
    @BindView(R.id.ll_constellation_fail)
    LinearLayout mConstellationFailLl;
    @BindView(R.id.pb_constellation)
    ProgressBar mConstellationPb;
    private Unbinder unbinder;


    private final static String DREAM_API_KEY = "468ea20f74584b11140e7dfea9cfc952";
    DreamListAdapter mAdapter;
    private String mSearchAntistop = "";//当前搜索的关键词

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constellation);
        unbinder = ButterKnife.bind(this);
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.color_tabbar_default), 0);
        initData();

    }

    private void initData() {
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(mClickListener);
        //        去掉默认title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mSearchSv.setOnQueryTextListener(mQueryTextListener);
        mSearchSv.setSubmitButtonEnabled(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mDreamListRv.setLayoutManager(layoutManager);
        mAdapter = new DreamListAdapter(this);
        mDreamListRv.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(mItemClickListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ConstellationActivity.this.finish();
        }
    };

    SearchView.OnQueryTextListener mQueryTextListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String s) {
            mSearchAntistop = s;
            mConstellationPb.setVisibility(View.VISIBLE);
            mDreamListRv.setVisibility(View.VISIBLE);
            mConstellationFailLl.setVisibility(View.GONE);
            request(s);
            return false;
        }

        @Override
        public boolean onQueryTextChange(String s) {
            return false;
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
                .addParams("full", "0")
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
                        DreamRequestListEntity entity = (DreamRequestListEntity) JsonUtil.stringToObject(response, DreamRequestListEntity.class);
                        List<DreamBriefEntity> list = entity.getResult();
                        if (list != null) {
                            mConstellationPb.setVisibility(View.GONE);
                            mDreamListRv.setVisibility(View.VISIBLE);
                            mConstellationFailLl.setVisibility(View.GONE);
                            LogUtil.d("Dream", "list.size:" + list.size(), true);
                            mAdapter.addData(list, true);
                            mAdapter.notifyDataSetChanged();
                            mDreamListRv.smoothScrollToPosition(0);
                        } else {
                            mConstellationPb.setVisibility(View.GONE);
                            mDreamListRv.setVisibility(View.GONE);
                            mConstellationFailLl.setVisibility(View.VISIBLE);
                        }



                    }
                });
    }


    DreamListAdapter.OnItemClickListener mItemClickListener = new DreamListAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            Intent intent = new Intent(ConstellationActivity.this, DreamDetailActivity.class);
            intent.putExtra("dreamAntistop", mSearchAntistop);
            intent.putExtra("dreamPosition", position + "");
            startActivity(intent);
        }
    };
}
