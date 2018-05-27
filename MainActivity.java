package com.example.sagar.lab3;

import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
ListView l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l1=findViewById(R.id.listview);

        Uri contacts=Uri.parse("content://contacts/people");
        Cursor c=managedQuery(contacts,null,null,null,null);
        String[] columns=new String[]{
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts._ID
        };

        int[] views=new int[]{
                android.R.id.text1,
                android.R.id.text2
        };

        SimpleCursorAdapter adapter=new SimpleCursorAdapter(
            this,android.R.layout.simple_list_item_2,c,columns,views
        );
        l1.setAdapter(adapter);
    }
}
