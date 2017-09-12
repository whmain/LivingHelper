package com.ahern.livinghelper.recreation.cookbook.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.ahern.livinghelper.R;
import com.ahern.livinghelper.common.utils.JsonUtil;
import com.ahern.livinghelper.recreation.cookbook.adapter.CookBookListAdapter;
import com.ahern.livinghelper.recreation.cookbook.model.CookBookClassifyRequestEntity;
import com.ahern.livinghelper.recreation.cookbook.model.CookBookListEntity;
import com.jaeger.library.StatusBarUtil;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;

public class CookBookListActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_cookbook_list)
    Toolbar mToolbar;
    @BindView(R.id.ms_classify_large_cookbook)
    MaterialSpinner mLargeClassifyMs;
    @BindView(R.id.ms_classify_small_cookbook)
    MaterialSpinner mSmallClassifyMs;
    @BindView(R.id.iv_cookbook_search_classify)
    ImageView mSearchClassifyIv;
    @BindView(R.id.et_cookbook_name_search)
    EditText mNameSearchEt;
    @BindView(R.id.iv_cookbook_search_name)
    ImageView mSearchNameIv;
    @BindView(R.id.recycler_cookbook_list)
    RecyclerView mCookListRv;
    //    @BindView(R.id.scrollview_cookbook)
