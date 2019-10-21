package br.com.mind5.business.scheduleRange.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;

public final class SchedageMerger {
	public static SchedageInfo mergeToSelect(SchedageInfo sourceOne, SchedageInfo sourceTwo) {
		InfoMerger<SchedageInfo, SchedageInfo> merger = new SchedageMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedageInfo> mergeToSelect(List<SchedageInfo> sourceOnes, List<SchedageInfo> sourceTwos) {
		InfoMerger<SchedageInfo, SchedageInfo> merger = new SchedageMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
}
