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


public class Weiyunsuan extends AppCompatActivity implements  View.OnClickListener{
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

    private Button but_and;
    private Button but_or;
    private Button but_not;
    private Button but_shiftleft;
    private Button but_shiftright;

    private EditText n1_edit;
    private EditText op_edit;
    private EditText n2_edit;
    private EditText result_edit;

    private Button backspace;
    private Button clean_all;
    private Button enter;

    //文本框空标记
    boolean isClean1=true;
    boolean isClean2=true;
    boolean isClean3=true;
    int jin_zhi=16;
    boolean enable16=true;
    int edit_text_id=0;




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weiyunsuan);
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
        but_and=findViewById(R.id.but_and);
        but_or=findViewById(R.id.but_or);
        but_not=findViewById(R.id.but_not);
        but_shiftleft=findViewById(R.id.but_shiftleft);
        but_shiftright=findViewById(R.id.but_shiftright);

        backspace=findViewById(R.id.backspace);
        clean_all=findViewById(R.id.clean_all);
        enter=findViewById(R.id.enter);

        n1_edit=findViewById(R.id.n1_edit);
        op_edit=findViewById(R.id.op_edit);
        n2_edit=findViewById(R.id.n2_edit);
        result_edit=findViewById(R.id.result_edit);

        //        光标显示但不召出软键盘
        n1_edit.setShowSoftInputOnFocus(false);
        op_edit.setShowSoftInputOnFocus(false);
        n2_edit.setShowSoftInputOnFocus(false);
        result_edit.setShowSoftInputOnFocus(false);

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
        but_and.setOnClickListener(this);
        but_or.setOnClickListener(this);
        but_not.setOnClickListener(this);
        but_shiftleft.setOnClickListener(this);
        but_shiftright.setOnClickListener(this);

        n1_edit.setOnClickListener(this);
        op_edit.setOnClickListener(this);
        n2_edit.setOnClickListener(this);
        result_edit.setOnClickListener(this);
        backspace.setOnClickListener(this);
        clean_all.setOnClickListener(this);
        enter.setOnClickListener(this);




        n1_edit.setOnTouchListener(new View.OnTouchListener() {
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
                but_a.setEnabled(true);
                but_b.setEnabled(true);
                but_c.setEnabled(true);
                but_d.setEnabled(true);
                but_e.setEnabled(true);
                but_f.setEnabled(true);
                but_and.setEnabled(false);
                but_or.setEnabled(false);
                but_not.setEnabled(false);
                but_shiftleft.setEnabled(false);
                but_shiftright.setEnabled(false);
                return false;
            }
        });

        op_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                edit_text_id=2;
                but_0.setEnabled(false);
                but_1.setEnabled(false);
                but_2.setEnabled(false);
                but_3.setEnabled(false);
                but_4.setEnabled(false);
                but_5.setEnabled(false);
                but_6.setEnabled(false);
                but_7.setEnabled(false);
                but_8.setEnabled(false);
                but_9.setEnabled(false);
                but_a.setEnabled(false);
                but_b.setEnabled(false);
                but_c.setEnabled(false);
                but_d.setEnabled(false);
                but_e.setEnabled(false);
                but_f.setEnabled(false);
                but_and.setEnabled(true);
                but_or.setEnabled(true);
                but_not.setEnabled(true);
                but_shiftleft.setEnabled(true);
                but_shiftright.setEnabled(true);
                return false;
            }
        });
        n2_edit.setOnTouchListener(new View.OnTouchListener() {
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
                but_a.setEnabled(true);
                but_b.setEnabled(true);
                but_c.setEnabled(true);
                but_d.setEnabled(true);
                but_e.setEnabled(true);
                but_f.setEnabled(true);
                but_and.setEnabled(false);
                but_or.setEnabled(false);
                but_not.setEnabled(false);
                but_shiftleft.setEnabled(false);
                but_shiftright.setEnabled(false);
                if (enable16==false){
                    but_a.setEnabled(false);
                    but_b.setEnabled(false);
                    but_c.setEnabled(false);
                    but_d.setEnabled(false);
                    but_e.setEnabled(false);
                    but_f.setEnabled(false);
                }
                return false;
            }
        });
        result_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                edit_text_id=4;
                but_0.setEnabled(false);
                but_1.setEnabled(false);
                but_2.setEnabled(false);
                but_3.setEnabled(false);
                but_4.setEnabled(false);
                but_5.setEnabled(false);
                but_6.setEnabled(false);
                but_7.setEnabled(false);
                but_8.setEnabled(false);
                but_9.setEnabled(false);
                but_a.setEnabled(false);
                but_b.setEnabled(false);
                but_c.setEnabled(false);
                but_d.setEnabled(false);
                but_e.setEnabled(false);
                but_f.setEnabled(false);
                but_and.setEnabled(false);
                but_or.setEnabled(false);
                but_not.setEnabled(false);
                but_shiftleft.setEnabled(false);
                but_shiftright.setEnabled(false);
                clean_all.setEnabled(true);
                return false;
            }
        });




    }

    @Override
    public void onClick(View view) {
        String str="";

        if (edit_text_id==1){
            str=n1_edit.getText().toString();
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
                    if (isClean1)
                        isClean1=false;
                    try {
                        str=n1_edit.getText().toString();
                        n1_edit.setText(str + ((Button) view).getText().toString() + "");
                        n1_edit.setSelection(n1_edit.getText().length());
                        n1_edit.getSelectionEnd();
                        break;
                    }catch (Exception e){
                    }
                case R.id.enter:
                    bitCalculate(str,op_edit.getText().toString(),n2_edit.getText().toString());
                    break;
                case R.id.clean_all:
                    n1_edit.setText("");
                    n2_edit.setText("");
                    op_edit.setText("");
                    result_edit.setText("");
                    break;
                case R.id.backspace:
                    if (!isClean1) {
                        int start = n1_edit.getSelectionStart();
                        int end= n1_edit.getSelectionEnd();
                        str=n1_edit.getText().toString();
                        try{
                            str = str.substring(0,start-1)+str.substring(end,n1_edit.getText().length());
                            n1_edit.setText(str + "" );
                            n1_edit.setSelection(start-1);
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
            switch (view.getId()){
                case R.id.but_and:
                case R.id.but_not:
                case R.id.but_or:
                case R.id.but_shiftleft:
                case R.id.but_shiftright:
                    if (isClean2)
                        isClean2=false;
                    try {
                        str=((Button) view).getText().toString() + "";
                        op_edit.setText(str);
                        op_edit.setSelection(op_edit.getText().length());
                        op_edit.getSelectionEnd();
                        if (str.equals("<<")||str.equals(">>")){
                            enable16=false;
                        }
                        else {
                            enable16=true;
                            if (str.equals("~")){
                                n1_edit.setText("");
                            }
                        }
                        break;
                    }catch (Exception e){
                    }
                case R.id.enter:
                    bitCalculate(n1_edit.getText().toString(),str,n2_edit.getText().toString());
                    break;
                case R.id.clean_all:
                    n1_edit.setText("");
                    n2_edit.setText("");
                    op_edit.setText("");
                    result_edit.setText("");
                    break;
                case R.id.backspace:
                            op_edit.setText("");
                            isClean1 = true;
                            break;

                    }
            }


        else if (edit_text_id==3){
            str=n2_edit.getText().toString();
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
                    if (isClean3)
                        isClean3=false;
                    try {
                        str=n2_edit.getText().toString();
                        n2_edit.setText(str + ((Button) view).getText().toString() + "");
                        n2_edit.setSelection(n2_edit.getText().length());
                        n2_edit.getSelectionEnd();
                        break;
                    }catch (Exception e){
                    }
                case R.id.enter:
                    bitCalculate(n1_edit.getText().toString(),op_edit.getText().toString(),str);
                    break;
                case R.id.clean_all:
                    n1_edit.setText("");
                    n2_edit.setText("");
                    op_edit.setText("");
                    result_edit.setText("");
                    break;
                case R.id.backspace:
                    if (!isClean3) {
                        int start = n2_edit.getSelectionStart();
                        int end= n2_edit.getSelectionEnd();
                        str=n2_edit.getText().toString();
                        try{
                            str = str.substring(0,start-1)+str.substring(end,n2_edit.getText().length());
                            n2_edit.setText(str + "" );
                            n2_edit.setSelection(start-1);
                        }catch (Exception e){
                        }
                        if (str.equals("")) {
                            isClean3 = true;
                            break;
                        }
                    }
            }
        }
        else if (edit_text_id==4) {
            switch (view.getId()) {
                case R.id.clean_all:
                    n1_edit.setText("");
                    n2_edit.setText("");
                    op_edit.setText("");
                    result_edit.setText("");
                    break;
            }
        }
    }

    public void bitCalculate(String str_n1,String str_op,String str_n2){
        String result="???";

        //alert(str_n1+" "+str_op+" "+str_n2);

        /*此处为算法，待补充*/


        result_edit.setText(result);
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
