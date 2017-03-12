package fbhack.martaungureanu.appgen;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import static android.R.attr.password;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class SpeechActivity extends AppCompatActivity {
    Button listenButton;
    Button doneButton;
    String userInput;

    private final String NO_INPUT              = "";
    private final int    REQ_CODE_SPEECH_INPUT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_speech);

        userInput = NO_INPUT;
        listenButton = (Button) findViewById(R.id.listen_button);
        listenButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });

        doneButton = (Button) findViewById(R.id.done_button);
        doneButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startCustomActivity();
            }
        });
    }

    private void startCustomActivity() {
        Intent intent = new Intent(this, CustomActivity.class);
        intent.putExtra("model", Parser.parse("I want the background to be white. I want the text color to be green. " +
                " I want the user to be able to introduce the password. I want the user to be able to press a button." +
                "I want the user to be able to pick a date. I want the user to be able to turn notifications on. " +
                "I want the user to be able to introduce his phone number."));
        startActivity(intent);
    }

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getText(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case REQ_CODE_SPEECH_INPUT:
                if(resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    userInput += " " + result.get(0);
                    //Parser.parse("I want the background to be red. I want the text color to be white.");
                }
                break;
        }
    }
}
