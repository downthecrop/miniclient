package org.runite.client;

public class isRightClick {
    private static boolean rcState = false;
    public static synchronized boolean getRC(){
        return rcState;
    }
    public isRightClick(boolean state){
        rcState = state;
    }
}
