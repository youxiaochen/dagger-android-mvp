package chen.you.mvpapp.mvp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import chen.you.lib.base.ToolbarDaggerActivity;
import chen.you.mvpapp.R;
import chen.you.mvpapp.mvp.adapter.ThreeAdapter;

/**
 * Created by You on 2019/1/16.
 */

public class ThreeActivity extends ToolbarDaggerActivity {

    @BindView(R.id.tv_title)
    public TextView tv_title;

    @BindView(R.id.mRecyclerView)
    public RecyclerView mRecyclerView;

    @Inject
    ThreeAdapter adapter;
    @Inject
    LinearLayoutManager manager;

    public static void lanuch(Context context) {
        context.startActivity(new Intent(context, ThreeActivity.class));
    }

    @Override
    protected int getActionBarResId() {
        return R.layout.actionbar_public;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_three;
    }

    @Override
    protected void initViews(View root) {
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {
        tv_title.setText("RecyclerView  Activity可自己再作封闭");


        ArrayList<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");

        adapter.addDatas(list);
    }

    @OnClick(R.id.tv_return)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_return:
                finish();
                break;
        }
    }

}
