package br.com.gda.payment.refundOrder.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.payOrder.info.PayordInfo;

final class RefuMergerPayord extends InfoMergerTemplate<RefuInfo, PayordInfo> {

	@Override protected InfoMergerVisitorV2<RefuInfo, PayordInfo> getVisitorHook() {
		return new RefuVisiMergePayord();
	}
	
	
	
	@Override protected InfoUniquifier<RefuInfo> getUniquifierHook() {
		return new RefuUniquifier();
	}
}
