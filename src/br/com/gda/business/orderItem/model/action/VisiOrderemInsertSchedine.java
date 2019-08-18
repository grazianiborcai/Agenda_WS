package br.com.gda.business.orderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.business.scheduleLine.info.SchedineCopier;
import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.model.decisionTree.RootSchedineInsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiOrderemInsertSchedine extends ActionVisitorTemplateAction<OrderemInfo, SchedineInfo> {
	public VisiOrderemInsertSchedine(Connection conn, String schemaName) {
		super(conn, schemaName, OrderemInfo.class, SchedineInfo.class);
	}
	
	
	
	@Override protected ActionStd<SchedineInfo> getActionHook(DeciTreeOption<SchedineInfo> option) {
		return new RootSchedineInsert(option).toAction();
	}
	
	
	
	@Override protected List<SchedineInfo> toActionClassHook(List<OrderemInfo> baseInfos) {
		return SchedineCopier.copyFromOrderem(baseInfos);
	}
	
	
	
	@Override protected List<OrderemInfo> toBaseClassHook(List<OrderemInfo> baseInfos, List<SchedineInfo> results) {
		return baseInfos;
	}
}
