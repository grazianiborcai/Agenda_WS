package br.com.gda.payment.refundOrderItem.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.customerPartner.info.CusparInfo;

final class RefemMergerCuspar extends InfoMergerTemplate<RefemInfo, CusparInfo> {

	@Override protected InfoMergerVisitorV2<RefemInfo, CusparInfo> getVisitorHook() {
		return new RefemVisiMergeCuspar();
	}
	
	
	
	@Override protected InfoUniquifier<RefemInfo> getUniquifierHook() {
		return new RefemUniquifier();
	}
}
