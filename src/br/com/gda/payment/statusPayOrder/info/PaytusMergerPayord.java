package br.com.gda.payment.statusPayOrder.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.payOrder.info.PayordInfo;

final class PaytusMergerPayord extends InfoMergerTemplate<PaytusInfo, PayordInfo> {

	@Override protected InfoMergerVisitor<PaytusInfo, PayordInfo> getVisitorHook() {
		return new PaytusVisiMergePayord();
	}
	
	
	
	@Override protected InfoUniquifier<PaytusInfo> getUniquifierHook() {
		return new PaytusUniquifier();
	}
}
