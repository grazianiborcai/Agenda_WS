package br.com.gda.security.username.info;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UsernameCopyEmplevate extends InfoCopierTemplate<UsernameInfo, EmplevateInfo>{
	
	public UsernameCopyEmplevate() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(EmplevateInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
