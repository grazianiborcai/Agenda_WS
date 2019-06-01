package br.com.gda.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.cartItem.info.CartemCopier;
import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.cartItem.model.decisionTree.RootCartemUpsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiOrderUpsertCartem extends ActionVisitorTemplateAction<OrderInfo, CartemInfo> {
	public VisiOrderUpsertCartem(Connection conn, String schemaName) {
		super(conn, schemaName, OrderInfo.class, CartemInfo.class);
	}
	
	
	
	@Override protected ActionStd<CartemInfo> getActionHook(DeciTreeOption<CartemInfo> option) {
		return new RootCartemUpsert(option).toAction();
	}
	
	
	
	@Override protected List<CartemInfo> toActionClassHook(List<OrderInfo> baseInfos) {
		return CartemCopier.copyFromCart(baseInfos);
	}
	
	
	
	@Override protected List<OrderInfo> toBaseClassHook(List<OrderInfo> baseInfos, List<CartemInfo> results) {
		return baseInfos;
	}
}
