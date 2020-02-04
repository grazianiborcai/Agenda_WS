package br.com.mind5.business.scheduleYear.info;

import java.util.List;

import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.obsolete.InfoMerger_;

public final class SchedyearMerger {
	public static SchedyearInfo mergeWithStolis(StolisInfo sourceOne, SchedyearInfo sourceTwo) {
		InfoMerger_<SchedyearInfo, StolisInfo> merger = new SchedyearMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedyearInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<SchedyearInfo> sourceTwos) {
		InfoMerger_<SchedyearInfo, StolisInfo> merger = new SchedyearMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedyearInfo mergeWithSchedyerat(SchedyeratInfo sourceOne, SchedyearInfo sourceTwo) {
		InfoMerger_<SchedyearInfo, SchedyeratInfo> merger = new SchedyearMergerSchedyerat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedyearInfo> mergeWithSchedyerat(List<SchedyeratInfo> sourceOnes, List<SchedyearInfo> sourceTwos) {
		InfoMerger_<SchedyearInfo, SchedyeratInfo> merger = new SchedyearMergerSchedyerat();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
