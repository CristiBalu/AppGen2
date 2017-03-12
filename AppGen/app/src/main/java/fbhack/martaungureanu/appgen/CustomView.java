package fbhack.martaungureanu.appgen;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.icu.text.MessagePattern;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fbhack.martaungureanu.appgen.utils.Model;
import fbhack.martaungureanu.appgen.utils.SingletonHashmap;

import static android.R.id.edit;

/**
 * Created by martaungureanu on 11/03/2017.
 */

public class CustomView extends LinearLayout implements Serializable{
    private Map<String, String> aspectMap;
    private List<String> elements;
    private int textColor;
    private int textSize;
    private boolean textColorSet;
    private boolean textSizeSet;
    private Context context;
    private AppCompatActivity activity;


    public CustomView(Context context, Model model, AppCompatActivity activity) {
        super(context);
        this.context = context;
        this.activity = activity;
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
                    editText.setOnLongClickListener(new CustomListener(editText) {
                        @Override
                        public boolean onLongClick(View v) {

                            GridLayout layout = new GridLayout(context);
                            layout.setColumnCount(2);
                            layout.setRowCount(5);

                            TextView textView = new TextView(context);
                            textView.setText("Width(dp):");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(0);
                            layout.addView(textView, params);

                            GridLayout.LayoutParams params2 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(0);

                            final EditText editText1 = new EditText(context);
                            editText1.setInputType(InputType.TYPE_CLASS_NUMBER);
                            editText1.setWidth(400);
                            editText1.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText1, params2);

                            textView = new TextView(context);
                            textView.setText("Height(dp):");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params3 = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(1);
                            layout.addView(textView, params3);

                            GridLayout.LayoutParams params4 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(1);

                            final EditText editText2 = new EditText(context);
                            editText2.setInputType(InputType.TYPE_CLASS_NUMBER);
                            editText2.setWidth(400);
                            editText2.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText2, params4);

                            textView = new TextView(context);
                            textView.setText("Placeholder:");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params5 = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(2);
                            layout.addView(textView, params5);

                            GridLayout.LayoutParams params6 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(2);

                            final EditText editText3 = new EditText(context);
                            editText3.setInputType(InputType.TYPE_CLASS_TEXT);
                            editText3.setWidth(400);
                            editText3.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText3, params6);

                            textView = new TextView(context);
                            textView.setText("Text size:");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params7 = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(3);
                            layout.addView(textView, params7);

                            GridLayout.LayoutParams params8 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(3);

                            final EditText editText4 = new EditText(context);
                            editText4.setInputType(InputType.TYPE_CLASS_NUMBER);
                            editText4.setWidth(400);
                            editText4.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText4, params8);

                            textView = new TextView(context);
                            textView.setText("Text colour:");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params9 = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(2);
                            layout.addView(textView, params9);

                            GridLayout.LayoutParams params10 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(2);

