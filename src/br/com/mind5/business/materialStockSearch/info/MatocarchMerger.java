package br.com.mind5.business.materialStockSearch.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class MatocarchMerger {
	public static MatocarchInfo mergeToSelect(MatocarchInfo sourceOne, MatocarchInfo sourceTwo) {
		InfoMerger_<MatocarchInfo, MatocarchInfo> merger = new MatocarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatocarchInfo> mergeToSelect(List<MatocarchInfo> sourceOnes, List<MatocarchInfo> sourceTwos) {
		InfoMerger_<MatocarchInfo, MatocarchInfo> merger = new MatocarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
