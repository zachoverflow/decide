// Copyright 2014 Zach Johnson (zachoverflow)

package com.zachoverflow.decide;

import android.app.Activity;
import android.speech.tts.TextToSpeech;

/**
 * An activity to perform a coin flip on behalf of the user
 */
public class CoinFlipActivity extends Activity {
	
	private TextToSpeech speech;
	
	@Override
    protected void onResume() {
        super.onResume();
        
        final Activity activity = this;
        this.speech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
            	activity.setContentView(ResultCardHelper.flipCoin(activity, speech).toView());
            }
        });
	}
	
	@Override
    public void onDestroy() {
		this.speech.shutdown();
		
		super.onDestroy();
	}
}