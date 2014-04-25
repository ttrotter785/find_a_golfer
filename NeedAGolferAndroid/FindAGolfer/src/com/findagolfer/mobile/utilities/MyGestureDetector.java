package com.findagolfer.mobile.utilities;

import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;

public class MyGestureDetector extends SimpleOnGestureListener
{
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        // i'm only scrolling along the X axis.
    	if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
    		return true;
		return false;
    }
    
   
}    
