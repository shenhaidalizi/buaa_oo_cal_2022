package com.example.calculator2;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


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
    private Button but_comma;
    private Button but_fcfs;
    private Button but_sjf;
    private Button but_enter;
    private Button but_e;
    private Button but_f;
    private EditText env_arr;
    private EditText env_length;
    private EditText env_pri;

    private EditText env_wait;
    private EditText env_turnover;
    private EditText pjdqzzsc;
    private EditText pjzzsc;
    //文本框空标记
    boolean isClean1=true;
    boolean isClean2=true;
    boolean isClean3=true;
    int algorithm = 0;                       //算法选择
    int edit_text_id=0;                 //输入框号

    //    操作
    private Button clean_all;
    private Button backspace;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.env_manage);
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
        but_sjf=findViewById(R.id.but_sjf);
        but_enter=findViewById(R.id.but_enter);

        backspace=findViewById(R.id.backspace);
        clean_all=findViewById(R.id.clean_all);

        env_arr=findViewById(R.id.arr_edit);
        env_length=findViewById(R.id.length_edit);
        env_pri=findViewById(R.id.pri_edit);

        env_wait=findViewById(R.id.wait_edit);
        env_turnover=findViewById(R.id.turnover_edit);
        pjzzsc=findViewById(R.id.pjzzsc);
        pjdqzzsc=findViewById(R.id.pjdqzzsc);

        //        光标显示但不召出软键盘
        env_arr.setShowSoftInputOnFocus(false);
        env_length.setShowSoftInputOnFocus(false);
        env_pri.setShowSoftInputOnFocus(false);

        env_wait.setShowSoftInputOnFocus(false);
        env_turnover.setShowSoftInputOnFocus(false);
        pjzzsc.setShowSoftInputOnFocus(false);
        pjdqzzsc.setShowSoftInputOnFocus(false);

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
        but_sjf.setOnClickListener(this);
        but_enter.setOnClickListener(this);
        //but_e.setOnClickListener(this);
        //but_f.setOnClickListener(this);
        env_arr.setOnClickListener(this);
        env_length.setOnClickListener(this);
        env_pri.setOnClickListener(this);
        env_wait.setOnClickListener(this);
        env_turnover.setOnClickListener(this);
        pjzzsc.setOnClickListener(this);
        pjzzsc.setOnClickListener(this);


        backspace.setOnClickListener(this);
        clean_all.setOnClickListener(this);

        env_arr.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                edit_text_id=1;
                return false;
            }
        });

        env_length.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                edit_text_id=2;
                return false;
            }
        });

        env_pri.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                edit_text_id=3;
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
        String str1 ="";
        String str2="";
        String str3="";

        if (edit_text_id==1){
            str1=env_arr.getText().toString();
            switch (view.getId()){
                case R.id.but_fcfs:
                    algorithm = 1;
                    break;
                case R.id.but_sjf:
                    algorithm = 2;
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
                        str1=env_arr.getText().toString();
                        env_arr.setText(str1 + ((Button) view).getText().toString() + "");
                        env_arr.setSelection(env_arr.getText().length());
                        env_arr.getSelectionEnd();
                        break;
                    }catch (Exception e){
                    }
                case R.id.but_enter:
                    Mcalculate(str1,str2,str3);
                    break;
                case R.id.clean_all:
                    env_arr.setText("");
                    env_length.setText("");
                    env_pri.setText("");
                    pjzzsc.setText("");
                    break;
                case R.id.backspace:
                    if (!isClean1) {
                        int start = env_arr.getSelectionStart();
                        int end= env_arr.getSelectionEnd();
                        str1=env_arr.getText().toString();
                        try{
                            str1 = str1.substring(0,start-1)+str1.substring(end,env_arr.getText().length());
                            env_arr.setText(str1 + "" );
                            env_arr.setSelection(start-1);
                        }catch (Exception e){
                        }
                        if (str1.equals("")) {
                            isClean1 = true;
                            break;
                        }
                    }
            }
        }
        else if (edit_text_id==2){
            str2=env_length.getText().toString();
            switch (view.getId()){
                case R.id.but_fcfs:
                    algorithm = 1;
                    break;
                case R.id.but_sjf:
                    algorithm = 2;
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
                        str1=env_length.getText().toString();
                        env_length.setText(str2 + ((Button) view).getText().toString() + "");
                        env_length.setSelection(env_length.getText().length());
                        env_length.getSelectionEnd();
                        break;
                    }catch (Exception e){
                    }
                case R.id.but_enter:
                    Mcalculate(str1,str2,str3);
                    break;
                case R.id.clean_all:
                    env_arr.setText("");
                    env_length.setText("");
                    env_pri.setText("");
                    pjzzsc.setText("");
                    break;
                case R.id.backspace:
                    if (!isClean2) {
                        int start = env_length.getSelectionStart();
                        int end= env_length.getSelectionEnd();
                        str2=env_length.getText().toString();
                        try{
                            str2 = str2.substring(0,start-1)+str2.substring(end,env_length.getText().length());
                            env_length.setText(str2 + "" );
                            env_length.setSelection(start-1);
                        }catch (Exception e){
                        }
                        if (str2.equals("")) {
                            isClean2 = true;
                            break;
                        }
                    }
            }
        }
        else if (edit_text_id==3){
            str3=env_pri.getText().toString();
            switch (view.getId()){
                case R.id.but_fcfs:
                    algorithm = 1;
                    break;
                case R.id.but_sjf:
                    algorithm = 2;
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
                    if (isClean3)
                        isClean3=false;
                    try {
                        str3=env_pri.getText().toString();
                        env_pri.setText(str3 + ((Button) view).getText().toString() + "");
                        env_pri.setSelection(env_pri.getText().length());
                        env_pri.getSelectionEnd();
                        break;
                    }catch (Exception e){
                    }
                case R.id.but_enter:
                    Mcalculate(str1,str2,str3);
                    break;
                case R.id.clean_all:
                    env_arr.setText("");
                    env_length.setText("");
                    env_pri.setText("");
                    env_wait.setText("");
                    env_turnover.setText("");
                    pjzzsc.setText("");
                    pjdqzzsc.setText("");
                    break;
                case R.id.backspace:
                    if (!isClean3) {
                        int start = env_pri.getSelectionStart();
                        int end= env_pri.getSelectionEnd();
                        str3=env_pri.getText().toString();
                        try{
                            str3 = str3.substring(0,start-1)+str3.substring(end,env_pri.getText().length());
                            env_pri.setText(str3 + "" );
                            env_pri.setSelection(start-1);
                        }catch (Exception e){
                        }
                        if (str1.equals("")) {
                            isClean3 = true;
                            break;
                        }
                    }
            }
        }


    }

    public void Mcalculate(String str_arr,String str_length,String str_pri){
        String env_wait_result="哈哈";
        String env_turnover_result="呵呵";
        String pjzzsc_result="吼吼";
        String pjdqzzsc_result="嘿嘿";


        /*此处为模拟进程调度算法，待补充*/
        if (algorithm==1){

        }
        else if (algorithm ==2){

        }
        else
            alert("请选择算法");


        env_wait.setText(env_wait_result);
        env_turnover.setText(env_turnover_result);
        pjzzsc.setText(pjzzsc_result);
        pjdqzzsc.setText(pjdqzzsc_result);
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
