package br.com.mind5.business.employee.info;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpMergerPerarch extends InfoMergerTemplate<EmpInfo, PerarchInfo> {

	@Override protected InfoMergerVisitor<EmpInfo, PerarchInfo> getVisitorHook() {
		return new EmpVisiMergePerarch();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
