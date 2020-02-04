package br.com.mind5.business.employeeLeaveDateSearch.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class EmplarchMerger {
	public static EmplarchInfo mergeToSelect(EmplarchInfo sourceOne, EmplarchInfo sourceTwo) {
		InfoMerger_<EmplarchInfo, EmplarchInfo> merger = new EmplarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmplarchInfo> mergeToSelect(List<EmplarchInfo> sourceOnes, List<EmplarchInfo> sourceTwos) {
		InfoMerger_<EmplarchInfo, EmplarchInfo> merger = new EmplarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
