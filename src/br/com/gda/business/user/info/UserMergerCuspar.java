package br.com.gda.business.user.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.customerPartner.info.CusparInfo;

final class UserMergerCuspar extends InfoMergerTemplate<UserInfo, CusparInfo> {

	@Override protected InfoMergerVisitorV2<UserInfo, CusparInfo> getVisitorHook() {
		return new UserVisiMergeCuspar();
	}
	
	
	
	@Override protected InfoUniquifier<UserInfo> getUniquifierHook() {
		return new UserUniquifier();
	}
}
