package br.com.mind5.security.userSearch.info;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UserarchCopyEmp extends InfoCopierTemplate<UserarchInfo, EmpInfo> {
	
	public UserarchCopyEmp() {
		super();
	}
	
	
	
	@Override protected UserarchInfo makeCopyHook(EmpInfo source) {
		UserarchInfo result = new UserarchInfo();
		
		result.codOwner = source.codOwner;
		result.codLanguage = source.codLanguage;
		result = setUsername(result, source);
		
		return result;
	}
	
	
	
	private UserarchInfo setUsername(UserarchInfo result, EmpInfo source) {
		if (source.personData == null)
			return result;
		
		if (source.personData.email == null)
			return result;
		
		result.username = source.personData.email;
		return result;
	}
}
