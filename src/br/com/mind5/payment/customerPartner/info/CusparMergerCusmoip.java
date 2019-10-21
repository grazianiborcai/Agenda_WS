package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.partnerMoip.customerMoip.info.CusmoipInfo;

final class CusparMergerCusmoip extends InfoMergerTemplate<CusparInfo, CusmoipInfo> {

	@Override protected InfoMergerVisitor<CusparInfo, CusmoipInfo> getVisitorHook() {
		return new CusparVisiMergeCusmoip();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
