package br.com.mind5.business.employeeSnapshot.info;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpnapMergerPersonap extends InfoMergerTemplate<EmpnapInfo, PersonapInfo> {

	@Override protected InfoMergerVisitor<EmpnapInfo, PersonapInfo> getVisitorHook() {
		return new EmpnapVisiMergePersonap();
	}
	
	
	
	@Override protected InfoUniquifier<EmpnapInfo> getUniquifierHook() {
		return new EmpnapUniquifier();
	}
}
