package br.com.gda.business.store.info;

import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMerger_;

final class StoreMergerPhone extends InfoMerger_<StoreInfo, PhoneInfo, StoreInfo> {
	public StoreInfo merge(PhoneInfo sourceOne, StoreInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new StoreVisiMergePhone());
	}
	
	
	
	public List<StoreInfo> merge(List<PhoneInfo> sourceOnes, List<StoreInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new StoreVisiMergePhone());
	}
}
