package br.com.mind5.business.order.info;

import br.com.mind5.business.masterData.info.FeeCategInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrderMergerFeeCateg extends InfoMergerTemplate<OrderInfo, FeeCategInfo> {

	@Override protected InfoMergerVisitor<OrderInfo, FeeCategInfo> getVisitorHook() {
		return new OrderVisiMergeFeeCateg();
	}
	
	
	
	@Override protected InfoUniquifier<OrderInfo> getUniquifierHook() {
		return new OrderUniquifier();
	}
}
