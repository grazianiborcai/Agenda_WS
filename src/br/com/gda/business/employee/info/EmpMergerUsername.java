package br.com.gda.business.employee.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class EmpMergerUsername extends InfoMergerTemplate<EmpInfo, UsernameInfo> {

	@Override protected InfoMergerVisitorV2<EmpInfo, UsernameInfo> getVisitorHook() {
		return new EmpVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
