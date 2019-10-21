package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

final class StorapMergerUserap extends InfoMergerTemplate<StorapInfo, UserapInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, UserapInfo> getVisitorHook() {
		return new StorapVisiMergeUserap();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
