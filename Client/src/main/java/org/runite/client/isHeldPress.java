package org.runite.client;

public class isHeldPress {
    private static boolean state = false;
    public static synchronized boolean getState(){
        return state;
    }
    public isHeldPress(boolean state){
        isHeldPress.state = state;
    }
}