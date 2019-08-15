package br.com.gda.business.scheduleLine.info;

import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMerger;

public final class SchedineMerger {
	public static SchedineInfo mergeWithStolis(StolisInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, StolisInfo> merger = new SchedineMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, StolisInfo> merger = new SchedineMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeWithMat(MatInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, MatInfo> merger = new SchedineMergerMat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithMat(List<MatInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, MatInfo> merger = new SchedineMergerMat();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeToSelect(SchedineInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, SchedineInfo> merger = new SchedineMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeToSelect(List<SchedineInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, SchedineInfo> merger = new SchedineMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
