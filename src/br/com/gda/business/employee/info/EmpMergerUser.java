package br.com.gda.business.employee.info;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmpMergerUser extends InfoMergerTemplate<EmpInfo, UserInfo> {

	@Override protected InfoMergerVisitorV2<EmpInfo, UserInfo> getVisitorHook() {
		return new EmpVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
