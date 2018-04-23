package net.androidbootcamp.applesandoranges;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class GameScreen extends AppCompatActivity {
    int wallet; //remember we have to pull this from storage
    int appleTotal = 0, orangeTotal = 0, treeTotal = 0;    //total number of fruit - but is tree necessary?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        //creating elements
        TextView txtPlayerName = (TextView) findViewById(R.id.txtPlayerName);
        TextView txtWallet = (TextView) findViewById(R.id.txtWallet);

        //player name file
        try {
            String FILENAME = "filePlayerName";
            byte[] bytes = new byte[1024];
            FileInputStream fos = openFileInput("filePlayerName");
            fos.read(bytes);
            fos.close();
            String playerName = new String(bytes);
            txtPlayerName.setText(playerName + "'s Farm");
        } catch (IOException e) {
            Log.e("ERROR", e.toString());
        }

        //wallet file
        try {
            String FILENAME = "fileWallet";
            String wallet = txtPlayerName.getText().toString();
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(wallet.getBytes());
            fos.close();

        } catch (IOException e) {
            Log.e("ERROR", e.toString());
        }

        //setting elements
        txtWallet.setText(appleTotal);
        appleTimer();
        txtWallet.setText(appleTotal);

        //timer for apples

        //timer for oranges

        //go to shop

    }

    int appleTimer(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                appleTotal = appleTotal + 1;
            }
        };
        Timer opening = new Timer();
        opening.schedule(task, 10000);
        return appleTotal;
    }
}