package br.com.mind5.business.scheduleLineSnapshot.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedinapMergerEmplis extends InfoMergerTemplate<SchedinapInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor<SchedinapInfo, EmplisInfo> getVisitorHook() {
		return new SchedinapVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedinapInfo> getUniquifierHook() {
		return new SchedinapUniquifier();
	}
}
