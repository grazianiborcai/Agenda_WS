package br.com.gda.business.planningTime.model.decisionTree;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.planningTime.info.PlanInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class HandlerPlanPruneAge extends ActionLazyTemplate<PlanInfo, PlanInfo> {

	public HandlerPlanPruneAge(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PlanInfo> translateRecordInfosHook(List<PlanInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PlanInfo> getInstanceOfActionHook(DeciTreeOption<PlanInfo> option) {
		return new ActionPlanPruneAge(option);
	}
	
	
	
	@Override protected DeciResult<PlanInfo> translateResultHook(DeciResult<PlanInfo> result) {
		return result;
	}
}
