package com.example.android.trialapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;
    private static final String TAG = MainActivity.class.getCanonicalName();
    private String BRIDGE_KEY = "Secured";
    private ProgressBar mLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mWebView = (WebView)findViewById(R.id.wvLogin);
        mLoading = (ProgressBar) findViewById(R.id.pbLoading);
//        mWebView.loadUrl("file:///android_asset/www/index.html");
        mWebView.loadUrl("file:///android_asset/www/ApplyOnDuty.html");
        WebSettings mWebSettings = mWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new WebAppInterface(this),"Android");


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
//    private class BridgeWCClient extends WebChromeClient {
//        @Override
//        public boolean onJsPrompt(WebView view, String url, String title,
//                                  String message, JsPromptResult result) {
//            if(title.equals(BRIDGE_KEY)){
//                JSONObject commandJSON = null;
//                try{
//                    commandJSON = new JSONObject(message);
//                    processCommand(commandJSON);
//                }
//                catch(JSONException ex){
//                    //Received an invalid json
//                    Log.e(TAG, "Invalid JSON: " + ex.getMessage());
//                    result.confirm();
//                    return true;
//                }
//                result.confirm();
//                return true;
//            }
//            else{
//                return false;
//            }
//        }
//        private void processCommand(JSONObject commandJSON)
//                throws JSONException{
//            String command = commandJSON.getString("method");
//            if("login".equals(command)){
//                int state = commandJSON.getInt("state");
//                if(state == 0){
//                    MainActivity.this.runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            mLoading.setVisibility(View.VISIBLE);
//                        }
//                    });
//                }
//                else if(state == 1){
//                    MainActivity.this.runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            mLoading.setVisibility(View.GONE);
//                        }
//                    });
//                }
//            }
//        }
//    }
}

