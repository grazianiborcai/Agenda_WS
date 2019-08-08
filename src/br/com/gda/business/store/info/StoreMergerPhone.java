package br.com.gda.business.store.info;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StoreMergerPhone extends InfoMergerTemplate<StoreInfo, PhoneInfo> {

	@Override protected InfoMergerVisitor<StoreInfo, PhoneInfo> getVisitorHook() {
		return new StoreVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
