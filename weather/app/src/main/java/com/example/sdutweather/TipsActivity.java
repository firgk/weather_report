package com.example.sdutweather;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;

import com.example.sdutweather.adapter.TipsAdapter;
import com.example.sdutweather.bean.DayWeatherBean;

public class TipsActivity extends AppCompatActivity {

    private RecyclerView rlvTips;
    private TipsAdapter mTipsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        rlvTips = findViewById(R.id.rlv_tips);

        Intent intent = getIntent();
        DayWeatherBean weatherBean = (DayWeatherBean) intent.getSerializableExtra("tips");
        if (weatherBean == null) return;  // 如果数据为空就不会进行下面的渲染

        mTipsAdapter = new TipsAdapter(this, weatherBean.getTipsBean());

        rlvTips.setAdapter(mTipsAdapter);
        rlvTips.setLayoutManager(new LinearLayoutManager(this));

    }
}