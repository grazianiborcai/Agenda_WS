package br.com.gda.business.planingData.info;

import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.info.InfoMergerOneToMany;

public final class PlanataMerger {	
	public static List<PlanataInfo> mergeWithMat(MatInfo sourceOne, PlanataInfo sourceTwo) {
		InfoMergerOneToMany<PlanataInfo, MatInfo> merger = new PlanataMergerMat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanataInfo> mergeWithMat(List<MatInfo> sourceOnes, List<PlanataInfo> sourceTwos) {
		InfoMergerOneToMany<PlanataInfo, MatInfo> merger = new PlanataMergerMat();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PlanataInfo mergeToSelect(PlanataInfo sourceOne, PlanataInfo sourceTwo) {
		InfoMerger<PlanataInfo, PlanataInfo> merger = new PlanataMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanataInfo> mergeToSelect(List<PlanataInfo> sourceOnes, List<PlanataInfo> sourceTwos) {
		InfoMerger<PlanataInfo, PlanataInfo> merger = new PlanataMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
