package br.com.mind5.business.scheduleYearData.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.masterData.month.info.MonthInfo;

public final class SchedyeratMerger {
	public static SchedyeratInfo mergeWithMonth(MonthInfo sourceOne, SchedyeratInfo sourceTwo) {
		InfoMerger_<SchedyeratInfo, MonthInfo> merger = new SchedyeratMergerMonth();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedyeratInfo> mergeWithMonth(List<MonthInfo> sourceOnes, List<SchedyeratInfo> sourceTwos) {
		InfoMerger_<SchedyeratInfo, MonthInfo> merger = new SchedyeratMergerMonth();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedyeratInfo mergeToSelect(SchedyeratInfo sourceOne, SchedyeratInfo sourceTwo) {
		InfoMerger_<SchedyeratInfo, SchedyeratInfo> merger = new SchedyeratMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedyeratInfo> mergeToSelect(List<SchedyeratInfo> sourceOnes, List<SchedyeratInfo> sourceTwos) {
		InfoMerger_<SchedyeratInfo, SchedyeratInfo> merger = new SchedyeratMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
