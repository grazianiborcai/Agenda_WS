package br.com.gda.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.orderItem.info.OrderemCopier;
import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.business.orderItem.model.decisionTree.RootOrderemInsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
