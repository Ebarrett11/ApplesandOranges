package net.androidbootcamp.applesandoranges;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ShopScreen extends AppCompatActivity {
    int aTreeTotal, oTreeTotal, buyCost, wallet, gain, stock, appleTotal, orangeTotal;
    String choice = "";
    int amount;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_screen);

        ImageButton buyApple =  findViewById(R.id.btnBuyApple);
        ImageButton buyOrange = findViewById(R.id.btnBuyOrange);
        ImageButton sellApple = findViewById(R.id.btnSellApple);
        ImageButton sellOrange = findViewById(R.id.btnSellOrange);
        Button buy = findViewById(R.id.btnBuy);
        Button sell = findViewById(R.id.btnSell);
        Button game = findViewById(R.id.btnGame);
        final TextView txtCost = findViewById(R.id.txtCost);
        final TextView txtFruitStats = findViewById(R.id.txtFruitStats);

        final SharedPreferences fruitPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        appleTotal = fruitPrefs.getInt("appleTotal", 0);
        orangeTotal = fruitPrefs.getInt("orangeTotal", 0);
        wallet = fruitPrefs.getInt("wallet", 0);
        //stock = fruitPrefs.getInt("stock",0);

        txtFruitStats.setText("apples: " + appleTotal + "\noranges: " + orangeTotal);

        final  EditText txtAmount = findViewById(R.id.txtSellAmount);

        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShopScreen.this, GameScreen.class));
            }
        });

        buyApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buyCost = 50;
                txtCost.setText("Cost: 50");
            }

        });

        buyOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buyCost = 75;
                txtCost.setText("Cost: 75");
            }
        });

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                aTreeTotal = fruitPrefs.getInt("aTreeTotal", 0);
                oTreeTotal = fruitPrefs.getInt("oTreeTotal", 0);

                if(oTreeTotal < 9 && aTreeTotal < 9){
                    if ((wallet - buyCost) < 0){
                        Toast.makeText(getBaseContext(), "You don't have enough money!", Toast.LENGTH_LONG).show();
                    }else {
                        wallet = wallet - buyCost;

                        if (buyCost == 50){
                            aTreeTotal++;
                        } else if (buyCost == 75){
                            oTreeTotal++;
                        }

                        SharedPreferences.Editor fruitEdit = fruitPrefs.edit();
                        fruitEdit.putInt("appleTotal", appleTotal);
                        fruitEdit.putInt("orangeTotal", orangeTotal);
                        fruitEdit.putInt("aTreeTotal", aTreeTotal);
                        fruitEdit.putInt("oTreeTotal", oTreeTotal);
                        fruitEdit.putInt("wallet", wallet);
                        fruitEdit.commit();

                        Toast.makeText(getBaseContext(), "-" + buyCost, Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(ShopScreen.this, GameScreen.class));
                    }
                }else if (aTreeTotal >= 9){
                    aTreeTotal = 8;
                    Toast.makeText(getBaseContext(), "Too many trees!", Toast.LENGTH_LONG).show();
                }else if (oTreeTotal >= 9){
                    oTreeTotal = 8;
                    Toast.makeText(getBaseContext(), "Too many trees!", Toast.LENGTH_LONG).show();
                }

            }
        });

        sellApple.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                choice = "apple";
                Toast.makeText(getBaseContext(), "Selected Apples", Toast.LENGTH_SHORT).show();

            }
        });

        sellOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice = "orange";
                Toast.makeText(getBaseContext(), "Selected Oranges", Toast.LENGTH_SHORT).show();
            }
        });

        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                amount = Integer.parseInt(txtAmount.getText().toString());
                appleTotal = fruitPrefs.getInt("appleTotal", 0);
                orangeTotal = fruitPrefs.getInt("orangeTotal", 0);

                if(choice.equals("")) {
                    Toast.makeText(getBaseContext(), "Pick a fruit!", Toast.LENGTH_LONG).show();
                }else {
                    if (choice.equals("apple")) {
                        if ((appleTotal - amount) >= 0) {
                            gain = amount * 2;
                            appleTotal = appleTotal - amount;
                            wallet = wallet + gain;

                            Toast.makeText(getBaseContext(), "+" + gain, Toast.LENGTH_LONG).show();

                            SharedPreferences.Editor fruitEdit = fruitPrefs.edit();
                            fruitEdit.putInt("appleTotal", appleTotal);
                            fruitEdit.putInt("orangeTotal", orangeTotal);
                            fruitEdit.putInt("wallet", wallet);
                            fruitEdit.commit();

                            startActivity(new Intent(ShopScreen.this, GameScreen.class));
                        } else {
                            Toast.makeText(getBaseContext(), "You don't have enough apples!", Toast.LENGTH_LONG).show();
                        }
                    } else if (choice.equals("orange")) {
                        if ((orangeTotal - amount) >= 0) {
                            gain = amount * 2;
                            orangeTotal = orangeTotal - amount;
                            wallet = wallet + gain;

                            Toast.makeText(getBaseContext(), "+" + gain, Toast.LENGTH_LONG).show();

                            SharedPreferences.Editor fruitEdit = fruitPrefs.edit();
                            fruitEdit.putInt("appleTotal", appleTotal);
                            fruitEdit.putInt("orangeTotal", orangeTotal);
                            fruitEdit.putInt("wallet", wallet);
                            fruitEdit.commit();

                            startActivity(new Intent(ShopScreen.this, GameScreen.class));
                        } else {
                            Toast.makeText(getBaseContext(), "You don't have enough oranges!", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });
    }
}