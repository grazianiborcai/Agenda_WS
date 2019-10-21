package br.com.mind5.business.scheduleYearData.info;

import java.util.List;

import br.com.mind5.business.masterData.info.MonthInfo;
import br.com.mind5.info.InfoMerger;

public final class SchedyeratMerger {
	public static SchedyeratInfo mergeWithMonth(MonthInfo sourceOne, SchedyeratInfo sourceTwo) {
		InfoMerger<SchedyeratInfo, MonthInfo> merger = new SchedyeratMergerMonth();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedyeratInfo> mergeWithMonth(List<MonthInfo> sourceOnes, List<SchedyeratInfo> sourceTwos) {
		InfoMerger<SchedyeratInfo, MonthInfo> merger = new SchedyeratMergerMonth();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedyeratInfo mergeToSelect(SchedyeratInfo sourceOne, SchedyeratInfo sourceTwo) {
		InfoMerger<SchedyeratInfo, SchedyeratInfo> merger = new SchedyeratMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedyeratInfo> mergeToSelect(List<SchedyeratInfo> sourceOnes, List<SchedyeratInfo> sourceTwos) {
		InfoMerger<SchedyeratInfo, SchedyeratInfo> merger = new SchedyeratMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
