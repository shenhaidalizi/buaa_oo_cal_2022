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


public class PageReplace extends AppCompatActivity implements  View.OnClickListener{

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

    private Button but_fifo;
    private Button but_lru;
    private Button but_clock;
    private Button but_opt;

    private EditText frame_edit;
    private EditText pages_edit;

    private EditText pfTimes_edit;
    private EditText pfRate_edit;
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
        setContentView(R.layout.page_replace);
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

        but_fifo=findViewById(R.id.but_fifo);
        but_lru=findViewById(R.id.but_lru);
        but_clock=findViewById(R.id.but_clock);
        but_opt=findViewById(R.id.but_opt);

        backspace=findViewById(R.id.backspace);
        clean_all=findViewById(R.id.clean_all);
        but_enter=findViewById(R.id.but_enter);

        frame_edit=findViewById(R.id.frame_edit);
        pages_edit=findViewById(R.id.pages_edit);
        pfTimes_edit=findViewById(R.id.pfTimes_edit);
        pfRate_edit=findViewById(R.id.pfRate_edit);

        //        光标显示但不召出软键盘
        frame_edit.setShowSoftInputOnFocus(false);
        pages_edit.setShowSoftInputOnFocus(false);
        pfTimes_edit.setShowSoftInputOnFocus(false);
        pfRate_edit.setShowSoftInputOnFocus(false);


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

        but_fifo.setOnClickListener(this);
        but_lru.setOnClickListener(this);
        but_clock.setOnClickListener(this);
        but_opt.setOnClickListener(this);

        frame_edit.setOnClickListener(this);
        pages_edit.setOnClickListener(this);

        backspace.setOnClickListener(this);
        clean_all.setOnClickListener(this);
        but_enter.setOnClickListener(this);

        frame_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                edit_text_id=1;
                return false;
            }
        });

        pages_edit.setOnTouchListener(new View.OnTouchListener() {
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
            str=frame_edit.getText().toString();
            switch (view.getId()){
                case R.id.but_fifo:
                    algorithm = 1;
                    break;
                case R.id.but_lru:
                    algorithm = 2;
                    break;
                case R.id.but_clock:
                    algorithm = 3;
                    break;
                case R.id.but_opt:
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
                        str=frame_edit.getText().toString();
                        frame_edit.setText(str + ((Button) view).getText().toString() + "");
                        frame_edit.setSelection(frame_edit.getText().length());
                        frame_edit.getSelectionEnd();
                        break;
                    }catch (Exception e){
                    }
                case R.id.but_enter:
                    pCalculate(str,pages_edit.getText().toString());
                    break;
                case R.id.clean_all:
                    frame_edit.setText("");
                    pages_edit.setText("");
                    pfTimes_edit.setText("");
                    pfRate_edit.setText("");
                    break;
                case R.id.backspace:
                    if (!isClean1) {
                        int start = frame_edit.getSelectionStart();
                        int end= frame_edit.getSelectionEnd();
                        str=frame_edit.getText().toString();
                        try{
                            str = str.substring(0,start-1)+str.substring(end,frame_edit.getText().length());
                            frame_edit.setText(str + "" );
                            frame_edit.setSelection(start-1);
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
            str=pages_edit.getText().toString();
            switch (view.getId()){
                case R.id.but_fifo:
                    algorithm = 1;
                    break;
                case R.id.but_lru:
                    algorithm = 2;
                    break;
                case R.id.but_clock:
                    algorithm = 3;
                    break;
                case R.id.but_opt:
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
                        str=pages_edit.getText().toString();
                        pages_edit.setText(str + ((Button) view).getText().toString() + "");
                        pages_edit.setSelection(pages_edit.getText().length());
                        pages_edit.getSelectionEnd();
                        break;
                    }catch (Exception e){
                    }
                case R.id.but_enter:
                    pCalculate(frame_edit.getText().toString(),str);
                    break;
                case R.id.clean_all:
                    frame_edit.setText("");
                    pages_edit.setText("");
                    pfTimes_edit.setText("");
                    pfRate_edit.setText("");
                    break;
                case R.id.backspace:
                    if (!isClean2) {
                        int start = pages_edit.getSelectionStart();
                        int end= pages_edit.getSelectionEnd();
                        str=pages_edit.getText().toString();
                        try{
                            str = str.substring(0,start-1)+str.substring(end,pages_edit.getText().length());
                            pages_edit.setText(str + "" );
                            pages_edit.setSelection(start-1);
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

    public void pCalculate(String frame,String pages){
        String pfTimes_result="哈哈";
        String pfRate_result="呵呵";

        alert(frame+" "+pages);
        /*此处为模拟进程调度算法，待补充*/
        if (algorithm==1){
            pfTimes_result="FIFO";
        }
        else if (algorithm ==2){
            pfTimes_result="LRU";
        }
        else if (algorithm ==3){
            pfTimes_result="CLOCK";
        }
        else if (algorithm ==4){
            pfTimes_result="OPT";
        }
        else
            alert("请选择算法");


        pfTimes_edit.setText(pfTimes_result);
        pfRate_edit.setText(pfRate_result);
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
