package br.com.gda.security.user.info;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class UserMergerAddress extends InfoMergerTemplate<UserInfo, AddressInfo> {

	@Override protected InfoMergerVisitor<UserInfo, AddressInfo> getVisitorHook() {
		return new UserVisiMergeAddress();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
