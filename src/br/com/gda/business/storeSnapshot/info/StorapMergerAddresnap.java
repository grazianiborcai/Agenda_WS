package br.com.gda.business.storeSnapshot.info;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StoreMergerAddress extends InfoMergerTemplate<StorapInfo, AddressInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, AddressInfo> getVisitorHook() {
		return new StoreVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
