package fbhack.martaungureanu.appgen;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import fbhack.martaungureanu.appgen.utils.Model;

public class PageLabelFragment extends Fragment {
    TextView pageTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.page_fragment_layout, container, false);
        pageTextView = (TextView) view.findViewById(R.id.page_title);
        ImageButton plusButton = (ImageButton) view.findViewById(R.id.plus_button);

        String pageTitle = getArguments().getString("pageTitle");
        final Model model = (Model) getArguments().getSerializable("model");

        if(pageTitle.equals("new")) {
            pageTextView.setVisibility(View.INVISIBLE);
            plusButton.setVisibility(View.VISIBLE);

            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    startSpeechActivity();
                }
            });
        } else{
            pageTextView.setText(pageTitle);
            pageTextView.setVisibility(View.VISIBLE);
            plusButton.setVisibility(View.INVISIBLE);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startEditActivity(model);
                }
            });
        }


        return view;
    }

    private void startEditActivity(Model model) {
        Intent intent = new Intent(getActivity(), CustomActivity.class);
        intent.putExtra("model", model);
        intent.putExtra("isNew", false);
        startActivity(intent);
    }

    private void startSpeechActivity() {
        Intent intent = new Intent(getActivity(), SpeechActivity.class);
        intent.putExtra("isNew", true);
        startActivity(intent);
    }

}
