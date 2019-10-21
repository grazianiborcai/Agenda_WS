package br.com.mind5.business.orderSnapshot.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userList.info.UselisInfo;

final class OrdnapMergerUselis extends InfoMergerTemplate<OrdnapInfo, UselisInfo> {

	@Override protected InfoMergerVisitor<OrdnapInfo, UselisInfo> getVisitorHook() {
		return new OrdnapVisiMergeUselis();
	}
	
	
	
	@Override protected InfoUniquifier<OrdnapInfo> getUniquifierHook() {
		return new OrdnapUniquifier();
	}
}
