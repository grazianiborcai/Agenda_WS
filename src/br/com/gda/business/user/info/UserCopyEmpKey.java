package br.com.gda.business.user.info;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.info.InfoCopierTemplate;

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
