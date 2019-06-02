package br.com.gda.business.employeeSnapshot.info;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmpnapMergerPerson extends InfoMergerTemplate<EmpnapInfo, PersonInfo> {

	@Override protected InfoMergerVisitorV2<EmpnapInfo, PersonInfo> getVisitorHook() {
		return new EmpnapVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<EmpnapInfo> getUniquifierHook() {
		return new EmpnapUniquifier();
	}
}
