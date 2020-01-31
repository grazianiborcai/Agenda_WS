package br.com.mind5.business.employee.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpMergerToDelete extends InfoMergerTemplate_<EmpInfo, EmpInfo> {

	@Override protected InfoMergerVisitor_<EmpInfo, EmpInfo> getVisitorHook() {
		return new EmpVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
