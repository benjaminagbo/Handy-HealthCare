package com.example.real.handyhealthcare;

import android.content.Intent;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.View;

import android.widget.EditText;


import com.gruveo.sdk.Gruveo;

import com.gruveo.sdk.model.CallEndReason;


import java.io.IOException;


import okhttp3.MediaType;

import okhttp3.OkHttpClient;

import okhttp3.Request;

import okhttp3.RequestBody;

import okhttp3.Response;


public class VideoActivity extends AppCompatActivity {
    
private static final int REQUEST_CALL = 1;
    
private static final String SIGNER_URL = "https://api-demo.gruveo.com/signer";

    
@Override
    
protected void onCreate(Bundle savedInstanceState) {
        
super.onCreate(savedInstanceState);
    getSupportActionBar().setDisplayShowHomeEnabled(true);
    getSupportActionBar().setLogo(R.drawable.ic_hhclogo);
    getSupportActionBar().setDisplayUseLogoEnabled(true);
setContentView(R.layout.video_main);

        
findViewById(R.id.main_video_button).setOnClickListener(new View.OnClickListener() {
            
@Override
            
public void onClick(View v) {
                
initCall(true);
            
}
        
});

        
findViewById(R.id.main_voice_button).setOnClickListener(new View.OnClickListener() {
            
@Override
            
public void onClick(View v) {
                
initCall(false);
            
}
        
});
    
}

    
private void initCall(Boolean videoCall) {
        
final Bundle otherExtras = new Bundle();
        
otherExtras.putBoolean(Gruveo.GRV_EXTRA_VIBRATE_IN_CHAT, false);
        
otherExtras.putBoolean(Gruveo.GRV_EXTRA_DISABLE_CHAT, false);

        
final String code = ((EditText) findViewById(R.id.main_edittext)).getText().toString();
        
final String result = new Gruveo.Builder(this)
.callCode(code)
.videoCall(videoCall)
.clientId("demo")
.requestCode(REQUEST_CALL)
.otherExtras(otherExtras)
.eventsListener(eventsListener)
.build();

        
switch (result) {
            
case Gruveo.GRV_INIT_MISSING_CALL_CODE: {
                
break;
            
}
            
case Gruveo.GRV_INIT_INVALID_CALL_CODE: {
                
break;
            
}
            
case Gruveo.GRV_INIT_MISSING_CLIENT_ID: {
                
break;
            
}
            
case Gruveo.GRV_INIT_OFFLINE: {
                
break;
            
}
            
default: {
                
break;
            
}
        
}
    
}

    
private Gruveo.EventsListener eventsListener = new Gruveo.EventsListener() {
        
@Override
        
public void callInit(boolean videoCall, String code) {
        
}

        
@Override
        
public void requestToSignApiAuthToken(String token) {
            
try {
                
Gruveo.Companion.authorize(signToken(token));
            
} 
catch (IOException ignored) {
            
}
        
}

        
@Override
        
public void callEstablished(String code) {
        
}

        
@Override
        
public void callEnd(Intent data, boolean isInForeground) {
            
parseCallExtras(data);
        
}

        
@Override
        
public void recordingStateChanged(boolean us, boolean them) {
        
}

        
@Override
        
public void recordingFilename(String filename) {
        
}
    
};

    
private String signToken(String token) throws IOException {
        
RequestBody body = RequestBody.create(MediaType.parse("text/plain"), token);
        
Request request = new Request.Builder()
.url(SIGNER_URL)
.post(body)
.build();

        
Response response = new OkHttpClient().newCall(request).execute();
        
return response.body().string();
    
}

    
@Override
    
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        
super.onActivityResult(requestCode, resultCode, data);
        
if (requestCode == REQUEST_CALL && resultCode == RESULT_OK && data != null) {
            
parseCallExtras(data);
        
}
    
}

    
private void parseCallExtras(Intent data) {
        
CallEndReason endReason = (CallEndReason) data.getSerializableExtra(Gruveo.GRV_RES_CALL_END_REASON);
        
String callCode = data.getStringExtra(Gruveo.GRV_RES_CALL_CODE);
        
String leftMessageTo = data.getStringExtra(Gruveo.GRV_RES_LEFT_MESSAGE_TO);
        
int duration = data.getIntExtra(Gruveo.GRV_RES_CALL_DURATION, 0);
        
int messagesSent = data.getIntExtra(Gruveo.GRV_RES_MESSAGES_SENT, 0);

        
switch (endReason) {
            
case BUSY: {
                
break;
            
}
            
case HANDLE_BUSY: {
                
break;
            
}
            
case HANDLE_UNREACHABLE: {
                
break;
            
}
            
case HANDLE_NONEXIST: {
                
break;
            
}
            
case FREE_DEMO_ENDED: {
                
break;
            
}
            
case ROOM_LIMIT_REACHED: {
                
break;
            
}
            
case NO_CONNECTION: {
                
break;
            
}
            
case INVALID_CREDENTIALS: {
                
break;
            
}
            
case UNSUPPORTED_PROTOCOL_VERSION: {
                
break;
            
}
            
case OTHER_PARTY: {
                
break;
            
}
            
default: {      
// USER - we hanged up the call
                
break;
            
}
        
}
    
}

}
