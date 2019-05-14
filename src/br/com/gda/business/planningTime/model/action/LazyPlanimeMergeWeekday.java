package br.com.gda.business.planningTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyPlanimeMergeWeekday extends ActionLazyTemplate<PlanimeInfo, PlanimeInfo> {

	public LazyPlanimeMergeWeekday(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PlanimeInfo> translateRecordInfosHook(List<PlanimeInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PlanimeInfo> getInstanceOfActionHook(DeciTreeOption<PlanimeInfo> option) {
		return new StdPlanimeMergeWeekday(option);
	}
	
	
	
	@Override protected DeciResult<PlanimeInfo> translateResultHook(DeciResult<PlanimeInfo> result) {
		return result;
	}
}
