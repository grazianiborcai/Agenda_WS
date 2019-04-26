package br.com.gda.business.feeStore.info;

import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoMerger_;

final class FeeStoreMergerStore extends InfoMerger_<FeeStoreInfo, StoreInfo, FeeStoreInfo> {
	public FeeStoreInfo merge(StoreInfo sourceOne, FeeStoreInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new FeeStoreVisitorStore());
	}
	
	
	
	public List<FeeStoreInfo> merge(List<StoreInfo> sourceOnes, List<FeeStoreInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new FeeStoreVisitorStore());
	}
}
