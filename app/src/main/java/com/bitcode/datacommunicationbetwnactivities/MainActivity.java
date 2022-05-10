package com.bitcode.datacommunicationbetwnactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtInfo;
    private EditText edtInfo;
    private Button btnNext;

    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
    }

    private void initListeners() {
        btnNext.setOnClickListener(new BtnNextClickListener());
    }

    private void initViews() {
        txtInfo = findViewById(R.id.txtInfo);
        edtInfo = findViewById(R.id.edtInfo);
        btnNext = findViewById(R.id.btnNext);
    }

    private class BtnNextClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //code to start DataActivity
            Intent intent = new Intent(
                    MainActivity.this,
                    DataActivity.class
            );

            intent.putExtra("info", edtInfo.getText().toString());
            intent.putExtra("code", 101);

            //startActivity(intent);
            startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data == null) {
            return;
        }

        Bundle bundle = data.getExtras();
        result = bundle.getString("result");

        txtInfo.setText(result);
    }
}