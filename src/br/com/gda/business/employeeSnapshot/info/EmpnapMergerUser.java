package br.com.gda.business.employeeSnapshot.info;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmpnapMergerUser extends InfoMergerTemplate<EmpnapInfo, UserInfo> {

	@Override protected InfoMergerVisitorV2<EmpnapInfo, UserInfo> getVisitorHook() {
		return new EmpnapVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<EmpnapInfo> getUniquifierHook() {
		return new EmpnapUniquifier();
	}
}
