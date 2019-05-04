package br.com.gda.business.planingData.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

public final class PlanataMerger {	
	public static PlanataInfo mergeToSelect(PlanataInfo sourceOne, PlanataInfo sourceTwo) {
		InfoMerger<PlanataInfo, PlanataInfo> merger = new PlanataMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanataInfo> mergeToSelect(List<PlanataInfo> sourceOnes, List<PlanataInfo> sourceTwos) {
		InfoMerger<PlanataInfo, PlanataInfo> merger = new PlanataMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
