package br.com.mind5.payment.statusPayOrder.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;
final class PaytusMergerPaytusem extends InfoMergerTemplate_<PaytusInfo, PaytusemInfo> {

	@Override protected InfoMergerVisitor_<PaytusInfo, PaytusemInfo> getVisitorHook() {
		return new PaytusVisiMergePaytusem();
	}
	
	
	
	@Override protected InfoUniquifier<PaytusInfo> getUniquifierHook() {
		return new PaytusUniquifier();
	}
}
