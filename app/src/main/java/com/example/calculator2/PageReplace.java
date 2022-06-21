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
        String pfTimes_result="";
        String pfRate_result="";

        //alert(frame+" "+pages);
        /*此处为模拟进程调度算法，待补充*/
        ret r=new ret(0,0);
        if (algorithm==1){
            //pfTimes_result="FIFO";
            r=callAlgorithm(frame,pages,1);
            pfTimes_result=Integer.toString(r.pfTimes);
            pfRate_result=Double.toString(r.pfRate);
        }
        else if (algorithm ==2){
            //pfTimes_result="LRU";
            r=callAlgorithm(frame,pages,2);
            pfTimes_result=Integer.toString(r.pfTimes);
            pfRate_result=Double.toString(r.pfRate);
        }
        else if (algorithm ==3){
            pfTimes_result="CLOCK";
            r=callAlgorithm(frame,pages,3);
            pfTimes_result=Integer.toString(r.pfTimes);
            pfRate_result=Double.toString(r.pfRate);
        }
        else if (algorithm ==4){
            pfTimes_result="OPT";
            r=callAlgorithm(frame,pages,4);
            pfTimes_result=Integer.toString(r.pfTimes);
            pfRate_result=Double.toString(r.pfRate);
        }
        else
            alert("请选择算法");

        pfTimes_edit.setText(pfTimes_result);
        pfRate_edit.setText(pfRate_result);

        if (r.pfTimes==-1) {
            pfTimes_edit.setText("");
            pfRate_edit.setText("");
            alert("请输入有效数据");
        }
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
        int pfTimes;
        double pfRate;
        public ret(int t,double r){
            this.pfTimes=t;
            this.pfRate=r;
        }
    }
    static class Frame{
        int index;
        int page;
        int inTime;
        int noUseTime;
        int nextUse=0xffff;
        int lastUse=-1;
        int clockFlag;
        public Frame(int index){
            this.index=index;
            this.page=-1;
            this.inTime=-1;
            this.noUseTime=0xffff;
            this.nextUse=0xffff;
            this.lastUse=-1;
            this.clockFlag = 0;
        }
    }


    //相当于接口，参数转换，调用置换算法
    public static ret callAlgorithm(String frame, String pages,int algorithm){
        int frameNum = 0;
        String[]pagesstr;
        int[] pagesint = new int[100];
        int pageNum = 0;

        try{
            frameNum=Integer.parseInt(frame);
            pagesstr=pages.split(",");
            pageNum=pagesstr.length;
            for (int i=0;i<pageNum;i++){
                pagesint[i]=Integer.parseInt(pagesstr[i]);
            }
        }
        catch (Exception e){
            System.out.println("输入格式错误");
        }

        if (pageNum==0)
            return new ret(-1,-1);

        int pfTimes=0;
        switch (algorithm){
            case 1:
                pfTimes=pageDefaultFIFO(frameNum,pagesint,pageNum);
                break;
            case 2:
                pfTimes=pageDefaultLRU(frameNum,pagesint,pageNum);
                break;
            case 3:
                pfTimes=pageDefaultClock(frameNum,pagesint,pageNum);
                break;
            case 4:
                pfTimes=pageDefaultOPT(frameNum,pagesint,pageNum);
                break;
        }

        double pfRate=(double) pfTimes/(double) pageNum;
        ret r=new ret(pfTimes,pfRate);

        return r;
    }


    //置换算法
    static int pageDefaultFIFO(int frameNum, int[] pages,int pageNum){
        int miss=0;
        Frame[] frames=new Frame[frameNum];
        for (int j=0;j<frameNum;j++){
            frames[j]=new Frame(j);
        }
        int thisPage;
        int i;
        int match;
        int rplc;
        int pageIn;

    /*    System.out.print(" f:  ");
        for (int j=0;j<frameNum;j++)
            System.out.print(j+" ");
        System.out.println();
    */
        for (i=0;i<pageNum;i++){                    //模拟依次调用每个页面
            match=match(i,frames,frameNum,pages);
            if (match!=-1){     //匹配到
            }
            else{               //缺页
                miss++;
                pageIn=pages[i];
                rplc=findReplaceFIFO(pageIn,i,frames,frameNum,pages,pageNum);
                frames[rplc].page=pageIn;           //页面替换
                frames[rplc].inTime=i;
            }
            //        prtCrtFrames(i,frames,frameNum);    //输出当前各页框里存的页
        }
        return miss;
    }
    static int pageDefaultLRU(int frameNum, int[] pages,int pageNum){
        int miss=0;
        Frame[] frames=new Frame[frameNum];
        for (int j=0;j<frameNum;j++){
            frames[j]=new Frame(j);
        }
        int thisPage;
        int i;
        int match;
        int rplc;
        int pageIn;

    /*    System.out.print(" f:  ");
        for (int j=0;j<frameNum;j++)
            System.out.print(j+" ");
        System.out.println();*/

        for (i=0;i<pageNum;i++){                    //模拟依次调用每个页面
            for (int j=0;j<frameNum;j++){
                frames[j].noUseTime++;
            }
            match=match(i,frames,frameNum,pages);
            if (match!=-1){     //匹配到
                frames[match].noUseTime=0;
            }
            else{               //缺页
                miss++;
                pageIn=pages[i];
                rplc=findReplaceLRU(pageIn,i,frames,frameNum,pages,pageNum);
                frames[rplc].page=pageIn;           //页面替换
                frames[rplc].noUseTime=0;
            }
            //        prtCrtFrames(i,frames,frameNum);    //输出当前各页框里存的页
        }
        return miss;
    }
    static int pageDefaultClock(int frameNum, int[] pages,int pageNum){
        int miss=0;
        Frame[] frames=new Frame[frameNum];
        for (int j=0;j<frameNum;j++){
            frames[j]=new Frame(j);
        }
        int thisPage;
        int i;
        int match;
        int rplc;
        int pageIn;

        int point=-1;
    /*    System.out.print(" f:  ");
        for (int j=0;j<frameNum;j++)
            System.out.print(j+" ");
        System.out.println();*/

        for (i=0;i<pageNum;i++){                    //模拟依次调用每个页面
            //prtCrtFrames(i,frames,frameNum,point);
            point++;
            if (point==5)
                point=0;
            match=match(i,frames,frameNum,pages);
            if (match!=-1){     //匹配到
                frames[match].clockFlag=1;
                point=match;
            }
            else{               //缺页
                miss++;
                pageIn=pages[i];
                rplc=findReplaceClock(pageIn,i,frames,frameNum,pages,pageNum,point);
                frames[rplc].page=pageIn;           //页面替换
                frames[rplc].clockFlag=1;
            }
            //        prtCrtFrames(i,frames,frameNum);    //输出当前各页框里存的页
        }
        return miss;
    }
    static int pageDefaultOPT(int frameNum, int[] pages,int pageNum){
        int miss=0;
        Frame[] frames=new Frame[frameNum];
        for (int j=0;j<frameNum;j++){
            frames[j]=new Frame(j);
        }
        int thisPage;
        int i;
        int match;
        int rplc;
        int pageIn;

    /*    System.out.print(" f:  ");
        for (int j=0;j<frameNum;j++)
            System.out.print(j+" ");
        System.out.println();
    */
        for (i=0;i<pageNum;i++){                    //模拟依次调用每个页面
            match=match(i,frames,frameNum,pages);
            if (match!=-1){     //匹配到
                frames[match].lastUse=i;        //更新lastUse
            }
            else{               //缺页
                miss++;
                pageIn=pages[i];
                rplc=findReplaceOPT(pageIn,i,frames,frameNum,pages,pageNum);
                frames[rplc].page=pageIn;           //页面替换
                frames[rplc].lastUse=i;
                frames[rplc].nextUse=0xffff;
            }
            //        prtCrtFrames(i,frames,frameNum);    //输出当前各页框里存的页
        }
        return miss;
    }

    //匹配
    static int match(int i, Frame[] frames, int frameNum, int[] pages){
        int j;
        for(j=0;j<frameNum;j++){
            if (frames[j].page==pages[i]){
                return j;               //不缺页，返回页框
            }
        }
        return -1;                      //缺页，返回-1
    }

    //替换
    static int findReplaceFIFO(int page, int now_i, Frame[] frames, int frameNum, int[] pages, int pageNum) {
        int rplc = -1;
        int min = 0xffff;
        int thisPage;

        //     System.out.print("              ");
        for (int j = 0; j < frameNum; j++) {       //找最早
            //         System.out.print((frames[j].inTime==-1?" -":String.format("%2d",frames[j].inTime))+" ");
            if (frames[j].inTime < min) {
                min = frames[j].inTime;
                rplc = j;
            }
        }
        //    System.out.println("in:"+page);
        return rplc;
    }
    static int findReplaceLRU(int page, int now_i, Frame[] frames, int frameNum, int[] pages, int pageNum) {
        int rplc = -1;
        int max=-2;
        int thisPage;

        //    System.out.print("              ");
        for (int j = 0; j < frameNum; j++) {       //找最久没用
            //        System.out.print((frames[j].noUseTime>=0xff00?"-":frames[j].noUseTime)+" ");
            if (frames[j].noUseTime>max) {
                max = frames[j].noUseTime;
                rplc = j;
            }
        }
        //    System.out.println("in:"+page);
        return rplc;
    }
    static int findReplaceOPT(int page, int now_i, Frame[] frames, int frameNum, int[] pages, int pageNum) {
        int rplc = -1;
        int max = 0;
        int thisPage;
        for (int j = 0; j < frameNum; j++) {       //更新每个frame的nextUse
            thisPage = frames[j].page;
            frames[j].nextUse=0xffff;
            for (int i = now_i; i < pageNum; i++) {
                if (pages[i] == thisPage) {
                    frames[j].nextUse = i - now_i;
                    break;
                }
            }
        }
        //    System.out.print("              ");
        for (int j = 0; j < frameNum; j++) {       //找最大
            //         System.out.print((frames[j].nextUse==0xffff?" *":String.format("%2d",frames[j].nextUse))+" ");
            if (frames[j].nextUse > max) {
                max = frames[j].nextUse;
                rplc = j;
            }
        }
        //     System.out.println("in:"+page);
        return rplc;
    }
    static int findReplaceClock(int page, int now_i, Frame[] frames, int frameNum, int[] pages, int pageNum, int point) {
        int rplc = -1;

        //    System.out.print("              ");
        for (int count=1;count<=frameNum;count++,point++) {       //最多转一圈
            //        System.out.print((frames[j].noUseTime>=0xff00?"-":frames[j].noUseTime)+" ");
            if (point>=frameNum)
                point%=frameNum;
            if (frames[point].clockFlag==1)
                frames[point].clockFlag=0;
            else {
                rplc=point;
                break;
            }
        }
        //    System.out.println("in:"+page);
        if (rplc==-1) {
            rplc = point++;
            rplc %= frameNum;
        }
        return rplc;
    }

}
