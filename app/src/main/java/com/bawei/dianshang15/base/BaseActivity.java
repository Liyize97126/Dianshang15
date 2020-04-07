package com.bawei.dianshang15.base;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.dianshang15.R;
import com.google.gson.Gson;
import com.umeng.analytics.MobclickAgent;

public abstract class BaseActivity extends AppCompatActivity {
    //定义
    private BasePresenter basePresenter;
    private ActionBar actionBar;
    private static final Gson GSON = new Gson();
    public static Gson getGson() {
        return GSON;
    }
    //创建视图
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        actionBar = getSupportActionBar();
        actionBar.setTitle(getAppTitle());
        basePresenter = initPresenter();
        initView();
    }
    //释放
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(basePresenter != null){
            basePresenter.destroy();
            basePresenter = null;
        }
    }
    //友盟统计
    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
    //返回按钮
    public void isShowBack(boolean isShowBack){
        actionBar.setDisplayHomeAsUpEnabled(isShowBack);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home: {
                finish();
                return true;
            }
            case R.id.refreshgo: {
                getRefreshGo();
                return true;
            }
            default:{
                return true;
            }
        }
    }
    //方法封装
    protected abstract int getLayoutId();
    protected abstract BasePresenter initPresenter();
    protected abstract void initView();
    protected abstract String getAppTitle();
    protected void getRefreshGo(){
    }
}
