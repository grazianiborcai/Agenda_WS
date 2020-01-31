package br.com.mind5.security.userAuthentication.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.userList.info.UselisInfo;

final class UauthMergerUselis extends InfoMergerTemplate_<UauthInfo, UselisInfo> {

	@Override protected InfoMergerVisitor_<UauthInfo, UselisInfo> getVisitorHook() {
		return new UauthVisiMergeUselis();
	}
	
	
	
	@Override protected InfoUniquifier<UauthInfo> getUniquifierHook() {
		return new UauthUniquifier();
	}
}
