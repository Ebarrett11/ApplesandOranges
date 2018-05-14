package net.androidbootcamp.applesandoranges;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameScreen extends AppCompatActivity {
    int wallet, stock = 5, oStock = 50, appleYield, orangeYield;
    int appleTotal, orangeTotal, aTreeTotal, oTreeTotal, playing;
    MediaPlayer music;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        music = new MediaPlayer();
        music = MediaPlayer.create(this, R.raw.ukulele);
        final Button btnSound = findViewById(R.id.btnSound);
        playing = 0;

        btnSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(playing) {
                    case 0:
                        music.start();
                        playing = 1;
                        btnSound.setText("Mute");
                        break;
                    case 1:
                        music.pause();
                        playing = 0;
                        btnSound.setText("Play");
                        break;
                }
            }
        });

        //AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        final DecimalFormat money = new DecimalFormat("###,###,###");

        //trees
        final ImageView treeOne = findViewById(R.id.imgTree1);
        final ImageView treeTwo = findViewById(R.id.imgTree2);
        final ImageView treeThree = findViewById(R.id.imgTree3);
        final ImageView treeFour = findViewById(R.id.imgTree4);
        final ImageView treeFive = findViewById(R.id.imgTree5);
        final ImageView treeSix = findViewById(R.id.imgTree6);
        final ImageView treeSeven = findViewById(R.id.imgTree7);
        final ImageView treeEight = findViewById(R.id.imgTree8);
        final ImageView treeNine = findViewById(R.id.imgTree9);
        final ImageView treeTen = findViewById(R.id.imgTree10);
        final ImageView treeEleven = findViewById(R.id.imgTree11);
        final ImageView treeTwelve = findViewById(R.id.imgTree12);
        final ImageView treeThirteen = findViewById(R.id.imgTree13);
        final ImageView treeFourteen = findViewById(R.id.imgTree14);
        final ImageView treeFifteen = findViewById(R.id.imgTree15);
        final ImageView treeSixteen = findViewById(R.id.imgTree16);

        //creating elements
        TextView txtPlayerName = findViewById(R.id.txtPlayerName);
        TextView txtWallet = findViewById(R.id.txtWallet);
        final TextView txtApple = findViewById(R.id.txtApple);
        final TextView txtOrange = findViewById(R.id.txtOrange);
        final TextView txtStock = findViewById(R.id.txtStock);
        final TextView txtOStock = findViewById(R.id.txtOStock);
        ImageButton btnShop = findViewById(R.id.btnShop);
        Button btnUpdate = findViewById(R.id.btnUpdate);

        //get fruits from sharedPrefs
        final SharedPreferences fruitPrefs = PreferenceManager.getDefaultSharedPreferences(GameScreen.this);
        appleTotal = fruitPrefs.getInt("appleTotal", 0);
        orangeTotal = fruitPrefs.getInt("orangeTotal", 0);
        aTreeTotal = fruitPrefs.getInt("aTreeTotal", 0);
        oTreeTotal = fruitPrefs.getInt("oTreeTotal", 0);
        wallet = fruitPrefs.getInt("wallet", 0);
        stock = fruitPrefs.getInt("stock", 0);
        oStock = fruitPrefs.getInt("oStock", 0);
        appleYield = fruitPrefs.getInt("appleYield", 0);
        orangeYield = fruitPrefs.getInt("orangeYield", 0);

        if (appleYield == 0){
            appleYield = 1;
        }
        if (orangeYield == 0){
            orangeYield = 1;
        }

        if (aTreeTotal == 0) {
            wallet = 50;
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor fruitEdit = fruitPrefs.edit();
                fruitEdit.putInt("appleYield", appleYield);
                fruitEdit.putInt("orangeYield", orangeYield);
                fruitEdit.putInt("wallet", wallet);
                fruitEdit.commit();
                startActivity(new Intent(GameScreen.this, Update.class));
            }
        });

        //setting elements
        txtWallet.setText(money.format(wallet) + "");
        txtApple.setText(money.format(appleTotal) + "");
        txtOrange.setText(money.format(orangeTotal) + "");

        //setting tree images with store
        switch (aTreeTotal) {
            case 1:
                treeOne.setImageResource(R.drawable.appletree);
                break;
            case 2:
                treeOne.setImageResource(R.drawable.appletree);
                treeTwo.setImageResource(R.drawable.appletree);
                break;
            case 3:
                treeOne.setImageResource(R.drawable.appletree);
                treeTwo.setImageResource(R.drawable.appletree);
                treeThree.setImageResource(R.drawable.appletree);
                break;
            case 4:
                treeOne.setImageResource(R.drawable.appletree);
                treeTwo.setImageResource(R.drawable.appletree);
                treeThree.setImageResource(R.drawable.appletree);
                treeFour.setImageResource(R.drawable.appletree);
                break;
            case 5:
                treeOne.setImageResource(R.drawable.appletree);
                treeTwo.setImageResource(R.drawable.appletree);
                treeThree.setImageResource(R.drawable.appletree);
                treeFour.setImageResource(R.drawable.appletree);
                treeFive.setImageResource(R.drawable.appletree);
                break;
            case 6:
                treeOne.setImageResource(R.drawable.appletree);
                treeTwo.setImageResource(R.drawable.appletree);
                treeThree.setImageResource(R.drawable.appletree);
                treeFour.setImageResource(R.drawable.appletree);
                treeFive.setImageResource(R.drawable.appletree);
                treeSix.setImageResource(R.drawable.appletree);
                break;
            case 7:
                treeOne.setImageResource(R.drawable.appletree);
                treeTwo.setImageResource(R.drawable.appletree);
                treeThree.setImageResource(R.drawable.appletree);
                treeFour.setImageResource(R.drawable.appletree);
                treeFive.setImageResource(R.drawable.appletree);
                treeSix.setImageResource(R.drawable.appletree);
                treeSeven.setImageResource(R.drawable.appletree);
                break;
            case 8:
                treeOne.setImageResource(R.drawable.appletree);
                treeTwo.setImageResource(R.drawable.appletree);
                treeThree.setImageResource(R.drawable.appletree);
                treeFour.setImageResource(R.drawable.appletree);
                treeFive.setImageResource(R.drawable.appletree);
                treeSix.setImageResource(R.drawable.appletree);
                treeSeven.setImageResource(R.drawable.appletree);
                treeEight.setImageResource(R.drawable.appletree);
                break;
        }

        switch (oTreeTotal) {
            case 1:
                treeNine.setImageResource(R.drawable.orangetree);
                break;
            case 2:
                treeNine.setImageResource(R.drawable.orangetree);
                treeTen.setImageResource(R.drawable.orangetree);
                break;
            case 3:
                treeNine.setImageResource(R.drawable.orangetree);
                treeTen.setImageResource(R.drawable.orangetree);
                treeEleven.setImageResource(R.drawable.orangetree);
                break;
            case 4:
                treeNine.setImageResource(R.drawable.orangetree);
                treeTen.setImageResource(R.drawable.orangetree);
                treeEleven.setImageResource(R.drawable.orangetree);
                treeTwelve.setImageResource(R.drawable.orangetree);
                break;
            case 5:
                treeNine.setImageResource(R.drawable.orangetree);
                treeTen.setImageResource(R.drawable.orangetree);
                treeEleven.setImageResource(R.drawable.orangetree);
                treeTwelve.setImageResource(R.drawable.orangetree);
                treeThirteen.setImageResource(R.drawable.orangetree);
                break;
            case 6:
                treeNine.setImageResource(R.drawable.orangetree);
                treeTen.setImageResource(R.drawable.orangetree);
                treeEleven.setImageResource(R.drawable.orangetree);
                treeTwelve.setImageResource(R.drawable.orangetree);
                treeThirteen.setImageResource(R.drawable.orangetree);
                treeFourteen.setImageResource(R.drawable.orangetree);
                break;
            case 7:
                treeNine.setImageResource(R.drawable.orangetree);
                treeTen.setImageResource(R.drawable.orangetree);
                treeEleven.setImageResource(R.drawable.orangetree);
                treeTwelve.setImageResource(R.drawable.orangetree);
                treeThirteen.setImageResource(R.drawable.orangetree);
                treeFourteen.setImageResource(R.drawable.orangetree);
                treeFifteen.setImageResource(R.drawable.orangetree);
                break;
            case 8:
                treeNine.setImageResource(R.drawable.orangetree);
                treeTen.setImageResource(R.drawable.orangetree);
                treeEleven.setImageResource(R.drawable.orangetree);
                treeTwelve.setImageResource(R.drawable.orangetree);
                treeThirteen.setImageResource(R.drawable.orangetree);
                treeFourteen.setImageResource(R.drawable.orangetree);
                treeFifteen.setImageResource(R.drawable.orangetree);
                treeSixteen.setImageResource(R.drawable.orangetree);
                break;
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

        //go to shop
        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor fruitEdit = fruitPrefs.edit();
                fruitEdit.putInt("appleTotal", appleTotal);
                fruitEdit.putInt("orangeTotal", orangeTotal);
                fruitEdit.putInt("aTreeTotal", aTreeTotal);
                fruitEdit.putInt("oTreeTotal", oTreeTotal);
                fruitEdit.putInt("wallet", wallet);
                fruitEdit.putInt("stock", stock);
                fruitEdit.putInt("oStock", oStock);
                fruitEdit.commit();
                startActivity(new Intent(GameScreen.this, ShopScreen.class));
            }
        });

        //crab!!

        final ImageButton btnCrab = findViewById(R.id.crab);

        final Handler crabA = new Handler();
        final int crabATimer = 60000; //milliseconds

        crabA.postDelayed(new Runnable(){
            public void run() {

                btnCrab.setImageResource(R.drawable.crab);
                btnCrab.startAnimation(AnimationUtils.loadAnimation(GameScreen.this, R.anim.crab_move));

                crabA.postDelayed(this, crabATimer);
            }
        }, crabATimer);

        btnCrab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rCrab = new Random();
                int iCrab = rCrab.nextInt(50) + 1;

                if (iCrab >= 4){
                    appleTotal = appleTotal + 100;
                    Toast.makeText(getBaseContext(), "You got 100 apples!", Toast.LENGTH_LONG).show();
                } else if (iCrab == 2 || iCrab == 3){
                    if (wallet >= 300000){
                        wallet = wallet - 300000;
                        Toast.makeText(getBaseContext(), "You lost $300,000!", Toast.LENGTH_LONG).show();
                    } else{
                        wallet = wallet / 2;
                        Toast.makeText(getBaseContext(), "You lost half your wallet!", Toast.LENGTH_LONG).show();
                    }
                } else if (iCrab == 1){
                    orangeTotal = orangeTotal + 1000;
                    Toast.makeText(getBaseContext(), "You got 1,000 oranges!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //actual game timer stuff
        //apple_s timer
        final Handler appleHandler = new Handler();
        final int appleDelay = 1000; //milliseconds

        appleHandler.postDelayed(new Runnable(){
            public void run(){
                appleTotal = appleTotal + (aTreeTotal * appleYield);
                txtApple.setText(appleTotal + "");

                SharedPreferences.Editor fruitEdit = fruitPrefs.edit();
                fruitEdit.putInt("appleTotal", appleTotal);
                fruitEdit.commit();

                appleHandler.postDelayed(this, appleDelay);
            }
        }, appleDelay);

        //orange timer
        final Handler orangeHandler = new Handler();
        final int orangeDelay = 3000; //milliseconds

        orangeHandler.postDelayed(new Runnable(){
            public void run(){
                orangeTotal = orangeTotal + (oTreeTotal * orangeYield);
                txtOrange.setText(orangeTotal + "");

                SharedPreferences.Editor fruitEdit = fruitPrefs.edit();
                fruitEdit.putInt("orangeTotal", orangeTotal);
                fruitEdit.commit();

                orangeHandler.postDelayed(this, orangeDelay);
            }
        }, orangeDelay);

        //saving everything
        final Handler saving = new Handler();
        final int saveTimer = 1000; //milliseconds

        saving.postDelayed(new Runnable(){
            public void run(){
                SharedPreferences fruitPrefs = PreferenceManager.getDefaultSharedPreferences(GameScreen.this);
                SharedPreferences.Editor fruitEdit = fruitPrefs.edit();
                fruitEdit.putInt("stock", stock);
                fruitEdit.commit();
                saving.postDelayed(this, saveTimer);
            }
        }, saveTimer);

        final Handler stockHandler = new Handler();
        final int stockDelay = 1000; //milliseconds

        stockHandler.postDelayed(new Runnable(){

            public void run(){
                Random rand2 = new Random();
                int crash = rand2.nextInt(200) + 1;

                Random rand = new Random();
                int decider = rand.nextInt(10) + 1;


                if(stock == 100){
                    stock = (stock - 20);
                }
                if(crash == 1) {
                    stock = stock - (stock /2);
                }
                if( decider >= 6) {
                    stock = stock + 1;
                }
                else if(decider <= 5) {
                    if((stock - 1) >= 1 ){
                        stock = stock -1;
                    }
                    else{
                        stock = (stock + 1);
                    }
                }

                SharedPreferences.Editor fruitEdit = fruitPrefs.edit();
                fruitEdit.putInt("stock", stock);
                fruitEdit.commit();

                txtStock.setText("Apple Value: $" + stock);
                stockHandler.postDelayed(this, stockDelay);
            }
        }, stockDelay);

        final Handler oStockHandler = new Handler();
        final int oStockDelay = 1000; //milliseconds

        stockHandler.postDelayed(new Runnable(){

            public void run(){
                Random rand2 = new Random();
                int crash = rand2.nextInt(300) + 1;

                Random rand = new Random();
                int decider = rand.nextInt(10) + 1;

                if(crash == 1) {
                    oStock = oStock - (oStock /2);
                }
                if( (oStock - 50) <= stock ){
                    oStock = oStock + 5;

                }
                if(oStock == 250){
                    oStock = (oStock - 20);
                }
                if( decider >= 6) {
                    oStock = oStock + 1;
                }
                else if(decider <= 5) {
                    if((oStock - 1) >= 1 ){
                        oStock = oStock -1;
                    }
                    else{
                        oStock = (oStock + 1);
                    }
                }

                SharedPreferences.Editor fruitEdit = fruitPrefs.edit();
                fruitEdit.putInt("oStock", oStock);
                fruitEdit.commit();

                txtOStock.setText("Orange Value: $" + oStock);
                oStockHandler.postDelayed(this, oStockDelay);
            }
        }, oStockDelay);

        //saving everything




    }

}