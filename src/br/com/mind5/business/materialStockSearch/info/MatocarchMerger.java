package br.com.mind5.business.materialStockSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;

public final class MatocarchMerger {
	public static MatocarchInfo mergeToSelect(MatocarchInfo sourceOne, MatocarchInfo sourceTwo) {
		InfoMerger<MatocarchInfo, MatocarchInfo> merger = new MatocarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatocarchInfo> mergeToSelect(List<MatocarchInfo> sourceOnes, List<MatocarchInfo> sourceTwos) {
		InfoMerger<MatocarchInfo, MatocarchInfo> merger = new MatocarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
