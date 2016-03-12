package development.rock.deltavee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InputActivity extends AppCompatActivity {

    public static String EXTRA_MESSAGE = "development.rock.deltaVee.num";
    public boolean isISP = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }

    public void switchButton(View view)
    {
        Button button = (Button) findViewById(R.id.switchButton);
        TextView text = (TextView) findViewById(R.id.switchText);
        String test = "ISP in Vacuum";

        if(text.getText().toString().equals(test))
        {
            text.setText(R.string.editTextVEx);
            button.setText(R.string.switchButtonIsp);
            isISP = false;
        }
        else
        {
            text.setText(R.string.ISP);
            button.setText(R.string.switchButtonVEx);
            isISP = true;
        }
    }

    public void calcDeltaV(View view)
    {
        EditText isp = (EditText) findViewById(R.id.ISP_Value);
        EditText WeightFull = (EditText) findViewById(R.id.WeightFull_Value);
        EditText WeightEmpty = (EditText) findViewById(R.id.WeightEmpty_Value);

        Intent intent = new Intent(this, ResultActivity.class);

        double ispNum = Double.parseDouble(isp.getText().toString());
        double weightFullNum = Double.parseDouble(WeightFull.getText().toString());
        double weightEmptyNum = Double.parseDouble(WeightEmpty.getText().toString());

        double vExhaust = ispNum;
        if(isISP) {
            vExhaust = ispNum * 9.8;
        }

        double weightRatio = weightFullNum/weightEmptyNum;
        double deltaVee = vExhaust*(Math.log(weightRatio));
        intent.putExtra(EXTRA_MESSAGE,deltaVee);

        startActivity(intent);
    }
}
