package com.example.intentschallenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    ImageView ivPic;
    TextView tvName;
    ImageView ivPhone, ivWebsite, ivLocation;
    Button btnContact;

    String name, phone, website, location;

    final int TOKEN = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ivPic = findViewById(R.id.ivPic);
        tvName = findViewById(R.id.tvName);
        btnContact = findViewById(R.id.btnContact);
        ivPhone = findViewById(R.id.ivPhone);
        ivWebsite = findViewById(R.id.ivWebsite);
        ivLocation = findViewById(R.id.ivLocation);


        ivPic.setVisibility(View.GONE);
        tvName.setVisibility(View.GONE);
        ivPhone.setVisibility(View.GONE);
        ivWebsite.setVisibility(View.GONE);
        ivLocation.setVisibility(View.GONE);


        btnContact.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent_toInputWindow = new Intent(MainActivity.this, com.example.intentschallenge.InputWindow.class);
                startActivityForResult(intent_toInputWindow, TOKEN);

            }
        });


        ivPhone.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent_phone = new Intent(Intent.ACTION_DIAL, Uri.parse(phone));
                startActivity(intent_phone);
            }
        });


        ivWebsite.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent_Website = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                startActivity(intent_Website);
            }
        });


        ivLocation.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent_Location = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
                startActivity(intent_Location);
            }
        });


    } // end of method onCreate


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TOKEN)
        {
            if (resultCode == RESULT_OK)
            {
                {
                    String face_color = data.getStringExtra("Face Color");

                    switch (face_color)
                    {
                        case "green":
                            ivPic.setImageResource(R.drawable.face_green);
                            break;
                        case "yellow":
                            ivPic.setImageResource(R.drawable.face_yellow);
                            break;
                        case "red":
                            ivPic.setImageResource(R.drawable.face_red);
                            break;
                        default:
                            ivPic.setImageResource(R.drawable.face_default);
                            break;
                    }
                }


                tvName.setText(data.getStringExtra("Name of the person"));

                name = data.getStringExtra("Name of the person");
                phone = "tel:" + data.getStringExtra("Phone of the person");
                website = "http://" + data.getStringExtra("Website of the person");
                location = "geo:0,0?q=" + data.getStringExtra("Location of the person");



                ivPic.setVisibility(View.VISIBLE);
                tvName.setVisibility(View.VISIBLE);
                ivPhone.setVisibility(View.VISIBLE);
                ivWebsite.setVisibility(View.VISIBLE);
                ivLocation.setVisibility(View.VISIBLE);

            }

            if (resultCode == RESULT_CANCELED)
            {
                tvName.setText("No contact entered");
                tvName.setVisibility(View.VISIBLE);
            }
        }







    }// end of method onActivityResult


}//end of class
