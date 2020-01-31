package br.com.mind5.business.employee.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class EmpMergerUsername extends InfoMergerTemplate_<EmpInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<EmpInfo, UsernameInfo> getVisitorHook() {
		return new EmpVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
