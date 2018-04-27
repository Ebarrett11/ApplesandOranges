package net.androidbootcamp.applesandoranges;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ShopScreen extends AppCompatActivity {
    int aTreeTotal, oTreeTotal, buyCost, wallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_screen);

        ImageButton buyApple =  findViewById(R.id.btnBuyApple);
        ImageButton buyOrange = findViewById(R.id.btnBuyOrange);
        Button buy = findViewById(R.id.btnBuy);
        Button game = findViewById(R.id.btnGame);
        final TextView txtCost = findViewById(R.id.txtCost);

        SharedPreferences fruitPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        wallet = fruitPrefs.getInt("wallet", 0);

        SharedPreferences trees = PreferenceManager.getDefaultSharedPreferences(this);
        aTreeTotal = trees.getInt("aTreeTotal", 0);
        oTreeTotal = trees.getInt("oTreeTotal", 0);

        final SharedPreferences.Editor treeEdit = trees.edit();

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
                if(oTreeTotal < 9 && aTreeTotal < 9){
                    if ((wallet - buyCost) < 0){
                        Toast.makeText(getBaseContext(), "Can't go into debt", Toast.LENGTH_LONG).show();
                    }else {
                        wallet = wallet - buyCost;
                        SharedPreferences fruitPrefs = PreferenceManager.getDefaultSharedPreferences(ShopScreen.this);
                        SharedPreferences.Editor editor = fruitPrefs.edit();
                        editor.putInt("wallet", wallet);
                        editor.commit();

                        if (buyCost == 50){
                            aTreeTotal++;
                            treeEdit.putInt("aTreeTotal", aTreeTotal);
                            treeEdit.commit();
                        } else if (buyCost == 75){
                            oTreeTotal++;
                            treeEdit.putInt("oTreeTotal", oTreeTotal);
                            treeEdit.commit();
                        }
                        Toast.makeText(getBaseContext(), "-" + buyCost, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ShopScreen.this, GameScreen.class));
                    }
                }else if (aTreeTotal >= 9){
                    aTreeTotal = 8;
                    Toast.makeText(getBaseContext(), "No more than 8 trees", Toast.LENGTH_LONG).show();
                }else if (oTreeTotal >= 9){
                    oTreeTotal = 8;
                    Toast.makeText(getBaseContext(), "No more than 8 trees", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
