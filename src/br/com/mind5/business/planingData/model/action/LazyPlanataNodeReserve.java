package br.com.mind5.business.planingData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.model.decisionTree.NodePlanataReserve;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPlanataNodeReserve extends ActionLazyTemplate<PlanataInfo, PlanataInfo> {
	
	public LazyPlanataNodeReserve(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PlanataInfo> translateRecordInfosHook(List<PlanataInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<PlanataInfo> getInstanceOfActionHook(DeciTreeOption<PlanataInfo> option) {
		return new NodePlanataReserve(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PlanataInfo> translateResultHook(DeciResult<PlanataInfo> result) {
		return result;
	}
}
