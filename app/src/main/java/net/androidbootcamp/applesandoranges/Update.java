package net.androidbootcamp.applesandoranges;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Update extends AppCompatActivity {
    int wallet, appleYield, orangeYield;
    int pAppleYield, pOrangeYield, appleCost, orangeCost;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        final SharedPreferences fruitPrefs = PreferenceManager.getDefaultSharedPreferences(Update.this);
        appleYield = fruitPrefs.getInt("appleYield", 0);
        orangeYield = fruitPrefs.getInt("orangeYield", 0);
        wallet = fruitPrefs.getInt("wallet", 0);

        TextView txtAppleCost = findViewById(R.id.txtAppleCost);
        TextView txtOrangeCost = findViewById(R.id.txtOrangeCost);
        TextView txtWallet = findViewById(R.id.txtWallet);
        Button upApple = findViewById(R.id.btnUpApple);
        Button upOrange = findViewById(R.id.btnUpOrange);
        Button btnGame = findViewById(R.id.btnGame);

        final DecimalFormat money = new DecimalFormat("###,###,###");

        txtWallet.setText("$" + money.format(wallet));

        if ((appleYield + 1) == 11){
            txtAppleCost.setText("You've reached the max upgrade! \n" + appleYield + "/sec");
        }else{
            pAppleYield = appleYield + 1;
            appleCost = pAppleYield * 100000;
            txtAppleCost.setText("Current Yield: " + appleYield + "/sec \nUpgrade to: " + pAppleYield + "/sec \nCost: $" + money.format(appleCost));
        }

        if ((orangeYield + 1) == 11){
            txtOrangeCost.setText("You've reached the max upgrade! \n" + orangeYield + "/sec");
        }else{
            pOrangeYield = orangeYield + 1;
            orangeCost = pOrangeYield * 200000;
            txtOrangeCost.setText("Current Yield: " + orangeYield + "/sec \nUpgrade to: " + pOrangeYield + "/sec \nCost: $" + money.format(orangeCost));
        }

        btnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Update.this, GameScreen.class));
            }
        });

        upApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((wallet - appleCost) < 0){
                    Toast.makeText(getBaseContext(), "Not enough money!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Update.this, GameScreen.class));
                }else{
                    wallet = wallet - appleCost;
                    appleYield = pAppleYield;
                    SharedPreferences.Editor fruitEdit = fruitPrefs.edit();
                    fruitEdit.putInt("wallet", wallet);
                    fruitEdit.putInt("appleYield", appleYield);
                    fruitEdit.putInt("orangeYield", orangeYield);
                    fruitEdit.commit();
                    Toast.makeText(getBaseContext(), "-$" + money.format(appleCost), Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Update.this, GameScreen.class));
                }
            }
        });

        upOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((wallet - orangeCost) < 0){
                    Toast.makeText(getBaseContext(), "Not enough money!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Update.this, GameScreen.class));
                }else{
                    wallet = wallet - orangeCost;
                    orangeYield = pOrangeYield;
                    SharedPreferences.Editor fruitEdit = fruitPrefs.edit();
                    fruitEdit.putInt("wallet", wallet);
                    fruitEdit.putInt("appleYield", appleYield);
                    fruitEdit.putInt("orangeYield", orangeYield);
                    fruitEdit.commit();
                    Toast.makeText(getBaseContext(), "-$" + money.format(orangeCost), Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Update.this, GameScreen.class));
                }
            }
        });

    }
}
