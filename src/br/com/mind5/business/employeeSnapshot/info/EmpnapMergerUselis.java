package br.com.mind5.business.employeeSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.userList.info.UselisInfo;

final class EmpnapMergerUselis extends InfoMergerTemplate_<EmpnapInfo, UselisInfo> {

	@Override protected InfoMergerVisitor_<EmpnapInfo, UselisInfo> getVisitorHook() {
		return new EmpnapVisiMergeUselis();
	}
	
	
	
	@Override protected InfoUniquifier<EmpnapInfo> getUniquifierHook() {
		return new EmpnapUniquifier();
	}
}
