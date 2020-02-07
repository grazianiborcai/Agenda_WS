package br.com.mind5.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.decisionTree.RootCusInsertFromUser;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderInsertCus extends ActionVisitorTemplateAction<OrderInfo, CusInfo> {

	public VisiOrderInsertCus(Connection conn, String schemaName) {
		super(conn, schemaName, OrderInfo.class, CusInfo.class);
	}
	
	
	
	@Override protected ActionStd<CusInfo> getActionHook(DeciTreeOption<CusInfo> option) {
		return new RootCusInsertFromUser(option).toAction();
	}
	
	
	
	protected List<OrderInfo> toBaseClassHook(List<OrderInfo> baseInfos, List<CusInfo> results) {
		return OrderMerger.mergeWithCus(baseInfos, results);
	}
}
