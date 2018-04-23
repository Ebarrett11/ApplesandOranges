package net.androidbootcamp.applesandoranges;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();

                try {
                    String FILENAME = "filePlayerName";
                    byte[] bytes = new byte[1024];

                    FileInputStream fos = openFileInput("filePlayerName");

                    fos.read(bytes);
                    fos.close();

                    playerName = new String(bytes);

                } catch (IOException e) {
                    Log.e("ERROR", e.toString());
                }

                if (playerName == null){
                    startActivity(new Intent(SplashActivity.this, StartScreen.class));
                }
                else {
                    startActivity(new Intent(SplashActivity.this, GameScreen.class));
                }
            }
        };
        Timer opening = new Timer();
        opening.schedule(task, 5000);
    }
}
