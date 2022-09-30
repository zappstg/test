package com.example.myapplication1;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Fragment Fragment_find=new Fragment_find();
    private Fragment Fragment_friend=new Fragment_friend();
    private Fragment Fragment_wechat=new Fragment_wechat();
    private Fragment Fragment_myself=new Fragment_myself();
    private FragmentManager fragmentManager;
    private LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout1=findViewById(R.id.linearLayout1);
        linearLayout2=findViewById(R.id.linearLayout2);
        linearLayout3=findViewById(R.id.linearLayout3);
        linearLayout4=findViewById(R.id.linearLayout4);

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);

        initFragment();
    }

    private void initFragment(){
        fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.id_content,Fragment_wechat);
        transaction.add(R.id.id_content,Fragment_myself);
        transaction.add(R.id.id_content,Fragment_find);
        transaction.add(R.id.id_content,Fragment_friend);
        transaction.commit();
    }


    private void hideFragment(FragmentTransaction transaction){
        transaction.hide(Fragment_wechat);
        transaction.hide(Fragment_myself);
        transaction.hide(Fragment_find);
        transaction.hide(Fragment_friend);
    }
    private void background(View v) {
        switch (v.getId()) {
            case R.id.linearLayout1:
                linearLayout1.setBackgroundColor(Color.parseColor("#426F42"));
                break;
            case R.id.linearLayout2:
                linearLayout2.setBackgroundColor(Color.parseColor("#426F42"));
                break;
            case R.id.linearLayout3:
                linearLayout3.setBackgroundColor(Color.parseColor("#426F42"));
                break;
            case R.id.linearLayout4:
                linearLayout4.setBackgroundColor(Color.parseColor("#426F42"));
                break;
            default:
                break;
        }
    }

    private void backgroundreturn(View v) {
        switch (v.getId()) {
            case R.id.linearLayout1:
                linearLayout1.setBackgroundColor(Color.parseColor("#000000"));
                break;
            case R.id.linearLayout2:
                linearLayout2.setBackgroundColor(Color.parseColor("#000000"));
                break;
            case R.id.linearLayout3:
                linearLayout3.setBackgroundColor(Color.parseColor("#000000"));
                break;
            case R.id.linearLayout4:
                linearLayout4.setBackgroundColor(Color.parseColor("#000000"));
                break;
            default:
                break;
        }
    }

    private void showfragmnet(int i) {

        FragmentTransaction transaction=fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                transaction.show(Fragment_wechat);
                background(linearLayout1);
                backgroundreturn(linearLayout3);
                backgroundreturn(linearLayout2);
                backgroundreturn(linearLayout4);
                break;
            case 1:
                transaction.show(Fragment_friend);
                background(linearLayout2);
                backgroundreturn(linearLayout4);
                backgroundreturn(linearLayout1);
                backgroundreturn(linearLayout3);
                break;
            case 2:
                transaction.show(Fragment_find);
                background(linearLayout3);
                backgroundreturn(linearLayout4);
                backgroundreturn(linearLayout2);
                backgroundreturn(linearLayout1);
                break;
            case 3:
                transaction.show(Fragment_myself);
                background(linearLayout4);
                backgroundreturn(linearLayout1);
                backgroundreturn(linearLayout2);
                backgroundreturn(linearLayout3);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.linearLayout1:
                showfragmnet(0);
                break;
            case R.id.linearLayout2:
                showfragmnet(1);
                break;
            case R.id.linearLayout3:
                showfragmnet(2);
                break;
            case R.id.linearLayout4:
                showfragmnet(3);
                break;
            default:
                break;
        }
    }



}
