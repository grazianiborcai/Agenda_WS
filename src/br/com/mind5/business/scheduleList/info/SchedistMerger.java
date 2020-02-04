package br.com.mind5.business.scheduleList.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class SchedistMerger {
	public static SchedistInfo mergeToSelect(SchedistInfo sourceOne, SchedistInfo sourceTwo) {
		InfoMerger_<SchedistInfo, SchedistInfo> merger = new SchedistMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedistInfo> mergeToSelect(List<SchedistInfo> sourceOnes, List<SchedistInfo> sourceTwos) {
		InfoMerger_<SchedistInfo, SchedistInfo> merger = new SchedistMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
