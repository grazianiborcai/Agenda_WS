package br.com.mind5.business.phone.info;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PhoneCopyEmpKey extends InfoCopierTemplate<PhoneInfo, EmpInfo> {
	
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
