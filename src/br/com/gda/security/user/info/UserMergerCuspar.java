package br.com.gda.security.user.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.customerPartner.info.CusparInfo;

final class UserMergerCuspar extends InfoMergerTemplate<UserInfo, CusparInfo> {

	@Override protected InfoMergerVisitor<UserInfo, CusparInfo> getVisitorHook() {
		return new UserVisiMergeCuspar();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
