package com.example.layoutpractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BluetoothConnect {
    //List<String> names;
    private List<Phone> phones;
    private Map<String,Phone> phoneMap;
    private String talkingName;
    //private PhoneState ps;
    public BluetoothConnect(){
        phones = new ArrayList<>();
        phoneMap = new HashMap<>();
        talkingName = "非通知";

        makePhone("たつや",PhoneState.ONLINE);
        makePhone("みか",PhoneState.OFFLINE);
        makePhone("あきのり",PhoneState.OFFLINE);
        makePhone("あきほ",PhoneState.OFFLINE);
        makePhone("たけひろ",PhoneState.ONLINE);
        makePhone("たかよし",PhoneState.ONLINE);
        makePhone("かなえ",PhoneState.OFFLINE);
        makePhone("そら",PhoneState.ONLINE);
        makePhone("まさひと",PhoneState.ONLINE);
        makePhone("まさお",PhoneState.OFFLINE);
    }

    private void makePhone(String NAME,int state){
        this.makePhone(NAME,state,R.drawable.human);
    }
    private void makePhone(String NAME,int state,int icon){
        Phone p = new Phone(NAME,state,icon);
        phones.add(p);
        phoneMap.put(NAME,p);
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public Map<String, Phone> getPhoneMap() {
        return phoneMap;
    }

    public String getTalkingName() {
        return talkingName;
    }

    public void setTalkingName(String talkingName) {
        this.talkingName = talkingName;
    }
}
