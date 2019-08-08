package br.com.gda.business.employeeSnapshot.info;

import br.com.gda.business.personSnapshot.info.PersonapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class EmpnapMergerPersonap extends InfoMergerTemplate<EmpnapInfo, PersonapInfo> {

	@Override protected InfoMergerVisitor<EmpnapInfo, PersonapInfo> getVisitorHook() {
		return new EmpnapVisiMergePersonap();
	}
	
	
	
	@Override protected InfoUniquifier<EmpnapInfo> getUniquifierHook() {
		return new EmpnapUniquifier();
	}
}
