package br.com.mind5.business.materialMovementSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;

public final class MatmarchMerger {
	public static MatmarchInfo mergeToSelect(MatmarchInfo sourceOne, MatmarchInfo sourceTwo) {
		InfoMerger<MatmarchInfo, MatmarchInfo> merger = new MatmarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatmarchInfo> mergeToSelect(List<MatmarchInfo> sourceOnes, List<MatmarchInfo> sourceTwos) {
		InfoMerger<MatmarchInfo, MatmarchInfo> merger = new MatmarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
