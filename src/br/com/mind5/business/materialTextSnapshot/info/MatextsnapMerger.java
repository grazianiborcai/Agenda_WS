package br.com.mind5.business.materialTextSnapshot.info;

import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.info.InfoMerger;

public final class MatextsnapMerger {
	public static MatextsnapInfo mergeWithMatext(MatextInfo sourceOne, MatextsnapInfo sourceTwo) {
		InfoMerger<MatextsnapInfo, MatextInfo> merger = new MatextsnapMergerMatext();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatextsnapInfo> mergeWithMatext(List<MatextInfo> sourceOnes, List<MatextsnapInfo> sourceTwos) {
		InfoMerger<MatextsnapInfo, MatextInfo> merger = new MatextsnapMergerMatext();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
