package br.com.mind5.security.userList.info;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UselisCopyEmpnap extends InfoCopierTemplate<UselisInfo, EmpnapInfo>{
	
	public UselisCopyEmpnap() {
		super();
	}
	
	
	
	@Override protected UselisInfo makeCopyHook(EmpnapInfo source) {
		UselisInfo result = new UselisInfo();
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
