package com.example.preferenciascompartidas3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnPreferencias, btnObtener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPreferencias = findViewById(R.id.btnPreferencias);
        btnObtener = findViewById(R.id.btnObtener);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

        btnPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PreferencesActivity.class);
                startActivity(i);
            }
        });

        btnObtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = prefs.getString("opcion5", "");
                android.net.Uri uri = android.net.Uri.parse(s);
                Ringtone ringtone = RingtoneManager.getRingtone(MainActivity.this, uri);
                Toast.makeText(MainActivity.this,
                        "Opción 1: " + prefs.getBoolean("opcion1", false) + "\n" +
                                "Opción 2: " + prefs.getString("opcion2", "") + "\n" +
                                "Opción 3: " + prefs.getString("opcion3", "") + "\n" +
                                "Opción 4: " + prefs.getBoolean("opcion4", false) + "\n" +
                                "Opción 5: " + ringtone.getTitle(MainActivity.this) + "\n",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
