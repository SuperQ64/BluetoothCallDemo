package com.example.layoutpractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BluetoothConnect {
    //List<String> names;
    List<Phone> phones;
    Map<String,Phone> phoneMap;
    Phone[] phone;
    private String talkingName;
    //private PhoneState ps;
    public BluetoothConnect(){
        phones = new ArrayList<>();
        phoneMap = new HashMap<>();

        makePhone("たつや",PhoneState.ONLINE,R.mipmap.otake_icon_round);
        makePhone("みか",PhoneState.OFFLINE);
        makePhone("あきのり",PhoneState.OFFLINE);
        makePhone("あきほ",PhoneState.OFFLINE);
        makePhone("たけひろ",PhoneState.ONLINE,R.mipmap.icon2_round);
        makePhone("たかよし",PhoneState.ONLINE);
        makePhone("かなえ",PhoneState.OFFLINE);
        makePhone("そら",PhoneState.ONLINE);
        makePhone("まさひと",PhoneState.ONLINE);
        makePhone("まさお",PhoneState.OFFLINE);

        phone = new Phone[phones.size()];
        makeArrayPhone();

        talkingName = "非通知";
    }

    private void makePhone(String NAME,int state){
        this.makePhone(NAME,state,R.drawable.human);
    }
    private void makePhone(String NAME,int state,int icon){
        Phone p = new Phone(NAME,state,icon);
        phones.add(p);
        phoneMap.put(NAME,p);
    }

    private void makeArrayPhone(){
        for(int i = 0;i < phone.length;i++){
            phone[i] = phones.get(i);
        }
    }

    public Phone[] getPhone() {
        return phone;
    }

    public List<String> getNames() {
        List<String> list = new ArrayList<>();
        for(Phone p : phones){
            list.add(p.getNAME());
        }
        return list;
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
