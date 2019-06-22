package br.com.gda.payment.payOrder.info;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PayordMergerOrder extends InfoMergerTemplate<PayordInfo, OrderInfo> {

	@Override protected InfoMergerVisitorV2<PayordInfo, OrderInfo> getVisitorHook() {
		return new PayordVisiMergeOrder();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
