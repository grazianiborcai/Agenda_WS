package br.com.mind5.business.personList.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class PersolisMerger {
	public static PersolisInfo mergeToSelect(PersolisInfo sourceOne, PersolisInfo sourceTwo) {
		InfoMerger_<PersolisInfo, PersolisInfo> merger = new PersolisMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PersolisInfo> mergeToSelect(List<PersolisInfo> sourceOnes, List<PersolisInfo> sourceTwos) {
		InfoMerger_<PersolisInfo, PersolisInfo> merger = new PersolisMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
