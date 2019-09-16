package br.com.gda.business.ownerSnapshot.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.userList.info.UselisInfo;

public final class OwnerapMergerUselis extends InfoMergerTemplate<OwnerapInfo, UselisInfo>{

	@Override protected InfoMergerVisitor<OwnerapInfo, UselisInfo> getVisitorHook() {
		return new OwnerapVisiMergeUselis();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerapInfo> getUniquifierHook() {
		return new OwnerapUniquifier();
	}
}
