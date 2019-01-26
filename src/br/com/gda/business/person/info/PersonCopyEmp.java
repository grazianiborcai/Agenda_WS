package br.com.gda.business.person.info;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.info.InfoCopierTemplate;

final class PersonCopyEmp extends InfoCopierTemplate<PersonInfo, EmpInfo>{
	
	public PersonCopyEmp() {
		super();
	}
	
	
	
	@Override protected PersonInfo makeCopyHook(EmpInfo source) {
		PersonInfo result = PersonInfo.copyFrom(source.personData);
		return result;
	}
}
