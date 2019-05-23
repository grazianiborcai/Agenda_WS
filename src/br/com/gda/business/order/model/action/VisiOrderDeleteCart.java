package br.com.gda.business.order.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.cart.model.decisionTree.RootCartDelete;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiOrderDeleteCart extends ActionVisitorTemplateAction<OrderInfo, CartemInfo> {
	public VisiOrderDeleteCart(Connection conn, String schemaName) {
		super(conn, schemaName, OrderInfo.class, CartemInfo.class);
	}
	
	
	
	@Override protected List<CartemInfo> toActionClassHook(List<OrderInfo> recordInfos) {
		List<CartemInfo> results = new ArrayList<>();
		
		for (OrderInfo eachRecord : recordInfos) {
			results.add(CartemInfo.copyFrom(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<CartemInfo> getActionHook(DeciTreeOption<CartemInfo> option) {
		return new RootCartDelete(option).toAction();
	}
	
	
	
	@Override protected List<OrderInfo> toBaseClassHook(List<OrderInfo> baseInfos, List<CartemInfo> results) {
		return baseInfos;
	}
}
