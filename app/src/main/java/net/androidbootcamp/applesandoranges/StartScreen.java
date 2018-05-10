package net.androidbootcamp.applesandoranges;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Handler;

import org.w3c.dom.Text;

import java.io.FileOutputStream;
import java.io.IOException;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        final EditText txtPlayerName = (EditText) findViewById(R.id.txtPlayer);
        Button btnGo = (Button) findViewById(R.id.btnGo);
        final TextView txtFarm = findViewById(R.id.txtFarm);




        final Handler farmHandler = new Handler();
        final int farmDelay = 10; //milliseconds

        farmHandler.postDelayed(new Runnable(){
            public void run(){

                String name = txtPlayerName.getText().toString();
                txtFarm.setText(name + "'s farm");

                farmHandler.postDelayed(this, farmDelay);
            }
        }, farmDelay);


        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    String FILENAME = "filePlayerName";
                    String playerName = txtPlayerName.getText().toString();

                    FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);

                    fos.write(playerName.getBytes());
                    fos.close();

                } catch (IOException e) {
                    Log.e("ERROR", e.toString());
                }

                startActivity(new Intent(StartScreen.this, GameScreen.class));
            }
        });

    }
}