package br.com.mind5.security.userSearch.info;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UserarchCopyCus extends InfoCopierTemplate<UserarchInfo, CusInfo> {
	
	public UserarchCopyCus() {
		super();
	}
	
	
	
	@Override protected UserarchInfo makeCopyHook(CusInfo source) {
		UserarchInfo result = new UserarchInfo();
		
		result.codOwner = source.codOwner;
		result.codLanguage = source.codLanguage;
		result = setUsername(result, source);
		
		return result;
	}
	
	
	
	private UserarchInfo setUsername(UserarchInfo result, CusInfo source) {
		if (source.personData == null)
			return result;
		
		if (source.personData.email == null)
			return result;
		
		result.username = source.personData.email;
		return result;
	}
}
