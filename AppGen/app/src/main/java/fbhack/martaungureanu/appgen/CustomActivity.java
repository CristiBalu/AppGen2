package fbhack.martaungureanu.appgen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

public class CustomActivity extends AppCompatActivity {
    private CustomView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = new CustomView(getApplicationContext(),
                (HashMap<String, String>) getIntent().getSerializableExtra("aspectMap"));
        setContentView(view);
    }
}
