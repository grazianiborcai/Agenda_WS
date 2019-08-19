package br.com.gda.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.model.decisionTree.RootSchedineFromOrder;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiOrderInsertSchedine extends ActionVisitorTemplateAction<OrderInfo, SchedineInfo> {
	public VisiOrderInsertSchedine(Connection conn, String schemaName) {
		super(conn, schemaName, OrderInfo.class, SchedineInfo.class);
	}
	
	
	
	@Override protected ActionStd<SchedineInfo> getActionHook(DeciTreeOption<SchedineInfo> option) {
		return new RootSchedineFromOrder(option).toAction();
	}
	
	
	
	@Override protected List<OrderInfo> toBaseClassHook(List<OrderInfo> baseInfos, List<SchedineInfo> results) {
		return baseInfos;
	}
}
