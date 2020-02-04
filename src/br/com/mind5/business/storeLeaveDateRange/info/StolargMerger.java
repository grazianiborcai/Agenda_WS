package br.com.mind5.business.storeLeaveDateRange.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class StolargMerger {
	public static StolargInfo mergeToSelect(StolargInfo sourceOne, StolargInfo sourceTwo) {
		InfoMerger_<StolargInfo, StolargInfo> merger = new StolargMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StolargInfo> mergeToSelect(List<StolargInfo> sourceOnes, List<StolargInfo> sourceTwos) {
		InfoMerger_<StolargInfo, StolargInfo> merger = new StolargMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
