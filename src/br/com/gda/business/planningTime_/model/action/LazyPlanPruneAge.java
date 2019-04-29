package br.com.gda.business.planningTime_.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.planningTime_.info.PlanInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyPlanPruneAge extends ActionLazyTemplate<PlanInfo, PlanInfo> {

	public LazyPlanPruneAge(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PlanInfo> translateRecordInfosHook(List<PlanInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PlanInfo> getInstanceOfActionHook(DeciTreeOption<PlanInfo> option) {
		return new StdPlanPruneAge(option);
	}
	
	
	
	@Override protected DeciResult<PlanInfo> translateResultHook(DeciResult<PlanInfo> result) {
		return result;
	}
}
