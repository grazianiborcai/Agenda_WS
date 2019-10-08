package br.com.gda.business.planingData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyPlanataPruneStolevate extends ActionLazyTemplate<PlanataInfo, PlanataInfo> {
	
	public LazyPlanataPruneStolevate(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PlanataInfo> translateRecordInfosHook(List<PlanataInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PlanataInfo> getInstanceOfActionHook(DeciTreeOption<PlanataInfo> option) {
		return new StdPlanataPruneStolevate(option);
	}
	
	
	
	@Override protected DeciResult<PlanataInfo> translateResultHook(DeciResult<PlanataInfo> result) {
		return result;
	}
}
