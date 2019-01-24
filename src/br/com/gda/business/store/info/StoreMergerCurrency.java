package br.com.gda.business.store.info;

import java.util.List;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.info.InfoMerger;

final class StoreMergerCurrency extends InfoMerger<StoreInfo, CurrencyInfo, StoreInfo> {
	public StoreInfo merge(CurrencyInfo sourceOne, StoreInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new StoreVisiMergeCurrency());
	}
	
	
	
	public List<StoreInfo> merge(List<CurrencyInfo> sourceOnes, List<StoreInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new StoreVisiMergeCurrency());
	}
}
