package com.example.real.handyhealthcare.Patient;


import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;


import com.example.real.handyhealthcare.R;


public class Confirmed_Appointment extends AppCompatActivity {

    
String username,password,user_type;

    
@Override
    
protected void onCreate(Bundle savedInstanceState) {
        
super.onCreate(savedInstanceState);
    getSupportActionBar().setDisplayShowHomeEnabled(true);
    getSupportActionBar().setLogo(R.drawable.ic_hhclogo);
    getSupportActionBar().setDisplayUseLogoEnabled(true);
        
setContentView(R.layout.confirmed_appointment);

        
Bundle bb = getIntent().getExtras();
        
username = bb.getString("username");
        
password = bb.getString("password");
        
user_type = bb.getString("user_type");
    
}

}
