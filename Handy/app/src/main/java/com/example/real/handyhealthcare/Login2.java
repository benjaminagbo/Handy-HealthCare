package com.example.real.handyhealthcare;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class Login2 extends AppCompatActivity {
    TextView registerUser;
    EditText username, password;
    Button loginButton;
    String user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_hhclogo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_login);

        registerUser = findViewById(R.id.register);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login2.this, Register2.class));
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = username.getText().toString();
                pass = password.getText().toString();

                if(user.equals("")){
                    username.setError("can't be blank");
                }
                else if(pass.equals("")){
                    password.setError("can't be blank");
                }
                else{
                    String url = "https://handy-healthcare.firebaseio.com/users.json";
                    final ProgressDialog pd = new ProgressDialog(Login2.this);
                    pd.setMessage("Loading...");
                    pd.show();

                    //StringRequest request = new StringRequest(DownloadManager.Request.Method.GET, url, new Response.Listener<String>(){
                    StringRequest request = new StringRequest(com.android.volley.Request.Method.GET, url,new Response.Listener<String>(){
                        @Override
                        public void onResponse(String s) {
                            if(s.equals("null")){
                                Toast.makeText(Login2.this, "An Error Occurred", Toast.LENGTH_LONG).show();
                            }
                            else{
                                try {
                                    JSONObject obj = new JSONObject(s);
                                    if(!obj.has(user)){
                                        Toast.makeText(Login2.this, "User not Found", Toast.LENGTH_LONG).show();
                                    }
                                    else if(obj.getJSONObject(user).getString("password").equals(pass)){
                                        UserDetails.username = user;
                                        UserDetails.password = pass;
                                        startActivity(new Intent(Login2.this, Users.class));
                                    }
                                    else {
                                        Toast.makeText(Login2.this, "incorrect password", Toast.LENGTH_LONG).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            pd.dismiss();
                        }
                    },new Response.ErrorListener(){
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {
                            System.out.println("" + volleyError);
                            pd.dismiss();
                        }
                    });

                    com.android.volley.RequestQueue rQueue = Volley.newRequestQueue(Login2.this);
                    rQueue.add(request);
                }

            }
        });
    }
}