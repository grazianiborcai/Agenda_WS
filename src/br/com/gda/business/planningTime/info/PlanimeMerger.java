package br.com.gda.business.planningTime.info;

import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoMerger;

public final class PlanimeMerger {
	public static PlanimeInfo mergeWithEmp(EmpInfo sourceOne, PlanimeInfo sourceTwo) {
		InfoMerger<PlanimeInfo, EmpInfo> merger = new PlanimeMergerEmp();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanimeInfo> mergeWithEmp(List<EmpInfo> sourceOnes, List<PlanimeInfo> sourceTwos) {
		InfoMerger<PlanimeInfo, EmpInfo> merger = new PlanimeMergerEmp();		
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
	
	
	
	public static PlanimeInfo mergeWithStore(StoreInfo sourceOne, PlanimeInfo sourceTwo) {
		InfoMerger<PlanimeInfo, StoreInfo> merger = new PlanimeMergerStore();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanimeInfo> mergeWithStore(List<StoreInfo> sourceOnes, List<PlanimeInfo> sourceTwos) {
		InfoMerger<PlanimeInfo, StoreInfo> merger = new PlanimeMergerStore();		
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
