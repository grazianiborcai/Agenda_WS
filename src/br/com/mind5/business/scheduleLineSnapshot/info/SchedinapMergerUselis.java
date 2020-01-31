package br.com.mind5.business.scheduleLineSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.userList.info.UselisInfo;

final class SchedinapMergerUselis extends InfoMergerTemplate_<SchedinapInfo, UselisInfo> {

	@Override protected InfoMergerVisitor_<SchedinapInfo, UselisInfo> getVisitorHook() {
		return new SchedinapVisiMergeUselis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedinapInfo> getUniquifierHook() {
		return new SchedinapUniquifier();
	}
}
