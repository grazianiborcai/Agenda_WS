package br.com.mind5.business.planningTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPlanimeMergeMoonase extends ActionLazyTemplate<PlanimeInfo, PlanimeInfo> {

	public LazyPlanimeMergeMoonase(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PlanimeInfo> translateRecordInfosHook(List<PlanimeInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<PlanimeInfo> getInstanceOfActionHook(DeciTreeOption<PlanimeInfo> option) {
		return new StdPlanimeMergeMoonase(option);
	}
	
	
	
	@Override protected DeciResult<PlanimeInfo> translateResultHook(DeciResult<PlanimeInfo> result) {
		return result;
	}
}
