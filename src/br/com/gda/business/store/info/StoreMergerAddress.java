package br.com.gda.business.store.info;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class StoreMergerAddress extends InfoMergerTemplate<StoreInfo, AddressInfo> {

	@Override protected InfoMergerVisitorV2<StoreInfo, AddressInfo> getVisitorHook() {
		return new StoreVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
