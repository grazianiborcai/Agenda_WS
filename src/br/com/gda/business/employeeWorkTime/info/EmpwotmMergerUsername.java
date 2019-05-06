package br.com.gda.business.employeeWorkTime.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class EmpwotmMergerUsername extends InfoMergerTemplate<EmpwotmInfo, UsernameInfo> {

	@Override protected InfoMergerVisitorV2<EmpwotmInfo, UsernameInfo> getVisitorHook() {
		return new EmpwotmVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwotmInfo> getUniquifierHook() {
		return new EmpwotmUniquifier();
	}
}
