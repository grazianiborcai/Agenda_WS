package br.com.mind5.business.employeeLeaveDate.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class EmplevateMergerUsername extends InfoMergerTemplate<EmplevateInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<EmplevateInfo, UsernameInfo> getVisitorHook() {
		return new EmplevateVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<EmplevateInfo> getUniquifierHook() {
		return new EmplevateUniquifier();
	}
}
