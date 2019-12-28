package br.com.mind5.business.customerSnapshot.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userList.info.UselisInfo;

public final class CusnapMergerUselis extends InfoMergerTemplate<CusnapInfo, UselisInfo>{

	@Override protected InfoMergerVisitor<CusnapInfo, UselisInfo> getVisitorHook() {
		return new CusnapVisiMergeUselis();
	}
	
	
	
	@Override protected InfoUniquifier<CusnapInfo> getUniquifierHook() {
		return new CusnapUniquifier();
	}
}
