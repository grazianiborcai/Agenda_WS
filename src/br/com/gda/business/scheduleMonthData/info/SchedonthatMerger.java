package br.com.gda.business.scheduleMonthData.info;

import java.util.List;

import br.com.gda.business.masterData.info.MonthInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMerger;

public final class SchedonthatMerger {
	public static SchedonthatInfo mergeWithWeekday(WeekdayInfo sourceOne, SchedonthatInfo sourceTwo) {
		InfoMerger<SchedonthatInfo, WeekdayInfo> merger = new SchedonthatMergerWeekday();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedonthatInfo> mergeWithWeekday(List<WeekdayInfo> sourceOnes, List<SchedonthatInfo> sourceTwos) {
		InfoMerger<SchedonthatInfo, WeekdayInfo> merger = new SchedonthatMergerWeekday();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedonthatInfo mergeWithMonth(MonthInfo sourceOne, SchedonthatInfo sourceTwo) {
		InfoMerger<SchedonthatInfo, MonthInfo> merger = new SchedonthatMergerMonth();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedonthatInfo> mergeWithMonth(List<MonthInfo> sourceOnes, List<SchedonthatInfo> sourceTwos) {
		InfoMerger<SchedonthatInfo, MonthInfo> merger = new SchedonthatMergerMonth();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedonthatInfo mergeToSelect(SchedonthatInfo sourceOne, SchedonthatInfo sourceTwo) {
		InfoMerger<SchedonthatInfo, SchedonthatInfo> merger = new SchedonthatMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedonthatInfo> mergeToSelect(List<SchedonthatInfo> sourceOnes, List<SchedonthatInfo> sourceTwos) {
		InfoMerger<SchedonthatInfo, SchedonthatInfo> merger = new SchedonthatMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
