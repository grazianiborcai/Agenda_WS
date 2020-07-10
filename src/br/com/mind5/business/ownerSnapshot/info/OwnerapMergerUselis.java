package br.com.mind5.business.ownerSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.userList.info.UselisInfo;

public final class OwnerapMergerUselis extends InfoMergerTemplate_<OwnerapInfo, UselisInfo> {

	@Override protected InfoMergerVisitor_<OwnerapInfo, UselisInfo> getVisitorHook() {
		return new OwnerapVisiMergeUselis();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerapInfo> getUniquifierHook() {
		return new OwnerapUniquifier();
	}
}
