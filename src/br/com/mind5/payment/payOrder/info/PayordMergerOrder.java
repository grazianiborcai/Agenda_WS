package br.com.mind5.payment.payOrder.info;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PayordMergerOrder extends InfoMergerTemplate<PayordInfo, OrderInfo> {

	@Override protected InfoMergerVisitor<PayordInfo, OrderInfo> getVisitorHook() {
		return new PayordVisiMergeOrder();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
