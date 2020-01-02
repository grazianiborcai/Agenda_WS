package br.com.mind5.business.planningTime.info;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;

public final class PlanimeMerger {
	public static PlanimeInfo mergeWithEmplis(EmplisInfo sourceOne, PlanimeInfo sourceTwo) {
		InfoMerger<PlanimeInfo, EmplisInfo> merger = new PlanimeMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanimeInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<PlanimeInfo> sourceTwos) {
		InfoMerger<PlanimeInfo, EmplisInfo> merger = new PlanimeMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PlanimeInfo mergeWithMatlis(MatlisInfo sourceOne, PlanimeInfo sourceTwo) {
		InfoMerger<PlanimeInfo, MatlisInfo> merger = new PlanimeMergerMatlis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanimeInfo> mergeWithMatlis(List<MatlisInfo> sourceOnes, List<PlanimeInfo> sourceTwos) {
		InfoMerger<PlanimeInfo, MatlisInfo> merger = new PlanimeMergerMatlis();		
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
