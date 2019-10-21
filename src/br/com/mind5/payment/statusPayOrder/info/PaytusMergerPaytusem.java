package br.com.mind5.payment.statusPayOrder.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;
final class PaytusMergerPaytusem extends InfoMergerTemplate<PaytusInfo, PaytusemInfo> {

	@Override protected InfoMergerVisitor<PaytusInfo, PaytusemInfo> getVisitorHook() {
		return new PaytusVisiMergePaytusem();
	}
	
	
	
	@Override protected InfoUniquifier<PaytusInfo> getUniquifierHook() {
		return new PaytusUniquifier();
	}
}
