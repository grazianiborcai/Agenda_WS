package br.com.mind5.security.userSearch.info;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UserarchCopyCusauth extends InfoCopierTemplate<UserarchInfo, SytotauhInfo> {
	
	public UserarchCopyCusauth() {
		super();
	}
	
	
	
	@Override protected UserarchInfo makeCopyHook(SytotauhInfo source) {
		UserarchInfo result = new UserarchInfo();
		
		result.codOwner = source.codOwner;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
