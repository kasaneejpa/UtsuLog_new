package com.example.tashino_akihiro.utsulog;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    boolean[] bigElement = new boolean[3];
    boolean[] smallElemant = new boolean[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logUtsu(View v){
        CheckBox[] bigCheck = new CheckBox[3];
        CheckBox[] smallCheck = new CheckBox[6];
        String hitokoto;
        String judge;

        bigCheck[0] = (CheckBox)findViewById(R.id.checkBoxA);
        bigCheck[1] = (CheckBox)findViewById(R.id.checkBoxB);
        bigCheck[2] = (CheckBox)findViewById(R.id.checkBoxC);

        smallCheck[0] = (CheckBox)findViewById(R.id.checkBox1);
        smallCheck[1] = (CheckBox)findViewById(R.id.checkBox2);
        smallCheck[2] = (CheckBox)findViewById(R.id.checkBox3);
        smallCheck[3] = (CheckBox)findViewById(R.id.checkBox4);
        smallCheck[4] = (CheckBox)findViewById(R.id.checkBox5);
        smallCheck[5] = (CheckBox)findViewById(R.id.checkBox6);

        TextView tv = (TextView)findViewById(R.id.editComment);
        hitokoto = tv.getText().toString();

        int bigCount=0;
        for(int i=0;i<3;i++)
        {
            if(bigCheck[i].isChecked()) {
                bigCount++;
            }
        }

        int smallCount=0;
        for(int i=0;i<6;i++)
        {
            if (smallCheck[i].isChecked()) {
                smallCount++;
            }
        }
        int level =1;
        if(bigCount >=3 && smallCount>=4){
            judge ="重症の可能性";
            level=4;
        }else if(bigCount >=2 && smallCount>=4){
            judge = "中症の可能性";
            level=3;
        }else if(bigCount>=2 && smallCount>=2){
            judge = "軽症の可能性";
            level=2;
        }else{
            judge = "うつ病ではない可能性";
            level=1;
        }

        if(smallCheck[3].isChecked()){
            judge += "\nですが自傷の可能性があります。専門医を受診しましょう。";
        }

        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra("JUDGE",judge);
        intent.putExtra("COMMENT",hitokoto);
        intent.putExtra("LEVEL",level);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            new AlertDialog.Builder(this).setTitle("このアプリケーションについて").
                    setPositiveButton("閉じる",null).setMessage("UtsuLogは2015/5/30に初めて作成されました。\n今後Android　Wearの歩数計などと連携して\n充実させていきます。\n　Version　0.9").create().show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
