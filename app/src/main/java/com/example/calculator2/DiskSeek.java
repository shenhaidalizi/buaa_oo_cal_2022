package com.example.calculator2;


import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


public class DiskSeek extends AppCompatActivity implements  View.OnClickListener{

    private Button but_0;
    private Button but_1;
    private Button but_2;
    private Button but_3;
    private Button but_4;
    private Button but_5;
    private Button but_6;
    private Button but_7;
    private Button but_8;
    private Button but_9;
    private Button but_comma;

    private Button but_fcfs;
    private Button but_sstf;
    private Button but_scan;
    private Button but_cscan;

    private EditText initialTrack_edit;
    private EditText tracks_edit;

    private EditText process_edit;
    private EditText length_edit;
    private EditText aveLength_edit;
    //文本框空标记
    boolean isClean1=true;
    boolean isClean2=true;
    int algorithm = 0;                       //算法选择
    int edit_text_id=0;                 //输入框号

    //    操作
    private Button clean_all;
    private Button backspace;
    private Button but_enter;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disk_seek);
        but_0=findViewById(R.id.but_0);
        but_1=findViewById(R.id.but_1);
        but_2=findViewById(R.id.but_2);
        but_3=findViewById(R.id.but_3);
        but_4=findViewById(R.id.but_4);
        but_5=findViewById(R.id.but_5);
        but_6=findViewById(R.id.but_6);
        but_7=findViewById(R.id.but_7);
        but_8=findViewById(R.id.but_8);
        but_9=findViewById(R.id.but_9);
        but_comma=findViewById(R.id.but_comma);

        but_fcfs=findViewById(R.id.but_fcfs);
        but_sstf=findViewById(R.id.but_sstf);
        but_scan=findViewById(R.id.but_scan);
        but_cscan=findViewById(R.id.but_cscan);

        backspace=findViewById(R.id.backspace);
        clean_all=findViewById(R.id.clean_all);
        but_enter=findViewById(R.id.but_enter);

        initialTrack_edit=findViewById(R.id.initialTrack_edit);
        tracks_edit=findViewById(R.id.tracks_edit);
        process_edit=findViewById(R.id.process_edit);
        length_edit=findViewById(R.id.length_edit);
        aveLength_edit=findViewById(R.id.aveLength_edit);

        //        光标显示但不召出软键盘
        initialTrack_edit.setShowSoftInputOnFocus(false);
        tracks_edit.setShowSoftInputOnFocus(false);
        process_edit.setShowSoftInputOnFocus(false);
        length_edit.setShowSoftInputOnFocus(false);
        aveLength_edit.setShowSoftInputOnFocus(false);


        but_0.setOnClickListener(this);
        but_1.setOnClickListener(this);
        but_2.setOnClickListener(this);
        but_3.setOnClickListener(this);
        but_4.setOnClickListener(this);
        but_5.setOnClickListener(this);
        but_6.setOnClickListener(this);
        but_7.setOnClickListener(this);
        but_8.setOnClickListener(this);
        but_9.setOnClickListener(this);
        but_comma.setOnClickListener(this);

        but_fcfs.setOnClickListener(this);
        but_sstf.setOnClickListener(this);
        but_scan.setOnClickListener(this);
        but_cscan.setOnClickListener(this);

        initialTrack_edit.setOnClickListener(this);
        tracks_edit.setOnClickListener(this);

        backspace.setOnClickListener(this);
        clean_all.setOnClickListener(this);
        but_enter.setOnClickListener(this);

        initialTrack_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                edit_text_id=1;
                return false;
            }
        });

        tracks_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                edit_text_id=2;
                return false;
            }
        });
    }


    @Override
    public void onClick(View view) {
        String str="";

        if (edit_text_id==1){
            str=initialTrack_edit.getText().toString();
            switch (view.getId()){
                case R.id.but_fcfs:
                    algorithm = 1;
                    break;
                case R.id.but_sstf:
                    algorithm = 2;
                    break;
                case R.id.but_scan:
                    algorithm = 3;
                    break;
                case R.id.but_cscan:
                    algorithm = 4;
                    break;

                case R.id.but_0:
                case R.id.but_1:
                case R.id.but_2:
                case R.id.but_3:
                case R.id.but_4:
                case R.id.but_5:
                case R.id.but_6:
                case R.id.but_7:
                case R.id.but_8:
                case R.id.but_9:
                case R.id.but_comma:
                    if (isClean1)
                        isClean1=false;
                    try {
                        str=initialTrack_edit.getText().toString();
                        initialTrack_edit.setText(str + ((Button) view).getText().toString() + "");
                        initialTrack_edit.setSelection(initialTrack_edit.getText().length());
                        initialTrack_edit.getSelectionEnd();
                        break;
                    }catch (Exception e){
                    }
                case R.id.but_enter:
                    dCalculate(str,tracks_edit.getText().toString());
                    break;
                case R.id.clean_all:
                    initialTrack_edit.setText("");
                    tracks_edit.setText("");
                    process_edit.setText("");
                    length_edit.setText("");
                    aveLength_edit.setText("");
                    break;
                case R.id.backspace:
                    if (!isClean1) {
                        int start = initialTrack_edit.getSelectionStart();
                        int end= initialTrack_edit.getSelectionEnd();
                        str=initialTrack_edit.getText().toString();
                        try{
                            str = str.substring(0,start-1)+str.substring(end,initialTrack_edit.getText().length());
                            initialTrack_edit.setText(str + "" );
                            initialTrack_edit.setSelection(start-1);
                        }catch (Exception e){
                        }
                        if (str.equals("")) {
                            isClean1 = true;
                            break;
                        }
                    }
            }
        }
        else if (edit_text_id==2){
            str=tracks_edit.getText().toString();
            switch (view.getId()){
                case R.id.but_fcfs:
                    algorithm = 1;
                    break;
                case R.id.but_sstf:
                    algorithm = 2;
                    break;
                case R.id.but_scan:
                    algorithm = 3;
                    break;
                case R.id.but_cscan:
                    algorithm = 4;
                    break;

                case R.id.but_0:
                case R.id.but_1:
                case R.id.but_2:
                case R.id.but_3:
                case R.id.but_4:
                case R.id.but_5:
                case R.id.but_6:
                case R.id.but_7:
                case R.id.but_8:
                case R.id.but_9:
                case R.id.but_comma:
                    if (isClean2)
                        isClean2=false;
                    try {
                        str=tracks_edit.getText().toString();
                        tracks_edit.setText(str + ((Button) view).getText().toString() + "");
                        tracks_edit.setSelection(tracks_edit.getText().length());
                        tracks_edit.getSelectionEnd();
                        break;
                    }catch (Exception e){
                    }
                case R.id.but_enter:
                    dCalculate(initialTrack_edit.getText().toString(),str);
                    break;
                case R.id.clean_all:
                    initialTrack_edit.setText("");
                    tracks_edit.setText("");
                    process_edit.setText("");
                    length_edit.setText("");
                    aveLength_edit.setText("");
                    break;
                case R.id.backspace:
                    if (!isClean2) {
                        int start = tracks_edit.getSelectionStart();
                        int end= tracks_edit.getSelectionEnd();
                        str=tracks_edit.getText().toString();
                        try{
                            str = str.substring(0,start-1)+str.substring(end,tracks_edit.getText().length());
                            tracks_edit.setText(str + "" );
                            tracks_edit.setSelection(start-1);
                        }catch (Exception e){
                        }
                        if (str.equals("")) {
                            isClean2 = true;
                            break;
                        }
                    }
            }
        }
    }


    public void dCalculate(String initialTrack,String tracks){
        String process_result="哈哈";
        String length_result="呵呵";
        String aveLength_result="呵呵";

        alert(initialTrack+" "+tracks);
        /*此处为模拟进程调度算法，待补充*/
        if (algorithm==1){
            process_result="FCFS";
        }
        else if (algorithm ==2){
            process_result="SSTF";
        }
        else if (algorithm ==3){
            process_result="SCAN";
        }
        else if (algorithm ==4){
            process_result="CSAN";
        }
        else
            alert("请选择算法");


        process_edit.setText(process_result);
        length_edit.setText(length_result);
        aveLength_edit.setText(aveLength_result);
    }

    public void alert(String s){
        new AlertDialog.Builder(this)
                .setTitle("alert")//标题
                .setMessage(s)//内容
                .setIcon(R.mipmap.ic_launcher)//图标
                .create()
                .show();
    }
}
