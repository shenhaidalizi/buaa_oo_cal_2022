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


public class Dizhijiexi extends AppCompatActivity implements  View.OnClickListener{
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
    private Button but_a;
    private Button but_b;
    private Button but_c;
    private Button but_d;
    private Button but_e;
    private Button but_f;
    private EditText addr_edit;
    private EditText bit1_edit;
    private EditText bit2_edit;
    private EditText bit3_edit;
    private EditText result1_edit;
    private EditText result2_edit;
    private EditText result3_edit;

    private Button backspace;
    private Button clean_all;
    private Button enter;

    //文本框空标记
    boolean isCleanA=true;
    boolean isClean1=true;
    boolean isClean2=true;
    boolean isClean3=true;
    boolean enable16=true;
    int edit_text_id=0;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dizhijiexi);
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
        but_a=findViewById(R.id.but_a);
        but_b=findViewById(R.id.but_b);
        but_c=findViewById(R.id.but_c);
        but_d=findViewById(R.id.but_d);
        but_e=findViewById(R.id.but_e);
        but_f=findViewById(R.id.but_f);

        backspace=findViewById(R.id.backspace);
        clean_all=findViewById(R.id.clean_all);
        enter=findViewById(R.id.enter);

        addr_edit=findViewById(R.id.addr_edit);
        bit1_edit=findViewById(R.id.bit1_edit);
        bit2_edit=findViewById(R.id.bit2_edit);
        bit3_edit=findViewById(R.id.bit3_edit);
        result1_edit=findViewById(R.id.result1_edit);
        result2_edit=findViewById(R.id.result2_edit);
        result3_edit=findViewById(R.id.result3_edit);

        //        光标显示但不召出软键盘
        addr_edit.setShowSoftInputOnFocus(false);
        bit1_edit.setShowSoftInputOnFocus(false);
        bit2_edit.setShowSoftInputOnFocus(false);
        bit3_edit.setShowSoftInputOnFocus(false);
        result1_edit.setShowSoftInputOnFocus(false);
        result2_edit.setShowSoftInputOnFocus(false);
        result3_edit.setShowSoftInputOnFocus(false);

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
        but_a.setOnClickListener(this);
        but_b.setOnClickListener(this);
        but_c.setOnClickListener(this);
        but_d.setOnClickListener(this);
        but_e.setOnClickListener(this);
        but_f.setOnClickListener(this);
        addr_edit.setOnClickListener(this);
        bit1_edit.setOnClickListener(this);
        bit2_edit.setOnClickListener(this);
        bit3_edit.setOnClickListener(this);

        backspace.setOnClickListener(this);
        clean_all.setOnClickListener(this);
        enter.setOnClickListener(this);





        bit1_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                edit_text_id=1;
                but_0.setEnabled(true);
                but_1.setEnabled(true);
                but_2.setEnabled(true);
                but_3.setEnabled(true);
                but_4.setEnabled(true);
                but_5.setEnabled(true);
                but_6.setEnabled(true);
                but_7.setEnabled(true);
                but_8.setEnabled(true);
                but_9.setEnabled(true);
                but_a.setEnabled(false);
                but_b.setEnabled(false);
                but_c.setEnabled(false);
                but_d.setEnabled(false);
                but_e.setEnabled(false);
                but_f.setEnabled(false);
                return false;
            }
        });
        bit2_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                edit_text_id=2;
                but_0.setEnabled(true);
                but_1.setEnabled(true);
                but_2.setEnabled(true);
                but_3.setEnabled(true);
                but_4.setEnabled(true);
                but_5.setEnabled(true);
                but_6.setEnabled(true);
                but_7.setEnabled(true);
                but_8.setEnabled(true);
                but_9.setEnabled(true);
                but_a.setEnabled(false);
                but_b.setEnabled(false);
                but_c.setEnabled(false);
                but_d.setEnabled(false);
                but_e.setEnabled(false);
                but_f.setEnabled(false);
                return false;
            }
        });
        bit3_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                edit_text_id=3;
                but_0.setEnabled(true);
                but_1.setEnabled(true);
                but_2.setEnabled(true);
                but_3.setEnabled(true);
                but_4.setEnabled(true);
                but_5.setEnabled(true);
                but_6.setEnabled(true);
                but_7.setEnabled(true);
                but_8.setEnabled(true);
                but_9.setEnabled(true);
                but_a.setEnabled(false);
                but_b.setEnabled(false);
                but_c.setEnabled(false);
                but_d.setEnabled(false);
                but_e.setEnabled(false);
                but_f.setEnabled(false);
                return false;
            }
        });
        addr_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                edit_text_id=0;
                but_0.setEnabled(true);
                but_1.setEnabled(true);
                but_2.setEnabled(true);
                but_3.setEnabled(true);
                but_4.setEnabled(true);
                but_5.setEnabled(true);
                but_6.setEnabled(true);
                but_7.setEnabled(true);
                but_8.setEnabled(true);
                but_9.setEnabled(true);
                but_a.setEnabled(true);
                but_b.setEnabled(true);
                but_c.setEnabled(true);
                but_d.setEnabled(true);
                but_e.setEnabled(true);
                but_f.setEnabled(true);
                return false;
            }
        });



    }

    @Override
    public void onClick(View view) {
        String str="";
        //int count = -1;
        //int value=0;
        //double[] arr = new double[100];
        //double time = 0;
        //double[] length = new double[100];
        //int[] pri = new int[100];


        if (edit_text_id==0){
            str=addr_edit.getText().toString();
            switch (view.getId()){
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
                case R.id.but_a:
                case R.id.but_b:
                case R.id.but_c:
                case R.id.but_d:
                case R.id.but_e:
                case R.id.but_f:
                    if (isCleanA)
                        isCleanA=false;
                    try {
                        str=addr_edit.getText().toString();
                        addr_edit.setText(str + ((Button) view).getText().toString() + "");
                        addr_edit.setSelection(addr_edit.getText().length());
                        addr_edit.getSelectionEnd();
                        break;
                    }catch (Exception e){
                    }
                case R.id.enter:
                    dzjxCalculate(str,bit1_edit.getText().toString(),bit2_edit.getText().toString(),bit3_edit.getText().toString());
                    break;
                case R.id.clean_all:
                    addr_edit.setText("");
                    bit1_edit.setText("");
                    bit2_edit.setText("");
                    bit3_edit.setText("");
                    result1_edit.setText("");
                    result2_edit.setText("");
                    result3_edit.setText("");
                    break;
                case R.id.backspace:
                    if (!isCleanA) {
                        int start = addr_edit.getSelectionStart();
                        int end= addr_edit.getSelectionEnd();
                        str=addr_edit.getText().toString();
                        try{
                            str = str.substring(0,start)+str.substring(end,addr_edit.getText().length());
                            addr_edit.setText(str + "" );
                            addr_edit.setSelection(start);
                        }catch (Exception e){
                        }
                        if (str.equals("")) {
                            isCleanA = true;
                            break;
                        }
                    }
            }
        }

        else if (edit_text_id==1){
            str=bit1_edit.getText().toString();
            switch (view.getId()){
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
                    if (isClean1)
                        isClean1=false;
                    try {
                        str=bit1_edit.getText().toString();
                        bit1_edit.setText(str + ((Button) view).getText().toString() + "");
                        bit1_edit.setSelection(bit1_edit.getText().length());
                        bit1_edit.getSelectionEnd();
                        break;
                    }catch (Exception e){
                    }
                case R.id.enter:
                    dzjxCalculate(addr_edit.getText().toString(),str,bit2_edit.getText().toString(),bit3_edit.getText().toString());
                    break;
                case R.id.clean_all:
                    addr_edit.setText("");
                    bit1_edit.setText("");
                    bit2_edit.setText("");
                    bit3_edit.setText("");
                    result1_edit.setText("");
                    result2_edit.setText("");
                    result3_edit.setText("");
                    break;
                case R.id.backspace:
                    if (!isClean1) {
                        int start = bit1_edit.getSelectionStart();
                        int end= bit1_edit.getSelectionEnd();
                        str=bit1_edit.getText().toString();
                        try{
                            str = str.substring(0,start)+str.substring(end,bit1_edit.getText().length());
                            bit1_edit.setText(str + "" );
                            bit1_edit.setSelection(start);
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
            str=bit2_edit.getText().toString();
            switch (view.getId()){
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
                    if (isClean2)
                        isClean2=false;
                    try {
                        str=bit2_edit.getText().toString();
                        bit2_edit.setText(str + ((Button) view).getText().toString() + "");
                        bit2_edit.setSelection(bit2_edit.getText().length());
                        bit2_edit.getSelectionEnd();
                        break;
                    }catch (Exception e){
                    }
                case R.id.enter:
                    dzjxCalculate(addr_edit.getText().toString(),bit1_edit.getText().toString(),str,bit3_edit.getText().toString());
                    break;
                case R.id.clean_all:
                    addr_edit.setText("");
                    bit1_edit.setText("");
                    bit2_edit.setText("");
                    bit3_edit.setText("");
                    result1_edit.setText("");
                    result2_edit.setText("");
                    result3_edit.setText("");
                    break;
                case R.id.backspace:
                    if (!isClean2) {
                        int start = bit2_edit.getSelectionStart();
                        int end= bit2_edit.getSelectionEnd();
                        str=bit2_edit.getText().toString();
                        try{
                            str = str.substring(0,start)+str.substring(end,bit2_edit.getText().length());
                            bit2_edit.setText(str + "" );
                            bit2_edit.setSelection(start);
                        }catch (Exception e){
                        }
                        if (str.equals("")) {
                            isClean2 = true;
                            break;
                        }
                    }
            }
        }
        else if (edit_text_id==3){
            str=bit3_edit.getText().toString();
            switch (view.getId()){
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
                    if (isClean3)
                        isClean3=false;
                    try {
                        str=bit3_edit.getText().toString();
                        bit3_edit.setText(str + ((Button) view).getText().toString() + "");
                        bit3_edit.setSelection(bit3_edit.getText().length());
                        bit3_edit.getSelectionEnd();
                        break;
                    }catch (Exception e){
                    }
                case R.id.enter:
                    dzjxCalculate(addr_edit.getText().toString(),bit1_edit.getText().toString(),bit2_edit.getText().toString(),str);
                    break;
                case R.id.clean_all:
                    addr_edit.setText("");
                    bit1_edit.setText("");
                    bit2_edit.setText("");
                    bit3_edit.setText("");
                    result1_edit.setText("");
                    result2_edit.setText("");
                    result3_edit.setText("");
                    break;
                case R.id.backspace:
                    if (!isClean1) {
                        int start = bit3_edit.getSelectionStart();
                        int end= bit3_edit.getSelectionEnd();
                        str=bit3_edit.getText().toString();
                        try{
                            str = str.substring(0,start)+str.substring(end,bit3_edit.getText().length());
                            bit3_edit.setText(str + "" );
                            bit3_edit.setSelection(start);
                        }catch (Exception e){
                        }
                        if (str.equals("")) {
                            isClean3 = true;
                            break;
                        }
                    }
            }
        }



    }

    public void dzjxCalculate(String addr,String bit1,String bit2,String bit3){
        String result1="???";
        String result2="...";
        String result3="!!!";

        //alert(addr+" "+bit1+" "+bit2+" "+bit3);

        int address=Integer.parseInt(addr,16);
        int b1=Integer.parseInt(bit1,10);
        int b2=Integer.parseInt(bit2,10);
        int b3=Integer.parseInt(bit3,10);
        int r1=address>>(b2+b3);
        int r2=(address>>b3)%(int)Math.pow(2,b2);
        int r3=address%(int)Math.pow(2,b3);

        result1="0x"+Integer.toHexString(r1);
        result2="0x"+Integer.toHexString(r2);
        result3="0x"+Integer.toHexString(r3);

        result1_edit.setText(result1);
        result2_edit.setText(result2);
        result3_edit.setText(result3);
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
