package org.runite.client;

public class isRightClick {
    private static boolean state = false;
    public static synchronized boolean getState(){
        return state;
    }
    public isRightClick(boolean state){ isRightClick.state = state; }
}

