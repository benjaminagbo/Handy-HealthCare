
package com.example.real.handyhealthcare;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ForgotPassword extends AppCompatActivity{
private EditText userbtn;
private Button confirmbtn1;
//private  userlayoutbtn;
//private InputValidation inputValidation;
private DatabaseHelper dbh;
protected void onCreate(Bundle savedInstanceState){
super.onCreate(savedInstanceState);
    getSupportActionBar().setDisplayShowHomeEnabled(true);
    getSupportActionBar().setLogo(R.drawable.ic_hhclogo);
    getSupportActionBar().setDisplayUseLogoEnabled(true);
setContentView(R.layout.activity_forgotpassword);
userbtn=(EditText)findViewById(R.id.userbtn);
confirmbtn1=(Button)findViewById(R.id.confirmbtn1);
dbh=new DatabaseHelper(this);
//inputValidation=new InputValidation(this);
setTitle("Handy Health Care");
    confirmbtn1.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            verifyFromSQLite();
        }

});
}
private void verifyFromSQLite(){
if(userbtn.getText().toString().isEmpty()){
Toast.makeText(this,"please enter your username",Toast.LENGTH_SHORT).show();
return;
}

if(dbh.checkUser(userbtn.getText().toString().trim())){
Intent i=new Intent(this,ConfirmPassword.class);
i.putExtra("username",userbtn.getText().toString().trim());
emptyInputEditText();
startActivity(i);
}
else{
Toast.makeText(this,"wrong username",Toast.LENGTH_SHORT).show();
}
}
private void emptyInputEditText(){
userbtn.setText("");
}
}