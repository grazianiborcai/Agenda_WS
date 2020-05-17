package br.com.mind5.security.username.info;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UsernameCopyEmp extends InfoCopierTemplate<UsernameInfo, EmpInfo> {
	
	public UsernameCopyEmp() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(EmpInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
