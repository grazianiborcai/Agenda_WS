package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class UserMergerCuspar extends InfoMergerTemplate<UserInfo, CusparInfo> {

	@Override protected InfoMergerVisitor<UserInfo, CusparInfo> getVisitorHook() {
		return new UserVisiMergeCuspar();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
