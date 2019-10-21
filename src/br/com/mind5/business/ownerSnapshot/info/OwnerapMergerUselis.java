package br.com.mind5.business.ownerSnapshot.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userList.info.UselisInfo;

public final class OwnerapMergerUselis extends InfoMergerTemplate<OwnerapInfo, UselisInfo>{

	@Override protected InfoMergerVisitor<OwnerapInfo, UselisInfo> getVisitorHook() {
		return new OwnerapVisiMergeUselis();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerapInfo> getUniquifierHook() {
		return new OwnerapUniquifier();
	}
}
