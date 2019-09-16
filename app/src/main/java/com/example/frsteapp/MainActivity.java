package com.example.frsteapp;

import android.app.Activity;
import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView status;
    Button indstillinger;
    Button vejledning;
    Button søg;
    EditText url;
    WebView browser;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        status = findViewById(R.id.status);
        indstillinger = findViewById(R.id.indstillinger);
        vejledning = findViewById(R.id.vejledning);
        browser = findViewById(R.id.browser);
        søg = findViewById(R.id.søgKnap);
        url = findViewById(R.id.URL);

        browser.getSettings().setJavaScriptEnabled(true);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);





        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl("http://www.youtube.dk");

        indstillinger.setOnClickListener(this);
        vejledning.setOnClickListener(this);
        søg.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {

        if (view == indstillinger){
            status.setText("Du trykkede på indstillinger.");
        }

        else if (view == vejledning){
            status.setText("Du trykkede på vejledning.");
        }

        else if (view == søg){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

            browser.loadUrl("http://" + url.getText());

        }


    }

}
