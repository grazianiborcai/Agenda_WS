package br.com.mind5.business.employeeSearch.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.user.info.UserInfo;

final class EmparchCopyUserEmail extends InfoCopierTemplate<EmparchInfo, UserInfo> {
	
	public EmparchCopyUserEmail() {
		super();
	}
	
	
	
	@Override protected EmparchInfo makeCopyHook(UserInfo source) {
		EmparchInfo result = new EmparchInfo();
		
		if (source.personData == null)
			return result;
		
		result.codOwner = source.codOwner;
		result.email = source.personData.email;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
