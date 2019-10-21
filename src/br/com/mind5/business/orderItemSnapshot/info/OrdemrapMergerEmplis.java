package br.com.mind5.business.orderItemSnapshot.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrdemrapMergerEmplis extends InfoMergerTemplate<OrdemrapInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor<OrdemrapInfo, EmplisInfo> getVisitorHook() {
		return new OrdemrapVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<OrdemrapInfo> getUniquifierHook() {
		return new OrdemrapUniquifier();
	}
}
