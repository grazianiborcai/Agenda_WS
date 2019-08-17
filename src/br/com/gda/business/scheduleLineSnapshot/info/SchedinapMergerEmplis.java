package br.com.gda.business.scheduleLineSnapshot.info;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedinapMergerEmplis extends InfoMergerTemplate<SchedinapInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor<SchedinapInfo, EmplisInfo> getVisitorHook() {
		return new SchedinapVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedinapInfo> getUniquifierHook() {
		return new SchedinapUniquifier();
	}
}
