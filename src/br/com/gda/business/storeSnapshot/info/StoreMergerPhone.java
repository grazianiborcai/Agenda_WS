package br.com.gda.business.storeSnapshot.info;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StoreMergerPhone extends InfoMergerTemplate<StorapInfo, PhoneInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, PhoneInfo> getVisitorHook() {
		return new StoreVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
