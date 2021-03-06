package com.example.calculator2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        使用ToolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //普通计算器
        Button normal = (Button) findViewById(R.id.normal);
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Normal.class);
                startActivity(intent);
            }
        });
        //科学计算器
        Button scientific = (Button) findViewById(R.id.scientific);
        scientific.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,Scientific.class);
                startActivity(intent);
            }
        });

        //进制转换器
        Button jinzhi = (Button) findViewById(R.id.jinzhi);
        jinzhi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,JinZhi.class);
                startActivity(intent);
            }
        });
        Button weiyunsuan = (Button) findViewById(R.id.weiyunsuan);
        weiyunsuan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,Weiyunsuan.class);
                startActivity(intent);
            }
        });
        Button dizhijiexi = (Button) findViewById(R.id.dizhijiexi);
        dizhijiexi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,Dizhijiexi.class);
                startActivity(intent);
            }
        });


        Button page_replace = (Button) findViewById(R.id.page_replace);
        page_replace.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,PageReplace.class);
                startActivity(intent);
            }
        });
        Button env_manage = (Button) findViewById(R.id.env_manage);
        env_manage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,Manager.class);
                startActivity(intent);
            }
        });
        Button disk_seek = (Button) findViewById(R.id.disk_seek);
        disk_seek.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,DiskSeek.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }



    //顶部提示栏
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.help){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("关于");
            builder.setMessage("本软件为操作系统计算器，\n\n" +
                    "我们从计算机操作系统领域的实践过程中现有的计算器无法满足的需求出发，\n\n" +
                    "适配操作系统日常使用的常规计算器、科学计算器、进制转换、的位运算、计算机16进制地址解析、页面置换模拟、进程调度模拟、磁盘寻道模拟等多种功能，\n\n" +
                    "本产品将为用户提供了在操作系统学科领域的学习实践过程中更加便利的体验。");
            builder.setPositiveButton("确 定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //删除单词
                    dialogInterface.cancel();

                }
            });

            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            Dialog dialog = builder.create();
            dialog.show();
        }
        return true;
    }




}
