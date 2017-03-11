package fbhack.martaungureanu.appgen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

import fbhack.martaungureanu.appgen.utils.Model;

public class CustomActivity extends AppCompatActivity {
    private CustomView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = new CustomView(getApplicationContext(),
                (Model) getIntent().getSerializableExtra("model"));
        setContentView(view);
    }
}
