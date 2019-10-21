package br.com.mind5.business.employee.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpMergerToDelete extends InfoMergerTemplate<EmpInfo, EmpInfo> {

	@Override protected InfoMergerVisitor<EmpInfo, EmpInfo> getVisitorHook() {
		return new EmpVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
