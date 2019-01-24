package br.com.gda.business.store.info;

import java.util.List;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.info.InfoMerger;

final class StoreMergerTimezone extends InfoMerger<StoreInfo, TimezoneInfo, StoreInfo> {
	public StoreInfo merge(TimezoneInfo sourceOne, StoreInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new StoreVisiMergeTimezone());
	}
	
	
	
	public List<StoreInfo> merge(List<TimezoneInfo> sourceOnes, List<StoreInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new StoreVisiMergeTimezone());
	}
}
