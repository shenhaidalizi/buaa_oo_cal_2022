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

import java.util.Arrays;
import java.util.PriorityQueue;


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
    private EditText maxTrack_edit;

    private EditText process_edit;
    private EditText length_edit;
    private EditText aveLength_edit;
    //文本框空标记
    boolean isClean1=true;
    boolean isClean2=true;
    boolean isClean3=true;
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
        maxTrack_edit=findViewById(R.id.maxTrack_edit);
        process_edit=findViewById(R.id.process_edit);
        length_edit=findViewById(R.id.length_edit);
        aveLength_edit=findViewById(R.id.aveLength_edit);

        //        光标显示但不召出软键盘
        initialTrack_edit.setShowSoftInputOnFocus(false);
        tracks_edit.setShowSoftInputOnFocus(false);
        maxTrack_edit.setShowSoftInputOnFocus(false);
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
        maxTrack_edit.setOnClickListener(this);

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

        maxTrack_edit.setOnTouchListener(new View.OnTouchListener() {
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
                    dCalculate(str,tracks_edit.getText().toString(),maxTrack_edit.getText().toString());
                    break;
                case R.id.clean_all:
                    initialTrack_edit.setText("");
                    tracks_edit.setText("");
                    maxTrack_edit.setText("");
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
                    dCalculate(initialTrack_edit.getText().toString(),str,maxTrack_edit.getText().toString());
                    break;
                case R.id.clean_all:
                    initialTrack_edit.setText("");
                    tracks_edit.setText("");
                    maxTrack_edit.setText("");
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
        else if (edit_text_id==3){
            str=maxTrack_edit.getText().toString();
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
                    if (isClean3)
                        isClean3=false;
                    try {
                        str=maxTrack_edit.getText().toString();
                        maxTrack_edit.setText(str + ((Button) view).getText().toString() + "");
                        maxTrack_edit.setSelection(maxTrack_edit.getText().length());
                        maxTrack_edit.getSelectionEnd();
                        break;
                    }catch (Exception e){
                    }
                case R.id.but_enter:
                    dCalculate(initialTrack_edit.getText().toString(),tracks_edit.getText().toString(),str);
                    break;
                case R.id.clean_all:
                    initialTrack_edit.setText("");
                    tracks_edit.setText("");
                    maxTrack_edit.setText("");
                    process_edit.setText("");
                    length_edit.setText("");
                    aveLength_edit.setText("");
                    break;
                case R.id.backspace:
                    if (!isClean3) {
                        int start = maxTrack_edit.getSelectionStart();
                        int end= maxTrack_edit.getSelectionEnd();
                        str=maxTrack_edit.getText().toString();
                        try{
                            str = str.substring(0,start-1)+str.substring(end,maxTrack_edit.getText().length());
                            maxTrack_edit.setText(str + "" );
                            maxTrack_edit.setSelection(start-1);
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


    public void dCalculate(String initialTrack,String tracks,String maxTrack){
        String process_result="";
        String length_result="";
        String aveLength_result="";

        /*此处为模拟进程调度算法，待补充*/
        if (algorithm==1){
            ret r=callAlgo(initialTrack,tracks,maxTrack,1);
            if (r==null) {
                alert("请检查输入");
                return;
            }
            process_result=r.process;
            length_result=Integer.toString(r.length);
            aveLength_result=Double.toString(r.aveLength);
        }
        else if (algorithm ==2){
            ret r=callAlgo(initialTrack,tracks,maxTrack,2);
            if (r==null) {
                alert("请检查输入");
                return;
            }
            process_result=r.process;
            length_result=Integer.toString(r.length);
            aveLength_result=Double.toString(r.aveLength);
        }
        else if (algorithm ==3){
            ret r=callAlgo(initialTrack,tracks,maxTrack,3);
            if (r==null) {
                alert("请检查输入");
                return;
            }
            process_result=r.process;
            length_result=Integer.toString(r.length);
            aveLength_result=Double.toString(r.aveLength);
        }
        else if (algorithm ==4){
            ret r=callAlgo(initialTrack,tracks,maxTrack,4);
            if (r==null) {
                alert("请检查输入");
                return;
            }
            process_result=r.process;
            length_result=Integer.toString(r.length);
            aveLength_result=Double.toString(r.aveLength);
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




    public static class ret{
        String process;
        int length;
        double aveLength;
        public ret(String p,int l,double al){
            this.process=p;
            this.length=l;
            this.aveLength=al;
        }
    }



    public static ret callAlgo(String initTrack, String tracks,String  maxTrack,int algorithm){
        int init=0;
        String[] tracksstr=new String[100];
        int[] tracksint=new int[100];
        int max=0;

        int trackNum=0;

        try{
            max=Integer.parseInt(maxTrack);
            init=Integer.parseInt(initTrack);
            tracksstr=tracks.split(",");
            trackNum=tracksstr.length;
            if (init>=max)
                return null;
            for (int i=0;i<trackNum;i++){
                tracksint[i]=Integer.parseInt(tracksstr[i]);
                if (tracksint[i]>=max){
                    System.out.println("磁道数有误");
                    return null;
                }
            }
        }
        catch (Exception e){
            System.out.println("输入格式有误");
            return null;
        }


        ret r=null;
        switch (algorithm){
            case 1:
                r=diskSeekFCFS(init,tracksint,max,trackNum);
                break;
            case 2:
                r=diskSeekSSTF(init,tracksint,max,trackNum);
                break;
            case 3:
                r=diskSeekSCAN(init,tracksint,max,trackNum);
                break;
            case 4:
                r=diskSeekCSCAN(init,tracksint,max,trackNum);
                break;
        }

        return r;
    }


    public static ret diskSeekFCFS(int init,int[] tracksint,int max,int trackNum){

        String process="";
        int length=0;

        process+=(init==tracksint[0])?(init):(init+","+tracksint[0]);
        length+=Math.abs(tracksint[0]-init);
        for (int i=1;i<trackNum;i++){
            process+=","+tracksint[i];
            length+=Math.abs(tracksint[i]-tracksint[i-1]);
        }
        double aveLength=(double) length/(double) trackNum;

        return new ret(process,length,aveLength);
    }



    public static ret diskSeekSSTF(int init,int[] tracksint,int max,int trackNum){
        String process="";
        int length=0;


        int now=init;
        int nexti=findNearest(now,tracksint,trackNum);
        int next=tracksint[nexti];
        tracksint[nexti]=10000;
        process+=(init==next)?(init):(init+","+next);
        length+=Math.abs(next-now);
        now=next;

        for (int cnt=2;cnt<=trackNum;cnt++){
            nexti=findNearest(now,tracksint,trackNum);
            next=tracksint[nexti];
            tracksint[nexti]=10000;
            process+=","+next;
            length+=Math.abs(next-now);
            now=next;
        }


        double aveLength=(double) length/(double) trackNum;
        System.out.println(process);
        System.out.println(length+" "+aveLength);

        return new ret(process,length,aveLength);
    }


    public static ret diskSeekSCAN(int init,int[] tracksint,int max,int trackNum){

        String process="";
        int length=0;


        Arrays.sort(tracksint,0,trackNum);

        int i;
        for (i=0;i<trackNum;i++) {
            System.out.print(tracksint[i] + ",");
        }
        for (i=0;i<trackNum;i++){
            if (tracksint[i]>=init){
                break;
            }
        }
        int left=i-1;
        System.out.println("left:"+left);

        process+=(init==tracksint[i])?(init):(init+","+tracksint[i]);
        length+=tracksint[i]-init;
        i++;
        for (;i<trackNum;i++){
            process+=","+tracksint[i];
            length+=(tracksint[i]-tracksint[i-1]);
        }
        process+=","+tracksint[left];
        length+=max-1-tracksint[i-1]+max-1-tracksint[left];
        for (i=left-1;i>=0;i--){
            process+=","+tracksint[i];
            length+=(tracksint[i+1]-tracksint[i]);
        }


        double aveLength=(double) length/(double) trackNum;

        System.out.println("\nprocess:"+process);
        System.out.println(length+" "+aveLength);

        return new ret(process,length,aveLength);
    }


    public static ret diskSeekCSCAN(int init,int[] tracksint,int max,int trackNum){

        String process="";
        int length=0;


        Arrays.sort(tracksint,0,trackNum);

        int i;
        for (i=0;i<trackNum;i++) {
            System.out.print(tracksint[i] + ",");
        }
        for (i=0;i<trackNum;i++){
            if (tracksint[i]>=init){
                break;
            }
        }
        int left=i-1;
        System.out.println("left:"+left);

        process+=(init==tracksint[i])?(init):(init+","+tracksint[i]);
        length+=tracksint[i]-init;
        i++;
        for (;i<trackNum;i++){
            process+=","+tracksint[i];
            length+=(tracksint[i]-tracksint[i-1]);
        }

        process+=","+tracksint[0];
        length+=max-1-tracksint[i-1]+max-1+tracksint[0];
        for (i=1;i<=left;i++){
            process+=","+tracksint[i];
            length+=(tracksint[i]-tracksint[i-1]);
        }


        double aveLength=(double) length/(double) trackNum;

        System.out.println("\nprocess:"+process);
        System.out.println(length+" "+aveLength);

        return new ret(process,length,aveLength);
    }


    public static int findNearest(int now,int[] tracks,int trackNum){
        int min=10000;
        int mini=-1;
        for (int i=0;i<trackNum;i++){
            if (Math.abs(now-tracks[i])<min){
                min=Math.abs(now-tracks[i]);
                mini=i;
            }
        }
        return mini;
    }
}
