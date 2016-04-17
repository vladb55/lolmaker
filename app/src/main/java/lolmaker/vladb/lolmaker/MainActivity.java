package lolmaker.vladb.lolmaker;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    private Button btnS1, btnS2, btnS3, btnS4;
    public static int SITUATION_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnS1 = (Button) findViewById(R.id.btnSituation1);
        btnS2 = (Button) findViewById(R.id.btnSituation2);
        btnS3 = (Button) findViewById(R.id.btnSituation3);
        btnS4 = (Button) findViewById(R.id.btnSituation4);

        btnS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SITUATION_ID = 1;
                Intent i = new Intent(MainActivity.this, Situation.class);
                startActivity(i);
            }
        });

        btnS2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SITUATION_ID = 2;
                Intent i = new Intent(MainActivity.this, Situation.class);
                startActivity(i);
            }
        });

        btnS3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SITUATION_ID = 3;
                Intent i = new Intent(MainActivity.this, Situation.class);
                startActivity(i);
            }
        });

        btnS4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SITUATION_ID = 4;
                Intent i = new Intent(MainActivity.this, Situation.class);
                startActivity(i);
            }
        });
    }
}
