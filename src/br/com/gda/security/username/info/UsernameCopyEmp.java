package br.com.gda.security.username.info;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UsernameCopyEmp extends InfoCopierTemplate<UsernameInfo, EmpInfo>{
	
	public UsernameCopyEmp() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(EmpInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
