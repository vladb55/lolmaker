package lolmaker.vladb.lolmaker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Vlady on 02.02.2016.
 */
public class Situation extends ActionBarActivity {

    String[] questions, answers, situation;
    TextView tvQuestion, tvxx, tvyy;
    EditText etAnswers;
    Button btnNext;
    int index;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.situation);

        index = 0;
        tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        etAnswers = (EditText) findViewById(R.id.etAnswers);
        tvxx = (TextView) findViewById(R.id.tvxx);
        tvyy = (TextView) findViewById(R.id.tvyy);
        btnNext = (Button) findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answers[index] = String.valueOf(etAnswers.getText());
                index++;
                tvQuestion.setText(questions[index]);
                tvxx.setText(String.valueOf(index + 1));
                tvyy.setText(String.valueOf("/" + questions.length));
                etAnswers.setText("");
            }
        });

        if(MainActivity.SITUATION_ID == 1){
            situation = getResources().getStringArray(R.array.situation1);
            questions = getResources().getStringArray(R.array.ques1);
            answers = new String[questions.length];
        }
        else if(MainActivity.SITUATION_ID == 2){
            situation = getResources().getStringArray(R.array.situation2);
            questions = getResources().getStringArray(R.array.ques2);
            answers = new String[questions.length];
        }
        else if(MainActivity.SITUATION_ID == 3){
            situation = getResources().getStringArray(R.array.situation3);
            questions = getResources().getStringArray(R.array.ques3);
            answers = new String[questions.length];
        }
        else if(MainActivity.SITUATION_ID == 4){
            situation = getResources().getStringArray(R.array.situation4);
            questions = getResources().getStringArray(R.array.ques4);
            answers = new String[questions.length];
        }

        tvQuestion.setText(questions[index]);
        tvxx.setText(String.valueOf(index + 1));
        tvyy.setText(String.valueOf("/" + questions.length));
    }

    private void pasteAnswers(){

    }

}
