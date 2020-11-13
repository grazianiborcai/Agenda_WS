package br.com.mind5.business.planingDataSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.planingDataSearch.info.PlanarchInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPlanarchPruneSel extends ActionLazyTemplate<PlanarchInfo, PlanarchInfo> {
	
	public LazyPlanarchPruneSel(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PlanarchInfo> translateRecordInfosHook(List<PlanarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PlanarchInfo> getInstanceOfActionHook(DeciTreeOption<PlanarchInfo> option) {
		return new StdPlanarchPruneSel(option);
	}
	
	
	
	@Override protected DeciResult<PlanarchInfo> translateResultHook(DeciResult<PlanarchInfo> result) {
		return result;
	}
}
