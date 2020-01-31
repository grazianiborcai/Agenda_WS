package br.com.mind5.business.employee.info;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpMergerPerson extends InfoMergerTemplate_<EmpInfo, PersonInfo> {

	@Override protected InfoMergerVisitor_<EmpInfo, PersonInfo> getVisitorHook() {
		return new EmpVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<EmpInfo> getUniquifierHook() {
		return new EmpUniquifier();
	}
}
