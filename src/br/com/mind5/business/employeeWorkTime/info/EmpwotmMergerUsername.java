package br.com.mind5.business.employeeWorkTime.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class EmpwotmMergerUsername extends InfoMergerTemplate<EmpwotmInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<EmpwotmInfo, UsernameInfo> getVisitorHook() {
		return new EmpwotmVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwotmInfo> getUniquifierHook() {
		return new EmpwotmUniquifier();
	}
}
