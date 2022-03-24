package br.com.mind5.business.order.model;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.decisionTree.OrderRootCancelAuth;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderModelCancelAuth extends ModelTemplate<OrderInfo> {

	public OrderModelCancelAuth(OrderInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<OrderInfo> getDecisionTreeHook(DeciTreeOption<OrderInfo> option) {
		return new OrderRootCancelAuth(option);
	}
}
