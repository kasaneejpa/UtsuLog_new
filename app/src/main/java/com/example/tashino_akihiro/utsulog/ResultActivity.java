package com.example.tashino_akihiro.utsulog;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;


public class ResultActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //記録データ用意
        Intent intent = getIntent();
        String judge = intent.getStringExtra("JUDGE");
        String comment = intent.getStringExtra("COMMENT");
        Date nowDate = new Date();
        DateFormat df = DateFormat.getDateTimeInstance();
        String date = df.format(nowDate);
        int level = intent.getIntExtra("LEVEL",1);

        //判定表示
        TextView tv = (TextView)findViewById(R.id.txtJudge);
        tv.setText(judge);

        //LISTVIEW設定
        ItemDBHelper helper = new ItemDBHelper(this);
        long id = helper.insert(judge, comment, date,level);

        List<ItemBean> list = helper.select();
        ListView lv = (ListView)findViewById(R.id.ResultList);

        ItemListAdapter adapter = new ItemListAdapter(this,list);
        lv.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
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
