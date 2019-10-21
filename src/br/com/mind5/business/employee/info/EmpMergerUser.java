package br.com.mind5.business.employee.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.user.info.UserInfo;

final class EmpMergerUser extends InfoMergerTemplate<EmpInfo, UserInfo> {

	@Override protected InfoMergerVisitor<EmpInfo, UserInfo> getVisitorHook() {
		return new EmpVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
