package br.com.mind5.business.scheduleLineSnapshot.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedinapMergerEmplis extends InfoMergerTemplate_<SchedinapInfo, EmplisInfo> {

	@Override protected InfoMergerVisitor_<SchedinapInfo, EmplisInfo> getVisitorHook() {
		return new SchedinapVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedinapInfo> getUniquifierHook() {
		return new SchedinapUniquifier();
	}
}
