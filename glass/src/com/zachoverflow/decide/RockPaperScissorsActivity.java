// Copyright 2014 Zach Johnson (zachoverflow)

package com.zachoverflow.decide;

import android.app.Activity;
import android.os.Bundle;

/**
 * And activity to choose between rock, paper, and scissors on behalf of the user
 */
public class RockPaperScissorsActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        this.setContentView(ResultCardHelper.rockPaperScissors(this).toView());
    }
}