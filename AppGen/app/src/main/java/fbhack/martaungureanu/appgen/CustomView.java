package fbhack.martaungureanu.appgen;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by martaungureanu on 11/03/2017.
 */

public class CustomView extends RelativeLayout implements Serializable{
    Map<String, String> aspectMap;
    int textColor;
    int textSize;
    Context context;

    public CustomView(Context context, Map<String, String> aspectMap) {
        super(context);
        this.context = context;
        this.aspectMap = aspectMap;

        setLayout();
    }

    private void setLayout() {
        for(String key : aspectMap.keySet()) {
            switch(key) {
                case "background":
                    int color = getColor(aspectMap.get(key));
                    setBackgroundColor(color);
                    break;
                case "textColor":
                    textColor = getColor(aspectMap.get(key));
                    break;
                case "textSize":
                    textSize = Integer.parseInt(aspectMap.get(key));

            }
        }

        Button button = new Button(context);
        button.setTextColor(textColor);
        button.setText("alabala");
        addView(button);
    }

    private int getColor(String color) {
        switch(color) {
            case "red":
                return Color.RED;
            case "green":
                return Color.GREEN;
            default:
                return -1;
        }
    }
}
