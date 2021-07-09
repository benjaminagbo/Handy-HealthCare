
package com.example.real.handyhealthcare;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ConfirmPassword extends AppCompatActivity{
private EditText confirmbtn2;
private EditText textInputpass;
private Button resetbtn;
//private  userlayoutbtn;
//private InputValidation inputValidation;
private DatabaseHelper dbh;
String username;
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getSupportActionBar().setDisplayShowHomeEnabled(true);
    getSupportActionBar().setLogo(R.drawable.ic_hhclogo);
    getSupportActionBar().setDisplayUseLogoEnabled(true);
    setContentView(R.layout.activity_confirmpassword);
   // inputValidation = new InputValidation(this);
    dbh = new DatabaseHelper(this);

    confirmbtn2 = (EditText) findViewById(R.id.confirmbtn2);
    textInputpass = (EditText) findViewById(R.id.textInputpass);
    resetbtn = (Button) findViewById(R.id.resetbtn);

    Intent i = getIntent();
    username = i.getStringExtra("username");
    setTitle("Reset Password");

    resetbtn.setOnClickListener(new View.OnClickListener(){
        public void onClick(View view) {
            updatePassword();
        }

    });
    }

    private void updatePassword() {

         String value1=confirmbtn2.getText().toString().trim();
        String value2=textInputpass.getText().toString().trim();
        if(value1.isEmpty()&&value2.isEmpty()){
            Toast.makeText(this,"please fill all fields",Toast.LENGTH_LONG).show();
            return;
        }

        if(!value1.contentEquals(value2)){

            Toast.makeText(this,"password doesn't match!",Toast.LENGTH_LONG).show();
            return;
        }

if(!dbh.checkUser(username)){

Toast.makeText(this,"No Such User",Toast.LENGTH_LONG).show();
return;


        }
        else{

dbh.updatePassword(username,value1);
Toast.makeText(this,"Password Updated Successfully",Toast.LENGTH_LONG).show();
//emptyInputEditText();
Intent i=new Intent(this,Login.class);
finish();

        }
    }
}
//}
