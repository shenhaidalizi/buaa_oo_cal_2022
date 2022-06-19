package com.example.calculator2;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;






public class Manager extends AppCompatActivity implements  View.OnClickListener{

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
    private Button but_dian;
    private Button but_fcfs;
    private Button but_sjf;
    private Button but_enter;
    private Button but_e;
    private Button but_f;
    private EditText env_time;
    private EditText env_arr;
    private EditText env_length;
    private EditText env_pri;

    //文本框空标记
    boolean clean=true;
    int type = 1;

    //    操作
    private Button reset;
    private Button backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jin_zhi);
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
        but_dian=findViewById(R.id.but_dian);
        but_fcfs=findViewById(R.id.but_fcfs);
        but_sjf=findViewById(R.id.but_sjf);
        but_enter=findViewById(R.id.but_enter);


        env_arr=findViewById(R.id.arr_edit);
        env_length=findViewById(R.id.length_edit);
        env_pri=findViewById(R.id.pri_edit);
        env_time=findViewById(R.id.time_edit);

        //        光标显示但不召出软键盘
        //env_arr.setShowSoftInputOnFocus(false);
        //env_length.setShowSoftInputOnFocus(false);
        //env_pri.setShowSoftInputOnFocus(false);
        //env_time.setShowSoftInputOnFocus(false);

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
        but_dian.setOnClickListener(this);
        but_fcfs.setOnClickListener(this);
        but_sjf.setOnClickListener(this);
        but_enter.setOnClickListener(this);
        but_e.setOnClickListener(this);
        but_f.setOnClickListener(this);
        env_arr.setOnClickListener(this);
        env_length.setOnClickListener(this);
        env_pri.setOnClickListener(this);
        env_time.setOnClickListener(this);




        env_arr.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

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
                but_dian.setEnabled(true);
                but_fcfs.setEnabled(true);
                but_sjf.setEnabled(true);
                but_enter.setEnabled(true);
                but_e.setEnabled(true);
                but_f.setEnabled(true);
                return false;
            }
        });
        env_length.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
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
                but_dian.setEnabled(true);
                but_fcfs.setEnabled(true);
                but_sjf.setEnabled(true);
                but_enter.setEnabled(true);
                but_e.setEnabled(true);
                but_f.setEnabled(true);
                return false;
            }
        });
        env_pri.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
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
                but_dian.setEnabled(true);
                but_fcfs.setEnabled(true);
                but_sjf.setEnabled(true);
                but_enter.setEnabled(true);
                but_e.setEnabled(true);
                but_f.setEnabled(true);
                return false;
            }
        });
        env_time.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
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
                but_dian.setEnabled(true);
                but_fcfs.setEnabled(true);
                but_sjf.setEnabled(true);
                but_enter.setEnabled(true);

                return false;
            }
        });




    }

    @Override
    public void onClick(View view) {
        String str="";
        int count = -1;
        int value=0;
        double[] arr = new double[100];
        double time = 0;
        double[] length = new double[100];
        int[] pri = new int[100];
        switch (view.getId()){
            case R.id.but_fcfs:
                type = 1;
            case R.id.but_sjf:
                type = 2;
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
            case R.id.but_dian:
                if (clean) {
                    clean = false;
                }
                try {
                    str=env_arr.getText().toString();
                    env_arr.setText(str + ((Button) view).getText().toString() + "");
                    arr[count + 1] = Double.parseDouble(env_arr.getText().toString());
                    str=env_length.getText().toString();
                    env_length.setText(str + ((Button) view).getText().toString() + "");
                    length[count + 1] = Double.parseDouble(env_length.getText().toString());
                    str=env_pri.getText().toString();
                    env_pri.setText(str + ((Button) view).getText().toString() + "");
                    pri[count + 1] = Integer.parseInt(env_pri.getText().toString());
                    count++;
                    break;

                }catch (Exception e){

                }



            case R.id.but_enter:
            case R.id.clean_all:
                if (!clean) {
                    env_arr.setText("");
                    env_length.setText("");
                    env_pri.setText("");
                    env_time.setText("");
                    clean = true;
                    break;
                }
                break;
            case R.id.backspace:
                if (!clean) {
                    try{
                        str=env_arr.getText().toString();
                        env_arr.setText(str + ((Button) view).getText().toString() + "");
                        arr[count + 1] = Double.parseDouble(env_arr.getText().toString());
                        str=env_length.getText().toString();
                        env_length.setText(str + ((Button) view).getText().toString() + "");
                        length[count + 1] = Double.parseDouble(env_length.getText().toString());
                        str=env_pri.getText().toString();
                        env_pri.setText(str + ((Button) view).getText().toString() + "");
                        pri[count + 1] = Integer.parseInt(env_pri.getText().toString());
                        break;

                    }catch (Exception e) {

                    }
                    if (str.equals("")) {
                        clean = true;
                        env_arr.setText("");
                        env_length.setText("");
                        env_pri.setText("");
                        env_time.setText("");
                        break;
                    }
                    break;

                }

        }

    }

}
