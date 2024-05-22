package com.example.test0508;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddDataActivity extends AppCompatActivity {

    private TextView addName;
    private TextView addHeight;
    private TextView addImageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        TextView addName = findViewById(R.id.edAddName);
        TextView addHeight = findViewById(R.id.edAddHeight);
        TextView addImageUrl = findViewById(R.id.edAddimageUrl);


    }

    public void goback(View view) {
        Intent intent = getIntent();
        String name = addName.getText().toString();
        String height = addHeight.getText().toString();
        String imageUrl = addImageUrl.getText().toString();



        intent.putExtra("name", name);
        intent.putExtra("height", height);
        intent.putExtra("imageUrl", imageUrl);
        setResult(RESULT_OK, intent);
        finish();
    }
}