package br.com.mind5.business.planningTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPlanimeMergeMatlis extends ActionLazyTemplateV2<PlanimeInfo, PlanimeInfo> {

	public LazyPlanimeMergeMatlis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PlanimeInfo> translateRecordInfosHook(List<PlanimeInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<PlanimeInfo> getInstanceOfActionHook(DeciTreeOption<PlanimeInfo> option) {
		return new StdPlanimeMergeMatlis(option);
	}
	
	
	
	@Override protected DeciResult<PlanimeInfo> translateResultHook(DeciResult<PlanimeInfo> result) {
		return result;
	}
}
