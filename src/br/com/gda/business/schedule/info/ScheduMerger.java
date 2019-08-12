package br.com.gda.business.schedule.info;

import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMerger;

public final class ScheduMerger {
	public static ScheduInfo mergeWithMat(MatInfo sourceOne, ScheduInfo sourceTwo) {
		InfoMerger<ScheduInfo, MatInfo> merger = new ScheduMergerMat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<ScheduInfo> mergeWithMat(List<MatInfo> sourceOnes, List<ScheduInfo> sourceTwos) {
		InfoMerger<ScheduInfo, MatInfo> merger = new ScheduMergerMat();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static ScheduInfo mergeToSelect(ScheduInfo sourceOne, ScheduInfo sourceTwo) {
		InfoMerger<ScheduInfo, ScheduInfo> merger = new ScheduMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<ScheduInfo> mergeToSelect(List<ScheduInfo> sourceOnes, List<ScheduInfo> sourceTwos) {
		InfoMerger<ScheduInfo, ScheduInfo> merger = new ScheduMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
