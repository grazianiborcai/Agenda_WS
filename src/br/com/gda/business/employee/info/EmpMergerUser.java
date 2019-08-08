package br.com.gda.business.employee.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.user.info.UserInfo;

final class EmpMergerUser extends InfoMergerTemplate<EmpInfo, UserInfo> {

	@Override protected InfoMergerVisitor<EmpInfo, UserInfo> getVisitorHook() {
		return new EmpVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
