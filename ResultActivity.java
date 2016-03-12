package development.rock.deltavee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        double deltaVee = intent.getDoubleExtra(InputActivity.EXTRA_MESSAGE, 0.0);


        DecimalFormat df = new DecimalFormat("#.##");
        String stringVee = df.format(deltaVee);

        String result = (stringVee + " m/s");

        TextView resultText = (TextView) findViewById(R.id.resultText);
        resultText.setText(result);
    }

    public void startOver(View view)
    {
        Intent intent = new Intent(this, InputActivity.class);
        startActivity(intent);
    }

    public void newStage(View view)
    {
        Intent intent2 = getIntent();
        double dVee = intent2.getDoubleExtra(InputActivity.EXTRA_MESSAGE, 0.0);
        Intent intent = new Intent(this, InputNewActivity.class);
        intent.putExtra("dVee", dVee);
        startActivity(intent);

    }
}
