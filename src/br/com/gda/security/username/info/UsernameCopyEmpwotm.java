package br.com.gda.security.username.info;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.info.InfoCopierTemplate;

final class UsernameCopyEmpwotm extends InfoCopierTemplate<UsernameInfo, EmpwotmInfo>{
	
	public UsernameCopyEmpwotm() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(EmpwotmInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
