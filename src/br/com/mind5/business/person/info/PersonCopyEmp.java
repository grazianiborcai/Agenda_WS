package br.com.mind5.business.person.info;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PersonCopyEmp extends InfoCopierTemplate<PersonInfo, EmpInfo>{
	
	public PersonCopyEmp() {
		super();
	}
	
	
	
	@Override protected PersonInfo makeCopyHook(EmpInfo source) {
		PersonInfo result = PersonInfo.copyFrom(source.personData);
		return result;
	}
}
