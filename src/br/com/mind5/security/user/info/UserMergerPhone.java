package br.com.mind5.security.user.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class UserMergerPhone extends InfoMergerTemplate<UserInfo, PhoneInfo> {

	@Override protected InfoMergerVisitor<UserInfo, PhoneInfo> getVisitorHook() {
		return new UserVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
