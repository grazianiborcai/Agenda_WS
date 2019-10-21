package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.user.info.UserInfo;

final class StorapMergerUser extends InfoMergerTemplate<StorapInfo, UserInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, UserInfo> getVisitorHook() {
		return new StorapVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
