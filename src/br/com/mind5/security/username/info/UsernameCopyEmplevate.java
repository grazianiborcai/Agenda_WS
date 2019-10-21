package br.com.mind5.security.username.info;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.info.InfoCopierTemplate;

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
