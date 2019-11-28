package br.com.mind5.business.employeeList.info;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmplisMergerPerarch extends InfoMergerTemplate<EmplisInfo, PerarchInfo> {

	@Override protected InfoMergerVisitor<EmplisInfo, PerarchInfo> getVisitorHook() {
		return new EmplisVisiMergePerarch();
	}
	
	
	
	@Override protected InfoUniquifier<EmplisInfo> getUniquifierHook() {
		return new EmplisUniquifier();
	}
}
