package br.com.gda.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.scheduleLine.info.SchedineCopier;
import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.model.decisionTree.RootSchedineRefresh;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiOrderRefreshSchedine extends ActionVisitorTemplateAction<OrderInfo, SchedineInfo> {
	public VisiOrderRefreshSchedine(Connection conn, String schemaName) {
		super(conn, schemaName, OrderInfo.class, SchedineInfo.class);
	}
	
	
	
	@Override protected ActionStd<SchedineInfo> getActionHook(DeciTreeOption<SchedineInfo> option) {
		return new RootSchedineRefresh(option).toAction();
	}
	
	
	
	@Override protected List<SchedineInfo> toActionClassHook(List<OrderInfo> baseInfos) {
		return SchedineCopier.copyFromOrderKey(baseInfos);
	}
	
	
	
	@Override protected List<OrderInfo> toBaseClassHook(List<OrderInfo> baseInfos, List<SchedineInfo> results) {
		return baseInfos;
	}
}
