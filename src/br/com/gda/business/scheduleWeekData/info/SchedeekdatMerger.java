package br.com.gda.business.scheduleWeekData.info;

import java.util.List;

import br.com.gda.business.masterData.info.MonthInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMerger;

public final class SchedeekdatMerger {
	public static SchedeekdatInfo mergeWithWeekday(WeekdayInfo sourceOne, SchedeekdatInfo sourceTwo) {
		InfoMerger<SchedeekdatInfo, WeekdayInfo> merger = new SchedeekdatMergerWeekday();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedeekdatInfo> mergeWithWeekday(List<WeekdayInfo> sourceOnes, List<SchedeekdatInfo> sourceTwos) {
		InfoMerger<SchedeekdatInfo, WeekdayInfo> merger = new SchedeekdatMergerWeekday();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedeekdatInfo mergeWithMonth(MonthInfo sourceOne, SchedeekdatInfo sourceTwo) {
		InfoMerger<SchedeekdatInfo, MonthInfo> merger = new SchedeekdatMergerMonth();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedeekdatInfo> mergeWithMonth(List<MonthInfo> sourceOnes, List<SchedeekdatInfo> sourceTwos) {
		InfoMerger<SchedeekdatInfo, MonthInfo> merger = new SchedeekdatMergerMonth();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedeekdatInfo mergeToSelect(SchedeekdatInfo sourceOne, SchedeekdatInfo sourceTwo) {
		InfoMerger<SchedeekdatInfo, SchedeekdatInfo> merger = new SchedeekdatMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedeekdatInfo> mergeToSelect(List<SchedeekdatInfo> sourceOnes, List<SchedeekdatInfo> sourceTwos) {
		InfoMerger<SchedeekdatInfo, SchedeekdatInfo> merger = new SchedeekdatMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
