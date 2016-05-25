package com.helloworld.kenneth.androidinterview;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class FrontPage extends AppCompatActivity implements View.OnClickListener {
    Button bsimple, btough, bsee, brate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_page);
//      CODES TO ADD ACTION BAR
        LinearLayout front_ll = (LinearLayout)findViewById(R.id.front_page_title_bar);
//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.front_page_title_bar);
        bsimple =  (Button)findViewById(R.id.bsq);
        btough  =  (Button)findViewById(R.id.btq);
        bsee    =  (Button)findViewById(R.id.bsee);
        brate   =  (Button)findViewById(R.id.brate);

        bsimple.setOnClickListener(this);
        btough.setOnClickListener(this);
        bsee.setOnClickListener(this);
        brate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.bsq:
                Intent simple = new Intent(FrontPage.this, Simple_question.class);
                startActivity(simple);
                break;
            case R.id.btq:
                Intent tough = new Intent(FrontPage.this, Tough_questions.class);
                startActivity(tough);
                break;
            case R.id.bsee:
//                Intent see = new Intent(FrontPage.this, See_our_other_apps.class);
//                startActivity(see);
                break;
            case R.id.brate:
//                Intent rate = new Intent(FrontPage.this, Rate_app.class);
//                startActivity(rate);
                break;
        }
    }
}
