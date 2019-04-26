package br.com.gda.business.store.info;

import java.util.List;

import br.com.gda.info.InfoMerger_;

final class StoreMergerToDelete extends InfoMerger_<StoreInfo, StoreInfo, StoreInfo> {
	public StoreInfo merge(StoreInfo sourceOne, StoreInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new StoreVisiMergeToDelete());
	}
	
	
	
	public List<StoreInfo> merge(List<StoreInfo> sourceOnes, List<StoreInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new StoreVisiMergeToDelete());
	}
}
