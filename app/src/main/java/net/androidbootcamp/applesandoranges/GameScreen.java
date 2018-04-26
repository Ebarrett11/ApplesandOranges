package net.androidbootcamp.applesandoranges;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.IOException;

public class GameScreen extends AppCompatActivity {
    int wallet = 500;
    int appleTotal, orangeTotal, aTreeTotal, oTreeTotal;
    TextView txtApple, txtOrange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        //trees
        ImageView treeOne = findViewById(R.id.imgTree1);
        ImageView treeTwo = findViewById(R.id.imgTree2);
        ImageView treeThree = findViewById(R.id.imgTree3);
        ImageView treeFour = findViewById(R.id.imgTree4);
        ImageView treeFive = findViewById(R.id.imgTree5);
        ImageView treeSix = findViewById(R.id.imgTree6);
        ImageView treeSeven = findViewById(R.id.imgTree7);
        ImageView treeEight = findViewById(R.id.imgTree8);
        ImageView treeNine = findViewById(R.id.imgTree9);
        ImageView treeTen = findViewById(R.id.imgTree10);
        ImageView treeEleven = findViewById(R.id.imgTree11);
        ImageView treeTwelve = findViewById(R.id.imgTree12);
        ImageView treeThirteen = findViewById(R.id.imgTree13);
        ImageView treeFourteen = findViewById(R.id.imgTree14);
        ImageView treeFifteen = findViewById(R.id.imgTree15);
        ImageView treeSixteen = findViewById(R.id.imgTree16);

        //get fruits from sharedPrefs
        SharedPreferences fruitPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        appleTotal = fruitPrefs.getInt("appleTotal", 0);
        orangeTotal = fruitPrefs.getInt("orangeTotal", 0);
        aTreeTotal = fruitPrefs.getInt("aTreeTotal", 0);
        oTreeTotal = fruitPrefs.getInt("oTreeTotal", 0);
        wallet = fruitPrefs.getInt("wallet", 0);

        //getting tree buying info
        SharedPreferences trees = PreferenceManager.getDefaultSharedPreferences(this);
        aTreeTotal = trees.getInt("aTreeTotal", 0);
        oTreeTotal = trees.getInt("oTreeTotal", 0);

        //creating elements
        TextView txtPlayerName = (TextView) findViewById(R.id.txtPlayerName);
        TextView txtWallet = (TextView) findViewById(R.id.txtWallet);
        txtApple = (TextView) findViewById(R.id.txtApple);
        txtOrange = (TextView) findViewById(R.id.txtOrange);
        ImageButton btnShop = (ImageButton) findViewById(R.id.btnShop);

        //setting tree images with store
        if (aTreeTotal == 1){
            treeOne.setImageResource(R.drawable.appletree);
        }else if (aTreeTotal == 2){
            treeOne.setImageResource(R.drawable.appletree);
            treeTwo.setImageResource(R.drawable.appletree);
        }else if (aTreeTotal == 3){
            treeOne.setImageResource(R.drawable.appletree);
            treeTwo.setImageResource(R.drawable.appletree);
            treeThree.setImageResource(R.drawable.appletree);
        }else if (aTreeTotal == 4){
            treeOne.setImageResource(R.drawable.appletree);
            treeTwo.setImageResource(R.drawable.appletree);
            treeThree.setImageResource(R.drawable.appletree);
            treeFour.setImageResource(R.drawable.appletree);
        }else if (aTreeTotal == 5){
            treeOne.setImageResource(R.drawable.appletree);
            treeTwo.setImageResource(R.drawable.appletree);
            treeThree.setImageResource(R.drawable.appletree);
            treeFour.setImageResource(R.drawable.appletree);
            treeFive.setImageResource(R.drawable.appletree);
        }else if (aTreeTotal == 6){
            treeOne.setImageResource(R.drawable.appletree);
            treeTwo.setImageResource(R.drawable.appletree);
            treeThree.setImageResource(R.drawable.appletree);
            treeFour.setImageResource(R.drawable.appletree);
            treeFive.setImageResource(R.drawable.appletree);
            treeSix.setImageResource(R.drawable.appletree);
        }else if (aTreeTotal == 7){
            treeOne.setImageResource(R.drawable.appletree);
            treeTwo.setImageResource(R.drawable.appletree);
            treeThree.setImageResource(R.drawable.appletree);
            treeFour.setImageResource(R.drawable.appletree);
            treeFive.setImageResource(R.drawable.appletree);
            treeSix.setImageResource(R.drawable.appletree);
            treeSeven.setImageResource(R.drawable.appletree);
        }else if (aTreeTotal == 8){
            treeOne.setImageResource(R.drawable.appletree);
            treeTwo.setImageResource(R.drawable.appletree);
            treeThree.setImageResource(R.drawable.appletree);
            treeFour.setImageResource(R.drawable.appletree);
            treeFive.setImageResource(R.drawable.appletree);
            treeSix.setImageResource(R.drawable.appletree);
            treeSeven.setImageResource(R.drawable.appletree);
            treeEight.setImageResource(R.drawable.appletree);
        }

