package br.com.gda.business.order.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartItem.info.CartInfo;
import br.com.gda.business.cart.model.decisionTree.RootCartDelete;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiOrderDeleteCart extends ActionVisitorTemplateAction<OrderInfo, CartInfo> {
	public VisiOrderDeleteCart(Connection conn, String schemaName) {
		super(conn, schemaName, OrderInfo.class, CartInfo.class);
	}
	
	
	
	@Override protected List<CartInfo> toActionClassHook(List<OrderInfo> recordInfos) {
		List<CartInfo> results = new ArrayList<>();
		
		for (OrderInfo eachRecord : recordInfos) {
			results.add(CartInfo.copyFrom(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<CartInfo> getActionHook(DeciTreeOption<CartInfo> option) {
		return new RootCartDelete(option).toAction();
	}
	
	
	
	@Override protected List<OrderInfo> toBaseClassHook(List<OrderInfo> baseInfos, List<CartInfo> results) {
		return baseInfos;
	}
}
