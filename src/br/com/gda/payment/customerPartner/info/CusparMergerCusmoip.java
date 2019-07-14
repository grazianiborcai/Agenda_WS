package br.com.gda.payment.customerPartner.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.partnerMoip.customerMoip.info.CusmoipInfo;

final class CusparMergerCusmoip extends InfoMergerTemplate<CusparInfo, CusmoipInfo> {

	@Override protected InfoMergerVisitorV2<CusparInfo, CusmoipInfo> getVisitorHook() {
		return new CusparVisiMergeCusmoip();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
