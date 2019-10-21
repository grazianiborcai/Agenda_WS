package br.com.mind5.payment.refundOrder.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class RefuMergerPayord extends InfoMergerTemplate<RefuInfo, PayordInfo> {

	@Override protected InfoMergerVisitor<RefuInfo, PayordInfo> getVisitorHook() {
		return new RefuVisiMergePayord();
	}
	
	
	
	@Override protected InfoUniquifier<RefuInfo> getUniquifierHook() {
		return new RefuUniquifier();
	}
}
