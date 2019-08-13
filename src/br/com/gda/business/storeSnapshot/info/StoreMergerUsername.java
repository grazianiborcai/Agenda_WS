package br.com.gda.business.storeSnapshot.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class StoreMergerUsername extends InfoMergerTemplate<StorapInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, UsernameInfo> getVisitorHook() {
		return new StoreVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
