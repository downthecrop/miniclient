package org.runite.client;

public class isMiddleMouse {
    private static boolean state = false;
    public static synchronized boolean getState(){
        return state;
    }
    public isMiddleMouse(boolean state){
        isMiddleMouse.state = state;
    }
}
