package br.com.mind5.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.scheduleLine.info.SchedineCopier;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.decisionTree.RootSchedineRefresh;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderRefreshSchedine extends ActionVisitorTemplateAction<OrderInfo, SchedineInfo> {
	public VisiOrderRefreshSchedine(Connection conn, String schemaName) {
		super(conn, schemaName, OrderInfo.class, SchedineInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<SchedineInfo> getActionHook(DeciTreeOption<SchedineInfo> option) {
		return new RootSchedineRefresh(option).toAction();
	}
	
	
	
	@Override protected List<SchedineInfo> toActionClassHook(List<OrderInfo> baseInfos) {
		return SchedineCopier.copyFromOrderKey(baseInfos);
	}
	
	
	
	@Override protected List<OrderInfo> toBaseClassHook(List<OrderInfo> baseInfos, List<SchedineInfo> results) {
		return baseInfos;
	}
}
