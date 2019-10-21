package br.com.mind5.business.phoneSnapshot.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userList.info.UselisInfo;

public final class PhonapMergerUselis extends InfoMergerTemplate<PhonapInfo, UselisInfo>{

	@Override protected InfoMergerVisitor<PhonapInfo, UselisInfo> getVisitorHook() {
		return new PhonapVisiMergeUselis();
	}
	
	
	
	@Override protected InfoUniquifier<PhonapInfo> getUniquifierHook() {
		return new PhonapUniquifier();
	}
}
