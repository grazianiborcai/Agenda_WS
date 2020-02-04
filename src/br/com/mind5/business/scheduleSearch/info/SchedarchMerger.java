package br.com.mind5.business.scheduleSearch.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class SchedarchMerger {
	public static SchedarchInfo mergeToSelect(SchedarchInfo sourceOne, SchedarchInfo sourceTwo) {
		InfoMerger_<SchedarchInfo, SchedarchInfo> merger = new SchedarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedarchInfo> mergeToSelect(List<SchedarchInfo> sourceOnes, List<SchedarchInfo> sourceTwos) {
		InfoMerger_<SchedarchInfo, SchedarchInfo> merger = new SchedarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
}
