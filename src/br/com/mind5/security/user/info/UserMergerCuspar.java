package br.com.mind5.security.user.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class UserMergerCuspar extends InfoMergerTemplate_<UserInfo, CusparInfo> {

	@Override protected InfoMergerVisitor_<UserInfo, CusparInfo> getVisitorHook() {
		return new UserVisiMergeCuspar();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
