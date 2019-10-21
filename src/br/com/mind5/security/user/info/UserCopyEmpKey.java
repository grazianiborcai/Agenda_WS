package br.com.mind5.security.user.info;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UserCopyEmpKey extends InfoCopierTemplate<UserInfo, EmpInfo>{
	
	public UserCopyEmpKey() {
		super();
	}
	
	
	
	@Override protected UserInfo makeCopyHook(EmpInfo source) {
		UserInfo result = new UserInfo();
		
		result.codOwner = source.codOwner;	
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
