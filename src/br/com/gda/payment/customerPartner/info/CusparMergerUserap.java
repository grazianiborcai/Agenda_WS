package br.com.gda.payment.customerPartner.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.userSnapshot.info.UserapInfo;

final class CusparMergerUserap extends InfoMergerTemplate<CusparInfo, UserapInfo> {

	@Override protected InfoMergerVisitorV2<CusparInfo, UserapInfo> getVisitorHook() {
		return new CusparVisiMergeUserap();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
