package br.com.gda.business.employeeLeaveDate.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class EmplevateMergerUsername extends InfoMergerTemplate<EmplevateInfo, UsernameInfo> {

	@Override protected InfoMergerVisitorV2<EmplevateInfo, UsernameInfo> getVisitorHook() {
		return new EmplevateVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<EmplevateInfo> getUniquifierHook() {
		return new EmplevateUniquifier();
	}
}
