package com.example.mythirdapplication;

import android.app.Activity;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class ProfileActivity extends AppCompatActivity {
    TextView txtWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtWelcome = findViewById(R.id.txtWelcome);
        final EditText edtFirstName = findViewById(R.id.edtFirstName);
        final EditText edtFamily = findViewById(R.id.edtFamily);
        final EditText edtPhone = findViewById(R.id.edtPhone);
        final EditText edtAge = findViewById(R.id.edtAge);
        final EditText edtAddress = findViewById(R.id.edtAddress);
        Button btnReview = findViewById(R.id.btnReview);

        String string = PreferenceManager.getDefaultSharedPreferences(com.example.mythirdapplication.ProfileActivity.this)
                .getString("First_Name","Unknown user, please register!");
        txtWelcome.setText(string);
        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfileActivity.this,ReviewActivity.class);

                String FirstName = edtFirstName.getText().toString();
                String Family = edtFamily.getText().toString();
                String Phone = edtPhone.getText().toString();
                String Age = edtAge.getText().toString();
                String Address = edtAddress.getText().toString();
                i.putExtra("FirstName",FirstName);
                i.putExtra("Family",Family);
                i.putExtra("Phone",Phone);
                i.putExtra("Age",Age);
                i.putExtra("Address",Address);
                startActivityForResult(i,125);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==125)
            if(resultCode== Activity.RESULT_OK){
                String st= data.getStringExtra("welcome");
                txtWelcome.setText(st);

            }
    }
}
