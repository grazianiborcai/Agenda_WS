package br.com.mind5.business.orderItemSnapshot.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrdemrapMergerEmplis extends InfoMergerTemplate_<OrdemrapInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor_<OrdemrapInfo, EmplisInfo> getVisitorHook() {
		return new OrdemrapVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<OrdemrapInfo> getUniquifierHook() {
		return new OrdemrapUniquifier();
	}
}
