package br.com.gda.business.employeeList.info;

import br.com.gda.business.personList.info.PersolisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmplisMergerPersolis extends InfoMergerTemplate<EmplisInfo, PersolisInfo> {

	@Override protected InfoMergerVisitorV2<EmplisInfo, PersolisInfo> getVisitorHook() {
		return new EmplisVisiMergePersolis();
	}
	
	
	
	@Override protected InfoUniquifier<EmplisInfo> getUniquifierHook() {
		return new EmplisUniquifier();
	}
}
