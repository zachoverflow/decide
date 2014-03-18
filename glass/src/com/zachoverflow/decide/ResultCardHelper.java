// Copyright 2014 Zach Johnson (zachoverflow)

package com.zachoverflow.decide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

import android.content.Context;
import android.speech.tts.TextToSpeech;

import com.google.android.glass.app.Card;

/**
 *  Helps with choosing and constructing result cards
 */
public class ResultCardHelper {

	/**
	 * Performs a coin flip
	 * @param context The context to construct the result card within
	 * @return A card representing the result
	 */
	public static Card flipCoin(Context context, TextToSpeech speech) {
		Random random = new Random();
		
		Card result = new Card(context);
		result.setImageLayout(Card.ImageLayout.FULL);
		
		switch (random.nextInt(2)) {
			case 1:
				result.setText(R.string.heads_result_text);
				result.addImage(R.drawable.heads);
				break;
			default:
				result.setText(R.string.tails_result_text);
				result.addImage(R.drawable.tails);
				break;
		}
		
		speech.speak(result.getText(), TextToSpeech.QUEUE_FLUSH, null);
		
		return result;
	}
	
	/**
	 * Chooses rock, paper, or scissors
	 * @param context The context to construct the result card within
	 * @return A card representing the result
	 */
	public static Card rockPaperScissors(Context context, TextToSpeech speech) {
		Random random = new Random();
		
		Card result = new Card(context);
		result.setImageLayout(Card.ImageLayout.FULL);
		
		switch (random.nextInt(3)) {
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
		
		speech.speak(result.getText(), TextToSpeech.QUEUE_FLUSH, null);
		
		return result;
	}
	
	/**
	 * Chooses between a list of options, with overrides for coin flips or rock paper scissors
	 * @param context The context to construct the result card within
	 * @return A card representing the result
	 */
	public static Card chooseGeneral(ArrayList<String> options, Context context, TextToSpeech speech) {
		Random random = new Random();
		
		if (options.size() == 2) {
			Collections.sort(options);
			if (options.get(0).toUpperCase(Locale.US).equals("HEADS")
					&& options.get(1).toUpperCase(Locale.US).equals("TAILS")) {
				return flipCoin(context, speech);
			}
			
			// 1/10 gets the why not both easter egg
			if (random.nextInt(10) == 0) {
				Card result = new Card(context);
				result.setImageLayout(Card.ImageLayout.FULL);
				result.setText(R.string.why_not_both_result_text);
				result.addImage(R.drawable.whynotboth);
				speech.speak(result.getText(), TextToSpeech.QUEUE_FLUSH, null);
				return result;
			}
		} else if (options.size() == 3) {
			Collections.sort(options);
			if (options.get(0).toUpperCase(Locale.US).equals("PAPER")
					&& options.get(1).toUpperCase(Locale.US).equals("ROCK")
					&& options.get(2).toUpperCase(Locale.US).equals("SCISSORS")) {
				return rockPaperScissors(context, speech);
			}
		}
		
		Card result = new Card(context);
		result.setText(options.get(random.nextInt(options.size())));
		
		speech.speak(result.getText(), TextToSpeech.QUEUE_FLUSH, null);
		
		return result;
	}
}
