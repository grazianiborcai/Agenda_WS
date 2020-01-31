package br.com.mind5.business.employeeSnapshot.info;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpnapMergerPersonap extends InfoMergerTemplate_<EmpnapInfo, PersonapInfo> {

	@Override protected InfoMergerVisitor_<EmpnapInfo, PersonapInfo> getVisitorHook() {
		return new EmpnapVisiMergePersonap();
	}
	
	
	
	@Override protected InfoUniquifier<EmpnapInfo> getUniquifierHook() {
		return new EmpnapUniquifier();
	}
}
