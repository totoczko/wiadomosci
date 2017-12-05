package com.example.martyna.wiadomosci;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import static com.example.martyna.wiadomosci.R.id.editText;

public class MainActivity extends AppCompatActivity {

    private int id = 1;
    EditText msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = 1;
        msg = (EditText) findViewById(editText);
    }

    public void SaveMessage(View view){
        Intent intentn = new Intent();
        intentn.setAction("com.example.martyna.wiadomosci.CUSTOM_INTENT");
        String title = "Notification " + id;
        String text = msg.getText().toString();

        intentn.putExtra("title", title);
        intentn.putExtra("text", text);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intentn, PendingIntent.FLAG_UPDATE_CURRENT);

        sendBroadcast(intentn);
        id++;
    }
}
