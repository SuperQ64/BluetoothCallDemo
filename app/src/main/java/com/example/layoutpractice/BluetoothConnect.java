package com.example.layoutpractice;

import java.util.ArrayList;
import java.util.List;

public class BluetoothConnect {
    List<String> names;
    private String talkingName;
    public BluetoothConnect(){
        names = new ArrayList<>();
        names.add("たつや");
        names.add("みか");
        names.add("あきのり");
        names.add("まさお");
        names.add("まさお");
        names.add("まさお");
        names.add("まさお");
        names.add("まさお");
        names.add("まさお");

        talkingName = "非通知";
    }

    public List<String> getNames() {
        return names;
    }

    public String getTalkingName() {
        return talkingName;
    }

    public void setTalkingName(String talkingName) {
        this.talkingName = talkingName;
    }
}
