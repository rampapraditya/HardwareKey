package com.pramedia.hardwarekey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    private boolean shortPress = false;
    private boolean longPress = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        //Log.i("key pressed", String.valueOf(event.getKeyCode()));
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (keyCode == 141){
            Log.d("AAA", "Long Press");
            //Long Press code goes here
            shortPress = false;
            longPress = true;
            return true;
        }
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 141) {
            event.startTracking();
            if (longPress == true) {
                shortPress = false;
            } else {
                shortPress = true;
                longPress = false;
            }

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == 141) {
            event.startTracking();
            if (shortPress) {
                Log.d("AAA", "Short Press");
                //Short Press code goes here
            }
            Log.d("AAA", "Diangkat");

            shortPress = true;
            longPress = false;
            return true;
        }

        return super.onKeyUp(keyCode, event);
    }
}