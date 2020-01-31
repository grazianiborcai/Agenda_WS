package br.com.mind5.business.employeeWorkTime.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpwotmMergerToDelete extends InfoMergerTemplate_<EmpwotmInfo, EmpwotmInfo> {

	@Override protected InfoMergerVisitor_<EmpwotmInfo, EmpwotmInfo> getVisitorHook() {
		return new EmpwotmVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwotmInfo> getUniquifierHook() {
		return new EmpwotmUniquifier();
	}
}
