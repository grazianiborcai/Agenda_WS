package br.com.mind5.business.employee.info;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpMergerPerarch extends InfoMergerTemplate_<EmpInfo, PerarchInfo> {

	@Override protected InfoMergerVisitor_<EmpInfo, PerarchInfo> getVisitorHook() {
		return new EmpVisiMergePerarch();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
