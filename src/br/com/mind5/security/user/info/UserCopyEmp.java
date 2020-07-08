package br.com.mind5.security.user.info;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.info.InfoCopierTemplate;

final class UserCopyEmp extends InfoCopierTemplate<UserInfo, EmpInfo> {
	
	public UserCopyEmp() {
		super();
	}
	
	
	
	@Override protected UserInfo makeCopyHook(EmpInfo source) {
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
