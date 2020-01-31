package br.com.mind5.business.employeeWorkTime.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class EmpwotmMergerUsername extends InfoMergerTemplate_<EmpwotmInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<EmpwotmInfo, UsernameInfo> getVisitorHook() {
		return new EmpwotmVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwotmInfo> getUniquifierHook() {
		return new EmpwotmUniquifier();
	}
}
