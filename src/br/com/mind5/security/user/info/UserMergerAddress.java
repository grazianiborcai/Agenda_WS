package br.com.mind5.security.user.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class UserMergerAddress extends InfoMergerTemplate<UserInfo, AddressInfo> {

	@Override protected InfoMergerVisitor<UserInfo, AddressInfo> getVisitorHook() {
		return new UserVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
