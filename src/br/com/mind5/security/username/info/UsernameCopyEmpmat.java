package br.com.mind5.security.username.info;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UsernameCopyEmpmat extends InfoCopierTemplate<UsernameInfo, EmpmatInfo>{
	
	public UsernameCopyEmpmat() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(EmpmatInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		
		return result;
	}
}
