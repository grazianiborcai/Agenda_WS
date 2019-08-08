package br.com.gda.payment.customerPartner.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.user.info.UserInfo;

final class CusparMergerUser extends InfoMergerTemplate<CusparInfo, UserInfo> {

	@Override protected InfoMergerVisitorV2<CusparInfo, UserInfo> getVisitorHook() {
		return new CusparVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
