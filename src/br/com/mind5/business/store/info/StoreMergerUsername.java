package br.com.mind5.business.store.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class StoreMergerUsername extends InfoMergerTemplate<StoreInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<StoreInfo, UsernameInfo> getVisitorHook() {
		return new StoreVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
