package br.com.gda.payment.refundOrderItem.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.payOrder.info.PayordInfo;

final class RefemMergerPayord extends InfoMergerTemplate<RefemInfo, PayordInfo> {

	@Override protected InfoMergerVisitorV2<RefemInfo, PayordInfo> getVisitorHook() {
		return new RefemVisiMergePayord();
	}
	
	
	
	@Override protected InfoUniquifier<RefemInfo> getUniquifierHook() {
		return new RefemUniquifier();
	}
}
