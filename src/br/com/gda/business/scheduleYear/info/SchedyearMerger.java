package br.com.gda.business.scheduleYear.info;

import java.util.List;

import br.com.gda.business.scheduleYearData.info.SchedyeratInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMerger;

public final class SchedyearMerger {
	public static SchedyearInfo mergeWithStolis(StolisInfo sourceOne, SchedyearInfo sourceTwo) {
		InfoMerger<SchedyearInfo, StolisInfo> merger = new SchedyearMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedyearInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<SchedyearInfo> sourceTwos) {
		InfoMerger<SchedyearInfo, StolisInfo> merger = new SchedyearMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedyearInfo mergeWithSchedyerat(SchedyeratInfo sourceOne, SchedyearInfo sourceTwo) {
		InfoMerger<SchedyearInfo, SchedyeratInfo> merger = new SchedyearMergerSchedyerat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedyearInfo> mergeWithSchedyerat(List<SchedyeratInfo> sourceOnes, List<SchedyearInfo> sourceTwos) {
		InfoMerger<SchedyearInfo, SchedyeratInfo> merger = new SchedyearMergerSchedyerat();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
