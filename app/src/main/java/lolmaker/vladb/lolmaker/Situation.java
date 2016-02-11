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
    TextView tvQuestion, index_xx, index_yy;
    EditText etAnswers;
    Button btnNext;
    int index;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.situation);

        index = 0;
        tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        etAnswers = (EditText) findViewById(R.id.etAnswers);
        index_xx = (TextView) findViewById(R.id.tvxx);
        index_yy = (TextView) findViewById(R.id.tvyy);
        btnNext = (Button) findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index < questions.length) {
                    answers[index] = String.valueOf(etAnswers.getText());
                    if(index != questions.length - 1) {
                        index++;
                        setText();
                    }
                    else showFinal();
                }
            }
        });

        if(MainActivity.SITUATION_ID == 1){
            situation = getResources().getStringArray(R.array.situation1);
            questions = getResources().getStringArray(R.array.ques1);
            answers = new String[questions.length];

            setText();
        }
        else if(MainActivity.SITUATION_ID == 2){
            situation = getResources().getStringArray(R.array.situation2);
            questions = getResources().getStringArray(R.array.ques2);
            answers = new String[questions.length];

            setText();
        }
        else if(MainActivity.SITUATION_ID == 3){
            situation = getResources().getStringArray(R.array.situation3);
            questions = getResources().getStringArray(R.array.ques3);
            answers = new String[questions.length];

            setText();
        }
        else if(MainActivity.SITUATION_ID == 4){
            situation = getResources().getStringArray(R.array.situation4);
            questions = getResources().getStringArray(R.array.ques4);
            answers = new String[questions.length];

            setText();
        }
    }

    private String pasteAnswers(String[] A, String[] B){
        int indexA = 0;
        for(int i = 0; i < B.length; i++){
            if(B[i] == null || B[i] == ""){
                B[i] = A[indexA];
                indexA++;
            }
        }

        String result = "";
        for(String s: B)
            result += s;

        return result;
    }

    private void setText(){
        tvQuestion.setText(questions[index]);
        index_xx.setText(String.valueOf(index + 1));
        index_yy.setText(String.valueOf("/" + questions.length));
        etAnswers.setText("");
    }

    private void showFinal(){
        index_xx.setVisibility(View.GONE);
        index_yy.setVisibility(View.GONE);
        etAnswers.setVisibility(View.GONE);
        String result = "";
        for(String s: answers)
            result += s;
        tvQuestion.setText(result);
    }

}
