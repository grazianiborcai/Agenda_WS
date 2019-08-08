package br.com.gda.security.userAuthentication.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.user.info.UserInfo;

final class UauthMergerUser extends InfoMergerTemplate<UauthInfo, UserInfo> {

	@Override protected InfoMergerVisitorV2<UauthInfo, UserInfo> getVisitorHook() {
		return new UauthVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<UauthInfo> getUniquifierHook() {
		return new UauthUniquifier();
	}
}
