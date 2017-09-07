package com.ahern.livinghelper.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ahern.livinghelper.R;
import com.ahern.livinghelper.main.adapter.MainPageAdapter;
import com.ahern.livinghelper.recreation.main.ui.RecreationFragment;
import com.ahern.livinghelper.tools.ToolsFragment;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.tabBar)
    BottomNavigationBar mBottomNavigationBar;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        StatusBarUtil.setColor(this, Color.parseColor("#00FFFF"), 0);

        initView();
    }

    private void initView() {

        setSupportActionBar(mToolbar);

        initBottomNavigationBar();
        initViewPager();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    /**
     * 初始化BottomNavigationBar
     */
    private void initBottomNavigationBar() {
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.tabBar);
        mBottomNavigationBar.setTabSelectedListener(mTabSelectedListener);
        mBottomNavigationBar.clearAll();
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_recreation_selected, R.string.tab_title_recreation)
                        .setInactiveIconResource(R.drawable.ic_recreation)
                        .setActiveColorResource(R.color.color_tabbar_default))
                .addItem(new BottomNavigationItem(R.drawable.ic_tools_selected, R.string.tab_title_tools)
                        .setInactiveIconResource(R.drawable.ic_tools)
                        .setActiveColorResource(R.color.color_tabbar_default))
                .initialise();
    }

    public void initViewPager() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecreationFragment());
        fragments.add(new ToolsFragment());

        mViewPager.setAdapter(new MainPageAdapter(getSupportFragmentManager(), fragments));
        mViewPager.addOnPageChangeListener(mPageChangeListener);
    }


    /**
     * BottomNavigationBar bar的选择监听事件
     */
    BottomNavigationBar.OnTabSelectedListener mTabSelectedListener = new BottomNavigationBar.OnTabSelectedListener() {
        @Override
        public void onTabSelected(int position) {
            mViewPager.setCurrentItem(position);
        }

        @Override
        public void onTabUnselected(int position) {

        }

        @Override
        public void onTabReselected(int position) {

        }
    };


    ViewPager.OnPageChangeListener mPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            mBottomNavigationBar.selectTab(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_share:
                Toast.makeText(this, "share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_navigation:
                Toast.makeText(this, "navigation", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}
