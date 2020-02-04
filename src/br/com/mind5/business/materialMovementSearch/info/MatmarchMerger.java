package br.com.mind5.business.materialMovementSearch.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class MatmarchMerger {
	public static MatmarchInfo mergeToSelect(MatmarchInfo sourceOne, MatmarchInfo sourceTwo) {
		InfoMerger_<MatmarchInfo, MatmarchInfo> merger = new MatmarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatmarchInfo> mergeToSelect(List<MatmarchInfo> sourceOnes, List<MatmarchInfo> sourceTwos) {
		InfoMerger_<MatmarchInfo, MatmarchInfo> merger = new MatmarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
