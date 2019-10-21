package br.com.mind5.business.store.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StoreMergerPhone extends InfoMergerTemplate<StoreInfo, PhoneInfo> {

	@Override protected InfoMergerVisitor<StoreInfo, PhoneInfo> getVisitorHook() {
		return new StoreVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
