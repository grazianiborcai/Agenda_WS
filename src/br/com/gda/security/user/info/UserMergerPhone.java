package br.com.gda.security.user.info;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class UserMergerPhone extends InfoMergerTemplate<UserInfo, PhoneInfo> {

	@Override protected InfoMergerVisitor<UserInfo, PhoneInfo> getVisitorHook() {
		return new UserVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
