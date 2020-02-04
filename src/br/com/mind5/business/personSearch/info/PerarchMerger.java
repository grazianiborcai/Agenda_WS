package br.com.mind5.business.personSearch.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class PerarchMerger {
	public static PerarchInfo mergeToSelect(PerarchInfo sourceOne, PerarchInfo sourceTwo) {
		InfoMerger_<PerarchInfo, PerarchInfo> merger = new PerarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PerarchInfo> mergeToSelect(List<PerarchInfo> sourceOnes, List<PerarchInfo> sourceTwos) {
		InfoMerger_<PerarchInfo, PerarchInfo> merger = new PerarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
