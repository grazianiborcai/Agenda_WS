package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.user.info.UserInfo;

final class StorapMergerUser extends InfoMergerTemplate_<StorapInfo, UserInfo> {

	@Override protected InfoMergerVisitor_<StorapInfo, UserInfo> getVisitorHook() {
		return new StorapVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
