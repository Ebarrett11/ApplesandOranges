package net.androidbootcamp.applesandoranges;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.IOException;

public class GameScreen extends AppCompatActivity {
    int wallet;
    boolean play = true;
    int appleTotal = 0, orangeTotal = 0, aTreeTotal = 1, oTreeTotal = 0;
    TextView txtApple, txtOrange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        //creating elements
        TextView txtPlayerName = (TextView) findViewById(R.id.txtPlayerName);
        TextView txtWallet = (TextView) findViewById(R.id.txtWallet);
        txtApple = (TextView) findViewById(R.id.txtApple);
        txtOrange = (TextView) findViewById(R.id.txtOrange);

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

        //apple number file

        //apple tree number file

        //orange number file

        //orange tree number file

        //setting elements

        //go to shop
        //startactivty here once we have the shop page but that's it

        //actual game timer stuff
        final Handler handler = new Handler();
        final int delay = 10000; //milliseconds

        handler.postDelayed(new Runnable(){
            @SuppressLint("SetTextI18n")
            public void run(){
                //do something
                appleTotal = appleTotal + (aTreeTotal);
                orangeTotal = orangeTotal + (oTreeTotal);

                txtApple.setText(appleTotal + " apples");
                txtOrange.setText(orangeTotal + " oranges");

                handler.postDelayed(this, delay);
            }
        }, delay);

    }

}