package com.example.intentschallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class InputWindow extends AppCompatActivity implements View.OnClickListener
{
    EditText etName, etPhone, etWebsite, etLocation;
    ImageView ivGreen, ivYellow, ivRed;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_window);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etWebsite = findViewById(R.id.etWebsite);
        etLocation = findViewById(R.id.etLocation);

        ivGreen = findViewById(R.id.ivGreen);
        ivYellow = findViewById(R.id.ivYellow);
        ivRed = findViewById(R.id.ivRed);

        ivGreen.setOnClickListener(this);
        ivYellow.setOnClickListener(this);
        ivRed.setOnClickListener(this);

//        ivGreen.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//
//                final String name = etName.getText().toString().trim();
//                final String phone = etPhone.getText().toString().trim();
//                final String website = etWebsite.getText().toString().trim();
//                final String location = etLocation.getText().toString().trim();
//
//                Intent intent_toMainActivity_fromInputWindow = new Intent();
//                final String face_color = "green";
//
//                intent_toMainActivity_fromInputWindow.putExtra("Name of the person", name);
//                intent_toMainActivity_fromInputWindow.putExtra("Phone of the person", phone);
//                intent_toMainActivity_fromInputWindow.putExtra("Website of the person", website);
//                intent_toMainActivity_fromInputWindow.putExtra("Location of the person", location);
//                intent_toMainActivity_fromInputWindow.putExtra("Face Color", face_color);
//
//                setResult(RESULT_OK, intent_toMainActivity_fromInputWindow);
//
//                InputWindow.this.finish();
//            }
//        });
//
//
//        ivYellow.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//
//                final String name = etName.getText().toString().trim();
//                final String phone = etPhone.getText().toString().trim();
//                final String website = etWebsite.getText().toString().trim();
//                final String location = etLocation.getText().toString().trim();
//
//                Intent intent_toMainActivity_fromInputWindow = new Intent();
//                final String face_color = "yellow";
//
//                intent_toMainActivity_fromInputWindow.putExtra("Name of the Person", name);
//                intent_toMainActivity_fromInputWindow.putExtra("Phone of the person", phone);
//                intent_toMainActivity_fromInputWindow.putExtra("Website of the person", website);
//                intent_toMainActivity_fromInputWindow.putExtra("Location of the person", location);
//                intent_toMainActivity_fromInputWindow.putExtra("Face Color", face_color);
//
//                setResult(RESULT_OK, intent_toMainActivity_fromInputWindow);
//
//                InputWindow.this.finish();
//            }
//        });
//
//
//        ivRed.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//
//                final String name = etName.getText().toString().trim();
//                final String phone = etPhone.getText().toString().trim();
//                final String website = etWebsite.getText().toString().trim();
//                final String location = etLocation.getText().toString().trim();
//
//                Intent intent_toMainActivity_fromInputWindow = new Intent();
//                final String face_color = "red";
//
//                intent_toMainActivity_fromInputWindow.putExtra("Name of the Person", name);
//                intent_toMainActivity_fromInputWindow.putExtra("Phone of the person", phone);
//                intent_toMainActivity_fromInputWindow.putExtra("Website of the person", website);
//                intent_toMainActivity_fromInputWindow.putExtra("Location of the person", location);
//                intent_toMainActivity_fromInputWindow.putExtra("Face Color", face_color);
//
//                setResult(RESULT_OK, intent_toMainActivity_fromInputWindow);
//
//                InputWindow.this.finish();
//            }
//        });



    }

    @Override
    public void onClick(View v)
    {
        if (etName.getText().toString().isEmpty() || etPhone.getText().toString().isEmpty() || etWebsite.getText().toString().isEmpty() || etLocation.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent_toMainActivity = new Intent();
            intent_toMainActivity.putExtra("Name of the person", etName.getText().toString().trim());
            intent_toMainActivity.putExtra("Phone of the person", etPhone.getText().toString().trim());
            intent_toMainActivity.putExtra("Location of the person", etLocation.getText().toString().trim());
            intent_toMainActivity.putExtra("Website of the person", etWebsite.getText().toString().trim());

            if (v.getId() == R.id.ivGreen)
                intent_toMainActivity.putExtra("Face Color", "green");

            else if (v.getId() == R.id.ivYellow)
                intent_toMainActivity.putExtra("Face Color", "yellow");

            else if (v.getId() == R.id.ivRed)
                intent_toMainActivity.putExtra("Face Color", "red");

            else
                intent_toMainActivity.putExtra("Face Color", "default");


            setResult(RESULT_OK, intent_toMainActivity);
            InputWindow.this.finish();


        }



    }
}

