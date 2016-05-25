package com.helloworld.kenneth.androidinterview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by kenneth on 5/25/2016.
 */
public class Simple_question extends AppCompatActivity implements View.OnClickListener
{
    TextView tv_question, tv_answer, tv_totallength_yy, tv_presentindex_xx;
    Button b_prev, b_ans, b_next;
    String[] simple_question, simple_answers;
    int index;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);
        index = 0;
//        TEXT VIEW DECLARATION
        tv_question         = (TextView)findViewById(R.id.tvquestion);
        tv_answer           = (TextView)findViewById(R.id.tvanswer);
        tv_totallength_yy   = (TextView)findViewById(R.id.tvyy);
        tv_presentindex_xx  = (TextView)findViewById(R.id.tvxx);
//        BUTTONS DECLARATION
        b_prev              = (Button)findViewById(R.id.bleft);
        b_ans               = (Button)findViewById(R.id.bshowanswer);
        b_next              = (Button)findViewById(R.id.bright);
//        XML IMPORT
        simple_question     = getResources().getStringArray(R.array.simple_question);
        simple_answers      = getResources().getStringArray(R.array.simple_answers);
//        ONCLICK LISTENER IMPLEMENTATION
        b_prev.setOnClickListener(this);
        b_ans.setOnClickListener(this);
        b_next.setOnClickListener(this);
//        SETTING VALUES FOR VARIABLES AND TEXT VIEWS
        index = 0;
        tv_question.setText(simple_question[index]);
        tv_answer.setText("Press the light bulb icon for the answer.");
        tv_presentindex_xx.setText(String.valueOf(index+1));
        tv_totallength_yy.setText("/"+String.valueOf(simple_question.length));

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
                    index = simple_question.length - 1;
                    tv_question.setText(simple_question[index]);
                    tv_presentindex_xx.setText(String.valueOf(index+1));
                }
                else
                {
                    tv_question.setText(simple_question[index]);
                    tv_presentindex_xx.setText(String.valueOf(index+1));
                }
                break;
            case R.id.bshowanswer:
                tv_answer.setText(simple_answers[index]);
                break;
            case R.id.bright:
                tv_answer.setText("Press the light bulb icon for the answer.");
                index++;
                if(index >simple_question.length - 1)
                {
                    index = 0;
                    tv_question.setText(simple_question[index]);
                    tv_presentindex_xx.setText(String.valueOf(index+1));
                }
                else
                {
                    tv_question.setText(simple_question[index]);
                    tv_presentindex_xx.setText(String.valueOf(index+1));
                }
                break;
        }
    }
}
