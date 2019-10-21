package br.com.mind5.business.employeeWorkTimeOutlier.info;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;

public final class EmpwoutMerger {
	public static EmpwoutInfo mergeWithEmplis(EmplisInfo sourceOne, EmpwoutInfo sourceTwo) {
		InfoMerger<EmpwoutInfo, EmplisInfo> merger = new EmpwoutMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpwoutInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<EmpwoutInfo> sourceTwos) {
		InfoMerger<EmpwoutInfo, EmplisInfo> merger = new EmpwoutMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpwoutInfo mergeWithWeekday(WeekdayInfo sourceOne, EmpwoutInfo sourceTwo) {
		InfoMerger<EmpwoutInfo, WeekdayInfo> merger = new EmpwoutMergerWeekday();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpwoutInfo> mergeWithWeekday(List<WeekdayInfo> sourceOnes, List<EmpwoutInfo> sourceTwos) {
		InfoMerger<EmpwoutInfo, WeekdayInfo> merger = new EmpwoutMergerWeekday();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpwoutInfo mergeWithStolis(StolisInfo sourceOne, EmpwoutInfo sourceTwo) {
		InfoMerger<EmpwoutInfo, StolisInfo> merger = new EmpwoutMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpwoutInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<EmpwoutInfo> sourceTwos) {
		InfoMerger<EmpwoutInfo, StolisInfo> merger = new EmpwoutMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpwoutInfo mergeToSelect(EmpwoutInfo sourceOne, EmpwoutInfo sourceTwo) {
		InfoMerger<EmpwoutInfo, EmpwoutInfo> merger = new EmpwoutMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpwoutInfo> mergeToSelect(List<EmpwoutInfo> sourceOnes, List<EmpwoutInfo> sourceTwos) {
		InfoMerger<EmpwoutInfo, EmpwoutInfo> merger = new EmpwoutMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
