package br.com.gda.business.phone.info;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.info.InfoCopierTemplate;

final class PhoneCopyEmpKey extends InfoCopierTemplate<PhoneInfo, EmpInfo>{
	
	public PhoneCopyEmpKey() {
		super();
	}
	
	
	
	@Override protected PhoneInfo makeCopyHook(EmpInfo source) {
		PhoneInfo result = new PhoneInfo();
		result.codOwner = source.codOwner;
		result.codEmployee = source.codEmployee;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		return result;
	}
}
