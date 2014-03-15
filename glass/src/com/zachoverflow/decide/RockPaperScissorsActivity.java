// Copyright 2014 Zach Johnson (zachoverflow)

package com.zachoverflow.decide;

import android.app.Activity;
import android.speech.tts.TextToSpeech;

/**
 * And activity to choose between rock, paper, and scissors on behalf of the user
 */
public class RockPaperScissorsActivity extends Activity {

	private TextToSpeech speech;
	private boolean created;
	
	@Override
    protected void onResume() {
        super.onResume();
        
        if (created) {
        	return;
        }
        
        created = true;
        
        final Activity activity = this;
        this.speech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
            	activity.setContentView(ResultCardHelper.rockPaperScissors(activity, speech).toView());
            }
        });
	}
	
	@Override
    public void onDestroy() {
		this.speech.shutdown();
		
		super.onDestroy();
	}
}