package br.com.mind5.payment.payOrder.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class PayordMergerCuspar extends InfoMergerTemplate<PayordInfo, CusparInfo> {

	@Override protected InfoMergerVisitor<PayordInfo, CusparInfo> getVisitorHook() {
		return new PayordVisiMergeCuspar();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
