package br.com.mind5.business.customerSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.userList.info.UselisInfo;

public final class CusnapMergerUselis extends InfoMergerTemplate_<CusnapInfo, UselisInfo>{

	@Override protected InfoMergerVisitor_<CusnapInfo, UselisInfo> getVisitorHook() {
		return new CusnapVisiMergeUselis();
	}
	
	
	
	@Override protected InfoUniquifier<CusnapInfo> getUniquifierHook() {
		return new CusnapUniquifier();
	}
}
