package br.com.mind5.payment.refundOrderItem.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class RefemMergerCuspar extends InfoMergerTemplate_<RefemInfo, CusparInfo> {

	@Override protected InfoMergerVisitor_<RefemInfo, CusparInfo> getVisitorHook() {
		return new RefemVisiMergeCuspar();
	}
	
	
	
	@Override protected InfoUniquifier<RefemInfo> getUniquifierHook() {
		return new RefemUniquifier();
	}
}
