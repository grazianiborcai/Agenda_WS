package br.com.mind5.business.employeeWorkTimeConflict.info;

import java.util.List;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.info.InfoMerger;

public final class EmpwocoMerger {
	public static EmpwocoInfo mergeWithTimezone(TimezoneInfo sourceOne, EmpwocoInfo sourceTwo) {
		InfoMerger<EmpwocoInfo, TimezoneInfo> merger = new EmpwocoMergerTimezone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpwocoInfo> mergeWithTimezone(List<TimezoneInfo> sourceOnes, List<EmpwocoInfo> sourceTwos) {
		InfoMerger<EmpwocoInfo, TimezoneInfo> merger = new EmpwocoMergerTimezone();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpwocoInfo mergeWithWeekday(WeekdayInfo sourceOne, EmpwocoInfo sourceTwo) {
		InfoMerger<EmpwocoInfo, WeekdayInfo> merger = new EmpwocoMergerWeekday();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpwocoInfo> mergeWithWeekday(List<WeekdayInfo> sourceOnes, List<EmpwocoInfo> sourceTwos) {
		InfoMerger<EmpwocoInfo, WeekdayInfo> merger = new EmpwocoMergerWeekday();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpwocoInfo mergeToSelect(EmpwocoInfo sourceOne, EmpwocoInfo sourceTwo) {
		InfoMerger<EmpwocoInfo, EmpwocoInfo> merger = new EmpwocoMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpwocoInfo> mergeToSelect(List<EmpwocoInfo> sourceOnes, List<EmpwocoInfo> sourceTwos) {
		InfoMerger<EmpwocoInfo, EmpwocoInfo> merger = new EmpwocoMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
