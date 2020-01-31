package br.com.mind5.business.employeeList.info;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmplisMergerPerarch extends InfoMergerTemplate_<EmplisInfo, PerarchInfo> {

	@Override protected InfoMergerVisitor_<EmplisInfo, PerarchInfo> getVisitorHook() {
		return new EmplisVisiMergePerarch();
	}
	
	
	
	@Override protected InfoUniquifier<EmplisInfo> getUniquifierHook() {
		return new EmplisUniquifier();
	}
}
