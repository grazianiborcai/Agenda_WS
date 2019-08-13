package br.com.gda.business.storeSnapshot.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.userSnapshot.info.UserapInfo;

final class StorapMergerUserap extends InfoMergerTemplate<StorapInfo, UserapInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, UserapInfo> getVisitorHook() {
		return new StorapVisiMergeUserap();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
