package br.com.mind5.payment.statusPayOrder.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class PaytusMergerPayord extends InfoMergerTemplate<PaytusInfo, PayordInfo> {

	@Override protected InfoMergerVisitor<PaytusInfo, PayordInfo> getVisitorHook() {
		return new PaytusVisiMergePayord();
	}
	
	
	
	@Override protected InfoUniquifier<PaytusInfo> getUniquifierHook() {
		return new PaytusUniquifier();
	}
}
