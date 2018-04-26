package net.androidbootcamp.applesandoranges;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShopScreen extends AppCompatActivity {
    int aTreeTotal, oTreeTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_screen);

        Button buyApple = (Button) findViewById(R.id.btnBuyApple);
        Button buyOrange = (Button) findViewById(R.id.btnBuyOrange);

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
                //wallet stuff here
                startActivity(new Intent(ShopScreen.this, GameScreen.class));
            }
        });

        buyOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oTreeTotal++;
                treeEdit.putInt("oTreeTotal", oTreeTotal);
                treeEdit.commit();
                //wallet stuff here
                startActivity(new Intent(ShopScreen.this, GameScreen.class));
            }
        });

    }

}
