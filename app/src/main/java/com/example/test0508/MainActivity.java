package com.example.test0508;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<StuData> stuDataList;

    private StuDataAapter adapter;

    //建立一個ActivityResultContract可以接收addData的資料
    private ActivityResultLauncher<Intent> activityResultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if(result != null){
                    Intent data = result.getData();
                    String name = data.getStringExtra("name");
                    String height = data.getStringExtra("height");
                    String imageUrl = data.getStringExtra("imageUrl");
                    Log.d("DDDDD", "name: " + name + " height: " + height + " imageUrl: " + imageUrl);
                    stuDataList.add(new StuData(name, imageUrl, height));
                    adapter.notifyDataSetChanged();

            };
            });

    public MainActivity() {
    }


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

        StuDataAapter adapter = new StuDataAapter(stuDataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }



    public void addData(View view) {
        Intent intent = new Intent(this, AddDataActivity.class);
        //startActityForResult(intent, 1);
        activityResultLauncher.launch(intent);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
                    if (requestCode == 1 && resultCode == RESULT_OK) {
                        String name = data.getStringExtra("name");
                        String height = data.getStringExtra("height");
                        String url = data.getStringExtra("url");
                        stuDataList.add(new StuData(url, name, height));
                        adapter.notifyDataSetChanged();
        }
    }
}