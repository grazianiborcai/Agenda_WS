package br.com.gda.business.order.info;

import br.com.gda.business.masterData.info.FeeCategInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrderMergerFeeCateg extends InfoMergerTemplate<OrderInfo, FeeCategInfo> {

	@Override protected InfoMergerVisitor<OrderInfo, FeeCategInfo> getVisitorHook() {
		return new OrderVisiMergeFeeCateg();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
