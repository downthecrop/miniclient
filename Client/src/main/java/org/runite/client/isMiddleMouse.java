package org.runite.client;

public class isMiddleMouse {
    private static boolean rcState = false;
    public static synchronized boolean getRC(){
        return rcState;
    }
    public isMiddleMouse(boolean state){
        rcState = state;
    }
}
