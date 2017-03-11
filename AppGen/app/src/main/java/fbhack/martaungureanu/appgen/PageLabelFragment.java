package fbhack.martaungureanu.appgen;

import android.media.Image;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

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

        if(pageTitle.equals("new")) {
            pageTextView.setVisibility(View.INVISIBLE);
            plusButton.setVisibility(View.VISIBLE);
        } else{
            pageTextView.setText(pageTitle);
            pageTextView.setVisibility(View.VISIBLE);
            plusButton.setVisibility(View.INVISIBLE);
        }


        return view;
    }

}
