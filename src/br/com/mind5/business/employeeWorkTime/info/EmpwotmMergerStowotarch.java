package br.com.mind5.business.employeeWorkTime.info;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpwotmMergerStowotarch extends InfoMergerTemplate_<EmpwotmInfo, StowotarchInfo> {

	@Override protected InfoMergerVisitor_<EmpwotmInfo, StowotarchInfo> getVisitorHook() {
		return new EmpwotmVisiMergeStowotarch();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwotmInfo> getUniquifierHook() {
		return new EmpwotmUniquifier();
	}
}
