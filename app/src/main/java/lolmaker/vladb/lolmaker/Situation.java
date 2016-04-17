package lolmaker.vladb.lolmaker;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        index = 0;
        tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        etAnswers = (EditText) findViewById(R.id.etAnswers);
        index_xx = (TextView) findViewById(R.id.tvxx);
        index_yy = (TextView) findViewById(R.id.tvyy);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setVisibility(View.VISIBLE);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index < questions.length) {
                    answers[index] = String.valueOf(etAnswers.getText());
                    if(index != questions.length - 1) {
                        index++;
                        setText();
                    }
                    else {
                        showFinal();
                        btnNext.setVisibility(View.GONE);
                    }
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

        // Записываем все элементы массива в строку через пробел
        int index_A = 0;
        String result = "";
        for(String s: B)
            result += s + " ";

        // Находим итемы, заменяем на ответы
        StringBuffer sb = new StringBuffer();
        Matcher m = Pattern.compile("item").matcher(result);
        while(m.find()){
            m.appendReplacement(sb, A[index_A]);
            index_A++;
        }
        m.appendTail(sb);
        result = sb.toString();
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
        tvQuestion.setText(pasteAnswers(answers, situation));
    }

}
