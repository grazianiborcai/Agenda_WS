package br.com.mind5.business.employeeLeaveDateRange.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;

public final class EmplargMerger {
	public static EmplargInfo mergeToSelect(EmplargInfo sourceOne, EmplargInfo sourceTwo) {
		InfoMerger<EmplargInfo, EmplargInfo> merger = new EmplargMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmplargInfo> mergeToSelect(List<EmplargInfo> sourceOnes, List<EmplargInfo> sourceTwos) {
		InfoMerger<EmplargInfo, EmplargInfo> merger = new EmplargMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
