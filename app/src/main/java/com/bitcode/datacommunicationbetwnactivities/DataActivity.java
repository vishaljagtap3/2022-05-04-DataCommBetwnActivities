package com.bitcode.datacommunicationbetwnactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class DataActivity extends Activity {

    private TextView txtInput;
    private EditText edtResult;
    private Button btnSetAndFinish;

    private String info;
    private int code;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_activity);

        initViews();
        initListeners();

        extractInput();
    }

    private void extractInput() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        info = bundle.getString("info");
        code = bundle.getInt("code");

        txtInput.setText(info + " -- " + code);
    }

    private void initViews() {
        txtInput = findViewById(R.id.txtInput);
        edtResult = findViewById(R.id.edtResult);
        btnSetAndFinish = findViewById(R.id.btnSetAndFinish);
    }

    private void initListeners() {
        btnSetAndFinish.setOnClickListener(new BtnSetAndFinishClickListener());
    }

    private class BtnSetAndFinishClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("result", edtResult.getText().toString());

            setResult(1, resultIntent);

            finish();
        }
    }
}
