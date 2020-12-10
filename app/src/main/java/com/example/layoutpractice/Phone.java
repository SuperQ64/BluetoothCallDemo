package com.example.layoutpractice;

import androidx.annotation.NonNull;

public class Phone implements PhoneState{
    private final String NAME;
    private int state;

    public Phone(String NAME,int state){
        this.NAME = NAME;
        this.state = state;
    }

    public String getNAME() {
        return NAME;
    }

    public int getState() {
        return state;
    }

    @NonNull
    @Override
    public String toString() {
        if(state == ONLINE){
            return "o　　" + NAME;
        } else {
            return "×　　" + NAME;
        }
    }
}
