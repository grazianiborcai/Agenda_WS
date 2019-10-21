package br.com.mind5.business.store.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StoreMergerAddress extends InfoMergerTemplate<StoreInfo, AddressInfo> {

	@Override protected InfoMergerVisitor<StoreInfo, AddressInfo> getVisitorHook() {
		return new StoreVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
