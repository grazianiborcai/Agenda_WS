package br.com.mind5.business.employee.info;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpMergerPerson extends InfoMergerTemplate<EmpInfo, PersonInfo> {

	@Override protected InfoMergerVisitor<EmpInfo, PersonInfo> getVisitorHook() {
		return new EmpVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
