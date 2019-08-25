package br.com.gda.business.orderSnapshot.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.security.userList.info.UselisInfo;
import br.com.gda.info.InfoUniquifier;

final class OrdnapMergerUselis extends InfoMergerTemplate<OrdnapInfo, UselisInfo> {

	@Override protected InfoMergerVisitor<OrdnapInfo, UselisInfo> getVisitorHook() {
		return new OrdnapVisiMergeUselis();
	}
	
	
	
	@Override protected InfoUniquifier<OrdnapInfo> getUniquifierHook() {
		return new OrdnapUniquifier();
	}
}
