package com.zachoverflow.decide;

import java.util.Random;

import android.content.Context;

import com.google.android.glass.app.Card;

public class ResultCardHelper {

	public static Card flipCoin(Context context) {
		Random random = new Random();
		
		Card result = new Card(context);
		result.setImageLayout(Card.ImageLayout.FULL);
		
		switch (random.nextInt() % 2) {
			case 1:
				result.setText(R.string.heads_result_text);
				result.addImage(R.drawable.heads);
				break;
			default:
				result.setText(R.string.tails_result_text);
				result.addImage(R.drawable.tails);
				break;
		}
		
		return result;
	}
	
	public static Card rockPaperScissors(Context context) {
		Random random = new Random();
		
		Card result = new Card(context);
		result.setImageLayout(Card.ImageLayout.FULL);
		
		switch (random.nextInt() % 3) {
			case 2:
				result.setText(R.string.rock_result_text);
				result.addImage(R.drawable.rock);
				break;
			case 1:
				result.setText(R.string.paper_result_text);
				result.addImage(R.drawable.paper);
				break;
			default:
				result.setText(R.string.scissors_result_text);
				result.addImage(R.drawable.scissors);
				break;
		}
		
		return result;
	}
}
