package br.com.mind5.common;

import java.text.Normalizer;

public final class StringUtil {
	public static String normalizeSearch(String source) {
		if (source == null)
			return source;		
		
		source = source.toUpperCase();
		source = Normalizer.normalize(source, Normalizer.Form.NFD);
		source = source.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		source = source.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		source = source.replaceAll("\\s+","");
		
		return source;
	}
}
