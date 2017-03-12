package fbhack.martaungureanu.appgen;

import android.support.v7.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.view.Gravity;
import android.widget.TextView;

import fbhack.martaungureanu.appgen.utils.Model;

public class CustomActivity extends AppCompatActivity {
    private CustomView view;
    private Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = (Model) getIntent().getSerializableExtra("model");
        view = new CustomView(getApplicationContext(), model);
        final boolean isNew = getIntent().getBooleanExtra("isNew", true);

        setContentView(view);

        view.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()) {
            @Override
            public void onSwipeLeft() {
                AlertDialog.Builder builder;
                if(isNew){
                    builder = createDialogBuilder(getString(R.string.new_fragment_dialog_title));
                    final EditText editText = new EditText(getApplicationContext());
                    builder.setView(editText);

                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            restartPagesActivity(editText.getText().toString(), true);
                        }
                    });
                } else {
                    builder = createDialogBuilder(getString(R.string.old_fragment_dialog_title));
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            restartPagesActivity("", true);
                        }
                    });
                }
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        TextView textView = new TextView(this);
        textView.setText("Click on an element to edit it. Swipe left when you are done.");
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        textView.setTextSize(20);
        alertDialogBuilder.setView(textView);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void restartPagesActivity(String name, boolean isNew) {
        Intent intent = new Intent(this, PagesActivity.class);
        if(isNew) {
            intent.putExtra("model", model);
            intent.putExtra("pageName", name);
        }
        startActivity(intent);
    }

    private AlertDialog.Builder createDialogBuilder(final String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(title);

        return builder;
    }

    private class OnSwipeTouchListener implements View.OnTouchListener {

        private final GestureDetector gestureDetector;

        public OnSwipeTouchListener(Context context) {
            gestureDetector = new GestureDetector(context, new GestureListener());
        }

        public void onSwipeLeft() {
        }

        public void onSwipeRight() {
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return gestureDetector.onTouchEvent(event);
        }

        private final class GestureListener extends GestureDetector.SimpleOnGestureListener {

            private static final int SWIPE_DISTANCE_THRESHOLD = 100;
            private static final int SWIPE_VELOCITY_THRESHOLD = 100;

            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                float distanceX = e2.getX() - e1.getX();
                float distanceY = e2.getY() - e1.getY();
                if (Math.abs(distanceX) > Math.abs(distanceY) && Math.abs(distanceX) > SWIPE_DISTANCE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (distanceX > 0)
                        onSwipeRight();
                    else
                        onSwipeLeft();
                    return true;
                }
                return false;
            }
        }

    }
}
