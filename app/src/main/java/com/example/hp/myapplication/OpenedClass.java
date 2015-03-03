package com.example.hp.myapplication;

/** * Created by Mohammad Nassar on 09/01/2015. */
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class OpenedClass extends Activity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    TextView question, test;
    Button returnData;
    RadioGroup rgSelectionList;
    String gotBread, setData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        initialise();

        SharedPreferences getData = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String et = getData.getString("name", "The name is: ");
        String values = getData.getString("list", "5");
        if (values.contentEquals("4")) {
            question.setText(et);
        }

        /*//Commenting the 3 lines below to avoid an error happening when button: 'StartActivityForResult' is pressed.
        Bundle gotBasket = getIntent().getExtras();
        gotBread = gotBasket.getString("key");
        question.setText(gotBread);*/
    }

    private void initialise() {
        question = (TextView) findViewById(R.id.tvQuestion);
        test = (TextView) findViewById(R.id.tvText);
        returnData = (Button) findViewById(R.id.bReturn);
        returnData.setOnClickListener(this);
        rgSelectionList = (RadioGroup) findViewById(R.id.rgAnswers);
        rgSelectionList.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        //When the button is pressed do the followng and end by finishing the activity
        Intent person = new Intent();
        Bundle backpack = new Bundle();
        backpack.putString("answerKey", setData);
        person.putExtras(backpack);
        //Since we're starting this activity for a result, we need to give the result back
        setResult(RESULT_OK, person);
        finish();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        switch (i) {
            case R.id.rBlue :
                setData = "Probably right!";
                break;

            case R.id.rGreen :
                setData = "Definitely right!";
                break;

            case R.id.rBoth :
                setData = "Spot On!";
                break;
        }
        test.setText(setData);
    }
}
