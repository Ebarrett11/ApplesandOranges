package net.androidbootcamp.applesandoranges;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class GameScreen extends AppCompatActivity {
    int wallet;
    int appleTotal, orangeTotal, aTreeTotal = 1, oTreeTotal;
    TextView txtApple, txtOrange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        //get from sharedPrefs
        SharedPreferences fruitPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        appleTotal = fruitPrefs.getInt("appleTotal", 0);
        orangeTotal = fruitPrefs.getInt("orangeTotal", 0);
        aTreeTotal = fruitPrefs.getInt("aTreeTotal", 0);
        oTreeTotal = fruitPrefs.getInt("oTreeTotal", 0);
        wallet = fruitPrefs.getInt("wallet", 0);

        appleTotal = 1;

        //creating elements
        TextView txtPlayerName = (TextView) findViewById(R.id.txtPlayerName);
        TextView txtWallet = (TextView) findViewById(R.id.txtWallet);
        txtApple = (TextView) findViewById(R.id.txtApple);
        txtOrange = (TextView) findViewById(R.id.txtOrange);
        ImageButton btnShop = (ImageButton) findViewById(R.id.btnShop);

        //trees
        ImageView treeOne = (ImageView) findViewById(R.id.imgTree1);
        ImageView treeTwo = (ImageView) findViewById(R.id.imgTree2);
        ImageView treeThree = (ImageView) findViewById(R.id.imgTree3);
        ImageView treeFour = (ImageView) findViewById(R.id.imgTree4);
        ImageView treeFive = (ImageView) findViewById(R.id.imgTree5);
        ImageView treeSix = (ImageView) findViewById(R.id.imgTree6);
        ImageView treeSeven = (ImageView) findViewById(R.id.imgTree7);
        ImageView treeEight = (ImageView) findViewById(R.id.imgTree8);
        ImageView treeNine = (ImageView) findViewById(R.id.imgTree9);
        ImageView treeTen = (ImageView) findViewById(R.id.imgTree10);
        ImageView treeEleven = (ImageView) findViewById(R.id.imgTree11);
        ImageView treeTwelve = (ImageView) findViewById(R.id.imgTree12);
        ImageView treeThirteen = (ImageView) findViewById(R.id.imgTree13);
        ImageView treeFourteen = (ImageView) findViewById(R.id.imgTree14);
        ImageView treeFifteen = (ImageView) findViewById(R.id.imgTree15);
        ImageView treeSixteen = (ImageView) findViewById(R.id.imgTree16);

        //first tree image
        treeOne.setImageResource(R.drawable.appletree);

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
        txtApple.setText(appleTotal + " apples");
        txtOrange.setText(orangeTotal + " oranges");
        txtWallet.setText(wallet);

        //go to shop
        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GameScreen.this, ShopScreen.class));
            }
        });

        //actual game timer stuff
        //apple timer
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