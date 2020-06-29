package br.com.mind5.common;

import java.text.Normalizer;

public final class StringUtil {
	public static String normalizeSearch(String source) {
		source = normalize(source);
		source = wordReduction(source);
		
		return source;
	}
	
	
	
	public static String normalize(String source) {
		if (source == null)
			return source;		
		
		source = source.toUpperCase();
		source = Normalizer.normalize(source, Normalizer.Form.NFD);
		source = source.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		
		return source;
	}
	
	
	
	private static String wordReduction(String word) {
		String result = wordReductionSpace(word);
		
		if (result == null)
			return result;
		
		return result.replaceAll("\\s+","");
	}
	
	
	
	private static String wordReductionSpace(String word) {
		if (checkWord(word) == false)
			return null;
		
		
		String[] tokens = wordTokenization(word);
		StringBuilder builder = new StringBuilder();
		
		
		for (String eachToken : tokens) {
			if (checkWord(eachToken) == true)
				builder.append(eachToken);
		}
		
		
		String result = builder.toString();
		
		if (checkWord(result) == true)
			return result;
		
		return null;
	}
	
	
	
	private static boolean checkWord(String word) {
		final int MIN_LENGTH = 2;
		
		if (word == null)
			return false;
		
		if (word.length() <= MIN_LENGTH)
			return false;
		
		return true;
	}
	
	
	
	private static String[] wordTokenization(String word) {
		return word.split("(\\s|-|\\/)+");
	}
}
