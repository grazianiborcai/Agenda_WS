package br.com.gda.business.employee.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class EmpMergerToDelete extends InfoMergerTemplate<EmpInfo, EmpInfo> {

	@Override protected InfoMergerVisitor<EmpInfo, EmpInfo> getVisitorHook() {
		return new EmpVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
