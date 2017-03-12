package fbhack.martaungureanu.appgen;

import android.content.Context;
import android.graphics.Color;
import android.icu.text.MessagePattern;
import android.text.InputType;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import fbhack.martaungureanu.appgen.utils.Model;

import static android.R.attr.button;

/**
 * Created by martaungureanu on 11/03/2017.
 */

public class CustomView extends LinearLayout implements Serializable{
    Map<String, String> aspectMap;
    List<String> elements;
    int textColor;
    int textSize;
    boolean textColorSet;
    boolean textSizeSet;
    Context context;

    public CustomView(Context context, Model model) {
        super(context);
        this.context = context;
        aspectMap = model.getAspectMap();
        elements = model.getElements();
        textColorSet = false;
        textSizeSet = false;
        this.setOrientation(VERTICAL);
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
                    textColorSet = true;
                    break;
                case "textSize":
                    textSize = Integer.parseInt(aspectMap.get(key));
                    textSizeSet = true;

            }
        }

        for(String element : elements) {
            switch(element) {
                case "DatePicker":
                    EditText editText = new EditText(context);
                    editText.setInputType(InputType.TYPE_CLASS_DATETIME);
                    editText.setHint("dd/mm/yyyy");
                    editText.setSelection(editText.getText().length());
                    if(textColorSet) {
                        editText.setTextColor(textColor);
                    }
                    if(textSizeSet) {
                        editText.setTextSize(textSize);
                    }
                    addView(editText);
                    break;
                case "Number":
                    editText = new EditText(context);
                    editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                    editText.setHint("Introduce a number");
                    if(textColorSet) {
                        editText.setTextColor(textColor);
                    }
                    if(textSizeSet) {
                        editText.setTextSize(textSize);
                    }
                    addView(editText);
                    break;
                case "Password":
                    editText = new EditText(context);
                    editText.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    editText.setHint("Introduce password");
                    editText.setSelection(editText.getText().length());
                    if(textColorSet) {
                        editText.setTextColor(textColor);
                    }
                    if(textSizeSet) {
                        editText.setTextSize(textSize);
                    }
                    addView(editText);
                    break;
                case "TextInput":
                    editText = new EditText(context);
                    editText.setInputType(InputType.TYPE_CLASS_TEXT);
                    editText.setHint("Introduce text");
                    if(textColorSet) {
                        editText.setTextColor(textColor);
                    }
                    if(textSizeSet) {
                        editText.setTextSize(textSize);
                    }
                    addView(editText);
                    break;
                case "Spinner":
                    Spinner spinner = new Spinner(context);
                    addView(spinner);
                    break;
                case "Button":
                    Button button = new Button(context);
                    button.setText("Button");
                    if(textColorSet) {
                        button.setTextColor(textColor);
                    }
                    if(textSizeSet) {
                        button.setTextSize(textSize);
                    }
                    addView(button);
                    break;
                case "Switch":
                    Switch userSwitch = new Switch(context);
                    addView(userSwitch);
            }
        }
    }

    private int getColor(String color) {
        switch(color) {
            case "red":
                return Color.RED;
            case "green":
                return Color.GREEN;
            case "white":
                return Color.WHITE;
            default:
                return -1;
        }
    }
}
