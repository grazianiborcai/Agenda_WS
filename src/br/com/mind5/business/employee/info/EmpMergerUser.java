package br.com.mind5.business.employee.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.user.info.UserInfo;

final class EmpMergerUser extends InfoMergerTemplate_<EmpInfo, UserInfo> {

	@Override protected InfoMergerVisitor_<EmpInfo, UserInfo> getVisitorHook() {
		return new EmpVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
