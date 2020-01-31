package br.com.mind5.payment.refundOrderItem.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class RefemMergerPayord extends InfoMergerTemplate_<RefemInfo, PayordInfo> {

	@Override protected InfoMergerVisitor_<RefemInfo, PayordInfo> getVisitorHook() {
		return new RefemVisiMergePayord();
	}
	
	
	
	@Override protected InfoUniquifier<RefemInfo> getUniquifierHook() {
		return new RefemUniquifier();
	}
}
