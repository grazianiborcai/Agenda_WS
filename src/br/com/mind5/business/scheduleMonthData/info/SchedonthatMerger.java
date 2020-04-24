package br.com.mind5.business.scheduleMonthData.info;

import java.util.List;

import br.com.mind5.business.masterData.info.MonthInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

public final class SchedonthatMerger {
	public static SchedonthatInfo mergeWithWeekday(WeekdayInfo sourceOne, SchedonthatInfo sourceTwo) {
		InfoMerger_<SchedonthatInfo, WeekdayInfo> merger = new SchedonthatMergerWeekday();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedonthatInfo> mergeWithWeekday(List<WeekdayInfo> sourceOnes, List<SchedonthatInfo> sourceTwos) {
		InfoMerger_<SchedonthatInfo, WeekdayInfo> merger = new SchedonthatMergerWeekday();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedonthatInfo mergeWithMonth(MonthInfo sourceOne, SchedonthatInfo sourceTwo) {
		InfoMerger_<SchedonthatInfo, MonthInfo> merger = new SchedonthatMergerMonth();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedonthatInfo> mergeWithMonth(List<MonthInfo> sourceOnes, List<SchedonthatInfo> sourceTwos) {
		InfoMerger_<SchedonthatInfo, MonthInfo> merger = new SchedonthatMergerMonth();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedonthatInfo mergeToSelect(SchedonthatInfo sourceOne, SchedonthatInfo sourceTwo) {
		InfoMerger_<SchedonthatInfo, SchedonthatInfo> merger = new SchedonthatMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedonthatInfo> mergeToSelect(List<SchedonthatInfo> sourceOnes, List<SchedonthatInfo> sourceTwos) {
		InfoMerger_<SchedonthatInfo, SchedonthatInfo> merger = new SchedonthatMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
