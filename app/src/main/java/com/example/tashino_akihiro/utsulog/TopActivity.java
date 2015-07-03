package com.example.tashino_akihiro.utsulog;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class TopActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void okSplash(View v){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void ngSplash(View v){
        finish();
    }
@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_top, menu);
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
