package com.ahern.livinghelper.recreation.cookbook.ui;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahern.livinghelper.R;
import com.ahern.livinghelper.common.utils.LogUtil;
import com.ahern.livinghelper.common.view.AdaptHeightRecyclerView;
import com.ahern.livinghelper.common.view.NoScrollLinearLayoutManager;
import com.ahern.livinghelper.recreation.cookbook.adapter.CookProcessAdapter;
import com.ahern.livinghelper.recreation.cookbook.model.CookBookListEntity;
import com.bumptech.glide.Glide;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CookDetailActivity extends AppCompatActivity {


    @BindView(R.id.toolbar_cookbook_detail)
    Toolbar mToolbar;
    @BindView(R.id.iv_cook_detail_pic)
    ImageView mCookPicIv;
    @BindView(R.id.tv_cook_detail_cook_name)
    TextView mCookNameTv;
    @BindView(R.id.tv_cook_detail_peoplenum)
    TextView mPeoplenumTv;
    @BindView(R.id.tv_cook_detail_preparetime)
    TextView mPreparetimeTv;
    @BindView(R.id.tv_cook_detail_cookingtime)
    TextView mCookingtimeTv;
    @BindView(R.id.tv_cook_detail_tag)
    TextView mTagTv;
    @BindView(R.id.tv_cook_detail_content)
    TextView mContentTv;
    @BindView(R.id.tv_cook_detail_main_ingredient)
    TextView mMainIngredientTv;
    @BindView(R.id.tv_cook_detail_burdening)
    TextView mBurdeningTv;
    @BindView(R.id.rv_cook_detail_process)
    AdaptHeightRecyclerView mProcessListRv;
    private CookBookListEntity.ResultBeanX.ResultBean.ListBean mCookDetail;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_detail);
        unbinder = ButterKnife.bind(this);
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.color_tabbar_default), 0);
        initView();
        setData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public void initView() {
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(mNavigationItemClickListener);
//        去掉默认title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void setData() {
        mCookDetail = (CookBookListEntity.ResultBeanX.ResultBean.ListBean) getIntent().getSerializableExtra("cook_detail");
        Glide.with(this).load(mCookDetail.getPic()).placeholder(R.mipmap.ic_launcher).into(mCookPicIv);
        mCookNameTv.setText(mCookDetail.getName());
        mPeoplenumTv.setText(mCookDetail.getPeoplenum());
        mPreparetimeTv.setText(mCookDetail.getPreparetime());
        mCookingtimeTv.setText(mCookDetail.getCookingtime());
        mTagTv.setText(mCookDetail.getTag());
        mContentTv.setText(mCookDetail.getContent().replace("<br />\t<br />","\n").replace("<br /><br />","\n").replace("<br />","\n").replace("&quot","\""));
        setMaterial();
        setCookProcess();
        //强制顶部图片获取焦点，避免每次优先显示RecyclerView内容
        mCookPicIv.setFocusable(true);
    }

    public void setCookProcess(){
        NoScrollLinearLayoutManager layoutManager = new NoScrollLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mProcessListRv.setLayoutManager(layoutManager);
        CookProcessAdapter mAdapter = new CookProcessAdapter(this);
        mProcessListRv.setAdapter(mAdapter);
        mAdapter.addAll(mCookDetail.getProcess());
    }


    /*
   * toolbar的返回按钮监听事件
   * */
    View.OnClickListener mNavigationItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            CookDetailActivity.this.finish();
        }
    };

    public void setMaterial(){
        StringBuilder mainIngredient = new StringBuilder(); //主料
        StringBuilder burdening = new StringBuilder();      //辅料
        for (CookBookListEntity.ResultBeanX.ResultBean.ListBean.MaterialBean bean:mCookDetail.getMaterial()) {
           if (bean.getType().equals("0")){
               //辅料
               burdening.append(bean.getMname()+bean.getAmount()+"；");
           }else if (bean.getType().equals("1")){
               //主料
               mainIngredient.append(bean.getMname()+bean.getAmount()+"；");
           }
        }
        mMainIngredientTv.setText(mainIngredient.substring(0,mainIngredient.length()-1));
        mBurdeningTv.setText(burdening.substring(0,burdening.length()-1));
        LogUtil.d("cookprocess",burdening.substring(0,burdening.length()-1),true);
    }

}
