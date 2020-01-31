package br.com.mind5.security.user.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class UserMergerPhone extends InfoMergerTemplate_<UserInfo, PhoneInfo> {

	@Override protected InfoMergerVisitor_<UserInfo, PhoneInfo> getVisitorHook() {
		return new UserVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
