package br.com.mind5.payment.statusPayOrder.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class PaytusMergerPayord extends InfoMergerTemplate_<PaytusInfo, PayordInfo> {

	@Override protected InfoMergerVisitor_<PaytusInfo, PayordInfo> getVisitorHook() {
		return new PaytusVisiMergePayord();
	}
	
	
	
	@Override protected InfoUniquifier<PaytusInfo> getUniquifierHook() {
		return new PaytusUniquifier();
	}
}
