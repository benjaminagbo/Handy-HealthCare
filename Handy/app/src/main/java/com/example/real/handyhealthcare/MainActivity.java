package com.example.real.handyhealthcare;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    ImageView login;
    ImageView sympt;
    ImageView doct;
    ImageView services;
    ImageView map_h;
    ImageView chat_d;
    ImageView email_d;
    ImageView video_d;
    ImageView reset_img;
    Button Bloginregister;
    Button send_btn;
    Button doctor;
    Button service;
    Button map;
    Button chat;
    Button email;
    Button video;
    Button resetbtn;
    Button contact_us;


    DatabaseHelper databaseHelper;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
getSupportActionBar().setDisplayShowHomeEnabled(true);
getSupportActionBar().setLogo(R.drawable.ic_hhclogo);
getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

//SET UP THE DATABASE

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        Bloginregister = (Button) findViewById(R.id.bloginregister);
        login=(ImageView)  findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Login.class);

                startActivity(i);
            }
        });

        Bloginregister.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, Login.class);

                startActivity(i);

            }

        });
        sympt=(ImageView)  findViewById(R.id.sympt);
        sympt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, HMainActivity.class);

                startActivity(i);
            }
        });

        send_btn = (Button) findViewById(R.id.send_btn);

        send_btn.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, HMainActivity.class);

                startActivity(i);

            }

        });


        doct=(ImageView)  findViewById(R.id.doct);
        doct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Doctors_available.class);

                startActivity(i);
            }
        });
        doctor = (Button) findViewById(R.id.doctor);

        doctor.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, Doctors_available.class);

                startActivity(i);

            }

        });


       services=(ImageView)  findViewById(R.id.services);
        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Services_offered.class);

                startActivity(i);
            }
        });

service=(Button)findViewById(R.id.service);
service.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Intent i = new Intent(MainActivity.this, Services_offered.class);

        startActivity(i);
    }
});


        map_h=(ImageView)  findViewById(R.id.map_h);
        map_h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MapsActivity.class);

                startActivity(i);
            }
        });
map=(Button)findViewById(R.id.map);
map.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(MainActivity.this,MapsActivity.class);
        startActivity(i);
    }
});




//**********************************//


        reset_img=(ImageView)  findViewById(R.id.reset_img);
        reset_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ForgotPassword.class);

                startActivity(i);
            }
        });
        resetbtn=(Button)findViewById(R.id.resetbtn);
        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,ForgotPassword.class);
                startActivity(i);
            }
        });

//*********************************//


        chat_d=(ImageView)  findViewById(R.id.chat_d);
        chat_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Login2.class);

                startActivity(i);
            }
        });
chat=(Button)findViewById(R.id.chat);
chat.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(MainActivity.this,Login2.class);
        startActivity(i);
    }
});

        email_d=(ImageView)  findViewById(R.id.email_d);
        email_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MailActivity.class);

                startActivity(i);
            }
        });
email=(Button) findViewById(R.id.email);
email.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(MainActivity.this,MailActivity.class);
        startActivity(i);
    }
});


        video_d=(ImageView)  findViewById(R.id.video_d);
        video_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, VideoActivity.class);

                startActivity(i);
            }
        });
video=(Button)findViewById(R.id.video);
video.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(MainActivity.this,VideoActivity.class);
        startActivity(i);
    }
});

        contact_us=(Button)findViewById(R.id.contact_us);
        contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,ContactUs.class);
                startActivity(i);
            }
        });
    }
}

