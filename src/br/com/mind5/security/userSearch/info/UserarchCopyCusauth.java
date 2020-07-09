package br.com.mind5.security.userSearch.info;

import br.com.mind5.authorization.customerAuthorization.info.CusauthInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UserarchCopyCusauth extends InfoCopierTemplate<UserarchInfo, CusauthInfo> {
	
	public UserarchCopyCusauth() {
		super();
	}
	
	
	
	@Override protected UserarchInfo makeCopyHook(CusauthInfo source) {
		UserarchInfo result = new UserarchInfo();
		
		result.codOwner = source.codOwner;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
