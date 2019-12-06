package br.com.mind5.business.materialSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;

public final class MatarchMerger {
	public static MatarchInfo mergeToSelect(MatarchInfo sourceOne, MatarchInfo sourceTwo) {
		InfoMerger<MatarchInfo, MatarchInfo> merger = new MatarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatarchInfo> mergeToSelect(List<MatarchInfo> sourceOnes, List<MatarchInfo> sourceTwos) {
		InfoMerger<MatarchInfo, MatarchInfo> merger = new MatarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
