package net.androidbootcamp.applesandoranges;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {
    int wallet = 0; //remember we have to pull this from storage
    String playerName = ""; //remember we have to pull this from storage
    int appleTotal = 0, orangeTotal = 0, treeTotal = 0;    //total number of fruit - but is tree necessary?


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        //creating elements
        TextView txtPlayerName = (TextView) findViewById(R.id.txtPlayerName);
        TextView txtWallet = (TextView) findViewById(R.id.txtWallet);

        //setting elements
        txtPlayerName.setText(playerName + "'s Farm");
        txtWallet.setText("$" + wallet);

        //timer for apples

        //timer for oranges

        //go to shop

    }
}
