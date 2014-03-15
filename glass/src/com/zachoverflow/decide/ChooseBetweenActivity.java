package com.zachoverflow.decide;

import java.util.ArrayList;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;

public class ChooseBetweenActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
	
	@Override
    protected void onResume() {
        super.onResume();
        
        ArrayList<String> voiceResults = getIntent()
        		.getExtras()
        		.getStringArrayList(RecognizerIntent.EXTRA_RESULTS);
        
        ArrayList<String> options = parseVoiceOptions(voiceResults.get(0));
        this.setContentView(ResultCardHelper.chooseGeneral(options, this).toView());
    }
	
	@SuppressLint("DefaultLocale") 
	private ArrayList<String> parseVoiceOptions(String input) {
		ArrayList<String> results = new ArrayList<String>();
		
		for (String option : input.split("\\s((or)|(and))\\s")) {
			String trimmed = option.trim();
			if (trimmed.length() > 0) {
				results.add(option.toLowerCase(Locale.getDefault()));
			}
		}
		
		return results;
	}
}