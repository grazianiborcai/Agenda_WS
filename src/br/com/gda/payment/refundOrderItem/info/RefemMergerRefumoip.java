package br.com.gda.payment.refundOrderItem.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.partnerMoip.refundMoip.info.RefumoipInfo;

final class RefemMergerRefumoip extends InfoMergerTemplate<RefemInfo, RefumoipInfo> {

	@Override protected InfoMergerVisitorV2<RefemInfo, RefumoipInfo> getVisitorHook() {
		return new RefemVisiMergeRefumoip();
	}
	
	
	
	@Override protected InfoUniquifier<RefemInfo> getUniquifierHook() {
		return new RefemUniquifier();
	}
}
