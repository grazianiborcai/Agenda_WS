package br.com.gda.payment.customerPartner.info;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class CusparMergerPhone extends InfoMergerTemplate<CusparInfo, PhoneInfo> {

	@Override protected InfoMergerVisitorV2<CusparInfo, PhoneInfo> getVisitorHook() {
		return new CusparVisiMergePhone();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
