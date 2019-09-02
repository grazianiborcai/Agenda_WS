package br.com.gda.business.scheduleList.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

public final class SchedistMerger {
	public static SchedistInfo mergeToSelect(SchedistInfo sourceOne, SchedistInfo sourceTwo) {
		InfoMerger<SchedistInfo, SchedistInfo> merger = new SchedistMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedistInfo> mergeToSelect(List<SchedistInfo> sourceOnes, List<SchedistInfo> sourceTwos) {
		InfoMerger<SchedistInfo, SchedistInfo> merger = new SchedistMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
