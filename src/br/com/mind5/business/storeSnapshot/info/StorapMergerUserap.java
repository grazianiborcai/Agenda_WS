package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

final class StorapMergerUserap extends InfoMergerTemplate_<StorapInfo, UserapInfo> {

	@Override protected InfoMergerVisitor_<StorapInfo, UserapInfo> getVisitorHook() {
		return new StorapVisiMergeUserap();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
