package br.com.mind5.business.scheduleWeekData.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

public final class SchedeekdatMerger {
	public static SchedeekdatInfo mergeWithWeekday(WeekdayInfo sourceOne, SchedeekdatInfo sourceTwo) {
		InfoMerger_<SchedeekdatInfo, WeekdayInfo> merger = new SchedeekdatMergerWeekday();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedeekdatInfo> mergeWithWeekday(List<WeekdayInfo> sourceOnes, List<SchedeekdatInfo> sourceTwos) {
		InfoMerger_<SchedeekdatInfo, WeekdayInfo> merger = new SchedeekdatMergerWeekday();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedeekdatInfo mergeWithMonth(MonthInfo sourceOne, SchedeekdatInfo sourceTwo) {
		InfoMerger_<SchedeekdatInfo, MonthInfo> merger = new SchedeekdatMergerMonth();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedeekdatInfo> mergeWithMonth(List<MonthInfo> sourceOnes, List<SchedeekdatInfo> sourceTwos) {
		InfoMerger_<SchedeekdatInfo, MonthInfo> merger = new SchedeekdatMergerMonth();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedeekdatInfo mergeToSelect(SchedeekdatInfo sourceOne, SchedeekdatInfo sourceTwo) {
		InfoMerger_<SchedeekdatInfo, SchedeekdatInfo> merger = new SchedeekdatMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedeekdatInfo> mergeToSelect(List<SchedeekdatInfo> sourceOnes, List<SchedeekdatInfo> sourceTwos) {
		InfoMerger_<SchedeekdatInfo, SchedeekdatInfo> merger = new SchedeekdatMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
