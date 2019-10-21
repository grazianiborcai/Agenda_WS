package br.com.mind5.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.orderItem.info.OrderemCopier;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.decisionTree.RootOrderemInsert;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderInsertOrderem extends ActionVisitorTemplateAction<OrderInfo, OrderemInfo> {
	public VisiOrderInsertOrderem(Connection conn, String schemaName) {
		super(conn, schemaName, OrderInfo.class, OrderemInfo.class);
	}
	
	
	
	@Override protected ActionStd<OrderemInfo> getActionHook(DeciTreeOption<OrderemInfo> option) {
		return new RootOrderemInsert(option).toAction();
	}
	
	
	
	@Override protected List<OrderemInfo> toActionClassHook(List<OrderInfo> baseInfos) {
		return OrderemCopier.copyFromOrder(baseInfos);
	}
	
	
	
	@Override protected List<OrderInfo> toBaseClassHook(List<OrderInfo> baseInfos, List<OrderemInfo> results) {
		return baseInfos;
	}
}
