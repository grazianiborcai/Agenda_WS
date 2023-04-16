package br.com.mind5.business.order.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.decisionTree.OrderRootPlaceAuth;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderModelPlaceAuth extends ModelTemplate<OrderInfo> {

	public OrderModelPlaceAuth(String incomingData, HttpServletRequest request) {
		super(incomingData, request, OrderInfo.class);
	}
	
	
	
	@Override protected DeciTree<OrderInfo> getDecisionTreeHook(DeciTreeOption<OrderInfo> option) {
		return new OrderRootPlaceAuth(option);
	}
}
