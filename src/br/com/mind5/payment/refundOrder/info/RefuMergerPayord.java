package br.com.mind5.payment.refundOrder.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class RefuMergerPayord extends InfoMergerTemplate_<RefuInfo, PayordInfo> {

	@Override protected InfoMergerVisitor_<RefuInfo, PayordInfo> getVisitorHook() {
		return new RefuVisiMergePayord();
	}
	
	
	
	@Override protected InfoUniquifier<RefuInfo> getUniquifierHook() {
		return new RefuUniquifier();
	}
}
