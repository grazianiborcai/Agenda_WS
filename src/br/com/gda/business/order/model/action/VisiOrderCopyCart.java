package br.com.gda.business.order.model.action;

import java.sql.Connection;
import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.decisionTree.RootCartSelect;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiOrderCopyCart extends ActionVisitorTemplateAction<OrderInfo, CartInfo> {
	public VisiOrderCopyCart(Connection conn, String schemaName) {
		super(conn, schemaName, OrderInfo.class, CartInfo.class);
	}
	
	
	
	@Override protected ActionStd<CartInfo> getActionHook(DeciTreeOption<CartInfo> option) {
		return new RootCartSelect(option).toAction();
	}
}
