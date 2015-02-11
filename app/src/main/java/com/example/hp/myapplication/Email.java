package com.example.hp.myapplication;

/** * Created by Mohammad Nassar on 21/12/2014. */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity implements View.OnClickListener {

    EditText personsEmail, intro, personsName, stupidThings, hatefulAction,
            outro;
    String emailAdd, beginning, name, stupidAction, hatefulAct, out;
    Button sendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);
        initializeVars();
        sendEmail.setOnClickListener(this);
    }

    private void initializeVars() {
        // TODO Auto-generated method stub
        personsEmail = (EditText) findViewById(R.id.etEmails);
        intro = (EditText) findViewById(R.id.etIntro);
        personsName = (EditText) findViewById(R.id.etName);
        stupidThings = (EditText) findViewById(R.id.etThings);
        hatefulAction = (EditText) findViewById(R.id.etAction);
        outro = (EditText) findViewById(R.id.etOutro);
        sendEmail = (Button) findViewById(R.id.bSentEmail);
    }

    public void onClick(View v) {
        // TODO Auto-generated method stub

        convertEditTextVarsIntoStringsAndYesThisIsAMethodWeCreated();
        String emailaddress[] = { emailAdd };
        String message = "Well hello "
                + name
                + " I just wanted to say "
                + beginning
                + ".  Not only that but I hate when you "
                + stupidAction
                + ", that just really makes me crazy.  I just want to make you "
                + hatefulAct
                + ".  Welp, thats all I wanted to chit-chatter about, oh and"
                + out
                + ".  Oh also if you get bored you should check out www.mybringback.com"
                + '\n' + "PS. I think I love you...   :(";

        //Intent emailIntent = new Intent(Intent.ACTION_CALL);
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, emailaddress);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "This is the Email Subject");
        emailIntent.setType("plain/text");
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(emailIntent);

    }

    private void convertEditTextVarsIntoStringsAndYesThisIsAMethodWeCreated() {
        // TODO Auto-generated method stub
        emailAdd = personsEmail.getText().toString();
        beginning = intro.getText().toString();
        name = personsName.getText().toString();
        stupidAction = stupidThings.getText().toString();
        hatefulAct = hatefulAction.getText().toString();
        out = outro.getText().toString();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}
/* Some help obtained from: http://www.mybringback.com/tutorial-series/749/thenewboston-tutorial35-email-java/
 * Parent link is: http://www.mybringback.com/series/android-thenewboston/ */