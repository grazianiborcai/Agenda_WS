package br.com.mind5.security.user.info;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.info.InfoCopierTemplate;

final class UserCopyCus extends InfoCopierTemplate<UserInfo, CusInfo> {
	
	public UserCopyCus() {
		super();
	}
	
	
	
	@Override protected UserInfo makeCopyHook(CusInfo source) {
		UserInfo result = new UserInfo();
		
		result.codOwner = source.codOwner;	
		result.codPerson = source.codPerson;	
		result.codUser = source.codUser;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		result.addresses = CloneUtil.cloneRecords(source.addresses, this.getClass());
		result.phones = CloneUtil.cloneRecords(source.phones, this.getClass());
		
		return result;
	}
}
