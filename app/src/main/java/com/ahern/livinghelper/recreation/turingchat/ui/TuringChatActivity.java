package com.ahern.livinghelper.recreation.turingchat.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.ahern.livinghelper.R;
import com.ahern.livinghelper.common.utils.JsonUtil;
import com.ahern.livinghelper.common.utils.LogUtil;
import com.ahern.livinghelper.recreation.turingchat.adapter.ChatAdapter;
import com.ahern.livinghelper.recreation.turingchat.model.ChatModel;
import com.ahern.livinghelper.recreation.turingchat.model.ItemModel;
import com.ahern.livinghelper.recreation.turingchat.model.TuringRequestDataEntity;
import com.jaeger.library.StatusBarUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;

public class TuringChatActivity extends AppCompatActivity {

    @BindView(R.id.rv_turing_chat_information)
    RecyclerView mChatListRv;
    @BindView(R.id.et_turing_chat_edit_content)
    EditText mSendContentEt;
    @BindView(R.id.tv_turing_chat_Send)
    TextView mSendButtonTv;
    @BindView(R.id.toolbar_turing)
    Toolbar mToolbar;

    private Unbinder unbinder;
    private ChatAdapter adapter;
//    private String content;
    private String mDeviceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turing_chat);
        unbinder = ButterKnife.bind(this);
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.color_tabbar_default), 0);
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


    public void initData() {
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(mClickBackListener);
//                去掉默认title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mDeviceId = getDeviceId();
        mChatListRv.setHasFixedSize(true);
        mChatListRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mChatListRv.setAdapter(adapter = new ChatAdapter());

        mSendContentEt.addTextChangedListener(mTextWatcher);

        mSendButtonTv.setOnClickListener(mClickListener);

        adapter.setURLClickListener(mOnURLClickListener);
    }

    TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
//            content = editable.toString().trim();
        }
    };

    View.OnClickListener mClickBackListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TuringChatActivity.this.finish();
        }
    };

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @TargetApi(Build.VERSION_CODES.M)
        @Override
        public void onClick(View view) {
            String sendMessage=mSendContentEt.getText().toString().trim();

            ArrayList<ItemModel> data = new ArrayList<>();
            ChatModel model = new ChatModel();
            model.setContent(sendMessage);
            data.add(new ItemModel(ItemModel.CHAT_B, model));
            adapter.addAll(data);
            mSendContentEt.setText("");
            hideKeyBorad(mSendContentEt);
            mChatListRv.smoothScrollToPosition(adapter.getItemCount());

            request(sendMessage);
        }
    };

    private void hideKeyBorad(View v) {
        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
        }
    }

    private String getDeviceId() {
        TelephonyManager TelephonyMgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        String szImei = TelephonyMgr.getDeviceId();
        return szImei;
    }

    public void request(String sendMessageByB) {
//       接口说明地址 https://wx.jcloud.com/market/datas/18/10659
        LogUtil.d("Turing",sendMessageByB,true);
        String url = "https://way.jd.com/turing/turing";


            OkHttpUtils
                    .get()
                    .url(url)
                    .addParams("info",sendMessageByB)
                    .addParams("loc", "")
                    .addParams("userid", "222")  //
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
                            TuringRequestDataEntity entity = (TuringRequestDataEntity) JsonUtil.stringToObject(response, TuringRequestDataEntity.class);
                            switch (Integer.parseInt(entity.getCode())) {
                                case 10000:
                                    //请求成功
                                    ArrayList<ItemModel> data = new ArrayList<>();
                                    ChatModel model = new ChatModel();
                                    model.setContent(entity.getResult().getText());
                                    model.setUrl(entity.getResult().getUrl());
                                    data.add(new ItemModel(ItemModel.CHAT_A, model));
                                    adapter.addAll(data);
                                    mChatListRv.smoothScrollToPosition(adapter.getItemCount());
                                    break;
                                case 10040:
                                    //超过每天限量，请明天继续
                                    //请求成功
                                    ArrayList<ItemModel> data2 = new ArrayList<>();
                                    ChatModel model2 = new ChatModel();
                                    model2.setContent("亲,小图今天和您聊天很长时间了,要去休息了,明天再聊(｀・ω・´)");
                                    data2.add(new ItemModel(ItemModel.CHAT_A, model2));
                                    adapter.addAll(data2);
                                    mChatListRv.smoothScrollToPosition(adapter.getItemCount());
                                    break;
                            }

                        }
                    });

    }


    ChatAdapter.OnURLClickListener mOnURLClickListener = new ChatAdapter.OnURLClickListener() {
        @Override
        public void onURLClick(String url) {

//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//            startActivity(intent);

            Intent intent = new Intent(TuringChatActivity.this, ChatWebActivity.class);
            intent.putExtra("url", url);
            startActivity(intent);
        }
    };
}
