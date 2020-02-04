package br.com.mind5.business.scheduleRange.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class SchedageMerger {
	public static SchedageInfo mergeToSelect(SchedageInfo sourceOne, SchedageInfo sourceTwo) {
		InfoMerger_<SchedageInfo, SchedageInfo> merger = new SchedageMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedageInfo> mergeToSelect(List<SchedageInfo> sourceOnes, List<SchedageInfo> sourceTwos) {
		InfoMerger_<SchedageInfo, SchedageInfo> merger = new SchedageMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
}
