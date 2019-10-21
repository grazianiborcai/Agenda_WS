package br.com.mind5.security.username.info;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.info.InfoCopierTemplate;

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
