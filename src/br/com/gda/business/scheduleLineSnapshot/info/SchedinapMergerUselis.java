package br.com.gda.business.scheduleLineSnapshot.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.userList.info.UselisInfo;

final class SchedinapMergerUselis extends InfoMergerTemplate<SchedinapInfo, UselisInfo> {

	@Override protected InfoMergerVisitor<SchedinapInfo, UselisInfo> getVisitorHook() {
		return new SchedinapVisiMergeUselis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedinapInfo> getUniquifierHook() {
		return new SchedinapUniquifier();
	}
}
