package br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.decisionTree.RootSteddUpsert;

public final class LazySteddRootUpsert extends ActionLazyTemplate<SteddInfo, SteddInfo> {

	public LazySteddRootUpsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SteddInfo> translateRecordInfosHook(List<SteddInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SteddInfo> getInstanceOfActionHook(DeciTreeOption<SteddInfo> option) {
		return new RootSteddUpsert(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SteddInfo> translateResultHook(DeciResult<SteddInfo> result) {
		return result;
	}
}
