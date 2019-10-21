package br.com.mind5.business.employee.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class EmpMergerUsername extends InfoMergerTemplate<EmpInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<EmpInfo, UsernameInfo> getVisitorHook() {
		return new EmpVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
