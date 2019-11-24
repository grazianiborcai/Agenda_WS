package br.com.mind5.business.employeeWorkTime.info;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpwotmMergerStowotarch extends InfoMergerTemplate<EmpwotmInfo, StowotarchInfo> {

	@Override protected InfoMergerVisitor<EmpwotmInfo, StowotarchInfo> getVisitorHook() {
		return new EmpwotmVisiMergeStowotarch();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwotmInfo> getUniquifierHook() {
		return new EmpwotmUniquifier();
	}
}
