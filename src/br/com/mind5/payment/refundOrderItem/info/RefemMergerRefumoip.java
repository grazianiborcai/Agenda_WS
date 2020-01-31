package br.com.mind5.payment.refundOrderItem.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.partnerMoip.refundMoip.info.RefumoipInfo;

final class RefemMergerRefumoip extends InfoMergerTemplate_<RefemInfo, RefumoipInfo> {

	@Override protected InfoMergerVisitor_<RefemInfo, RefumoipInfo> getVisitorHook() {
		return new RefemVisiMergeRefumoip();
	}
	
	
	
	@Override protected InfoUniquifier<RefemInfo> getUniquifierHook() {
		return new RefemUniquifier();
	}
}
