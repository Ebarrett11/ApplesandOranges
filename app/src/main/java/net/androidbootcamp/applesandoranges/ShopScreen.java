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
        final TextView txtCost = findViewById(R.id.txtCost);

        SharedPreferences fruitPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        wallet = fruitPrefs.getInt("wallet", 0);

        SharedPreferences trees = PreferenceManager.getDefaultSharedPreferences(this);
        aTreeTotal = trees.getInt("aTreeTotal", 0);
        oTreeTotal = trees.getInt("oTreeTotal", 0);

        final SharedPreferences.Editor treeEdit = trees.edit();

        buyApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aTreeTotal++;
                treeEdit.putInt("aTreeTotal", aTreeTotal);
                treeEdit.commit();
                txtCost.setText("Cost: 50");
                buyCost = 50;
            }
        });

        buyOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oTreeTotal++;
                treeEdit.putInt("oTreeTotal", oTreeTotal);
                treeEdit.commit();
                txtCost.setText("Cost: 75");
                buyCost = 75;
            }
        });

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wallet = wallet - buyCost;
                SharedPreferences fruitPrefs = PreferenceManager.getDefaultSharedPreferences(ShopScreen.this);
                SharedPreferences.Editor editor = fruitPrefs.edit();
                editor.putInt("wallet", wallet);
                editor.commit();
                //toast message that says how much was spent
                startActivity(new Intent(ShopScreen.this, GameScreen.class));
            }
        });

    }

}
