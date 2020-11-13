package br.com.mind5.business.planingData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPlanataPruneStolate extends ActionLazyTemplate<PlanataInfo, PlanataInfo> {
	
	public LazyPlanataPruneStolate(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PlanataInfo> translateRecordInfosHook(List<PlanataInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PlanataInfo> getInstanceOfActionHook(DeciTreeOption<PlanataInfo> option) {
		return new StdPlanataPruneStolate(option);
	}
	
	
	
	@Override protected DeciResult<PlanataInfo> translateResultHook(DeciResult<PlanataInfo> result) {
		return result;
	}
}
