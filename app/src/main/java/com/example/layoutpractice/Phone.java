package com.example.layoutpractice;

import androidx.annotation.NonNull;

public class Phone implements PhoneState{
    private final String NAME;
    private int state;
    private int icon;

    public Phone(String NAME,int state){
        this(NAME,state,R.drawable.human);
    }

    public Phone(String NAME,int state,int icon){
        this.NAME = NAME;
        this.state = state;
        this.icon = icon;
    }

    public String getNAME() {
        return NAME;
    }

    public int getState() {
        return state;
    }

    public int getIcon() {
        return icon;
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