//    ScrollView mMainCookBookSv;
    @BindView(R.id.pb_cookbook_list)
    ProgressBar mCookbookPb;
    @BindView(R.id.activity_cook_book_list)
    RelativeLayout activityCookBookList;
    @BindView(R.id.ll_cookbook)
    LinearLayout mMainCookbookLl;

    private Unbinder unbinder;

    private List<CookBookClassifyRequestEntity.ResultBeanX.ResultBean> mCookBookClassify;
    private int mLastLargeClassifyPosition = 0;
    private int mLastSmallClassifyPosition = 0;
    private CookBookListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_book_list);
        unbinder = ButterKnife.bind(this);
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.color_tabbar_default), 0);
        initData();
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public void initView() {
        mCookbookPb.setVisibility(View.VISIBLE);
        mMainCookbookLl.setVisibility(View.GONE);
    }

    public void initData() {
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(mNavigationItemClickListener);
//        去掉默认title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        requestCookBookClassify();
        setSpinner();

        mSearchClassifyIv.setOnClickListener(mSearchButtonClickListener);
        mSearchNameIv.setOnClickListener(mSearchButtonClickListener);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mCookListRv.setLayoutManager(layoutManager);
        mAdapter = new CookBookListAdapter(this);
        mCookListRv.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(mOnItemClickListener);
    }


    public void setSpinner() {
        mLargeClassifyMs.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                if (mCookBookClassify != null) {
                    String[] smallClassifyNames = new String[mCookBookClassify.get(position).getList().size()];
                    for (int i = 0; i < mCookBookClassify.get(position).getList().size(); i++) {
                        smallClassifyNames[i] = mCookBookClassify.get(position).getList().get(i).getName();
                    }
                    mSmallClassifyMs.setItems(smallClassifyNames);
                    //每次点击主分类，子分类的位置设为0
                    mLastLargeClassifyPosition = position;
                    mLastSmallClassifyPosition = 0;
                }
            }
        });

        mSmallClassifyMs.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                mLastSmallClassifyPosition = position;
            }
        });
    }

    /*
    * toolbar的返回按钮监听事件
    * */
    View.OnClickListener mNavigationItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            CookBookListActivity.this.finish();
        }
    };

    View.OnClickListener mSearchButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mCookbookPb.setVisibility(View.VISIBLE);
            switch (view.getId()) {

                case R.id.iv_cookbook_search_classify:
                    //分类搜索按钮
                    requestcookBookListByClassId(mCookBookClassify.get(mLastLargeClassifyPosition).getList().get(mLastSmallClassifyPosition).getClassid());
                    break;
                case R.id.iv_cookbook_search_name:
                    //菜名搜索按钮
                    requestcookBookListByName(mNameSearchEt.getText().toString().trim());
                    break;
            }
        }
    };

    //item的点击监听事件
    CookBookListAdapter.OnItemClickListener mOnItemClickListener = new CookBookListAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            Intent intent = new Intent(CookBookListActivity.this, CookDetailActivity.class);
            intent.putExtra("cook_detail", mAdapter.getItem(position));
            startActivity(intent);
        }
    };

    public void requestCookBookClassify() {
        String url = "https://way.jd.com/jisuapi/recipe_class";
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

                        CookBookClassifyRequestEntity entity = (CookBookClassifyRequestEntity) JsonUtil.stringToObject(response, CookBookClassifyRequestEntity.class);
                        if (entity.getCode().equals("10000")) {
                            List<CookBookClassifyRequestEntity.ResultBeanX.ResultBean> result = entity.getResult().getResult();
                            if (result != null) {
                                mCookBookClassify = result;
                                String[] largeClassifyNames = new String[mCookBookClassify.size()];
                                String[] smallClassifyNames = new String[mCookBookClassify.get(0).getList().size()];
                                for (int i = 0; i < mCookBookClassify.size(); i++) {
                                    largeClassifyNames[i] = mCookBookClassify.get(i).getName();
                                }
                                for (int j = 0; j < mCookBookClassify.get(0).getList().size(); j++) {
                                    smallClassifyNames[j] = mCookBookClassify.get(0).getList().get(j).getName();
                                }

                                mLargeClassifyMs.setItems(largeClassifyNames);
                                mSmallClassifyMs.setItems(smallClassifyNames);
                            }
                        }

                        mCookbookPb.setVisibility(View.GONE);
                        mMainCookbookLl.setVisibility(View.VISIBLE);
                    }
                });
    }

    public void requestcookBookListByClassId(String classId) {
        //接口：https://wx.jcloud.com/market/datas/18/11072
        String url = "https://way.jd.com/jisuapi/byclass";
        OkHttpUtils
                .get()
                .url(url)
                .addParams("classid", classId)
                .addParams("start", "0")
                .addParams("num", "0")
                .addParams("appkey", "8ce41956dadc4e4630d78429c222609e")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        mCookbookPb.setVisibility(View.GONE);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONObject result = jsonObject.getJSONObject("result");
                            String status = result.getString("status");
                            if (!status.equals("0")) {
                                List<CookBookListEntity.ResultBeanX.ResultBean.ListBean> list = new ArrayList<CookBookListEntity.ResultBeanX.ResultBean.ListBean>();
                                mAdapter.addAll(list);
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        CookBookListEntity entity = (CookBookListEntity) JsonUtil.stringToObject(response, CookBookListEntity.class);
                        if (entity.getCode().equals("10000")) {
                            if (entity.getResult().getResult() != null) {
                                List<CookBookListEntity.ResultBeanX.ResultBean.ListBean> list = entity.getResult().getResult().getList();
                                mAdapter.addAll(list);
                                mCookListRv.smoothScrollToPosition(0);
                            }
                        }
                    }
                });
    }

    public void requestcookBookListByName(String name) {
//接口：https://wx.jcloud.com/market/datas/18/11072
        String url = "https://way.jd.com/jisuapi/search";
        OkHttpUtils
                .get()
                .url(url)
                .addParams("keyword", name)
                .addParams("num", "0")
                .addParams("appkey", "8ce41956dadc4e4630d78429c222609e")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {
                            mCookbookPb.setVisibility(View.GONE);
                            JSONObject jsonObject = new JSONObject(response);
                            JSONObject result = jsonObject.getJSONObject("result");
                            String status = result.getString("status");
                            if (!status.equals("0")) {
                                List<CookBookListEntity.ResultBeanX.ResultBean.ListBean> list = new ArrayList<CookBookListEntity.ResultBeanX.ResultBean.ListBean>();
                                mAdapter.addAll(list);
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        CookBookListEntity entity = (CookBookListEntity) JsonUtil.stringToObject(response, CookBookListEntity.class);
                        if (entity.getCode().equals("10000")) {
                            if (entity.getResult().getResult() != null) {
                                List<CookBookListEntity.ResultBeanX.ResultBean.ListBean> list = entity.getResult().getResult().getList();
                                mAdapter.addAll(list);
                                mCookListRv.smoothScrollToPosition(0);
                            }
                        }
                    }
                });
    }
}
