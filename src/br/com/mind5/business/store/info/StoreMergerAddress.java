package br.com.mind5.business.store.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StoreMergerAddress extends InfoMergerTemplate_<StoreInfo, AddressInfo> {

	@Override protected InfoMergerVisitor_<StoreInfo, AddressInfo> getVisitorHook() {
		return new StoreVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
