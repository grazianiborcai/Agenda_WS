package br.com.mind5.business.orderSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.userList.info.UselisInfo;

final class OrdnapMergerUselis extends InfoMergerTemplate_<OrdnapInfo, UselisInfo> {

	@Override protected InfoMergerVisitor_<OrdnapInfo, UselisInfo> getVisitorHook() {
		return new OrdnapVisiMergeUselis();
	}
	
	
	
	@Override protected InfoUniquifier<OrdnapInfo> getUniquifierHook() {
		return new OrdnapUniquifier();
	}
}
