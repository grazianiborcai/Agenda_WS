package br.com.mind5.business.order.info;

import br.com.mind5.business.masterData.info.FeeCategInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrderMergerFeeCateg extends InfoMergerTemplate_<OrderInfo, FeeCategInfo> {

	@Override protected InfoMergerVisitor_<OrderInfo, FeeCategInfo> getVisitorHook() {
		return new OrderVisiMergeFeeCateg();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
