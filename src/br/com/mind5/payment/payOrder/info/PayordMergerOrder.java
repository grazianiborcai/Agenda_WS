package br.com.mind5.payment.payOrder.info;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PayordMergerOrder extends InfoMergerTemplate_<PayordInfo, OrderInfo> {

	@Override protected InfoMergerVisitor_<PayordInfo, OrderInfo> getVisitorHook() {
		return new PayordVisiMergeOrder();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
