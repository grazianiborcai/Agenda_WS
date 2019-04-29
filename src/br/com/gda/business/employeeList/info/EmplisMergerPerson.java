package br.com.gda.business.employeeList.info;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmplisMergerPerson extends InfoMergerTemplate<EmplisInfo, PersonInfo> {

	@Override protected InfoMergerVisitorV2<EmplisInfo, PersonInfo> getVisitorHook() {
		return new EmplisVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<EmplisInfo> getUniquifierHook() {
		return new EmplisUniquifier();
	}
}
