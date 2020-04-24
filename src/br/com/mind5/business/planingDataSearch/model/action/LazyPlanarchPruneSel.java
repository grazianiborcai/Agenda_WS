package br.com.mind5.business.planingDataSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.planingDataSearch.info.PlanarchInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPlanarchPruneSel extends ActionLazyTemplateV2<PlanarchInfo, PlanarchInfo> {
	
	public LazyPlanarchPruneSel(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PlanarchInfo> translateRecordInfosHook(List<PlanarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<PlanarchInfo> getInstanceOfActionHook(DeciTreeOption<PlanarchInfo> option) {
		return new StdPlanarchPruneSel(option);
	}
	
	
	
	@Override protected DeciResult<PlanarchInfo> translateResultHook(DeciResult<PlanarchInfo> result) {
		return result;
	}
}
