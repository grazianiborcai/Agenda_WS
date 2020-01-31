package br.com.mind5.security.user.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class UserMergerAddress extends InfoMergerTemplate_<UserInfo, AddressInfo> {

	@Override protected InfoMergerVisitor_<UserInfo, AddressInfo> getVisitorHook() {
		return new UserVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
