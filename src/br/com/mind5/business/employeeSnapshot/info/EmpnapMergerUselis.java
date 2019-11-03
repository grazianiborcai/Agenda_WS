package br.com.mind5.business.employeeSnapshot.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userList.info.UselisInfo;

final class EmpnapMergerUselis extends InfoMergerTemplate<EmpnapInfo, UselisInfo> {

	@Override protected InfoMergerVisitor<EmpnapInfo, UselisInfo> getVisitorHook() {
		return new EmpnapVisiMergeUselis();
	}
	
	
	
	@Override protected InfoUniquifier<EmpnapInfo> getUniquifierHook() {
		return new EmpnapUniquifier();
	}
}
