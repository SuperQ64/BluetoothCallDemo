package com.example.layoutpractice;

import java.util.ArrayList;
import java.util.List;

public class BluetoothConnect {
    //List<String> names;
    List<Phone> phones;
    Phone[] phone;
    private String talkingName;
    //private PhoneState ps;
    public BluetoothConnect(){
        phones = new ArrayList<>();


        phones.add(makePhone("たつや",PhoneState.ONLINE));
        phones.add(makePhone("みか",PhoneState.OFFLINE));
        phones.add(makePhone("あきのり",PhoneState.OFFLINE));
        phones.add(makePhone("あきほ",PhoneState.OFFLINE));
        phones.add(makePhone("たけひろ",PhoneState.ONLINE));
        phones.add(makePhone("たかよし",PhoneState.ONLINE));
        phones.add(makePhone("かなえ",PhoneState.OFFLINE));
        phones.add(makePhone("そら",PhoneState.ONLINE));
        phones.add(makePhone("まさひと",PhoneState.ONLINE));
        phones.add(makePhone("まさお",PhoneState.OFFLINE));

        phone = new Phone[phones.size()];
        makeArrayPhone();

        talkingName = "非通知";
    }

    private Phone makePhone(String NAME,int state){
        return new Phone(NAME,state);
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

    public String getTalkingName() {
        return talkingName;
    }

    public void setTalkingName(String talkingName) {
        this.talkingName = talkingName;
    }
}
