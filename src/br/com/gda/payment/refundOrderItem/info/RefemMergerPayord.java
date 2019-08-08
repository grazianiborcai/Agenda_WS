package br.com.gda.payment.refundOrderItem.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.payOrder.info.PayordInfo;

final class RefemMergerPayord extends InfoMergerTemplate<RefemInfo, PayordInfo> {

	@Override protected InfoMergerVisitor<RefemInfo, PayordInfo> getVisitorHook() {
		return new RefemVisiMergePayord();
	}
	
	
	
	@Override protected InfoUniquifier<RefemInfo> getUniquifierHook() {
		return new RefemUniquifier();
	}
}
