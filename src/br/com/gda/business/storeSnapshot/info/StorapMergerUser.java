package br.com.gda.business.storeSnapshot.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.user.info.UserInfo;

final class StorapMergerUser extends InfoMergerTemplate<StorapInfo, UserInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, UserInfo> getVisitorHook() {
		return new StorapVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
