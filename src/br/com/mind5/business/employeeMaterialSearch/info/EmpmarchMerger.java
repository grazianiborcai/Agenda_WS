package br.com.mind5.business.employeeMaterialSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;

public final class EmpmarchMerger {
	public static EmpmarchInfo mergeToSelect(EmpmarchInfo sourceOne, EmpmarchInfo sourceTwo) {
		InfoMerger<EmpmarchInfo, EmpmarchInfo> merger = new EmpmarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpmarchInfo> mergeToSelect(List<EmpmarchInfo> sourceOnes, List<EmpmarchInfo> sourceTwos) {
		InfoMerger<EmpmarchInfo, EmpmarchInfo> merger = new EmpmarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
