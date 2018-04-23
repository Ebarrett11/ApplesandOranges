package net.androidbootcamp.applesandoranges;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;

public class GameScreen extends AppCompatActivity {
    int wallet = 0; //remember we have to pull this from storage
    int appleTotal = 0, orangeTotal = 0, treeTotal = 0;    //total number of fruit - but is tree necessary?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        //creating elements
        TextView txtPlayerName = (TextView) findViewById(R.id.txtPlayerName);
        TextView txtWallet = (TextView) findViewById(R.id.txtWallet);

        //storage test stuff
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

        //setting elements
        txtWallet.setText("$" + wallet);

        //timer for apples

        //timer for oranges

        //go to shop

    }
}