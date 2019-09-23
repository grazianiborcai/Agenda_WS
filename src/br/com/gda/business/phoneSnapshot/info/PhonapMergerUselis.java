package br.com.gda.business.phoneSnapshot.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.userList.info.UselisInfo;

public final class PhonapMergerUselis extends InfoMergerTemplate<PhonapInfo, UselisInfo>{

	@Override protected InfoMergerVisitor<PhonapInfo, UselisInfo> getVisitorHook() {
		return new PhonapVisiMergeUselis();
	}
	
	
	
	@Override protected InfoUniquifier<PhonapInfo> getUniquifierHook() {
		return new PhonapUniquifier();
	}
}
