package br.com.mind5.business.employeeWorkTime.info;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class EmpwotmMerger {	
	public static EmpwotmInfo mergeWithStowotarch(StowotarchInfo sourceOne, EmpwotmInfo sourceTwo) {
		InfoMerger<EmpwotmInfo, StowotarchInfo> merger = new EmpwotmMergerStowotarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpwotmInfo> mergeWithStowotarch(List<StowotarchInfo> sourceOnes, List<EmpwotmInfo> sourceTwos) {
		InfoMerger<EmpwotmInfo, StowotarchInfo> merger = new EmpwotmMergerStowotarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static EmpwotmInfo mergeWithEmpwout(EmpwoutInfo sourceOne, EmpwotmInfo sourceTwo) {
		InfoMerger<EmpwotmInfo, EmpwoutInfo> merger = new EmpwotmMergerEmpwout();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpwotmInfo> mergeWithEmpwout(List<EmpwoutInfo> sourceOnes, List<EmpwotmInfo> sourceTwos) {
		InfoMerger<EmpwotmInfo, EmpwoutInfo> merger = new EmpwotmMergerEmpwout();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static EmpwotmInfo mergeWithEmpwoco(EmpwocoInfo sourceOne, EmpwotmInfo sourceTwo) {
		InfoMerger<EmpwotmInfo, EmpwocoInfo> merger = new EmpwotmMergerEmpwoco();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpwotmInfo> mergeWithEmpwoco(List<EmpwocoInfo> sourceOnes, List<EmpwotmInfo> sourceTwos) {
		InfoMerger<EmpwotmInfo, EmpwocoInfo> merger = new EmpwotmMergerEmpwoco();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static EmpwotmInfo mergeWithEmpwotarch(EmpwotarchInfo sourceOne, EmpwotmInfo sourceTwo) {
		InfoMerger<EmpwotmInfo, EmpwotarchInfo> merger = new EmpwotmMergerEmpwotarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpwotmInfo> mergeWithEmpwotarch(List<EmpwotarchInfo> sourceOnes, List<EmpwotmInfo> sourceTwos) {
		InfoMerger<EmpwotmInfo, EmpwotarchInfo> merger = new EmpwotmMergerEmpwotarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
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
