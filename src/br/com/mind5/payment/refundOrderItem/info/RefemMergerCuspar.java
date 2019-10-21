package br.com.mind5.payment.refundOrderItem.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class RefemMergerCuspar extends InfoMergerTemplate<RefemInfo, CusparInfo> {

	@Override protected InfoMergerVisitor<RefemInfo, CusparInfo> getVisitorHook() {
		return new RefemVisiMergeCuspar();
	}
	
	
	
	@Override protected InfoUniquifier<RefemInfo> getUniquifierHook() {
		return new RefemUniquifier();
	}
}
