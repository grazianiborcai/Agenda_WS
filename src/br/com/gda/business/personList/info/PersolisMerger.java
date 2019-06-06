package br.com.gda.business.personList.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

public final class PersolisMerger {
	public static PersolisInfo mergeToSelect(PersolisInfo sourceOne, PersolisInfo sourceTwo) {
		InfoMerger<PersolisInfo, PersolisInfo> merger = new PersolisMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PersolisInfo> mergeToSelect(List<PersolisInfo> sourceOnes, List<PersolisInfo> sourceTwos) {
		InfoMerger<PersolisInfo, PersolisInfo> merger = new PersolisMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
