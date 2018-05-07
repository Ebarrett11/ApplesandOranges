package net.androidbootcamp.applesandoranges;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
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
    int wallet, stock = 5;
    int appleTotal, orangeTotal, aTreeTotal, oTreeTotal;
    TextView txtApple, txtOrange, txtStock;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

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
        txtApple = findViewById(R.id.txtApple);
        txtOrange = findViewById(R.id.txtOrange);
        //txtStock = findViewById(R.id.txtStock);
        ImageButton btnShop = findViewById(R.id.btnShop);

        //get fruits from sharedPrefs
        final SharedPreferences fruitPrefs = PreferenceManager.getDefaultSharedPreferences(GameScreen.this);
        appleTotal = fruitPrefs.getInt("appleTotal", 0);
        orangeTotal = fruitPrefs.getInt("orangeTotal", 0);
        aTreeTotal = fruitPrefs.getInt("aTreeTotal", 0);
        oTreeTotal = fruitPrefs.getInt("oTreeTotal", 0);
        wallet = fruitPrefs.getInt("wallet", 0);
       // stock = fruitPrefs.getInt("stock", 0);

        if (aTreeTotal == 0) {
            wallet = 50;
        }

        //setting elements
        txtWallet.setText("$" + wallet);
        txtApple.setText(appleTotal + " apples");
        txtOrange.setText(orangeTotal + " oranges");

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
                startActivity(new Intent(GameScreen.this, ShopScreen.class));
            }
        });

        //actual game timer stuff
        //apple_s timer
        final Handler appleHandler = new Handler();
        final int appleDelay = 1000; //milliseconds

        appleHandler.postDelayed(new Runnable(){
            public void run(){
                appleTotal = appleTotal + (aTreeTotal);
                txtApple.setText(appleTotal + " apples");
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
                orangeTotal = orangeTotal + (oTreeTotal);
                txtOrange.setText(orangeTotal + " oranges");
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
//                fruitEdit.putInt("appleTotal", appleTotal);
//                fruitEdit.putInt("orangeTotal", orangeTotal);
                fruitEdit.putInt("aTreeTotal", aTreeTotal);
                fruitEdit.putInt("oTreeTotal", oTreeTotal);
                fruitEdit.putInt("wallet", wallet);
                //fruitEdit.putInt("stock", stock);
                fruitEdit.commit();
                saving.postDelayed(this, saveTimer);
            }
        }, saveTimer);

        //stock stuff
//        final Handler stockHandler = new Handler();
//        final int stockDelay = 1000; //milliseconds
//
//        stockHandler.postDelayed(new Runnable(){
//
//            public void run(){
//                Random rand2 = new Random();
//                int crash = rand2.nextInt(200) + 1;
//
//                Random rand = new Random();
//                int decider = rand.nextInt(10) + 1;
//
//                if(crash == 1) {
//                    stock = stock - (stock /2);
//                }
//                if( decider >= 5) {
//                    stock = stock + 1;
//                }
//                else if(decider < 4) {
//                    stock = stock -1;
//                }
//                txtStock.setText("Stock Price: " + stock );
//                stockHandler.postDelayed(this, stockDelay);
//            }
//        }, stockDelay);
    }

}