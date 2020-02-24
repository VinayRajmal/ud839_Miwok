package com.example.android.miwok;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;

public class CampusLinkService extends AccessibilityService {

    @Override
    protected void onServiceConnected() {
        System.out.println("onServiceConnected");
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        info.eventTypes = AccessibilityEvent.TYPE_VIEW_CLICKED;
        info.eventTypes = AccessibilityEvent.TYPES_ALL_MASK;
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_ALL_MASK;
        info.notificationTimeout = 100;
        info.packageNames = null;
        setServiceInfo(info);
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (event.getPackageName().toString().equalsIgnoreCase("com.refmobile")) {
                if (!event.getText().isEmpty()) {
                    String text = event.getText().toString();
                    Toast.makeText(this, text, Toast.LENGTH_LONG).show();
                    AccessibilityNodeInfo currentNode=getRootInActiveWindow();
                    //currentNode.getChild(1).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                    //System.out.println(currentNode.getChildCount());
                    Log.i("Accessibility Info", "Current Node Child Count: " + currentNode.getChildCount());
                    Log.i("Accessibility Info", "Current Node class: " + currentNode.getClassName());
                    //Log.i("Accessibility Info", "Current Node Child Child Count: " + currentNode.getChild(1).toString());
                }
            }
    }

    @Override
    public void onInterrupt() {

    }
}