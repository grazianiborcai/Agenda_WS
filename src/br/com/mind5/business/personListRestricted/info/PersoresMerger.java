package br.com.mind5.business.personListRestricted.info;


import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMerger;

public final class PersoresMerger {
	public static PersoresInfo mergeWithPersolis(PersolisInfo sourceOne, PersoresInfo sourceTwo) {
		InfoMerger<PersoresInfo, PersolisInfo> merger = new PersoresMergerPersolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PersoresInfo> mergeWithPersolis(List<PersolisInfo> sourceOnes, List<PersoresInfo> sourceTwos) {
		InfoMerger<PersoresInfo, PersolisInfo> merger = new PersoresMergerPersolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}