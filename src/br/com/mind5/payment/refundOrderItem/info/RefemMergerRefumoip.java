package br.com.mind5.payment.refundOrderItem.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.partnerMoip.refundMoip.info.RefumoipInfo;

final class RefemMergerRefumoip extends InfoMergerTemplate<RefemInfo, RefumoipInfo> {

	@Override protected InfoMergerVisitor<RefemInfo, RefumoipInfo> getVisitorHook() {
		return new RefemVisiMergeRefumoip();
	}
	
	
	
	@Override protected InfoUniquifier<RefemInfo> getUniquifierHook() {
		return new RefemUniquifier();
	}
}
