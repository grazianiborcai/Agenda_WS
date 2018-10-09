package br.com.gda.business.order.model.action;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.decisionTree.RootCartSelect;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitor;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class LazyVisitorOrderCopyCart implements ActionVisitor<OrderInfo> {
	private DeciTreeOption<CartInfo> selOption;
	
	
	public LazyVisitorOrderCopyCart(Connection conn, String schemaName) {
		checkArgument(conn, schemaName);
		makeOption(conn, schemaName);
	}
	
	
	
	private void checkArgument(Connection conn, String schemaName) {
		if (conn == null)
			throw new NullPointerException("conn" + SystemMessage.NULL_ARGUMENT);		
		
		if (schemaName == null)
			throw new NullPointerException("schemaName" + SystemMessage.NULL_ARGUMENT);		
	}
	
	
	
	private void makeOption(Connection conn, String schemaName) {
		selOption = new DeciTreeOption<>();
		selOption.conn = conn;
		selOption.schemaName = schemaName;
		selOption.recordInfos = null;
	}
	
	
		
	@Override public List<OrderInfo> executeTransformation(List<OrderInfo> recordInfos) {
		addRecordToOption(recordInfos);
		List<CartInfo> carts = selectCart();
		
		if (carts.isEmpty())
			return Collections.emptyList();
		
		return makeCopy(carts);
	}	
	
	
	
	private void addRecordToOption(List<OrderInfo> recordInfos) {
		selOption.recordInfos = CartInfo.copyFrom(recordInfos);
	}
	
	
	
	private List<CartInfo> selectCart() {
		ActionStd<CartInfo> mainAction = new RootCartSelect(selOption).toAction();
		mainAction.executeAction();
		
		if (mainAction.getDecisionResult().hasResultset())		
			return mainAction.getDecisionResult().getResultset();
		
		return Collections.emptyList();
	}
	
	
	
	private List<OrderInfo> makeCopy(List<CartInfo> carts) {
		return OrderInfo.copyFrom(carts);
	}
}
