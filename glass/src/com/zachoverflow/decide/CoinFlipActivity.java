// Copyright 2014 Zach Johnson (zachoverflow)

package com.zachoverflow.decide;

import android.app.Activity;
import android.os.Bundle;

/**
 * An activity to perform a coin flip on behalf of the user
 */
public class CoinFlipActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        this.setContentView(ResultCardHelper.flipCoin(this).toView());
    }
}