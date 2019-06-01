package br.com.gda.business.orderItem.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.business.cartSnapshot.model.decisionTree.RootCartSnapInsert;
import br.com.gda.business.orderItem.info.OrderInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiOrderInsertCartSnap extends ActionVisitorTemplateAction<OrderInfo, CartSnapInfo> {
	public VisiOrderInsertCartSnap(Connection conn, String schemaName) {
		super(conn, schemaName, OrderInfo.class, CartSnapInfo.class);
	}
	
	
	
	@Override protected List<CartSnapInfo> toActionClassHook(List<OrderInfo> recordInfos) {
		List<CartSnapInfo> results = new ArrayList<>();
		
		for (OrderInfo eachRecord : recordInfos) {
			results.add(CartSnapInfo.copyFrom(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<CartSnapInfo> getActionHook(DeciTreeOption<CartSnapInfo> option) {
		return new RootCartSnapInsert(option).toAction();
	}
	
	
	
	@Override protected List<OrderInfo> toBaseClassHook(List<OrderInfo> baseInfos, List<CartSnapInfo> results) {
		return baseInfos;
	}
}
