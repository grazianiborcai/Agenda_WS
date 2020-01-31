package br.com.mind5.business.phoneSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.userList.info.UselisInfo;

public final class PhonapMergerUselis extends InfoMergerTemplate_<PhonapInfo, UselisInfo>{

	@Override protected InfoMergerVisitor_<PhonapInfo, UselisInfo> getVisitorHook() {
		return new PhonapVisiMergeUselis();
	}
	
	
	
	@Override protected InfoUniquifier<PhonapInfo> getUniquifierHook() {
		return new PhonapUniquifier();
	}
}
