package br.com.mind5.business.materialTextSnapshot.info;

import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.info.obsolete.InfoMerger_;

public final class MatextsnapMerger {
	public static MatextsnapInfo mergeWithMatext(MatextInfo sourceOne, MatextsnapInfo sourceTwo) {
		InfoMerger_<MatextsnapInfo, MatextInfo> merger = new MatextsnapMergerMatext();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatextsnapInfo> mergeWithMatext(List<MatextInfo> sourceOnes, List<MatextsnapInfo> sourceTwos) {
		InfoMerger_<MatextsnapInfo, MatextInfo> merger = new MatextsnapMergerMatext();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatextsnapInfo mergeToSelect(MatextsnapInfo sourceOne, MatextsnapInfo sourceTwo) {
		InfoMerger_<MatextsnapInfo, MatextsnapInfo> merger = new MatextsnapMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatextsnapInfo> mergeToSelect(List<MatextsnapInfo> sourceOnes, List<MatextsnapInfo> sourceTwos) {
		InfoMerger_<MatextsnapInfo, MatextsnapInfo> merger = new MatextsnapMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
