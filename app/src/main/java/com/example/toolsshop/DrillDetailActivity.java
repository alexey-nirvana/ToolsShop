package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class DrillDetailActivity extends AppCompatActivity {
    TextView textViewInfo;
    TextView textViewOpsisanie;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_detail);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.hide();
        }

        Intent intent = getIntent();

        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("resId")) {
            textViewInfo = findViewById(R.id.textViewScroll);
            textViewInfo.setText(intent.getStringExtra("info"));

            textViewOpsisanie = findViewById(R.id.textViewOPISANIE);
            textViewOpsisanie.setText(intent.getStringExtra("title"));

            imageView = findViewById(R.id.imageViewOneDrill);

            imageView.setImageResource(intent.getIntExtra("resId", -1));
        } else {
            Intent intentBack = new Intent(this, DrillCategoryActivity.class);
            startActivity(intentBack);
            Toast.makeText(this, "Неверный", Toast.LENGTH_SHORT).show();
        }


    }
}