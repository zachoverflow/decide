package com.zachoverflow.decide;

import java.util.Random;

import android.content.Context;

import com.google.android.glass.app.Card;

public class ResultCardHelper {

	public static Card flipCoin(Context context) {
		Random random = new Random();
		
		Card result = new Card(context);
		result.setImageLayout(Card.ImageLayout.FULL);
		
		if ((random.nextInt() % 2) == 0) {
			result.setText(R.string.heads_result_text);
			result.addImage(R.drawable.heads);
		} else {
			result.setText(R.string.tails_result_text);
			result.addImage(R.drawable.tails);
		}
		
		return result;
	}
}
