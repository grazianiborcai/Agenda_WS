package br.com.gda.business.storeLeaveDate.info;

import java.util.List;

import br.com.gda.business.planningTime.info.PlanDataInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class StolevateMerger {
	public static StolevateInfo mergeWithPlan(PlanDataInfo sourceOne, StolevateInfo sourceTwo) {
		InfoMerger<StolevateInfo, PlanDataInfo> merger = new StolevateMergerPlan();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StolevateInfo> mergeWithPlan(List<PlanDataInfo> sourceOnes, List<StolevateInfo> sourceTwos) {
		InfoMerger<StolevateInfo, PlanDataInfo> merger = new StolevateMergerPlan();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StolevateInfo mergeWithUsername(UsernameInfo sourceOne, StolevateInfo sourceTwo) {
		InfoMerger<StolevateInfo, UsernameInfo> merger = new StolevateMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StolevateInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<StolevateInfo> sourceTwos) {
		InfoMerger<StolevateInfo, UsernameInfo> merger = new StolevateMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StolevateInfo mergeToSelect(StolevateInfo sourceOne, StolevateInfo sourceTwo) {
		InfoMerger<StolevateInfo, StolevateInfo> merger = new StolevateMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StolevateInfo> mergeToSelect(List<StolevateInfo> sourceOnes, List<StolevateInfo> sourceTwos) {
		InfoMerger<StolevateInfo, StolevateInfo> merger = new StolevateMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StolevateInfo mergeToDeleteSelect(StolevateInfo sourceOne, StolevateInfo sourceTwo) {
		InfoMerger<StolevateInfo, StolevateInfo> merger = new StolevateMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StolevateInfo> mergeToDelete(List<StolevateInfo> sourceOnes, List<StolevateInfo> sourceTwos) {
		InfoMerger<StolevateInfo, StolevateInfo> merger = new StolevateMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
