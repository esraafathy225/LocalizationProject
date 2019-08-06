package com.sabaya.emcan.localizationproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
CheckBox checkBox,checkBox1;
private static final String FILE="myFile";
String lang;
boolean checked,checked1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox=findViewById(R.id.check);
        checkBox1=findViewById(R.id.check1);
        SharedPreferences shared = getSharedPreferences(FILE, MODE_PRIVATE);
        lang=shared.getString("lang","en");
        checked=shared.getBoolean("checked",false);
        checked1=shared.getBoolean("checked1",false);
        Log.d("checked",checked+"");
        Log.d("checked1",checked1+"");

        if(checked){

            Locale myLocale = new Locale("ar");
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = myLocale;
            res.updateConfiguration(conf, dm);
            conf.setLayoutDirection(new Locale("ar"));
            checkBox.setChecked(checked);
            checkBox1.setChecked(checked1);
        }
            if(checked1){
            Locale myLocale = new Locale("en");
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = myLocale;
            res.updateConfiguration(conf, dm);
            conf.setLayoutDirection(new Locale("en"));
            checkBox.setChecked(checked);
            checkBox1.setChecked(checked1);
        }




        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    SharedPreferences sharedPreferences = getSharedPreferences(FILE, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("lang", "ar");
                    editor.putBoolean("checked", true);
                    editor.putBoolean("checked1", false);
                    editor.apply();
                    checkBox1.setChecked(false);
                    Locale myLocale = new Locale("ar");
                    Resources res = getResources();
                    DisplayMetrics dm = res.getDisplayMetrics();
                    Configuration conf = res.getConfiguration();
                    conf.locale = myLocale;
                    res.updateConfiguration(conf, dm);
                    conf.setLayoutDirection(new Locale("ar"));
                    Intent i = new Intent(MainActivity.this, MainActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(i);

                }}
        });

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    SharedPreferences sharedPreferences = getSharedPreferences(FILE, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("lang", "en");
                    editor.putBoolean("checked1",true);
                    editor.putBoolean("checked", false);
                    editor.apply();
                    checkBox.setChecked(false);
                    Locale myLocale = new Locale("en");
                    Resources res = getResources();
                    DisplayMetrics dm = res.getDisplayMetrics();
                    Configuration conf = res.getConfiguration();
                    conf.locale = myLocale;
                    res.updateConfiguration(conf, dm);
                    conf.setLayoutDirection(new Locale("en"));
                    Intent i=new Intent(MainActivity.this,MainActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(i);
                }
            }
        });
    }
}
