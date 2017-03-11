package fbhack.martaungureanu.appgen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HelloActivity extends AppCompatActivity {
    Button getStartedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_layout);

        getStartedButton = (Button) findViewById(R.id.get_started_button);
        getStartedButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startPagesActivity();
            }
        });
    }

    public void startPagesActivity() {
        Intent intent = new Intent(this, PagesActivity.class);
        startActivity(intent);
    }
}
