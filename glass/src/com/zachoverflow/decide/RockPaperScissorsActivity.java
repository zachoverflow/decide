package com.zachoverflow.decide;

import android.app.Activity;
import android.os.Bundle;

public class RockPaperScissorsActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        this.setContentView(ResultCardHelper.rockPaperScissors(this).toView());
    }
}