package com.example.layoutpractice;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SelectModeActivity extends Activity implements Runnable{
    static final String TAG = "SELECT_MODE_ACTIVITY";
    List<Button> buttons;
    BluetoothConnect bc;
    Thread thread;
    ProgressDialog progressDialog;
    ListView listView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_mode);
        bc = new BluetoothConnect();
        listView = findViewById(R.id.name_list);
        TextView textView = findViewById(R.id.question);
        List<Phone> phones = bc.getPhones();
        ArrayAdapter<Phone> adapter = new ArrayAdapter<Phone>(this, R.layout.name_list_text,phones);
        //BaseAdapter adapter = new PhoneAdapter(this.getApplicationContext(),R.layout.name_list,bc.getPhone());
        listView.setAdapter(adapter);

//        LinearLayout linearLayout = findViewById(R.id.button_linear);
//        TranslateAnimation translateAnimation = new TranslateAnimation(0,0,0,-linearLayout.getHeight()*2);
//        translateAnimation.setDuration(500);
//        translateAnimation.setFillAfter(true);
        AlphaAnimation feedIn_am = new AlphaAnimation(0,1);
        TranslateAnimation slideIn_am = new TranslateAnimation(0,0,0,this.findViewById(R.id.select_constrain).getHeight() * 10);
        feedIn_am.setDuration(500);
        slideIn_am.setDuration(1000);
        //ProgressDialog--------->
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
//        listView = (ListView)findViewById(R.id.name_list);
//        listView.setAdapter(adapter);
//        thread = new Thread( this);
        //<------------ProgressDialog
        buttons = new ArrayList<>();
        buttons.add(findViewById(R.id.ad_hoc_button));
        buttons.add(findViewById(R.id.party_button));
        buttons.add(findViewById(R.id.table_button));
        buttons.add(findViewById(R.id.class_button));
        for(Button b : buttons){
            String[] str = String.valueOf(b.getText()).split("\n");
            String text = "<b>"+str[0]+"</b><br>"+str[1];
            b.setText(Html.fromHtml(text));
            b.setOnClickListener(view -> {
                removeButtons(b);
                textView.setText(R.string.ad_hoc_question);
                listView.setVisibility(View.VISIBLE);
                listView.startAnimation(feedIn_am);
//                listView.startAnimation(slideIn_am);
//                progressDialog.show();
//                thread.start();
            });
        }
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            String[] str = ((TextView)view).getText().toString().split("　　");
            Map<String,Phone> map = bc.getPhoneMap();
            for(String s : str){
                Log.d(TAG,"Array: " + s);
            }
            bc.setTalkingName(str[1]);

            Intent intent = new Intent(SelectModeActivity.this,TalkingActivity.class);
            intent.putExtra("TALKING",bc.getTalkingName());
            intent.putExtra("ICON", Objects.requireNonNull(map.get(str[1])).getIcon());
            startActivity(intent);
            Log.d(TAG,bc.getTalkingName());
        });

    }

    protected void removeButtons(Button button){
        for(Button b : buttons){
            if(!b.equals(button)){
                b.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void run(){
        try{
            thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        progressDialog.dismiss();
        listView.setVisibility(View.VISIBLE);
    }
}
