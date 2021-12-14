package org.runite.client;

public class isHeldPress {
    private static boolean rcState = false;
    public static synchronized boolean getRC(){
        return rcState;
    }
    public isHeldPress(boolean state){
        rcState = state;
    }
}
