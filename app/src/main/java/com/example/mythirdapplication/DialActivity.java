package com.example.mythirdapplication;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial);
        Button btnCall = findViewById(R.id.btnCall);
        final EditText edtText = findViewById(R.id.edtName);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edtText.getText().toString();
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + s));
                startActivity(i);


            }
        });

    }
}
