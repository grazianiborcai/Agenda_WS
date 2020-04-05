package br.com.mind5.business.cart.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.info.CartMerger;
import br.com.mind5.business.order.info.OrderCopier;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.decisionTree.RootOrderInsert;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateActionV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartInsertOrder extends ActionVisitorTemplateActionV1<CartInfo, OrderInfo> {
	public VisiCartInsertOrder(Connection conn, String schemaName) {
		super(conn, schemaName, CartInfo.class, OrderInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<OrderInfo> getActionHook(DeciTreeOption<OrderInfo> option) {
		return new RootOrderInsert(option).toAction();
	}
	
	
	
	@Override protected List<OrderInfo> toActionClassHook(List<CartInfo> baseInfos) {
		return OrderCopier.copyFromCart(baseInfos);
	}
	
	
	
	@Override protected List<CartInfo> toBaseClassHook(List<CartInfo> baseInfos, List<OrderInfo> results) {
		return CartMerger.mergeWithOrder(results, baseInfos);
	}
}