        if (oTreeTotal == 1){
            treeNine.setImageResource(R.drawable.orangetree);
        }else if (oTreeTotal == 2){
            treeNine.setImageResource(R.drawable.orangetree);
            treeTen.setImageResource(R.drawable.orangetree);
        }else if (oTreeTotal == 3){
            treeNine.setImageResource(R.drawable.orangetree);
            treeTen.setImageResource(R.drawable.orangetree);
            treeEleven.setImageResource(R.drawable.orangetree);
        }else if (oTreeTotal == 4){
            treeNine.setImageResource(R.drawable.orangetree);
            treeTen.setImageResource(R.drawable.orangetree);
            treeEleven.setImageResource(R.drawable.orangetree);
            treeTwelve.setImageResource(R.drawable.orangetree);
        }else if (oTreeTotal == 5){
            treeNine.setImageResource(R.drawable.orangetree);
            treeTen.setImageResource(R.drawable.orangetree);
            treeEleven.setImageResource(R.drawable.orangetree);
            treeTwelve.setImageResource(R.drawable.orangetree);
            treeThirteen.setImageResource(R.drawable.orangetree);
        }else if (oTreeTotal == 6){
            treeNine.setImageResource(R.drawable.orangetree);
            treeTen.setImageResource(R.drawable.orangetree);
            treeEleven.setImageResource(R.drawable.orangetree);
            treeTwelve.setImageResource(R.drawable.orangetree);
            treeThirteen.setImageResource(R.drawable.orangetree);
            treeFourteen.setImageResource(R.drawable.orangetree);
        }else if (oTreeTotal == 7){
            treeNine.setImageResource(R.drawable.orangetree);
            treeTen.setImageResource(R.drawable.orangetree);
            treeEleven.setImageResource(R.drawable.orangetree);
            treeTwelve.setImageResource(R.drawable.orangetree);
            treeThirteen.setImageResource(R.drawable.orangetree);
            treeFourteen.setImageResource(R.drawable.orangetree);
            treeFifteen.setImageResource(R.drawable.orangetree);
        }else if (oTreeTotal == 8){
            treeNine.setImageResource(R.drawable.orangetree);
            treeTen.setImageResource(R.drawable.orangetree);
            treeEleven.setImageResource(R.drawable.orangetree);
            treeTwelve.setImageResource(R.drawable.orangetree);
            treeThirteen.setImageResource(R.drawable.orangetree);
            treeFourteen.setImageResource(R.drawable.orangetree);
            treeFifteen.setImageResource(R.drawable.orangetree);
            treeSixteen.setImageResource(R.drawable.orangetree);
        }

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

        //setting elements
        txtWallet.setText("$" + wallet);
        txtApple.setText(appleTotal + " apples");
        txtOrange.setText(orangeTotal + " oranges");

        //go to shop
        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GameScreen.this, ShopScreen.class));
            }
        });

        //actual game timer stuff
        //apple_s timer
        final Handler appleHandler = new Handler();
        final int appleDelay = 1000; //milliseconds

        appleHandler.postDelayed(new Runnable(){
            @SuppressLint("SetTextI18n")
            public void run(){
                appleTotal = appleTotal + (aTreeTotal);
                txtApple.setText(appleTotal + " apples");
                appleHandler.postDelayed(this, appleDelay);
            }
        }, appleDelay);

        //orange timer
        final Handler orangeHandler = new Handler();
        final int orangeDelay = 3000; //milliseconds

        orangeHandler.postDelayed(new Runnable(){
            @SuppressLint("SetTextI18n")
            public void run(){
                orangeTotal = orangeTotal + (oTreeTotal);
                txtOrange.setText(orangeTotal + " oranges");
                orangeHandler.postDelayed(this, orangeDelay);
            }
        }, orangeDelay);

    }

    protected void onStop(){
        super.onStop();
        SharedPreferences fruitPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = fruitPrefs.edit();
        editor.putInt("appleTotal", appleTotal);
        editor.putInt("orangeTotal", orangeTotal);
        editor.putInt("aTreeTotal", aTreeTotal);
        editor.putInt("oTreeTotal", oTreeTotal);
        editor.putInt("wallet", wallet);
        editor.commit();
    }
}