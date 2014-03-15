// Copyright 2014 Zach Johnson (zachoverflow)

package com.zachoverflow.decide;

import java.util.ArrayList;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;

/**
 * An activity to choose between a general list of options on behalf of the user
 */
public class ChooseBetweenActivity extends Activity {

private TextToSpeech speech;
	
	@Override
    protected void onResume() {
        super.onResume();
        
        ArrayList<String> voiceResults = getIntent()
        		.getExtras()
        		.getStringArrayList(RecognizerIntent.EXTRA_RESULTS);
        
        final ArrayList<String> options = parseVoiceOptions(voiceResults.get(0));        
        final Activity activity = this;
        
        this.speech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
            	activity.setContentView(ResultCardHelper.chooseGeneral(options, activity, speech).toView());
            }
        });
	}
	
	@Override
    public void onDestroy() {
		this.speech.shutdown();
		
		super.onDestroy();
	}
	
	/**
	 * Break the input string into a list of options
	 * @param input The string to parse
	 * @return The parsed options
	 */
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