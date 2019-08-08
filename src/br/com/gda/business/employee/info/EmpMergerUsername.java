package br.com.gda.business.employee.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class EmpMergerUsername extends InfoMergerTemplate<EmpInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<EmpInfo, UsernameInfo> getVisitorHook() {
		return new EmpVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
