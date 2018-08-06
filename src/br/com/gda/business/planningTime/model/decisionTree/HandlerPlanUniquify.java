package br.com.gda.business.planningTime.model.decisionTree;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.planningTime.info.PlanInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandlerTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class HandlerPlanUniquify extends DeciActionHandlerTemplate<PlanInfo, PlanInfo> {
	
	public HandlerPlanUniquify(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PlanInfo> translateRecordInfosHook(List<PlanInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected  DeciAction<PlanInfo> getInstanceOfActionHook(DeciTreeOption<PlanInfo> option) {
		return new ActionPlanUniquify(option);
	}
	
	
	
	@Override protected DeciResult<PlanInfo> translateResultHook(DeciResult<PlanInfo> result) {
		return result;
	}
}