                            final EditText editText5 = new EditText(context);
                            editText5.setInputType(InputType.TYPE_CLASS_TEXT);
                            editText5.setWidth(400);
                            editText5.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText5, params10);

                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
                            alertDialogBuilder.setPositiveButton("Ok", new CustomOnClick(v) {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if(!editText1.getText().toString().equals("")) {
                                        getView().setLayoutParams(new LayoutParams(Integer.parseInt(editText1.getText().toString())
                                                ,getView().getHeight()));
                                    }
                                    if(!editText2.getText().toString().equals("")) {
                                        getView().setLayoutParams(new LayoutParams(getView().getWidth(), Integer.parseInt(editText2.getText().toString())));
                                    }
                                    if(!editText3.getText().toString().equals("")) {
                                        ((EditText) getView()).setHint(editText3.getText().toString());
                                    }
                                    if(!editText4.getText().toString().equals("")) {
                                        ((EditText) getView()).setTextSize(Integer.parseInt(editText4.getText().toString()));
                                    }
                                    if(!editText5.getText().toString().equals("")) {
                                        ((EditText) getView()).setTextColor(getColor(editText5.getText().toString()));
                                    }
                                }
                            });
                            alertDialogBuilder.setTitle("Edit Date Input Field");
                            AlertDialog alertDialog = alertDialogBuilder.create();

                            alertDialog.setView(layout);

                            alertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                            alertDialog.show();
                            return true;
                        }
                    });
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
                    editText.setOnLongClickListener(new CustomListener(editText) {
                        @Override
                        public boolean onLongClick(View v) {

                            GridLayout layout = new GridLayout(context);
                            layout.setColumnCount(2);
                            layout.setRowCount(5);

                            TextView textView = new TextView(context);
                            textView.setText("Width(dp):");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(0);
                            layout.addView(textView, params);

                            GridLayout.LayoutParams params2 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(0);

                            final EditText editText1 = new EditText(context);
                            editText1.setInputType(InputType.TYPE_CLASS_NUMBER);
                            editText1.setWidth(400);
                            editText1.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText1, params2);

                            textView = new TextView(context);
                            textView.setText("Height(dp):");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params3 = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(1);
                            layout.addView(textView, params3);

                            GridLayout.LayoutParams params4 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(1);

                            final EditText editText2 = new EditText(context);
                            editText2.setInputType(InputType.TYPE_CLASS_NUMBER);
                            editText2.setWidth(400);
                            editText2.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText2, params4);

                            textView = new TextView(context);
                            textView.setText("Placeholder:");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params5 = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(2);
                            layout.addView(textView, params5);

                            GridLayout.LayoutParams params6 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(2);

                            final EditText editText3 = new EditText(context);
                            editText3.setInputType(InputType.TYPE_CLASS_TEXT);
                            editText3.setWidth(400);
                            editText3.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText3, params6);

                            textView = new TextView(context);
                            textView.setText("Text size:");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params7 = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(3);
                            layout.addView(textView, params7);

                            GridLayout.LayoutParams params8 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(3);

                            final EditText editText4 = new EditText(context);
                            editText4.setInputType(InputType.TYPE_CLASS_NUMBER);
                            editText4.setWidth(400);
                            editText4.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText4, params8);

                            textView = new TextView(context);
                            textView.setText("Text colour:");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params9 = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(2);
                            layout.addView(textView, params9);

                            GridLayout.LayoutParams params10 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(2);

                            final EditText editText5 = new EditText(context);
                            editText5.setInputType(InputType.TYPE_CLASS_TEXT);
                            editText5.setWidth(400);
                            editText5.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText5, params10);

                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
                            alertDialogBuilder.setPositiveButton("Ok", new CustomOnClick(v) {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if(!editText1.getText().toString().equals("")) {
                                        getView().setLayoutParams(new LayoutParams(Integer.parseInt(editText1.getText().toString())
                                                ,getView().getHeight()));
                                    }
                                    if(!editText2.getText().toString().equals("")) {
                                        getView().setLayoutParams(new LayoutParams(getView().getWidth(), Integer.parseInt(editText2.getText().toString())));
                                    }
                                    if(!editText3.getText().toString().equals("")) {
                                        ((EditText) getView()).setHint(editText3.getText().toString());
                                    }
                                    if(!editText4.getText().toString().equals("")) {
                                        ((EditText) getView()).setTextSize(Integer.parseInt(editText4.getText().toString()));
                                    }
                                    if(!editText5.getText().toString().equals("")) {
                                        ((EditText) getView()).setTextColor(getColor(editText5.getText().toString()));
                                    }
                                }
                            });
                            alertDialogBuilder.setTitle("Edit Number Input Field");
                            AlertDialog alertDialog = alertDialogBuilder.create();

                            alertDialog.setView(layout);

                            alertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                            alertDialog.show();
                            return true;
                        }
                    });
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
                    editText.setOnLongClickListener(new CustomListener(editText) {
                        @Override
                        public boolean onLongClick(View v) {

                            GridLayout layout = new GridLayout(context);
                            layout.setColumnCount(2);
                            layout.setRowCount(5);

                            TextView textView = new TextView(context);
                            textView.setText("Width(dp):");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(0);
                            layout.addView(textView, params);

                            GridLayout.LayoutParams params2 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(0);

                            final EditText editText1 = new EditText(context);
                            editText1.setInputType(InputType.TYPE_CLASS_NUMBER);
                            editText1.setWidth(400);
                            editText1.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText1, params2);

                            textView = new TextView(context);
                            textView.setText("Height(dp):");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params3 = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(1);
                            layout.addView(textView, params3);

                            GridLayout.LayoutParams params4 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(1);

                            final EditText editText2 = new EditText(context);
                            editText2.setInputType(InputType.TYPE_CLASS_NUMBER);
                            editText2.setWidth(400);
                            editText2.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText2, params4);

                            textView = new TextView(context);
                            textView.setText("Placeholder:");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params5 = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(2);
                            layout.addView(textView, params5);

                            GridLayout.LayoutParams params6 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(2);

                            final EditText editText3 = new EditText(context);
                            editText3.setInputType(InputType.TYPE_CLASS_TEXT);
                            editText3.setWidth(400);
                            editText3.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText3, params6);

                            textView = new TextView(context);
                            textView.setText("Text size:");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params7 = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(3);
                            layout.addView(textView, params7);

                            GridLayout.LayoutParams params8 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(3);

                            final EditText editText4 = new EditText(context);
                            editText4.setInputType(InputType.TYPE_CLASS_NUMBER);
                            editText4.setWidth(400);
                            editText4.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText4, params8);

                            textView = new TextView(context);
                            textView.setText("Text colour:");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params9 = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(2);
                            layout.addView(textView, params9);

                            GridLayout.LayoutParams params10 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(2);

                            final EditText editText5 = new EditText(context);
                            editText5.setInputType(InputType.TYPE_CLASS_TEXT);
                            editText5.setWidth(400);
                            editText5.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText5, params10);

                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
                            alertDialogBuilder.setPositiveButton("Ok", new CustomOnClick(v) {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if(!editText1.getText().toString().equals("")) {
                                        getView().setLayoutParams(new LayoutParams(Integer.parseInt(editText1.getText().toString())
                                                ,getView().getHeight()));
                                    }
                                    if(!editText2.getText().toString().equals("")) {
                                        getView().setLayoutParams(new LayoutParams(getView().getWidth(), Integer.parseInt(editText2.getText().toString())));
                                    }
                                    if(!editText3.getText().toString().equals("")) {
                                        ((EditText) getView()).setHint(editText3.getText().toString());
                                    }
                                    if(!editText4.getText().toString().equals("")) {
                                        ((EditText) getView()).setTextSize(Integer.parseInt(editText4.getText().toString()));
                                    }
                                    if(!editText5.getText().toString().equals("")) {
                                        ((EditText) getView()).setTextColor(getColor(editText5.getText().toString()));
                                    }
                                }
                            });
                            alertDialogBuilder.setTitle("Edit Password Field");
                            AlertDialog alertDialog = alertDialogBuilder.create();

                            alertDialog.setView(layout);

                            alertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                            alertDialog.show();
                            return true;
                        }
                    });
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
                    editText.setOnLongClickListener(new CustomListener(editText) {
                        @Override
                        public boolean onLongClick(View v) {

                            GridLayout layout = new GridLayout(context);
                            layout.setColumnCount(2);
                            layout.setRowCount(5);

                            TextView textView = new TextView(context);
                            textView.setText("Width(dp):");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(0);
                            layout.addView(textView, params);

                            GridLayout.LayoutParams params2 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(0);

                            final EditText editText1 = new EditText(context);
                            editText1.setInputType(InputType.TYPE_CLASS_NUMBER);
                            editText1.setWidth(400);
                            editText1.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText1, params2);

                            textView = new TextView(context);
                            textView.setText("Height(dp):");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params3 = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(1);
                            layout.addView(textView, params3);

                            GridLayout.LayoutParams params4 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(1);

                            final EditText editText2 = new EditText(context);
                            editText2.setInputType(InputType.TYPE_CLASS_NUMBER);
                            editText2.setWidth(400);
                            editText2.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText2, params4);

                            textView = new TextView(context);
                            textView.setText("Placeholder:");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params5 = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(2);
                            layout.addView(textView, params5);

                            GridLayout.LayoutParams params6 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(2);

                            final EditText editText3 = new EditText(context);
                            editText3.setInputType(InputType.TYPE_CLASS_TEXT);
                            editText3.setWidth(400);
                            editText3.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText3, params6);

                            textView = new TextView(context);
                            textView.setText("Text size:");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params7 = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(3);
                            layout.addView(textView, params7);

                            GridLayout.LayoutParams params8 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(3);

                            final EditText editText4 = new EditText(context);
                            editText4.setInputType(InputType.TYPE_CLASS_NUMBER);
                            editText4.setWidth(400);
                            editText4.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText4, params8);

                            textView = new TextView(context);
                            textView.setText("Text colour:");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params9 = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(2);
                            layout.addView(textView, params9);

                            GridLayout.LayoutParams params10 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(2);

                            final EditText editText5 = new EditText(context);
                            editText5.setInputType(InputType.TYPE_CLASS_TEXT);
                            editText5.setWidth(400);
                            editText5.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText5, params10);

                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
                            alertDialogBuilder.setPositiveButton("Ok", new CustomOnClick(v) {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if(!editText1.getText().toString().equals("")) {
                                        getView().setLayoutParams(new LayoutParams(Integer.parseInt(editText1.getText().toString())
                                                ,getView().getHeight()));
                                    }
                                    if(!editText2.getText().toString().equals("")) {
                                        getView().setLayoutParams(new LayoutParams(getView().getWidth(), Integer.parseInt(editText2.getText().toString())));
                                    }
                                    if(!editText3.getText().toString().equals("")) {
                                        ((EditText) getView()).setHint(editText3.getText().toString());
                                    }
                                    if(!editText4.getText().toString().equals("")) {
                                        ((EditText) getView()).setTextSize(Integer.parseInt(editText4.getText().toString()));
                                    }
                                    if(!editText5.getText().toString().equals("")) {
                                        ((EditText) getView()).setTextColor(getColor(editText5.getText().toString()));
                                    }
                                }
                            });
                            alertDialogBuilder.setTitle("Edit Text Input Field");
                            AlertDialog alertDialog = alertDialogBuilder.create();

                            alertDialog.setView(layout);

                            alertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                            alertDialog.show();
                            return true;
                        }
                    });
                    addView(editText);
                    break;
                case "Spinner":
                    Spinner spinner = new Spinner(context);
                    spinner.setOnLongClickListener(new OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
                            alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            alertDialogBuilder.setTitle("Edit Spinner");
                            AlertDialog alertDialog = alertDialogBuilder.create();
                            alertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                            alertDialog.show();
                            return true;
                        }
                    });
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
                    button.setOnLongClickListener(new CustomListener(button) {
                        @Override
                        public boolean onLongClick(View v) {

                            GridLayout layout = new GridLayout(context);
                            layout.setColumnCount(2);
                            layout.setRowCount(5);

                            TextView textView = new TextView(context);
                            textView.setText("Width(dp):");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(0);
                            layout.addView(textView, params);

                            GridLayout.LayoutParams params2 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(0);

                            final EditText editText1 = new EditText(context);
                            editText1.setInputType(InputType.TYPE_CLASS_NUMBER);
                            editText1.setWidth(400);
                            editText1.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText1, params2);

                            textView = new TextView(context);
                            textView.setText("Height(dp):");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params3 = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(1);
                            layout.addView(textView, params3);

                            GridLayout.LayoutParams params4 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(1);

                            final EditText editText2 = new EditText(context);
                            editText2.setInputType(InputType.TYPE_CLASS_NUMBER);
                            editText2.setWidth(400);
                            editText2.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText2, params4);

                            textView = new TextView(context);
                            textView.setText("Action (page name):");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params5 = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(2);
                            layout.addView(textView, params5);

                            GridLayout.LayoutParams params6 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(2);

                            final EditText editText3 = new EditText(context);
                            editText3.setInputType(InputType.TYPE_CLASS_TEXT);
                            editText3.setWidth(400);
                            editText3.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText3, params6);

                            textView = new TextView(context);
                            textView.setText("Text size:");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params7 = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(3);
                            layout.addView(textView, params7);

                            GridLayout.LayoutParams params8 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(3);

                            final EditText editText4 = new EditText(context);
                            editText4.setInputType(InputType.TYPE_CLASS_NUMBER);
                            editText4.setWidth(400);
                            editText4.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText4, params8);

                            textView = new TextView(context);
                            textView.setText("Text colour:");
                            textView.setTextSize(20);
                            textView.setPadding(50, 0, 0 ,0);
                            textView.setGravity(Gravity.CENTER_HORIZONTAL);

                            GridLayout.LayoutParams params9 = new GridLayout.LayoutParams();
                            params.columnSpec = GridLayout.spec(0);
                            params.rowSpec = GridLayout.spec(2);
                            layout.addView(textView, params9);

                            GridLayout.LayoutParams params10 = new GridLayout.LayoutParams();
                            params2.columnSpec = GridLayout.spec(1);
                            params2.rowSpec = GridLayout.spec(2);

                            final EditText editText5 = new EditText(context);
                            editText5.setInputType(InputType.TYPE_CLASS_TEXT);
                            editText5.setWidth(400);
                            editText5.setGravity(Gravity.CENTER_HORIZONTAL);
                            layout.addView(editText5, params10);

                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
                            alertDialogBuilder.setPositiveButton("Ok", new CustomOnClick(v) {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if(!editText1.getText().toString().equals("")) {
                                        getView().setLayoutParams(new LayoutParams(Integer.parseInt(editText1.getText().toString())
                                                ,getView().getHeight()));
                                    }
                                    if(!editText2.getText().toString().equals("")) {
                                        getView().setLayoutParams(new LayoutParams(getView().getWidth(), Integer.parseInt(editText2.getText().toString())));
                                    }
                                    if(!editText3.getText().toString().equals("")) {
                                        SingletonHashmap pagesMapping = SingletonHashmap.getInstance();
                                        HashMap<String, Model> hashMap = pagesMapping.getHashMap();
                                        final Model model = hashMap.get(editText3.getText().toString());
                                        if(model != null) {
                                            getView().setOnClickListener(new OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent = new Intent(activity, CustomActivity.class);
                                                    intent.putExtra("model", model);
                                                    activity.startActivity(intent);
                                                }
                                            });
                                        }
                                    }
                                    if(!editText4.getText().toString().equals("")) {
                                        ((Button) getView()).setTextSize(Integer.parseInt(editText4.getText().toString()));
                                    }
                                    if(!editText5.getText().toString().equals("")) {
                                        ((Button) getView()).setTextColor(getColor(editText5.getText().toString()));
                                    }
                                }
                            });
                            alertDialogBuilder.setTitle("Edit Button");
                            AlertDialog alertDialog = alertDialogBuilder.create();

                            alertDialog.setView(layout);

                            alertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                            alertDialog.show();
                            return true;
                        }
                    });
                    addView(button);
                    break;
                case "Switch":
                    Switch userSwitch = new Switch(context);
                    userSwitch.setOnLongClickListener(new OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
                            alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            alertDialogBuilder.setTitle("Edit Switch");
                            AlertDialog alertDialog = alertDialogBuilder.create();
                            alertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                            alertDialog.show();
                            return true;
                        }
                    });
                    addView(userSwitch);
            }
        }
    }

    private abstract class CustomListener implements OnLongClickListener {
        private View v;
        public CustomListener (View v) {
            this.v = v;
        }
        public View getView() {
            return v;
        }
    }

    private abstract class CustomOnClick implements DialogInterface.OnClickListener {
        private View v;

        public CustomOnClick(View v) {
            this.v = v;
        }

        public View getView() {
            return v;
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
