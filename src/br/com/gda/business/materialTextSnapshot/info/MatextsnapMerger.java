package br.com.gda.business.materialTextSnapshot.info;

import java.util.List;

import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.info.InfoMerger;

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
