package com.example.saitarun.contentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Uri uri=Uri.parse("content://com.example.saitarun.sqlitedatabase");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Cursor c=getContentResolver().query(uri,null,null,null,null);

        if(c.getCount()>0){
            StringBuffer sb=new StringBuffer();
            c.moveToFirst();
            do {
                sb.append(c.getString(1)+":"+c.getInt(2)+"\n");
            }while (c.moveToNext());

            Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "No Information is retrieved", Toast.LENGTH_SHORT).show();
        }
    }
}
