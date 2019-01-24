package br.com.gda.business.store.info;

import java.util.List;

import br.com.gda.info.InfoKeeper;

final class StoreKeeperStore extends InfoKeeper<StoreInfo, StoreInfo> {
	public StoreInfo keep(StoreInfo sourceOne, StoreInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new StoreVisiKeepStore());
	}
	
	
	
	public List<StoreInfo> keep(List<StoreInfo> sourceOnes, List<StoreInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new StoreVisiKeepStore());
	}
}
