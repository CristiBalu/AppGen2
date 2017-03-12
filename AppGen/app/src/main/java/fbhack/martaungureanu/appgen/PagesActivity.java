package fbhack.martaungureanu.appgen;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

import fbhack.martaungureanu.appgen.utils.Model;
import fbhack.martaungureanu.appgen.utils.SingletonHashmap;

public class PagesActivity extends AppCompatActivity {
    private final String TITLE_BUNDLE_KEY = "pageTitle";

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    private SingletonHashmap pagesMapping;
    Model model;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pages_layout);

        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        pagesMapping = SingletonHashmap.getInstance();
        HashMap<String, Model> hashMap = pagesMapping.getHashMap();
        try {
            model = (Model) getIntent().getSerializableExtra("model");
            name = (String) getIntent().getSerializableExtra("pageName");
            if(name != null && !name.equals("")) {
                hashMap.put(name, model);
            }
        } catch (Exception e) {

        }

        for(String key : hashMap.keySet()) {
            addPage(key);
        }

        addPage("new");

        fragmentTransaction.commit();
    }

    public void addPage(String pageTitle) {
        PageLabelFragment newPageFragment = new PageLabelFragment();

        Bundle bundle = new Bundle();
        bundle.putString(TITLE_BUNDLE_KEY, pageTitle);
        bundle.putSerializable("model", model);
        newPageFragment.setArguments(bundle);

        fragmentTransaction.add(R.id.pages_scrollable, newPageFragment);
    }
}
