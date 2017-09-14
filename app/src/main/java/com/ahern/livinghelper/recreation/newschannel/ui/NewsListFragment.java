package com.ahern.livinghelper.recreation.newschannel.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.ahern.livinghelper.R;
import com.ahern.livinghelper.base.BaseFragment;
import com.ahern.livinghelper.common.utils.JsonUtil;
import com.ahern.livinghelper.common.utils.LogUtil;
import com.ahern.livinghelper.recreation.newschannel.OnRcvScrollListener;
import com.ahern.livinghelper.recreation.newschannel.adapter.NewListContentAdapter;
import com.ahern.livinghelper.recreation.newschannel.model.NewsRequestEntity;
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

/**
 * @auther: WangHao on 2017/9/13 10:54
 * @email：Ahern.h.wang@emore-smart.com
 */

public class NewsListFragment extends BaseFragment {

    View mView;
    List<NewsRequestEntity.ResultBeanX.ResultBean.ListBean> list = new ArrayList<>();
    @BindView(R.id.rv_news_list)
    RecyclerView mNewsListRv;
    NewListContentAdapter mAdapter;
    @BindView(R.id.pb_news_fragment)
    ProgressBar mProgressBar;
    @BindView(R.id.srl_news_list_fragment)
    SwipeRefreshLayout mNewsListFragmentSrl;
    private Unbinder unbinder;
    private boolean isLoadingData = false;   //判断上拉加载是否正在进行
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.inflate_news_list_fragment, container, false);
        unbinder = ButterKnife.bind(this, mView);
        initView();
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lazyLoadData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 进行耗时操作
     */
    @Override
    protected void loadData() {
        super.loadData();
        String title = ((NewsListActivity) getActivity()).getCurrentSelectedTitle();
        if (list.size() <= 0) {
            mProgressBar.setVisibility(View.VISIBLE);
            mNewsListFragmentSrl.setVisibility(View.GONE);
            request(title, "20", "0",false);
        } else {
            mProgressBar.setVisibility(View.GONE);
            mNewsListFragmentSrl.setVisibility(View.VISIBLE);
            mNewsListFragmentSrl.setRefreshing(false);
            mAdapter.addData(list, true);
        }


    }

    public void initView() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mNewsListRv.setLayoutManager(layoutManager);
        mAdapter = new NewListContentAdapter(getActivity());
        mAdapter.setOnItemClickListener(mOnItemClickListener);
        mNewsListRv.setAdapter(mAdapter);
        mNewsListRv.addOnScrollListener(mOnScrollListener);

        mNewsListFragmentSrl.setOnRefreshListener(mOnRefreshListener);
        mNewsListFragmentSrl.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light,android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
    }

    SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {

        @Override
        public void onRefresh() {

                request(((NewsListActivity) getActivity()).getCurrentSelectedTitle(),"20","0",false);
        }
    };


    OnRcvScrollListener mOnScrollListener = new OnRcvScrollListener(){
        int currentStart = 20;
        @Override
        public void onBottom() {
            super.onBottom();
            // 到底部自动加载
            if (!isLoadingData){
                LogUtil.d("newslist","currentstart:"+currentStart,true);
                request(((NewsListActivity) getActivity()).getCurrentSelectedTitle(),"20",currentStart+"",true);
                currentStart = currentStart+20;
                isLoadingData = true;
            }
        }
    };

    NewListContentAdapter.OnItemClickListener mOnItemClickListener = new NewListContentAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            Intent intent = new Intent(getActivity(),NewsDetailActivity.class);
            intent.putExtra("newsEntity",mAdapter.getItem(position));
            getActivity().startActivity(intent);
        }
    };

    public void request(String channel, String num, String start,final boolean isPullUp) {
        String url = "https://way.jd.com/jisuapi/get";
        OkHttpUtils
                .get()
                .url(url)
                .addParams("channel", channel)
                .addParams("num", num)
                .addParams("start", start)
                .addParams("appkey", "8ce41956dadc4e4630d78429c222609e")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {


                        try { //当请求数据没有更多新闻时，result会返回"",而不会null,因此需要避免gson解析异常
                            JSONObject result = new JSONObject(response);
                            if (result.getJSONObject("result").getString("result").equals("")) {
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        NewsRequestEntity entity = (NewsRequestEntity) JsonUtil.stringToObject(response, NewsRequestEntity.class);

                        //由于api返回的资源中，有的没有图片url，故将其删除
                        List<NewsRequestEntity.ResultBeanX.ResultBean.ListBean> currentList = new ArrayList<>();
                        for (NewsRequestEntity.ResultBeanX.ResultBean.ListBean bean:entity.getResult().getResult().getList()) {
                            if (!(bean.getPic().equals(""))){
                                currentList.add(bean);
                            }
                        }

                        if (isPullUp){ //判断是否是上拉加载的操作
                            isLoadingData =false;
                        }else {
                            list.clear();
                        }
                        list.addAll(currentList);
                        if (isViewCreated) {

                            mProgressBar.setVisibility(View.GONE);
                            mNewsListFragmentSrl.setVisibility(View.VISIBLE);
                            mNewsListFragmentSrl.setRefreshing(false);
                            if (isPullUp){
                                mAdapter.addData(currentList,false);
                            }else {
                                mAdapter.addData(list, true);
                            }

                        }
                    }
                });
    }
}
