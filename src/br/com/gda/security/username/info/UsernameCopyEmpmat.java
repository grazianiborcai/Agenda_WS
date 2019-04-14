package br.com.gda.security.username.info;

import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.info.InfoCopierTemplate;

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
