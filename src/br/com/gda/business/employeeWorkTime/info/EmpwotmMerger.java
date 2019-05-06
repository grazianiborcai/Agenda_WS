package br.com.gda.business.employeeWorkTime.info;

import java.util.List;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class EmpwotmMerger {	
	public static EmpwotmInfo mergeWithTimezone(TimezoneInfo sourceOne, EmpwotmInfo sourceTwo) {
		InfoMerger<EmpwotmInfo, TimezoneInfo> merger = new EmpwotmMergerTimezone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpwotmInfo> mergeWithTimezone(List<TimezoneInfo> sourceOnes, List<EmpwotmInfo> sourceTwos) {
		InfoMerger<EmpwotmInfo, TimezoneInfo> merger = new EmpwotmMergerTimezone();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static EmpwotmInfo mergeWithUsername(UsernameInfo sourceOne, EmpwotmInfo sourceTwo) {
		InfoMerger<EmpwotmInfo, UsernameInfo> merger = new EmpwotmMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpwotmInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<EmpwotmInfo> sourceTwos) {
		InfoMerger<EmpwotmInfo, UsernameInfo> merger = new EmpwotmMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpwotmInfo mergeWithWeekday(WeekdayInfo sourceOne, EmpwotmInfo sourceTwo) {
		InfoMerger<EmpwotmInfo, WeekdayInfo> merger = new EmpwotmMergerWeekday();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpwotmInfo> mergeWithWeekday(List<WeekdayInfo> sourceOnes, List<EmpwotmInfo> sourceTwos) {
		InfoMerger<EmpwotmInfo, WeekdayInfo> merger = new EmpwotmMergerWeekday();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpwotmInfo mergeToDelete(EmpwotmInfo sourceOne, EmpwotmInfo sourceTwo) {
		InfoMerger<EmpwotmInfo, EmpwotmInfo> merger = new EmpwotmMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpwotmInfo> mergeToDelete(List<EmpwotmInfo> sourceOnes, List<EmpwotmInfo> sourceTwos) {
		InfoMerger<EmpwotmInfo, EmpwotmInfo> merger = new EmpwotmMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpwotmInfo mergeToSelect(EmpwotmInfo sourceOne, EmpwotmInfo sourceTwo) {
		InfoMerger<EmpwotmInfo, EmpwotmInfo> merger = new EmpwotmMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpwotmInfo> mergeToSelect(List<EmpwotmInfo> sourceOnes, List<EmpwotmInfo> sourceTwos) {
		InfoMerger<EmpwotmInfo, EmpwotmInfo> merger = new EmpwotmMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
