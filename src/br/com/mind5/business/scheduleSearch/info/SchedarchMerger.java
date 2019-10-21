package br.com.mind5.business.scheduleSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;

public final class SchedarchMerger {
	public static SchedarchInfo mergeToSelect(SchedarchInfo sourceOne, SchedarchInfo sourceTwo) {
		InfoMerger<SchedarchInfo, SchedarchInfo> merger = new SchedarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedarchInfo> mergeToSelect(List<SchedarchInfo> sourceOnes, List<SchedarchInfo> sourceTwos) {
		InfoMerger<SchedarchInfo, SchedarchInfo> merger = new SchedarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
}
