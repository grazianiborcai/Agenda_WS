package br.com.gda.payment.creditCard.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.customerPartner.info.CusparInfo;

final class CrecardMergerCuspar extends InfoMergerTemplate<CrecardInfo, CusparInfo> {

	@Override protected InfoMergerVisitor<CrecardInfo, CusparInfo> getVisitorHook() {
		return new CrecardVisiMergeCuspar();
	}
	
	
	
	@Override protected InfoUniquifier<CrecardInfo> getUniquifierHook() {
		return new CrecardUniquifier();
	}
}
