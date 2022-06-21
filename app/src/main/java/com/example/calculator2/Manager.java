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
    private Button but_sjf2;
    private Button but_pri;
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
        but_pri=findViewById(R.id.but_pri);
        but_sjf2=findViewById(R.id.but_sjf2);

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
        but_pri.setOnClickListener(this);
        but_sjf2.setOnClickListener(this);
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
                case R.id.but_pri:
                    algorithm = 3;
                    break;
                case R.id.but_sjf2:
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
                        str1=env_arr.getText().toString();
                        env_arr.setText(str1 + ((Button) view).getText().toString() + "");
                        env_arr.setSelection(env_arr.getText().length());
                        env_arr.getSelectionEnd();
                        break;
                    }catch (Exception e){
                    }
                case R.id.but_enter:
                    Mcalculate(str1,env_length.getText().toString(),env_pri.getText().toString());
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
                    //break;
                case R.id.but_sjf:
                    algorithm = 2;
                    break;
                case R.id.but_pri:
                    algorithm = 3;
                    break;
                case R.id.but_sjf2:
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
                        str1=env_length.getText().toString();
                        env_length.setText(str2 + ((Button) view).getText().toString() + "");
                        env_length.setSelection(env_length.getText().length());
                        env_length.getSelectionEnd();
                        break;
                    }catch (Exception e){
                    }
                case R.id.but_enter:
                    Mcalculate(env_arr.getText().toString(),str2,env_pri.getText().toString());
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
                    //break;
                case R.id.but_sjf:
                    algorithm = 2;
                    break;
                case R.id.but_pri:
                    algorithm = 3;
                    break;
                case R.id.but_sjf2:
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
                    Mcalculate(env_arr.getText().toString(),env_length.getText().toString(),str3);
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

        String[] nums1 = str_arr.split(",");
        int length1 = nums1.length;
        String[] nums2 = str_length.split(",");
        int length2 = nums2.length;


        /*if(algorithm == 4){
            String[] nums3 = str_pri.split(",");
            length3 = nums3.length;
            for(int sb = 0;sb < length1;sb++)pri[sb] = Integer.parseInt(nums3[sb]);
        }*/


        String env_wait_result="";
        String env_turnover_result="";
        String pjzzsc_result="";
        String pjdqzzsc_result="";

        //alert("输入非法" + str_arr +"|" +str_length +"|"+ str_pri +"|"+ Integer.toString(length1) + Integer.toString(length2) + Integer.toString(length3) + "|" +  Integer.toString(algorithm));

        if(length1 == length2){

            //alert("init succ!");
            if (algorithm==1){

                int now = 0;
                int arr[] = new int[length1];
                int length[] = new int[length1];
                int pri[] = new int[length1];
                int start[] = new int[length1];
                int wait[] = new int[length1];
                int cir[] = new int[length1];
                int end[] = new int[length1];
                for(int sb = 0;sb < length1;sb++){
                    arr[sb] = Integer.parseInt(nums1[sb]);
                    length[sb] = Integer.parseInt(nums2[sb]);

                }
                int anscir = 0;
                int i;
                i = length1;
                int j;
                int ans = arr[0];
                for(j = 0;j < i;j++){
                    start[j] = ans;
                    ans = ans + length[j];
                    if(j != i - 1 && ans <= arr[j + 1])ans = arr[j + 1];
                }
                for(i = 0;i < length1;i++){
                    wait[i] = start[i] - arr[i];
                    if(i != length1 - 1)env_wait_result = env_wait_result + Integer.toString(wait[i]) + ",";
                    else env_wait_result = env_wait_result + Integer.toString(wait[i]);
                }
                for (i = 0;i < length1;i++){
                    cir[i] = wait[i] + length[i];
                    anscir += cir[i];
                    if(i != length1 - 1)env_turnover_result = env_turnover_result + Integer.toString(cir[i]) + ",";
                    else env_turnover_result = env_turnover_result + Integer.toString(cir[i]);
                }

                double pjzzsc = anscir / length1;
                double pjdqzzsc = 0;
                for (i = 0;i < length1;i++){
                    pjdqzzsc += cir[i] / length[i];
                }
                pjzzsc_result = Double.toString(pjzzsc);
                pjdqzzsc_result = Double.toString(pjdqzzsc);

            }
            else if (algorithm ==2){

                int now = 0;
                int arr[] = new int[length1];
                int length[] = new int[length1];
                int pri[] = new int[length1];
                int start[] = new int[length1];
                int wait[] = new int[length1];
                int cir[] = new int[length1];
                int end[] = new int[length1];
                for(int sb = 0;sb < length1;sb++){
                    arr[sb] = Integer.parseInt(nums1[sb]);
                    length[sb] = Integer.parseInt(nums2[sb]);

                }
                int anscir = 0;
                int i = 0;
                int tepflag[] = new int[100];
                for(int baga = 0;baga < 100;baga++)tepflag[baga] = 0;
                int counttime = 0;
                while(i < length1){
                    int tepi = -1;
                    int teptime = 2147483647;
                    int j;
                    for(j = 0; j < length1 && arr[j] <= counttime;j++){
                        if(tepflag[j] != -1 && length[j] < teptime){
                            teptime = length[j];
                            tepi = j;
                        }
                    }
                    if(tepi != -1){

                        start[tepi] = counttime;
                        i++;
                        counttime = counttime + length[tepi];
                        tepflag[tepi] = -1;

                    }
                    else{
                        counttime = arr[j];
                    }
                }


                for(i = 0;i < length1;i++){
                    wait[i] = start[i] - arr[i];
                    if(i != length1 - 1)env_wait_result = env_wait_result + Integer.toString(wait[i]) + ",";
                    else env_wait_result = env_wait_result + Integer.toString(wait[i]);
                }

                for (i = 0;i < length1;i++){
                    cir[i] = wait[i] + length[i];
                    anscir += cir[i];
                    if(i != length1 - 1)env_turnover_result = env_turnover_result + Integer.toString(cir[i]) + ",";
                    else env_turnover_result = env_turnover_result + Integer.toString(cir[i]);
                }

                double pjzzsc = anscir / length1;
                double pjdqzzsc = 0;
                for (i = 0;i < length1;i++){
                    pjdqzzsc += cir[i] / length[i];
                }
                pjzzsc_result = Double.toString(pjzzsc);
                pjdqzzsc_result = Double.toString(pjdqzzsc);

            }
            else if (algorithm ==3){
                String[] nums3 = str_pri.split(",");
                int length3 = nums3.length;
                if(length3 != length1) alert("输入非法");
                int now = 0;
                int arr[] = new int[length1];
                int length[] = new int[length1];
                int pri[] = new int[length1];
                int start[] = new int[length1];
                int wait[] = new int[length1];
                int cir[] = new int[length1];
                int end[] = new int[length1];
                for(int sb = 0;sb < length1;sb++){
                    arr[sb] = Integer.parseInt(nums1[sb]);
                    length[sb] = Integer.parseInt(nums2[sb]);
                    pri[sb] = Integer.parseInt(nums3[sb]);
                }
                int anscir = 0;
                int flag[] = new int[100];
                for(int sb = 0;sb < 100;sb++)flag[sb] = 0;
                now = arr[0];
                int count = 0;
                int nowenv = 0;
                while(count < length1){
                    int nowpri = 0;
                    //findpri
                    int i;

                    int findenv = 0;
                    for(i = 0;i < length1 && arr[i] <= now;i++){
                        if(flag[i] == 0 && nowpri < pri[i]){
                            nowpri = pri[i];
                            nowenv = i;
                            findenv = 1;
                        }
                    }

                    if(findenv == 1){
                        start[nowenv] = now;
                        flag[nowenv] = -1;
                        now = now + length[nowenv];
                        end[nowenv] = now;
                        count++;

                    }
                    else{
                        int sb;
                        for(sb = 0;sb < length1;sb++){
                            if(arr[sb] > now){
                                now = arr[sb];
                                break;
                            }
                        }
                    }

                }
                int i;
                for(i = 0;i < length1;i++){
                    wait[i] = start[i] - arr[i];
                    if(i != length1 - 1)env_wait_result = env_wait_result + Integer.toString(wait[i]) + ",";
                    else env_wait_result = env_wait_result + Integer.toString(wait[i]);
                }

                for (i = 0;i < length1;i++){
                    cir[i] = wait[i] + length[i];
                    anscir += cir[i];
                    if(i != length1 - 1)env_turnover_result = env_turnover_result + Integer.toString(cir[i]) + ",";
                    else env_turnover_result = env_turnover_result + Integer.toString(cir[i]);
                }

                double pjzzsc = anscir / length1;
                double pjdqzzsc = 0;
                for (i = 0;i < length1;i++){
                    pjdqzzsc += cir[i] / length[i];
                }
                pjzzsc_result = Double.toString(pjzzsc);
                pjdqzzsc_result = Double.toString(pjdqzzsc);
            }
            else if (algorithm ==4){

                int now = 0;
                int arr[] = new int[length1];
                int length[] = new int[length1];
                int pri[] = new int[length1];
                int start[] = new int[length1];
                int wait[] = new int[length1];
                int cir[] = new int[length1];
                int end[] = new int[length1];
                for(int sb = 0;sb < length1;sb++){
                    arr[sb] = Integer.parseInt(nums1[sb]);
                    length[sb] = Integer.parseInt(nums2[sb]);

                }
                int anscir = 0;
                int flag[] = new int[100];
                for(int sb = 0;sb < 100;sb++)flag[sb] = 0;
                int wuyule[] = new int[length1];
                for(int wuyuzi = 0;wuyuzi < length1;wuyuzi++)wuyule[wuyuzi] = length[wuyuzi];
                now = arr[0];
                int i = 0;
                int nexttime = 2147483647;
                while(i < length1){
                    int tepi = -1;
                    int nowlength = 2147483647;
                    int nowj = 2147483647;


                    //findnexttime
                    int sb;
                    for(sb = 0;sb < length1;sb++){
                        if(arr[sb] > now){
                            nexttime = arr[sb];
                            break;
                        }

                    }

                    //findenv
                    int j;
                    int findflag = -1;
                    for(j = 0;j < length1 && arr[j] <= now;j++){

                        if(length[j] != 0 && length[j] < nowlength){
                            nowj = j;
                            nowlength = length[j];
                            findflag = 0;
                        }
                    }
                    int teplength = nexttime - now;
                   // printf("%d %d %d\n",nowj,nexttime,nexttime - now);
                    if(findflag == 0){
                        if(flag[nowj] == 0)start[nowj] = now;
                        flag[nowj]++;
                        if(teplength == 0)teplength = 2147483647;
                        if(teplength >= length[nowj]){
                            end[nowj] = now + length[nowj];
                            nexttime = now + length[nowj];
                            length[nowj] = 0;
                            flag[nowj] = -1;
                            i++;
                        }
                        else{
                            length[nowj] = length[nowj] - (nexttime - now);
                        }
                    }
                    else{
                        int dsb;
                        for(dsb = 0;dsb < length1;dsb++){
                            if(arr[dsb] > now){
                                nexttime = arr[dsb];
                                break;
                            }
                        }
                    }



                    if(nexttime - now <= 0){
                        int ddsb;
                        for(ddsb = 0;ddsb < length1;ddsb++){
                            if(length[ddsb] != 0){
                                if(flag[ddsb] == 0)start[ddsb] = now;
                                now = now + length[ddsb];
                                length[ddsb] = 0;
                                flag[ddsb] = -1;
                                end[ddsb] = now;
                                i++;
                            }
                        }
                    }
                    now = nexttime;
                }

                for(i = 0;i < length1;i++){
                    wait[i] = start[i] - arr[i];
                    if(i != length1 - 1)env_wait_result = env_wait_result + Integer.toString(wait[i]) + ",";
                    else env_wait_result = env_wait_result + Integer.toString(wait[i]);
                }

                for (i = 0;i < length1;i++){
                    cir[i] = end[i] - arr[i];
                    anscir += cir[i];
                    if(i != length1 - 1)env_turnover_result = env_turnover_result + Integer.toString(cir[i])+ ",";
                    else env_turnover_result = env_turnover_result +  Integer.toString(cir[i]);
                }

                double pjzzsc = anscir / length1;
                double pjdqzzsc = 0;
                for (i = 0;i < length1;i++){
                    pjdqzzsc += cir[i] / wuyule[i];
                }
                pjzzsc_result = Double.toString(pjzzsc);
                pjdqzzsc_result = Double.toString(pjdqzzsc);

            }
            else
                alert("请选择算法");
        }
        else {

        }


        /*此处为模拟进程调度算法，待补充*/




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
