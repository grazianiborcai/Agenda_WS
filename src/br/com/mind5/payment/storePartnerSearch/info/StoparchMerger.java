package br.com.mind5.payment.storePartnerSearch.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class StoparchMerger {	
	public static StoparchInfo mergeToSelect(StoparchInfo sourceOne, StoparchInfo sourceTwo) {
		InfoMerger_<StoparchInfo, StoparchInfo> merger = new StoparchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoparchInfo> mergeToSelect(List<StoparchInfo> sourceOnes, List<StoparchInfo> sourceTwos) {
		InfoMerger_<StoparchInfo, StoparchInfo> merger = new StoparchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}			
}
