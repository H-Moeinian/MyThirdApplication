package com.example.mythirdapplication;


import android.app.Activity;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        Button btnConfirm = findViewById(R.id.btnConfirm);
        Button btnEdit = findViewById(R.id.btnEdit);
        TextView FirstName = findViewById(R.id.txtFirstName);
        TextView Family = findViewById(R.id.txtFamily);
        TextView Phone = findViewById(R.id.txtPhone);
        TextView Age = findViewById(R.id.txtAge);
        TextView Address = findViewById(R.id.txtAddress);




        Intent i = getIntent();

        final String FirstNameString = i.getStringExtra("FirstName");
        FirstName.setText("Name: "+FirstNameString);

        final String FamilyString = i.getStringExtra("Family");
        Family.setText("Family Name: "+FamilyString);

        final String PhoneString = i.getStringExtra("Phone");
        Phone.setText("Phone number: "+PhoneString);

        final String AgeString = i.getStringExtra("Age");
        Age.setText("Age: "+AgeString);

        final String AddressString = i.getStringExtra("Address");
        Address.setText("Address: "+AddressString);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceManager
                        .getDefaultSharedPreferences(com.example.mythirdapplication.ReviewActivity.this)
                        .edit()
                        .putString("First_Name",FirstNameString)
                        .apply();
                PreferenceManager
                        .getDefaultSharedPreferences(com.example.mythirdapplication.ReviewActivity.this)
                        .edit()
                        .putString("_Family",FamilyString)
                        .apply();
                PreferenceManager
                        .getDefaultSharedPreferences(com.example.mythirdapplication.ReviewActivity.this)
                        .edit()
                        .putString("_Phone",PhoneString)
                        .apply();
                PreferenceManager
                        .getDefaultSharedPreferences(com.example.mythirdapplication.ReviewActivity.this)
                        .edit()
                        .putString("_Age",AgeString)
                        .apply();
                PreferenceManager
                        .getDefaultSharedPreferences(com.example.mythirdapplication.ReviewActivity.this)
                        .edit()
                        .putString("_Address",AddressString)
                        .apply();
                Intent j = new Intent();
                j.putExtra("welcome","Your profile data has been saved successfully "+FirstNameString+" !");
                setResult(Activity.RESULT_OK,j);
                finish();
            }
        });

    }
}
