package com.helloworld.kenneth.androidinterview;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by kenneth on 5/25/2016.
 */
public class Tough_questions extends AppCompatActivity implements View.OnClickListener
{
    TextToSpeech ttsobject;
    TextView tv_question, tv_answer, tv_totallength_yy, tv_presentindex_xx,tv_category;
    Button b_prev, b_ans, b_next,b_speak,b_stop;
    String[] tough_question, tough_answers;
    int index = 0, result;
    private static final String default_ans = "Press the light bulb icon for the answer.";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);
        //      CODES TO ADD ACTION BAR
        LinearLayout questions_ll = (LinearLayout)findViewById(R.id.questions_title_bar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.questions_title_bar);


        index = 0;
//        TEXT VIEW DECLARATION
        tv_question         = (TextView)findViewById(R.id.tvquestion);
        tv_answer           = (TextView)findViewById(R.id.tvanswer);
        tv_totallength_yy   = (TextView)findViewById(R.id.tvyy);
        tv_presentindex_xx  = (TextView)findViewById(R.id.tvxx);
        tv_category         = (TextView)findViewById(R.id.tv_questions_title_bar);
        tv_category.setText("Tough Questions");
//        BUTTONS DECLARATION
        b_prev              = (Button)findViewById(R.id.bleft);
        b_ans               = (Button)findViewById(R.id.bshowanswer);
        b_next              = (Button)findViewById(R.id.bright);
        b_speak             = (Button)findViewById(R.id.bspeak);
        b_stop              = (Button)findViewById(R.id.bstop);
//        XML IMPORT
        tough_question = getResources().getStringArray(R.array.tough_questions);
        tough_answers  = getResources().getStringArray(R.array.tough_answers);
//        ONCLICK LISTENER IMPLEMENTATION
        b_prev.setOnClickListener(this);
        b_ans.setOnClickListener(this);
        b_next.setOnClickListener(this);
        b_speak.setOnClickListener(this);
        b_stop.setOnClickListener(this);
//       SETTING VALUES  FOR TEXT VIEWS AND VARIABLES
        index = 0;
        tv_question.setText(tough_question[index]);
        tv_answer.setText(default_ans);
        tv_presentindex_xx.setText(String.valueOf(index+1));
        tv_totallength_yy.setText("/"+String.valueOf(tough_question.length));

        ttsobject = new TextToSpeech(Tough_questions.this, new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int i) {
                if(i == TextToSpeech.SUCCESS)
                {
                    i = ttsobject.setLanguage(Locale.US);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Feature not supported.",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.bleft:
                tv_answer.setText("Press the light bulb icon for the answer.");
                index--;
                if(index <= 0)
                {
                    index = tough_question.length - 1;
                    tv_question.setText(tough_question[index]);
                    tv_presentindex_xx.setText(String.valueOf(index+1));
                }
                else
                {
                    tv_question.setText(tough_question[index]);
                    tv_presentindex_xx.setText(String.valueOf(index+1));
                }
                break;
            case R.id.bshowanswer:
                tv_answer.setText(tough_answers[index]);
                break;
            case R.id.bright:
                tv_answer.setText("Press the light bulb icon for the answer.");
                index++;
                if(index >tough_question.length - 1)
                {
                    index = 0;
                    tv_question.setText(tough_question[index]);
                    tv_presentindex_xx.setText(String.valueOf(index+1));
                }
                else
                {
                    tv_question.setText(tough_question[index]);
                    tv_presentindex_xx.setText(String.valueOf(index+1));
                }
                break;
            case R.id.bspeak:
                if(result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA)
                {
                    Toast.makeText(getApplicationContext(),"Feature not supported.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(tv_answer.getText().toString().equals(default_ans))
                    {

                    }
                    else
                    {
                        ttsobject.speak(tough_answers[index], TextToSpeech.QUEUE_FLUSH,null);
                    }
                }
                break;
            case R.id.bstop:
                ttsobject.stop();
                break;
        }
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        if(ttsobject != null)
        {
            ttsobject.stop();
            ttsobject.shutdown();
        }
    }
}
