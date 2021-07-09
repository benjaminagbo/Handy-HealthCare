package com.example.real.handyhealthcare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class ContactUs extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_hhclogo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.contact);

    }
}
