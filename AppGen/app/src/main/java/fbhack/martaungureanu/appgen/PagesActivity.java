package fbhack.martaungureanu.appgen;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class PagesActivity extends AppCompatActivity {
    private final String TITLE_BUNDLE_KEY = "pageTitle";

    ArrayList<String> pageNames;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pages_layout);

        pageNames = new ArrayList<>(0);
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        for(int i = 0; i < pageNames.size(); i++) {
            addPage(pageNames.get(i));
        }

        addPage("new");

        fragmentTransaction.commit();
    }

    public void addPage(String pageTitle) {
        PageLabelFragment newPageFragment = new PageLabelFragment();

        Bundle bundle = new Bundle();
        bundle.putString(TITLE_BUNDLE_KEY, pageTitle);
        newPageFragment.setArguments(bundle);

        fragmentTransaction.add(R.id.pages_scrollable, newPageFragment);
    }
}
