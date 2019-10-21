package br.com.mind5.business.employeeList.info;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmplisMergerPersolis extends InfoMergerTemplate<EmplisInfo, PersolisInfo> {

	@Override protected InfoMergerVisitor<EmplisInfo, PersolisInfo> getVisitorHook() {
		return new EmplisVisiMergePersolis();
	}
	
	
	
	@Override protected InfoUniquifier<EmplisInfo> getUniquifierHook() {
		return new EmplisUniquifier();
	}
}
