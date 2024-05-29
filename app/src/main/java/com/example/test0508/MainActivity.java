package com.example.test0508;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<StuData> stuDataList;
    private StuDataAdapter adapter;

    //建立一個 ActivityResultContract 可以接收 addDataActivity 的資料
    @SuppressLint("NotifyDataSetChanged")
    private ActivityResultLauncher<Intent> activityResultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                Log.d("DDDDD", "onActivityResult: " + result.getResultCode());
                if (result.getResultCode() == 200) {     //addDataActivity
                    Intent data = result.getData();
                    String name = data.getStringExtra("name");
                    String height = data.getStringExtra("height");
                    String url = data.getStringExtra("url");
                    Log.d("DDDDD", "name: " + name + " height: " + height + " url: " + url);
                    stuDataList.add(new StuData(url, name, height));
                    adapter.notifyDataSetChanged();
                    recyclerView.setAdapter(adapter);
                }
                if (result.getResultCode() == 100) {    //UpdateActivity
                    Intent data = result.getData();
                    String name = data.getStringExtra("name");
                    String height = data.getStringExtra("height");
                    String url = data.getStringExtra("url");
                    int position = data.getIntExtra("position", 0);
                    Log.d("DDDDD", "name: " + name + " height: " + height + " url: " + url);
                    stuDataList.set(position,new StuData(url, name, height));
                    adapter.notifyDataSetChanged();
                    recyclerView.setAdapter(adapter);
                }
                Log.d("DDDDD", "onActivityResult: " + stuDataList.size());

            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvMyData);

        stuDataList = new ArrayList<>();

        stuDataList.add(new StuData("John", "https://images2.gamme.com.tw/news2/2015/42/36/p56Zn6Wbj6KW.jpg", "180"));
        stuDataList.add(new StuData("Tom", "https://img.lovepik.com/free-png/20220125/lovepik-corgi-dog-png-image_401706065_wh860.png", "175"));
        stuDataList.add(new StuData("Jerry", "https://images2.gamme.com.tw/news2/2015/42/36/p56Zn6Wbj6KW.jpg", "170"));
        stuDataList.add(new StuData("Mike", "https://img.lovepik.com/free-png/20220125/lovepik-corgi-dog-png-image_401706065_wh860.png", "165"));
        stuDataList.add(new StuData("Jack", "https://images2.gamme.com.tw/news2/2015/42/36/p56Zn6Wbj6KW.jpg", "160"));
        stuDataList.add(new StuData("Rose", "https://img.lovepik.com/free-png/20220125/lovepik-corgi-dog-png-image_401706065_wh860.png", "155"));
        stuDataList.add(new StuData("Lily", "https://images2.gamme.com.tw/news2/2015/42/36/p56Zn6Wbj6KW.jpg", "150"));
        stuDataList.add(new StuData("Lucy", "https://img.lovepik.com/free-png/20220125/lovepik-corgi-dog-png-image_401706065_wh860.png", "145"));
        stuDataList.add(new StuData("Andy", "https://images2.gamme.com.tw/news2/2015/42/36/p56Zn6Wbj6KW.jpg", "140"));
        stuDataList.add(new StuData("Marry", "https://img.lovepik.com/free-png/20220125/lovepik-corgi-dog-png-image_401706065_wh860.png", "135"));
        adapter = new StuDataAdapter(stuDataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setOnItemClickListener(new StuDataAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                StuData stuData = stuDataList.get(position);
                intent.putExtra("name", stuData.getName());
                intent.putExtra("height", stuData.getHeight());
                intent.putExtra("url", stuData.getImageUrl());
                intent.putExtra("position", position);
                Log.d("DDDDD", "onItemClick: " + position);
                Log.d("DDDDD", "onItemClick: " + stuDataList.size());
//                stuDataList.remove(position);
                Log.d("DDDDD", "onItemClick: " + stuDataList.size());
                activityResultLauncher.launch(intent);
            }
        });
    }

    public void addData(View view) {
        Intent intent = new Intent(this, AddDataActivity.class);
//        startActivityForResult(intent, 1);
        activityResultLauncher.launch(intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}