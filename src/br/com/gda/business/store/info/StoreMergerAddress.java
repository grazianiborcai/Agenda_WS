package br.com.gda.business.store.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.info.InfoMerger_;

final class StoreMergerAddress extends InfoMerger_<StoreInfo, AddressInfo, StoreInfo> {
	public StoreInfo merge(AddressInfo sourceOne, StoreInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new StoreVisiMergeAddress());
	}
	
	
	
	public List<StoreInfo> merge(List<AddressInfo> sourceOnes, List<StoreInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new StoreVisiMergeAddress());
	}
}
