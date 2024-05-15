package com.example.test0508;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rvMyData);

        List<StuData> stuDataList = new ArrayList<>();
        stuDataList.add(new StuData("John", "https://pic5.sucaisucai.com/12/45/12045875_2.jpg", "180"));
        stuDataList.add(new StuData("Tom", "https://thumb.ac-illust.com/a4/a4cef20734d25cce8ab60237cb709d31_t.jpeg", "175"));
        stuDataList.add(new StuData("Jerry", "https://pic5.sucaisucai.com/12/45/12045875_2.jpg", "170"));
        stuDataList.add(new StuData("Mike", "https://thumb.ac-illust.com/a4/a4cef20734d25cce8ab60237cb709d31_t.jpeg", "165"));
        stuDataList.add(new StuData("Jack", "https://pic5.sucaisucai.com/12/45/12045875_2.jpg", "160"));
        stuDataList.add(new StuData("Rose", "https://thumb.ac-illust.com/a4/a4cef20734d25cce8ab60237cb709d31_t.jpeg", "155"));
        stuDataList.add(new StuData("Lily", "https://pic5.sucaisucai.com/12/45/12045875_2.jpg", "150"));
        stuDataList.add(new StuData("Lucy", "https://thumb.ac-illust.com/a4/a4cef20734d25cce8ab60237cb709d31_t.jpeg", "145"));
        stuDataList.add(new StuData("Linda", "https://pic5.sucaisucai.com/12/45/12045875_2.jpg", "140"));
        stuDataList.add(new StuData("Marry", "https://thumb.ac-illust.com/a4/a4cef20734d25cce8ab60237cb709d31_t.jpeg", "135"));
        recyclerView.setAdapter(new StuDataAapter(stuDataList));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}