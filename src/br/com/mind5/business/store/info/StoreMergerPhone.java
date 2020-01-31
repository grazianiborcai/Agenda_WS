package br.com.mind5.business.store.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StoreMergerPhone extends InfoMergerTemplate_<StoreInfo, PhoneInfo> {

	@Override protected InfoMergerVisitor_<StoreInfo, PhoneInfo> getVisitorHook() {
		return new StoreVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
