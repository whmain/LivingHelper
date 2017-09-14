package com.ahern.livinghelper.recreation.newschannel.ui;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahern.livinghelper.R;
import com.ahern.livinghelper.recreation.newschannel.model.NewsRequestEntity;
import com.bumptech.glide.Glide;
import com.jaeger.library.StatusBarUtil;

import org.sufficientlysecure.htmltextview.HtmlResImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class NewsDetailActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_news_detail)
    Toolbar mToolbar;
    @BindView(R.id.tv_news_detail_title)
    TextView mTitleTv;
    @BindView(R.id.tv_news_detail_src)
    TextView mSrcTv;
    @BindView(R.id.iv_news_detail_picture)
    ImageView mImageIv;
    @BindView(R.id.html_text)
    HtmlTextView mContentHtv;
    @BindView(R.id.tv_news_detail_time)
    TextView mTimeTv;
    private NewsRequestEntity.ResultBeanX.ResultBean.ListBean bean;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        unbinder = ButterKnife.bind(this);
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.color_tabbar_default), 0);
        initView();
        initData();
    }

    public void initView() {
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(mNavigationItemClickListener);
//        去掉默认title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void initData() {
        bean = (NewsRequestEntity.ResultBeanX.ResultBean.ListBean) getIntent().getSerializableExtra("newsEntity");
        mTitleTv.setText(bean.getTitle());
        mSrcTv.setText(bean.getSrc());
        mTimeTv.setText(bean.getTime());
        Glide.with(this).load(bean.getPic()).placeholder(R.mipmap.ic_launcher).into(mImageIv);
        mContentHtv.setHtml(bean.getContent(),new HtmlResImageGetter(mContentHtv));
    }

    /*
  * toolbar的返回按钮监听事件
  * */
    View.OnClickListener mNavigationItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            NewsDetailActivity.this.finish();
        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
