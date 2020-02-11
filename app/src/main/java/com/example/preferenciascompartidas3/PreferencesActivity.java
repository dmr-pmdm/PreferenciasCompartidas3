package com.example.preferenciascompartidas3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.RingtonePreference;
import android.preference.SwitchPreference;
import android.widget.RadioButton;
import android.widget.Toast;

public class PreferencesActivity extends PreferenceActivity {

    private CheckBoxPreference chkPreference;
    private EditTextPreference edtPreference;
    private ListPreference lstPreference;
    private SwitchPreference swtPreference;
    private RingtonePreference rgtPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);

        chkPreference = (CheckBoxPreference) findPreference("opcion1");
        edtPreference = (EditTextPreference) findPreference("opcion2");
        lstPreference = (ListPreference) findPreference("opcion3");
        swtPreference = (SwitchPreference) findPreference("opcion4");
        rgtPreference = (RingtonePreference) findPreference("opcion5");

        chkPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if ((boolean) newValue) {
                    Toast.makeText(PreferencesActivity.this,
                            "CheckBox activado",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PreferencesActivity.this,
                            "CheckBox desactivado",
                            Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        edtPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                Toast.makeText(PreferencesActivity.this,
                        "El usuario ha guardado la palabra " + newValue.toString(),
                        Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        lstPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                Toast.makeText(PreferencesActivity.this,
                        "El usuario ha seleccionado " + newValue.toString(),
                        Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        swtPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if ((boolean) newValue) {
                    Toast.makeText(PreferencesActivity.this,
                            "Switch activado",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PreferencesActivity.this,
                            "Switch desactivado",
                            Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        rgtPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                android.net.Uri uri = android.net.Uri.parse(newValue.toString());
                Ringtone ringtone = RingtoneManager.getRingtone(PreferencesActivity.this, uri);
                Toast.makeText(PreferencesActivity.this,
                        "El usuario ha seleccionado " + ringtone.getTitle(PreferencesActivity.this),
                        Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
