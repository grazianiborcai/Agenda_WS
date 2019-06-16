package br.com.gda.payment.customer.info;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PaycusMergerUser extends InfoMergerTemplate<PaycusInfo, UserInfo> {

	@Override protected InfoMergerVisitorV2<PaycusInfo, UserInfo> getVisitorHook() {
		return new PaycusVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<PaycusInfo> getUniquifierHook() {
		return new PaycusUniquifier();
	}
}
