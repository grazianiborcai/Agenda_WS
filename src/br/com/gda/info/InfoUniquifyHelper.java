package br.com.gda.info;

import java.util.List;
import java.util.stream.Collectors;


public final class InfoUniquifyHelper<T> implements InfoUniquifier<T> {
	private List<T> results;
	
	@Override public List<T> uniquify(List<T> infoRecords) {
		results = infoRecords;
		removeDuplicate();
		
		return results;
	}
	
	
	
	private void removeDuplicate() {
		results = results.stream().distinct().collect(Collectors.toList());	
	}
}
