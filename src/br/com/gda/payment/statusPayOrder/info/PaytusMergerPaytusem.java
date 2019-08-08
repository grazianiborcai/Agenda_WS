package br.com.gda.payment.statusPayOrder.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.statusPayOrderItem.info.PaytusemInfo;
final class PaytusMergerPaytusem extends InfoMergerTemplate<PaytusInfo, PaytusemInfo> {

	@Override protected InfoMergerVisitor<PaytusInfo, PaytusemInfo> getVisitorHook() {
		return new PaytusVisiMergePaytusem();
	}
	
	
	
	@Override protected InfoUniquifier<PaytusInfo> getUniquifierHook() {
		return new PaytusUniquifier();
	}
}
