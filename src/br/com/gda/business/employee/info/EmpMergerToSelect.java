package br.com.gda.business.employee.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmpMergerToSelect extends InfoMergerTemplate<EmpInfo, EmpInfo> {

	@Override protected InfoMergerVisitorV2<EmpInfo, EmpInfo> getVisitorHook() {
		return new EmpVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
