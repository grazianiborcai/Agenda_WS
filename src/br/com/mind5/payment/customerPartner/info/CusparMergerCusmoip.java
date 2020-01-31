package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.partnerMoip.customerMoip.info.CusmoipInfo;

final class CusparMergerCusmoip extends InfoMergerTemplate_<CusparInfo, CusmoipInfo> {

	@Override protected InfoMergerVisitor_<CusparInfo, CusmoipInfo> getVisitorHook() {
		return new CusparVisiMergeCusmoip();
	}
	
	
	
	@Override protected InfoUniquifier<CusparInfo> getUniquifierHook() {
		return new CusparUniquifier();
	}
}
