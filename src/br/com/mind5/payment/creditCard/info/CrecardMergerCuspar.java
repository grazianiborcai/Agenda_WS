package br.com.mind5.payment.creditCard.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class CrecardMergerCuspar extends InfoMergerTemplate_<CrecardInfo, CusparInfo> {

	@Override protected InfoMergerVisitor_<CrecardInfo, CusparInfo> getVisitorHook() {
		return new CrecardVisiMergeCuspar();
	}
	
	
	
	@Override protected InfoUniquifier<CrecardInfo> getUniquifierHook() {
		return new CrecardUniquifier();
	}
}
