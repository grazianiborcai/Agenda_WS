package br.com.mind5.business.employeePositionSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;

public final class EmposarchMerger {
	public static EmposarchInfo mergeToSelect(EmposarchInfo sourceOne, EmposarchInfo sourceTwo) {
		InfoMerger<EmposarchInfo, EmposarchInfo> merger = new EmposarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmposarchInfo> mergeToSelect(List<EmposarchInfo> sourceOnes, List<EmposarchInfo> sourceTwos) {
		InfoMerger<EmposarchInfo, EmposarchInfo> merger = new EmposarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
