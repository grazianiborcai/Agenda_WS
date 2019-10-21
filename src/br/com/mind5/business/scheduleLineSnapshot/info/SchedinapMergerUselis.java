package br.com.mind5.business.scheduleLineSnapshot.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userList.info.UselisInfo;

final class SchedinapMergerUselis extends InfoMergerTemplate<SchedinapInfo, UselisInfo> {

	@Override protected InfoMergerVisitor<SchedinapInfo, UselisInfo> getVisitorHook() {
		return new SchedinapVisiMergeUselis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedinapInfo> getUniquifierHook() {
		return new SchedinapUniquifier();
	}
}
