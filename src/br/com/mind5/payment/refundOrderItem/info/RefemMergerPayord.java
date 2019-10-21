package br.com.mind5.payment.refundOrderItem.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class RefemMergerPayord extends InfoMergerTemplate<RefemInfo, PayordInfo> {

	@Override protected InfoMergerVisitor<RefemInfo, PayordInfo> getVisitorHook() {
		return new RefemVisiMergePayord();
	}
	
	
	
	@Override protected InfoUniquifier<RefemInfo> getUniquifierHook() {
		return new RefemUniquifier();
	}
}
