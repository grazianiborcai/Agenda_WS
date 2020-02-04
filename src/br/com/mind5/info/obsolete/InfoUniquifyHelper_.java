package br.com.mind5.info.obsolete;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.info.InfoUniquifier;


public final class InfoUniquifyHelper_<T> implements InfoUniquifier<T> {
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
