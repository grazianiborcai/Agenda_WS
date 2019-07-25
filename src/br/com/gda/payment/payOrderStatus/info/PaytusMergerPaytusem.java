package br.com.gda.payment.payOrderStatus.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.payOrderItemStatus.info.PaytusemInfo;
final class PaytusMergerPaytusem extends InfoMergerTemplate<PaytusInfo, PaytusemInfo> {

	@Override protected InfoMergerVisitorV2<PaytusInfo, PaytusemInfo> getVisitorHook() {
		return new PaytusVisiMergePaytusem();
	}
	
	
	
	@Override protected InfoUniquifier<PaytusInfo> getUniquifierHook() {
		return new PaytusUniquifier();
	}
}
