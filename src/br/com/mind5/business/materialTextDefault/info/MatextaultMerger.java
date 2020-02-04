package br.com.mind5.business.materialTextDefault.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class MatextaultMerger {	
	public static MatextaultInfo mergeToSelect(MatextaultInfo sourceOne, MatextaultInfo sourceTwo) {
		InfoMerger_<MatextaultInfo, MatextaultInfo> merger = new MatextaultMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatextaultInfo> mergeToSelect(List<MatextaultInfo> sourceOnes, List<MatextaultInfo> sourceTwos) {
		InfoMerger_<MatextaultInfo, MatextaultInfo> merger = new MatextaultMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
