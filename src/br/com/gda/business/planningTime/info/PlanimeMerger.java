package br.com.gda.business.planningTime.info;

import java.util.List;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMerger;

public final class PlanimeMerger {
	public static PlanimeInfo mergeWithEmplis(EmplisInfo sourceOne, PlanimeInfo sourceTwo) {
		InfoMerger<PlanimeInfo, EmplisInfo> merger = new PlanimeMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanimeInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<PlanimeInfo> sourceTwos) {
		InfoMerger<PlanimeInfo, EmplisInfo> merger = new PlanimeMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PlanimeInfo mergeWithMat(MatInfo sourceOne, PlanimeInfo sourceTwo) {
		InfoMerger<PlanimeInfo, MatInfo> merger = new PlanimeMergerMat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanimeInfo> mergeWithMat(List<MatInfo> sourceOnes, List<PlanimeInfo> sourceTwos) {
		InfoMerger<PlanimeInfo, MatInfo> merger = new PlanimeMergerMat();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PlanimeInfo mergeWithStolis(StolisInfo sourceOne, PlanimeInfo sourceTwo) {
		InfoMerger<PlanimeInfo, StolisInfo> merger = new PlanimeMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanimeInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<PlanimeInfo> sourceTwos) {
		InfoMerger<PlanimeInfo, StolisInfo> merger = new PlanimeMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PlanimeInfo mergeWithWeekday(WeekdayInfo sourceOne, PlanimeInfo sourceTwo) {
		InfoMerger<PlanimeInfo, WeekdayInfo> merger = new PlanimeMergerWeekday();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanimeInfo> mergeWithWeekday(List<WeekdayInfo> sourceOnes, List<PlanimeInfo> sourceTwos) {
		InfoMerger<PlanimeInfo, WeekdayInfo> merger = new PlanimeMergerWeekday();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PlanimeInfo mergeWithPlanata(PlanataInfo sourceOne, PlanimeInfo sourceTwo) {
		InfoMerger<PlanimeInfo, PlanataInfo> merger = new PlanimeMergerPlanata();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanimeInfo> mergeWithPlanata(List<PlanataInfo> sourceOnes, List<PlanimeInfo> sourceTwos) {
		InfoMerger<PlanimeInfo, PlanataInfo> merger = new PlanimeMergerPlanata();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
