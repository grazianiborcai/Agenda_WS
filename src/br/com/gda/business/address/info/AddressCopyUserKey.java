package br.com.gda.business.address.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.security.user.info.UserInfo;

final class AddressCopyUserKey extends InfoCopierTemplate<AddressInfo, UserInfo>{
	
	public AddressCopyUserKey() {
		super();
	}
	
	
	
	@Override protected AddressInfo makeCopyHook(UserInfo source) {
		AddressInfo result = new AddressInfo();
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;
		result.lastChangedBy = source.lastChangedBy;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		return result;
	}
}
