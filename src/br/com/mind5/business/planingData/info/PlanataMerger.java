package br.com.mind5.business.planingData.info;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerOneToMany;

public final class PlanataMerger {	
	public static List<PlanataInfo> mergeWithMatlis(MatlisInfo sourceOne, PlanataInfo sourceTwo) {
		InfoMergerOneToMany<PlanataInfo, MatlisInfo> merger = new PlanataMergerMatlis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanataInfo> mergeWithMatlis(List<MatlisInfo> sourceOnes, List<PlanataInfo> sourceTwos) {
		InfoMergerOneToMany<PlanataInfo, MatlisInfo> merger = new PlanataMergerMatlis();		
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
