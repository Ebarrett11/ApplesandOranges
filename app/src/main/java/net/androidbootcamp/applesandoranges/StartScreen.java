package net.androidbootcamp.applesandoranges;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class StartScreen extends AppCompatActivity {
    String playerName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        EditText txtPlayerName = (EditText) findViewById(R.id.txtPlayer);

        playerName = txtPlayerName.getText().toString();

        
    }
}
