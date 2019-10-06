package br.com.gda.business.employeeWorkTimeOutlier.info;

import java.util.List;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMerger;

public final class EmpwoutMerger {
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
