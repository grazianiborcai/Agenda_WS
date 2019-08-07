package br.com.gda.business.cart.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.info.CartMerger;
import br.com.gda.business.order.info.OrderCopier;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.model.decisionTree.RootOrderInsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiCartInsertOrder extends ActionVisitorTemplateAction<CartInfo, OrderInfo> {
	public VisiCartInsertOrder(Connection conn, String schemaName) {
		super(conn, schemaName, CartInfo.class, OrderInfo.class);
	}
	
	
	
	@Override protected ActionStd<OrderInfo> getActionHook(DeciTreeOption<OrderInfo> option) {
		return new RootOrderInsert(option).toAction();
	}
	
	
	
	@Override protected List<OrderInfo> toActionClassHook(List<CartInfo> baseInfos) {
		return OrderCopier.copyFromCart(baseInfos);
	}
	
	
	
	@Override protected List<CartInfo> toBaseClassHook(List<CartInfo> baseInfos, List<OrderInfo> results) {
		return CartMerger.mergeWithOrder(results, baseInfos);
	}
}
