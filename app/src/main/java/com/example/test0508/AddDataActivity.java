package com.example.test0508;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AddDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        TextView addName = findViewById(R.id.edAddName);
        TextView addHeight = findViewById(R.id.edAddHeight);
        TextView addImageUrl = findViewById(R.id.edAddimageUrl);
        Intent intent = new Intent();
        String name = addName.getText().toString();
        String height = addHeight.getText().toString();
        String imageUrl = addImageUrl.getText().toString();


        public void goBack() {
            intent.putExtra("name", name);
            intent.putExtra("height", height);
            intent.putExtra("imageUrl", imageUrl);
            setResult(RESULT_OK, intent);
            finish();
        }

    }
}