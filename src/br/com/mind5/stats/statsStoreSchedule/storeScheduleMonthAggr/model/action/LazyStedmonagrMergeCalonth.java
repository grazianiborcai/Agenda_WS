package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;

public final class LazyStedmonagrMergeCalonth extends ActionLazyTemplate<StedmonagrInfo, StedmonagrInfo> {

	public LazyStedmonagrMergeCalonth(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StedmonagrInfo> translateRecordInfosHook(List<StedmonagrInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StedmonagrInfo> getInstanceOfActionHook(DeciTreeOption<StedmonagrInfo> option) {
		return new StdStedmonagrMergeCalonth(option);
	}
	
	
	
	@Override protected DeciResult<StedmonagrInfo> translateResultHook(DeciResult<StedmonagrInfo> result) {
		return result;
	}
}
