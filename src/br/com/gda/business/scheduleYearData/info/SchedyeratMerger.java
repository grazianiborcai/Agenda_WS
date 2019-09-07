package br.com.gda.business.scheduleYearData.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

public final class SchedyeratMerger {
	public static SchedyeratInfo mergeToSelect(SchedyeratInfo sourceOne, SchedyeratInfo sourceTwo) {
		InfoMerger<SchedyeratInfo, SchedyeratInfo> merger = new SchedyeratMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedyeratInfo> mergeToSelect(List<SchedyeratInfo> sourceOnes, List<SchedyeratInfo> sourceTwos) {
		InfoMerger<SchedyeratInfo, SchedyeratInfo> merger = new SchedyeratMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
