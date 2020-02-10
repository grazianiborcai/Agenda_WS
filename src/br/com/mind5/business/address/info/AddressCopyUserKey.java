package br.com.mind5.business.address.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.user.info.UserInfo;

final class AddressCopyUserKey extends InfoCopierTemplate<AddressInfo, UserInfo>{
	
	public AddressCopyUserKey() {
		super();
	}
	
	
	
	@Override protected AddressInfo makeCopyHook(UserInfo source) {
		AddressInfo result = new AddressInfo();
		
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
