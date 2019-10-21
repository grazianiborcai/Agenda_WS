package br.com.mind5.payment.creditCard.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class CrecardMergerCuspar extends InfoMergerTemplate<CrecardInfo, CusparInfo> {

	@Override protected InfoMergerVisitor<CrecardInfo, CusparInfo> getVisitorHook() {
		return new CrecardVisiMergeCuspar();
	}
	
	
	
	@Override protected InfoUniquifier<CrecardInfo> getUniquifierHook() {
		return new CrecardUniquifier();
	}
}
