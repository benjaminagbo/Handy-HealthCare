package com.example.real.handyhealthcare;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class Welcome extends AsyncTask<String, Void, JSONObject> {
    private Context mContext;
    public Welcome(Context mContext) {
        this.mContext = mContext;
    }
    @Override
    protected JSONObject doInBackground(String... strings) {
        JSONObject jobj=null;
        try {
            String text = "";
            BufferedReader reader = null;
            URL url = new URL("https://young-retreat-26153.herokuapp.com/welcome");
            //URL url = new URL("https://hhcare.herokuapp.com/welcome");
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                // Append server response in string
                sb.append(line + "\n");
            }
            text = sb.toString();
            reader.close();
            jobj = new JSONObject(text);
            return jobj;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    protected void onPostExecute(JSONObject result) {
        // result holds what you return from doInBackground;
        HMainActivity cont = (HMainActivity) mContext;
        cont.ServerWelcome(result);
    }
}

