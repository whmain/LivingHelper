package com.ahern.livinghelper.recreation.history.ui;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ahern.livinghelper.R;
import com.ahern.livinghelper.common.utils.JsonUtil;
import com.ahern.livinghelper.common.utils.LogUtil;
import com.ahern.livinghelper.recreation.history.adapter.HistoryListAdapter;
import com.ahern.livinghelper.recreation.history.model.HistoryListEntity;
import com.ahern.livinghelper.recreation.history.model.HistoryRequestDataEntity;
import com.jaeger.library.StatusBarUtil;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;

public class HistoryActivity extends AppCompatActivity {


    @BindView(R.id.toolbar_history)
    Toolbar mToolbarHistory;
    @BindView(R.id.ms_history_month)
    MaterialSpinner mHistoryMonthMs;
    @BindView(R.id.ms_history_day)
    MaterialSpinner mHistoryDayMs;
    @BindView(R.id.rv_history_list)
    RecyclerView mHistoryListRv;
    private Unbinder unbinder;
    private String[] months = {"1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月",};
    private String mHistroyApiKey;
    private String LogTag = "HistoryActivity";
    private boolean mOpenLog = true;
    private int mMonthCurrentPosition = 0;
    private HistoryListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        unbinder = ButterKnife.bind(this);
        StatusBarUtil.setColor(this, Color.parseColor("#00FFFF"), 0);
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public void initData() {
        mHistroyApiKey = getApiKey();
        setSupportActionBar(mToolbarHistory);
        setSpinner();
        initRecyclerView();
    }

    public void initRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mHistoryListRv.setLayoutManager(layoutManager);
        mAdapter = new HistoryListAdapter(this);
        mHistoryListRv.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(mItemClickListener);
    }

    public void setSpinner() {

        mHistoryMonthMs.setItems(months);
        mHistoryMonthMs.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                mHistoryDayMs.setItems(getDays(months[position]));
                mMonthCurrentPosition = position;
            }
        });

        mHistoryDayMs.setItems(getDays(months[0]));
        mHistoryDayMs.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, final int position, long id, String item) {
                request(mMonthCurrentPosition + 1 + "", position + 1 + "");

            }
        });
    }

    public String[] getDays(String month) {

        if (month.equals("2月")) {
            return new String[]{"1日", "2日", "3日", "4日", "5日", "6日", "7日", "8日", "9日", "10日", "11日", "12日", "13日", "14日", "15日", "16日", "17日", "18日", "19日", "20日", "21日", "22日", "23日", "24日", "25日", "26日", "27日", "28日", "29日"};
        }
        return new String[]{"1日", "2日", "3日", "4日", "5日", "6日", "7日", "8日", "9日", "10日", "11日", "12日", "13日", "14日", "15日", "16日", "17日", "18日", "19日", "20日", "21日", "22日", "23日", "24日", "25日", "26日", "27日", "28日", "29日", "30日", "31日"};
    }

    public String getApiKey() {
        ApplicationInfo appInfo = null;
        try {
            appInfo = this.getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return appInfo.metaData.getString("history_key");
    }



    public void request(String month,String day){
        String url = "http://api.juheapi.com/japi/toh";
        OkHttpUtils
                .get()
                .url(url)
                .addParams("key", mHistroyApiKey)
                .addParams("v", "1")
                .addParams("month", month)
                .addParams("day", day)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        LogUtil.d(LogTag,response,mOpenLog);
                        HistoryRequestDataEntity entity = (HistoryRequestDataEntity) JsonUtil.stringToObject(response, HistoryRequestDataEntity.class);
                        List<HistoryListEntity> list = entity.getResult();
                        mAdapter.addData(list,true);
                        mAdapter.notifyDataSetChanged();
                        mHistoryListRv.smoothScrollToPosition(0);
                    }
                });
    }

    HistoryListAdapter.OnItemClickListener mItemClickListener = new HistoryListAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            Intent intent = new Intent(HistoryActivity.this,HistoryDetailActivity.class);
            intent.putExtra("eventId",mAdapter.getListItem(position).getId());
            startActivity(intent);
        }
    };
}
