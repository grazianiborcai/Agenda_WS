package br.com.gda.business.orderItemSnapshot.info;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrdemrapMergerEmplis extends InfoMergerTemplate<OrdemrapInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor<OrdemrapInfo, EmplisInfo> getVisitorHook() {
		return new OrdemrapVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<OrdemrapInfo> getUniquifierHook() {
		return new OrdemrapUniquifier();
	}
}
