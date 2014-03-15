package com.zachoverflow.decide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
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
	
	public static Card chooseGeneral(ArrayList<String> options, Context context) {
		Random random = new Random();
		
		if (options.size() == 2) {
			Collections.sort(options);
			if (options.get(0).toUpperCase(Locale.US).equals("HEADS")
					&& options.get(1).toUpperCase(Locale.US).equals("TAILS")) {
				return flipCoin(context);
			}
		} else if (options.size() == 3) {
			Collections.sort(options);
			if (options.get(0).toUpperCase(Locale.US).equals("PAPER")
					&& options.get(1).toUpperCase(Locale.US).equals("ROCK")
					&& options.get(2).toUpperCase(Locale.US).equals("SCISSORS")) {
				return rockPaperScissors(context);
			}
		}
		
		Card result = new Card(context);
		result.setText(options.get(random.nextInt() % options.size()));
		
		return result;
	}
}
