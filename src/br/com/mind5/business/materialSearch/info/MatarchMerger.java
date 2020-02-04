package br.com.mind5.business.materialSearch.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class MatarchMerger {
	public static MatarchInfo mergeToSelect(MatarchInfo sourceOne, MatarchInfo sourceTwo) {
		InfoMerger_<MatarchInfo, MatarchInfo> merger = new MatarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatarchInfo> mergeToSelect(List<MatarchInfo> sourceOnes, List<MatarchInfo> sourceTwos) {
		InfoMerger_<MatarchInfo, MatarchInfo> merger = new MatarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
