package br.com.mind5.model.decisionTree.temp;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoRecord;

final class DeciTreeUtil {
	public static <T extends InfoRecord> List<T> copyOf(List<T> records) {
		try {
			return tryCopyOf(records);
			
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	private static <T extends InfoRecord> List<T> tryCopyOf(List<T> records) throws CloneNotSupportedException {
		List<T> copies = new ArrayList<>();
		
		for (T eachRecord : records) {
			T eachCopy = (T) eachRecord.clone();
			copies.add(eachCopy);
		}
		
		return copies;
	}
}
