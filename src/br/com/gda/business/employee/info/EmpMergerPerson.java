package br.com.gda.business.employee.info;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class EmpMergerPerson extends InfoMergerTemplate<EmpInfo, PersonInfo> {

	@Override protected InfoMergerVisitor<EmpInfo, PersonInfo> getVisitorHook() {
		return new EmpVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
